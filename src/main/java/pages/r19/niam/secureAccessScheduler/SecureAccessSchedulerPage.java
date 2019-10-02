package pages.r19.niam.secureAccessScheduler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SecureAccessSchedulerPage {

    private final int TIMEOUT_30SECONDS = 30, TIMEOUT_2MINUTES = 120;

    WebDriver driver;

    @FindBy(xpath = "//button[text()='Create' and ancestor::td[following-sibling::td[descendant::button[text()='Delete']]]]")
    WebElement CREATE_BUTTON;

    @FindBy(xpath = "//a[text()='Password Rotation']")
    WebElement PASSWORD_ROTATION_BUTTON;

    @FindBy(xpath = "//a[text()='Network Elements...']")
    WebElement NETWORK_ELEMENTS_BUTTON;

    @FindBy(xpath = "//input[ancestor::div[preceding-sibling::label[contains(text(),'Name')]]]")
    WebElement SCHEDULE_NAME_INPUT;

    @FindBy(xpath = "//input[ancestor::td[following-sibling::td[child::div[text()=':']]]]")
    WebElement START_TIME_HOUR_INPUT;

    @FindBy(xpath = "(//input[ancestor::td[preceding-sibling::td[child::div[text()=':']]]])[1]")
    WebElement START_TIME_MINUTE_INPUT;

    @FindBy(xpath = "(//input[ancestor::td[preceding-sibling::td[child::div[text()=':']]]])[2]")
    WebElement START_TIME_CLOCK_INPUT;

    @FindBy(xpath = "//span[text()='Network Elements' and ancestor::li[preceding-sibling::li[descendant::span[text()='Schedule']]]]")
    WebElement NETWORK_ELEMENTS_TAB;

    @FindBy(xpath = "//button[text()='Add' and ancestor::td[following-sibling::td[descendant::button[text()='Remove']]]]")
    WebElement ADD_BUTTON;

    @FindBy(xpath = "//button[text()='Add Selected']")
    WebElement ADD_SELECTED_BUTTON;

    @FindBy(xpath = "//button[text()='Save' and ancestor::td[following-sibling::td[descendant::button[text()='Cancel']]]]")
    WebElement SAVE_ROTATION_BUTTON;

    @FindBys(@FindBy(xpath = "//span[text()='The schedule was successfully created.']"))
    List<WebElement> CREATE_SCHEDULE_SUCCESS;

    @FindBy(xpath = "(//img[contains(@class,'x-btn-image') and ancestor::td[preceding-sibling::td[descendant::span[contains(@class,'xtb-sep x-component')]]]])[1]")
    WebElement REFRESH_BUTTON;

    @FindBys(@FindBy(xpath = "//span[contains(text(),'The schedule must start in the future.')]"))
    List<WebElement> CREATE_SCHEDULE_TIME_ERROR;

    final String DISABLED_STATUS_XPATH = "(//img[@title='Disabled' and ancestor::td[following-sibling::td[descendant::span[contains(text(),'%s')]]]])[1]";
    final String NETWORK_ELEMENT_ROTATION_NAME_XPATH = "//div[contains(@class,'x-grid3-col-neName') and text()='%s']";
    final String COMBO_LIST_DROPDOWN_XPATH = "//div[contains(@class,'x-combo-list-nakina-item') and text()='%s']";

    public SecureAccessSchedulerPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateButton() {

        CREATE_BUTTON.click();
    }

    public void clickPasswordRotationButton() {

        PASSWORD_ROTATION_BUTTON.click();
    }

    public void clickNetworkElementButton() {

        NETWORK_ELEMENTS_BUTTON.click();
    }

    public void enterScheduleName(String scheduleName) {

        SCHEDULE_NAME_INPUT.sendKeys(scheduleName);
    }

    public void enterScheduleTime(String scheduleHour, String scheduleMinute, String scheduleClock) {

        START_TIME_HOUR_INPUT.sendKeys(scheduleHour);
        driver.findElement(By.xpath(String.format(COMBO_LIST_DROPDOWN_XPATH, scheduleHour))).click();
        START_TIME_MINUTE_INPUT.sendKeys(scheduleMinute);
        driver.findElement(By.xpath(String.format(COMBO_LIST_DROPDOWN_XPATH, scheduleMinute))).click();
        START_TIME_CLOCK_INPUT.click();
        driver.findElement(By.xpath(String.format(COMBO_LIST_DROPDOWN_XPATH, scheduleClock))).click();
    }

    public void selectNetworkElementsTab() {

        NETWORK_ELEMENTS_TAB.click();
    }

    public void addNewNetworkElement(String neName) {

        ADD_BUTTON.click();
        driver.findElement(By.xpath(String.format(NETWORK_ELEMENT_ROTATION_NAME_XPATH, neName))).click();
        ADD_SELECTED_BUTTON.click();

    }

    public Boolean saveSchedule() {

        SAVE_ROTATION_BUTTON.click();

        Boolean successPresent = CREATE_SCHEDULE_SUCCESS.size() > 0;
        Boolean errorPresent = CREATE_SCHEDULE_TIME_ERROR.size() > 1;

        if (errorPresent) {
            return false;
        } else if (successPresent) {
            return true;
        } else {
            return false;
        }

    }

    public void createPasswordRotationSchedule(String scheduleName, String hour, String minute, String clock, String neName) {

        enterScheduleName(scheduleName);
        enterScheduleTime(hour, minute, clock);
        selectNetworkElementsTab();
        addNewNetworkElement(neName);
        saveSchedule();
    }

    public void waitForPasswordRotationPerformed(String scheduleName) {

        Boolean notPresent = driver.findElements(By.xpath(String.format(DISABLED_STATUS_XPATH, scheduleName))).size() == 0;
        while (notPresent) {
            REFRESH_BUTTON.click();
        }
    }





}
