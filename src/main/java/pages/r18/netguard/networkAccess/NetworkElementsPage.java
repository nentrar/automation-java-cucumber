package pages.r18.netguard.networkAccess;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetworkElementsPage {

    private final int TIMEOUT_30SECONDS = 30;
    private final int TIMEOUT_60SECONDS = 60;

    WebDriver driver;

    private final By VERIFY_CONFIG_XPATH = By.xpath("//a[contains(text(),'Verify Configuration on Selection...')]");
    private final By VERIFY_SUCCESS_XPATH = By.xpath("//span[contains(text(),'Verify Configuration Completed [1 success, 0 failed]')]");
    private final By VERIFY_FAILED_XPATH = By.xpath("//span[contains(text(),'Verify Configuration Completed [0 success, 1 failed]')]");
    private final By CLOSE_BUTTON_XPATH = By.xpath("//button[contains(text(),'Close')]");
    private final By NEWORKSHEET_CLOSE_BUTTON_XPATH = By.xpath("//button[contains(text(),'Close')]");
    private final By NETWORK_ACCESS_BUTTON_XPATH = By.xpath("//button[text()='Network Access']");
    private final By CLOSE_WINDOW_XPATH = By.xpath("//a[text()='Close window']");
    private final By CHANGE_MANAGEMENT_STATE_XPATH = By.xpath("//a[contains(text(),'Change Management State on Selection')]");
    private final By POPUP_CHANGE_STATE_XPATH = By.xpath("//span[contains(text(),'Changing Management State')]");
    private final By CLOSE_POPUP_XPATH = By.xpath("//button[contains(text(),'Close')]");
    private final By EDIT_CONFIGURATION_XPATH = By.xpath("//a[contains(text(),'Edit NE Configuration...')]");
    private final By VERIFY_IN_PROGRESS = By.xpath("//span[contains(text(),'Verify Configuration [Completed 0 of 1 NEs - 0 success, 0 failed]')]");

    private final String NETWORK_ELEMENT_XPATH = "//div[contains(@class,'x-grid3-col-neName') and text()='%s']";
    private final String NE_CHANGED_STATE_XPATH = "//div[text()='%s' and ancestor::td[preceding-sibling::td[child::div[text()='%s']]]]";
    private final String MANAGEMENT_STATE_XPATH = "//a[text()='%s']";

    public NetworkElementsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void openContextMenu(String neName) {

        // This method is responsible for open context menu on the network element

        (new WebDriverWait(driver, TIMEOUT_60SECONDS)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(NETWORK_ELEMENT_XPATH, neName))));

        WebElement networkElement = driver.findElement(By.xpath(String.format(NETWORK_ELEMENT_XPATH, neName)));

        Actions action = new Actions(driver);
        action.contextClick(networkElement).build().perform();


    }

    public Boolean changeManagementState(String neName, String managementState) throws InterruptedException {

        // First we open context menu on NE

        openContextMenu(neName);

        // Then choose to change management state of Network Element to chosen state

        WebElement changeState = driver.findElement(CHANGE_MANAGEMENT_STATE_XPATH);

        changeState.click();

        WebElement chosenState = driver.findElement(By.xpath(String.format(MANAGEMENT_STATE_XPATH, managementState)));

        chosenState.click();

        closeManagementStatePopup();

        // Next we wait 2 minutes until management state changes

        (new WebDriverWait(driver, TIMEOUT_60SECONDS)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(NE_CHANGED_STATE_XPATH, managementState, neName))));

        // At the end we log if operation succeed or not

        try {

            driver.findElement(By.xpath(String.format(NE_CHANGED_STATE_XPATH, managementState, neName)));

            return true;
        }

        catch (NoSuchElementException exception) {

            return false;
        }
    }

    public void verifyConfiguration(String neName) throws InterruptedException {

        // This method run fingerprint test

        openContextMenu(neName);

        WebElement changeState = driver.findElement(VERIFY_CONFIG_XPATH);

        changeState.click();


    }

    public Boolean verifyFingerprintSuccess() {

        //Thread.sleep(30000);

        (new WebDriverWait(driver, TIMEOUT_60SECONDS)).until(ExpectedConditions.invisibilityOfElementLocated(VERIFY_IN_PROGRESS));

        Boolean isSuccess = driver.findElements(VERIFY_SUCCESS_XPATH).size() > 0;
        Boolean isFailed = driver.findElements(VERIFY_FAILED_XPATH).size() > 0;


        //After one minute of wait we check if the XPATH exist and log success or failed.

        if (isSuccess == true) {

            return true;

        }

        else if (isFailed == true) {

            return false;
        }

        else {
            return false;
        }
    }

    public void closeNeWorksheet() throws InterruptedException {

        // This method close Verify Configuration window

        //(new WebDriverWait(driver, TIMEOUT_30SECONDS)).until(ExpectedConditions.presenceOfElementLocated(CLOSE_BUTTON_XPATH));

        Thread.sleep(30000);
        WebElement closeButton = driver.findElement(CLOSE_BUTTON_XPATH);

        closeButton.click();

//        try {
//
//            (new WebDriverWait(driver, TIMEOUT_60SECONDS)).until(ExpectedConditions.presenceOfElementLocated(CLOSE_BUTTON_XPATH));
//
//            driver.findElement(CLOSE_BUTTON_XPATH).click();
//
//        }
//
//        catch (NoSuchElementException exception) {
//
//
//
//        }

    }

    public void closeNetworkElements() {

        WebElement nokiaAccessButton = driver.findElement(NETWORK_ACCESS_BUTTON_XPATH);
        Actions action = new Actions(driver);
        action.contextClick(nokiaAccessButton).build().perform();
        driver.findElement(CLOSE_WINDOW_XPATH);
    }

    public Boolean verifyAdapterManaged(String managementState, String neName ) throws InterruptedException {

        Thread.sleep(60000);
        Boolean isPresent = driver.findElements(By.xpath(String.format(NE_CHANGED_STATE_XPATH, managementState, neName))).size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }
    }

    public void closeManagementStatePopup() throws InterruptedException {

//        (new WebDriverWait(driver, TIMEOUT_60SECONDS)).until(ExpectedConditions.presenceOfElementLocated(POPUP_CHANGE_STATE_XPATH));
//        (new WebDriverWait(driver, TIMEOUT_60SECONDS)).until(ExpectedConditions.presenceOfElementLocated(CLOSE_POPUP_XPATH));
        Thread.sleep(15000);
        driver.findElement(CLOSE_POPUP_XPATH).click();
    }

    public void selectEditNeConfiguration() {

        (new WebDriverWait(driver, TIMEOUT_30SECONDS)).until(ExpectedConditions.presenceOfElementLocated(EDIT_CONFIGURATION_XPATH));
        driver.findElement(EDIT_CONFIGURATION_XPATH).click();


    }
}
