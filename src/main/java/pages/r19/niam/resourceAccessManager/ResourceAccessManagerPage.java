package pages.r19.niam.resourceAccessManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResourceAccessManagerPage {

    private final int TIMEOUT_30SECONDS = 30, TIMEOUT_2MINUTES = 120;

    WebDriver driver;

    @FindBy(xpath = "//div[@class='x-menu-list-item' and descendant::a[text()='Create Network Account Credentials...']]")
    WebElement CREATE_NE_CREDENTIALS_BUTTON;

    @FindBy(xpath = "//div[@class='x-menu-list-item' and descendant::a[text()='Create Network SNMP Credentials...']]")
    WebElement CREATE_NE_SNMP_CREDENTIALS_BUTTON;

    @FindBy(xpath = "//div[@class='x-menu-list-item' and descendant::a[text()='Delete Account Credentials...']]")
    WebElement DELETE_NE_CREDENTIALS_BUTTON;

    @FindBy(xpath = "//div[@class='x-menu-list-item' and descendant::a[text()='Create Network SNMP Credentials...']]")
    WebElement DELETE_NE_SNMP_CREDENTIALS_BUTTON;

    @FindBy(xpath = "//div[@class='x-menu-list-item' and descendant::a[text()='Add User Access']]")
    WebElement ADD_USERACCESS_BUTTON;

    @FindBy(xpath = "//input[contains(@class,'x-form-field x-form-text') and ancestor::div[preceding-sibling::label[contains(text(),'Login')]]]")
    WebElement LOGIN_INPUT;

    @FindBy(xpath = "//input[contains(@class,'x-form-field x-form-text') and ancestor::div[preceding-sibling::label[text()='Password:']]]")
    WebElement PASSWORD_INPUT;

    @FindBy(xpath = "//input[contains(@class,'x-form-field x-form-text') and ancestor::div[preceding-sibling::label[text()='Confirm Password:']]]")
    WebElement CONFIRM_PASSWORD_INPUT;

    @FindBy(xpath = "//input[contains(@class,'x-form-field x-form-text x-triggerfield-noedit') and ancestor::div[preceding-sibling::label[text()=' Store Name:']]]")
    WebElement STORE_NAME;

    @FindBy(xpath = "//input[contains(@class,'x-form-field x-form-text x-triggerfield-noedit ') and ancestor::div[preceding-sibling::label[text()='Category:']]]")
    WebElement CATEGORY;

    @FindBy(xpath = "//input[contains(@class,'x-form-field x-form-text x-triggerfield-noedit') and ancestor::div[preceding-sibling::label[text()='Network Security Profile:']]]")
    WebElement NETWORK_SECURITY_PROFILE;

    @FindBy(xpath = "//button[text()='Apply to Network']")
    WebElement APPLY_CREDENTIAL;

    @FindBys(@FindBy(xpath = "//div[@class='x-grid3-cell-inner x-grid3-col-operationResult' and child::div[text()='Success']]"))
    List<WebElement> APPLY_CREDENTIAL_SUCCESS;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement CLOSE_BUTTON;

    @FindBy(xpath = "//button[text()='Delete Selected']")
    WebElement DELETE_SELECTED_BUTTON;

    @FindBy(xpath = "//button[text()='Yes']")
    WebElement CONFIRM_DELETE_BUTTON;

    @FindBys(@FindBy(xpath = "//span[text()='Operation Completed Successfully']"))
    List<WebElement> CONFIRM_CRED_DELETE;

    @FindBy(xpath = "//a[text()='Test']")
    WebElement TEST_CREDENTIALS;

    @FindBys(@FindBy(xpath = "//span[text()='The selected credentials have been successfully tested.']"))
    List<WebElement> TEST_CRED_SUCCESS;

    @FindBy(xpath = "(//button[text()='Save'])[1]")
    WebElement SAVE_CREDENTIALS_BUTTON;

    @FindBy(xpath = "(//button[text()='Save'])[2]")
    WebElement SAVE_CREDENTIALS_BUTTON_HIDDEN;

    @FindBys(@FindBy(xpath = "(//button[text()='Save'])[1]"))
    List<WebElement> SAVE_CREDENTIALS_BUTTON_CHECK;

    @FindBys(@FindBy(xpath = "(//button[text()='Save'])[2]"))
    List<WebElement> SAVE_CREDENTIALS_BUTTON_HIDDEN_CHECK;

    @FindBy(xpath = "//button[text()='Yes']")
    WebElement APPLY_NETWORK_BUTTON;

    @FindBys(@FindBy(xpath = "//div[text()='Password Update' and ancestor::td[preceding-sibling::td[descendant::a[text()='Success']]]]"))
    List<WebElement> PASSWORD_UPDATE_SUCCESS;

    @FindBy(xpath = "//a[text()='Assign Network Security Profile']")
    WebElement ASSIGN_PROFILE_BUTTON;

    @FindBys(@FindBy(xpath = "//span[text()='Failed to create credential on some NEs. See result for more details.']"))
    List<WebElement> CREATE_CREDENTIAL_ERROR;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement CREATE_CREDENTIAL_ERROR_BUTTON;

    @FindBy(xpath = "//input[@type='password']")
    WebElement CREDENTIALS_PASSWORD_INPUT_SELECTED;

    @FindBy(xpath = "(//img[ancestor::td[preceding-sibling::td[child::span[contains(@class,'xtb-sep')]]]])[12]")
    WebElement REFRESH_BUTTON;

    @FindBys(@FindBy(xpath = "//span[text()='Current Access']"))
    List<WebElement> CURRENT_ACCESS_TITLE;

    private final String CREDENTIAL_NAME_XPATH = "//div[@class='x-grid3-cell-inner x-grid3-col-loginID' and text()='%s']";
    private final String TAB_XPATH = "//span[contains(@class,'x-tab-strip-text') and text()='%s']";
    private final String CREDENTIALS_PASSWORD_INPUT = "//div[contains(@class,'x-grid3-col-password') and parent::td[preceding-sibling::td[child::div[text()='%s']]]]";
    private final String LEFT_PANEL_DROPDOWN_XPATH = "//img[contains(@class,'x-tree3-node-joint') and following-sibling::img[contains(@class,'x-tree3-node-icon') and following-sibling::span[text()='%s']]]";
    private final String NETWORK_ELEMENT_NAME = "//span[text()='%s']";
    private final String SELECTED_PROFILE_XPATH = "//a[text()='%s']";
    private final String CONFIRM_CREDENTIAL = "//div[contains(text(),'%s')]";
    private final By WARNING_MESSAGE_TEXT = By.xpath("//div[contains(text(),'Some of the credentials did not meet password requirements. Click Yes to apply only valid Network credential passwords to the network, and save both valid and invalid System credential passwords.')]");
    private final String SELECTED_USERNAME = "//div[text()='%s' and contains(@class,'x-grid3-col-loginID')]";

    public ResourceAccessManagerPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void openNeContextMenu(String neName) {

        Actions actions = new Actions(driver);
        WebElement networkElement = driver.findElement(By.xpath(String.format(NETWORK_ELEMENT_NAME, neName)));
        actions.contextClick(networkElement).build().perform();
    }

    public void openAccountContextMenu(String username) {

        Actions actions = new Actions(driver);
        WebElement selectedUsername = driver.findElement(By.xpath(String.format(SELECTED_USERNAME, username)));
        actions.contextClick(selectedUsername).build().perform();
    }

    public void openCreateCredentials() {

        CREATE_NE_CREDENTIALS_BUTTON.click();
    }

    public void openCreateSnmpCredentials() {

        CREATE_NE_SNMP_CREDENTIALS_BUTTON.click();

    }

    public void openDeleteCredentials() {

        DELETE_NE_CREDENTIALS_BUTTON.click();

    }

    public void openDeleteSnmpCredentials() {

        DELETE_NE_SNMP_CREDENTIALS_BUTTON.click();
    }

    public void openAddUserAccess() {

        ADD_USERACCESS_BUTTON.click();

    }

    public Boolean createNetworkAccountCredentials(String credentialLogin, String credentialPassword) {

        LOGIN_INPUT.sendKeys(credentialLogin);
        PASSWORD_INPUT.sendKeys(credentialPassword);
        CONFIRM_PASSWORD_INPUT.sendKeys(credentialPassword);
        NETWORK_SECURITY_PROFILE.click();
        NETWORK_SECURITY_PROFILE.sendKeys(Keys.DOWN);
        NETWORK_SECURITY_PROFILE.sendKeys(Keys.ENTER);
        APPLY_CREDENTIAL.click();

        Boolean isPresentSuccess = APPLY_CREDENTIAL_SUCCESS.size() > 0;

        if (isPresentSuccess) {

            CLOSE_BUTTON.click();
            return true;

        } else {

            CREATE_CREDENTIAL_ERROR_BUTTON.click();
            CLOSE_BUTTON.click();
            return false;
        }

    }

    public Boolean deleteNetworkAccountCredential(String credentialName) {

        driver.findElement(By.xpath(String.format(CREDENTIAL_NAME_XPATH, credentialName))).click();
        DELETE_SELECTED_BUTTON.click();
        CONFIRM_DELETE_BUTTON.click();
        Boolean confirmDeleteSuccess = CONFIRM_CRED_DELETE.size() > 0;

        if (confirmDeleteSuccess) {
            return true;
        } else {
            return false;
        }

    }

    public void selectUserDatabaseTab(String userDatabaseTabName) {

        driver.findElement(By.xpath(String.format(TAB_XPATH, userDatabaseTabName))).click();

    }

    public void openCredentialContextMenu(String credName) {

        Actions actions = new Actions(driver);
        WebElement credentialName = driver.findElement(By.xpath(String.format(CREDENTIAL_NAME_XPATH, credName)));
        actions.contextClick(credentialName).build().perform();

    }

    public Boolean testCredentials() {

        TEST_CREDENTIALS.click();
        Boolean isPresent = TEST_CRED_SUCCESS.size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }


    }

    public Boolean changePasswordManually(String credentialName, String newPassword) throws InterruptedException {

        WebElement passwordInputUnselected = driver.findElement(By.xpath(String.format(CREDENTIALS_PASSWORD_INPUT, credentialName)));
        passwordInputUnselected.click();
        CREDENTIALS_PASSWORD_INPUT_SELECTED.sendKeys(newPassword);
        CREDENTIALS_PASSWORD_INPUT_SELECTED.sendKeys(Keys.ENTER);

        Boolean isPresentNormal = SAVE_CREDENTIALS_BUTTON_HIDDEN_CHECK.size() > 0;
        Boolean isPresentHidden = SAVE_CREDENTIALS_BUTTON_CHECK.size() > 0;

        if (isPresentNormal) {
            SAVE_CREDENTIALS_BUTTON.click();
        } else if (isPresentHidden) {
            SAVE_CREDENTIALS_BUTTON_HIDDEN.click();
        }
        APPLY_NETWORK_BUTTON.click();

        Thread.sleep(5000);

        Boolean isPresentWarning = driver.findElements(WARNING_MESSAGE_TEXT).size() > 0;

        if (isPresentWarning) {

            APPLY_NETWORK_BUTTON.click();

        }

        Boolean isPresent = PASSWORD_UPDATE_SUCCESS.size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }

    }

    public void groupDropdown(String groupName) {

        driver.findElement(By.xpath(String.format(LEFT_PANEL_DROPDOWN_XPATH, groupName))).click();

    }

    public void selectNetworkElement(String neName) {

        driver.findElement(By.xpath(String.format(NETWORK_ELEMENT_NAME, neName))).click();

    }

    public void assignNetworkSecurityProfile(String profileName) {

        ASSIGN_PROFILE_BUTTON.click();
        driver.findElement(By.xpath(String.format(SELECTED_PROFILE_XPATH, profileName))).click();

    }

    public void refreshUserList() {

        REFRESH_BUTTON.click();

    }

    public Boolean isAccessPresent() {

        Boolean isPresent = CURRENT_ACCESS_TITLE.size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean confirmCredentialExist(String credentialName) {

        Boolean isPresent = driver.findElements(By.xpath(String.format(CONFIRM_CREDENTIAL, credentialName))).size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }


    }




}
