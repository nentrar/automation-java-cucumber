package pages.r19.netguard.networkAccess.networkElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditNEConfigurationPage {

    WebDriver driver;

    @FindBy(xpath = "//input[parent::div[@role='combobox' and ancestor::div[child::label[contains(text(),'Administrative State')]]]]")
    WebElement ADMINISTRATIVE_STATE_COMBOBOX;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    WebElement APPLY_CHANGES_BUTTON;

    @FindBy(xpath = "//button[contains(text(),'Close')]")
    WebElement CLOSE_BUTTON;

    @FindBy(xpath = "//button[contains(text(),'Save') and ancestor::td[following-sibling::td[descendant::button[contains(text(),'Apply')]]]]")
    WebElement SAVE_BUTTON;

    private final String NE_CONFIGURATION_TAB_XPATH = "//span[contains(text(),'%s') and ancestor::li[preceding-sibling::li[descendant::span[contains(text(),'NE Details')]]]]";
    private final String SELECT_ADMINISTRATIVE_STATE_XPATH = "//div[contains(@class,'x-combo-list-nakina-item') and text()='%s']";

    public EditNEConfigurationPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void selectConfigurationTab(String tabName) {

        driver.findElement(By.xpath(String.format(NE_CONFIGURATION_TAB_XPATH, tabName))).click();
    }

    public void changeAdministrativeState(String administrativeState) {

        ADMINISTRATIVE_STATE_COMBOBOX.click();
        driver.findElement(By.xpath(String.format(SELECT_ADMINISTRATIVE_STATE_XPATH, administrativeState))).click();

    }

    public void saveChanges() {

        SAVE_BUTTON.click();
    }


}
