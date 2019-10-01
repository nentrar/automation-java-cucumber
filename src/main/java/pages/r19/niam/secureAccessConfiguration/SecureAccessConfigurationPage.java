package pages.r19.niam.secureAccessConfiguration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAccessConfigurationPage {

    private final int TIMEOUT_30SECONDS = 30, TIMEOUT_2MINUTES = 120;

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Proxy Ports')]")
    WebElement PROXY_PORT;

    @FindBy(xpath = "//img[contains(@class,'x-tree3-node-joint') and following-sibling::span[contains(text(),'Proxy Port')]]")
    WebElement PROXY_PORT_DROPDOWN;

    @FindBy(xpath = "//span[contains(text(),'Credential Categories')]")
    WebElement CREDENTIAL_CATEGORY;

    @FindBy(xpath = "//img[contains(@class,'x-tree3-node-joint') and following-sibling::span[contains(text(),'Credential Categories')]]")
    WebElement CREDENTIAL_CATEGORY_DROPDOWN;

    @FindBy(xpath = "//span[contains(text(),'Security Profile Instance Names')]")
    WebElement SECURITY_PROFILE_INSTANCE_NAMES;

    @FindBy(xpath = "//img[contains(@class,'x-tree3-node-joint') and following-sibling::span[contains(text(),'Security Profile Instance Names')]]")
    WebElement SECURITY_PROFILE_INSTANCE_NAMES_DROPDOWN;

    @FindBy(xpath = "//span[contains(text(),'NE Types')]")
    WebElement NE_TYPES;

    @FindBy(xpath = "//img[contains(@class,'x-tree3-node-joint') and following-sibling::span[contains(text(),'NE Types')]]")
    WebElement NE_TYPES_DROPDOWN;

    @FindBy(xpath = "//span[contains(text(),'Functions')]")
    WebElement FUNCTIONS;

    @FindBy(xpath = "//img[contains(@class,'x-tree3-node-joint') and following-sibling::span[contains(text(),'Functions')]]")
    WebElement FUNCTIONS_DROPDOWN;

    @FindBy(xpath = "//input[ancestor::div[preceding-sibling::label[contains(text(),'Port Name')]]]")
    WebElement PORT_NAME_INPUT;

    @FindBy(xpath = "//input[ancestor::div[preceding-sibling::label[contains(text(),'Port Number')]]]")
    WebElement PORT_NUMBER_INPUT;

    @FindBy(xpath = "//input[ancestor::div[preceding-sibling::label[contains(text(),'Protocol')]]]")
    WebElement PROTOCOL_INPUT;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement SAVE_BUTTON;

    @FindBy(xpath = "(//td[contains(@class,'x-grid3-td-neTypeBean') and contains(text(),*)])[1]")
    WebElement FIRST_EMPTY_NETYPE_LINE;

    @FindBy(xpath = "//input[contains(@class,'x-form-field x-form-text x-form-focus')]")
    WebElement NETYPE_ONLY_INPUT;

    @FindBy(xpath = "//a[contains(text(),'Create')]")
    WebElement CREATE_BUTTON;

    @FindBy(xpath = "//input[ancestor::div[preceding-sibling::label[contains(text(),'Name')]]]")
    WebElement CRED_NAME_INPUT;

    @FindBy(xpath = "//span[contains(text(),'Proxy Ports') and ancestor::div[preceding-sibling::div[descendant::span[contains(text(),'CLI')]]]]")
    WebElement PROXY_PORT_INCLI;

    @FindBy(xpath = "//div[contains(@class,'arrow-right')]")
    WebElement ARROW_RIGHT;

    @FindBy(xpath = "//input[ancestor::div[preceding-sibling::label[contains(text(),'Name')]] and following-sibling::img]")
    WebElement APP_NAME_INPUT;

    @FindBy(xpath = "//input[ancestor::div[preceding-sibling::label[contains(text(),'Display Name')]]]")
    WebElement APP_DISPLAYNAME_INPUT;

    @FindBy(xpath = "//input[following-sibling::label[contains(text(),'Application Executable')]]")
    WebElement APP_EXECUTABLE_CHECKBOX;

    @FindBy(xpath = "//input[ancestor::td[preceding-sibling::td[descendant::label[contains(text(),'Application Executable')]]]]")
    WebElement APP_EXECUTABLE_SCRIPT_INPUT;

    @FindBy(xpath = "//span[contains(text(),'Applications')]")
    WebElement APPLICATIONS;

    @FindBy(xpath = "//input[ancestor::div[preceding-sibling::label[contains(text(),'Name')]]]")
    WebElement FUNCTION_NAME_INPUT;

    @FindBy(xpath = "//input[contains(@class,'x-form-checkbox') and ancestor::div[preceding-sibling::label[contains(text(),'Video')]]]")
    WebElement FUNCTION_VIDEO_CHECKBOX;

    @FindBy(xpath = "//input[contains(@class,'x-form-checkbox') and ancestor::div[preceding-sibling::label[contains(text(),'Proxy')]]]")
    WebElement FUNCTION_PROXY_CHECKBOX;

    @FindBy(xpath = "//input[contains(@class,'x-form-checkbox') and ancestor::div[preceding-sibling::label[contains(text(),'Tasks')]]]")
    WebElement FUNCTION_TASKS_CHECKBOX;

    @FindBy(xpath = "//input[contains(@class,'x-form-checkbox') and ancestor::div[preceding-sibling::label[contains(text(),'Privilege Escalation')]]]")
    WebElement FUNCTION_PRIVESCAL_CHECKBOX;

    private final String CONFIG_ITEM_XPATH = "//span[contains(text(),'%s')]";
    private final String PROTOCOL_DROPDOWN_XPATH = "//div[@class='x-combo-list-nakina-item' and contains(text(),'%s')]";
    private final String PROXY_PORT_DROP_ITEM_XPATH = "//span[contains(text(),'%s')]";
    private final String CREDENTIAL_CATEGORY_DROP_ITEM_XPATH = "//span[contains(text(),'%s')]";
    private final String NE_IMG_DROPDOWN_XPATH = "//img[contains(@class,'x-tree3-node-joint') and following-sibling::span[contains(text(),'%s')]]";
    private final String CLI_DROPDOWN_XPATH = "(//img[contains(@class,'x-tree3-node-joint') and following-sibling::span[contains(text(),'CLI')] and ancestor::div[preceding-sibling::div[descendant::span[contains(text(),'%s')]]]])[1]";
    private final String AVAILABLE_PROXY_PORT_XPATH = "//div[contains(text(),'%s') and ancestor::tr[preceding-sibling::tr[descendant::div[contains(text(),'Available')]]]]";
    private final String SELECTED_PROXY_PORT_XPATH = "//div[contains(text(),'%s') and ancestor::tr[preceding-sibling::tr[descendant::div[contains(text(),'Selected')]]]]";
    private final String APPLICATION_ITEM_XPATH = "//span[contains(text(),'%s') and ancestor::div[preceding-sibling::div[descendant::span[contains(text(),'Applications')]]]]";
    private final String SELECT_CRED_CATEGORY_XPATH = "//div[contains(text(),'%s')]";

    public SecureAccessConfigurationPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void openConfigContextMenu(String configItem) {

        Actions actions = new Actions(driver);
        WebElement networkElement = driver.findElement(By.xpath(String.format(CONFIG_ITEM_XPATH, configItem)));
        actions.contextClick(networkElement).build().perform();

    }

    public Boolean createProxyPort(String name, String port, String protocol) {

        WebElement protocolDrop = driver.findElement(By.xpath(String.format(PROTOCOL_DROPDOWN_XPATH, protocol)));
        openConfigContextMenu("Proxy Ports");
        CREATE_BUTTON.click();
        PORT_NAME_INPUT.sendKeys(name);
        PORT_NAME_INPUT.sendKeys(Keys.ENTER);
        PORT_NUMBER_INPUT.sendKeys(port);
        PORT_NUMBER_INPUT.sendKeys(Keys.ENTER);
        PROTOCOL_INPUT.click();
        protocolDrop.click();

        Boolean isPresent = driver.findElements(By.xpath(String.format(PROXY_PORT_DROP_ITEM_XPATH, name))).size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }
    }

    public void addNetworkElementToProxyPort(String proxyPort, String networkElementType) {

        PROXY_PORT_DROPDOWN.click();
        driver.findElement(By.xpath(String.format(PROXY_PORT_DROP_ITEM_XPATH, proxyPort))).click();
        FIRST_EMPTY_NETYPE_LINE.click();
        NETYPE_ONLY_INPUT.sendKeys(networkElementType);
        NETYPE_ONLY_INPUT.sendKeys(Keys.ENTER);
        SAVE_BUTTON.click();

    }

    public Boolean createCredentialCategory(String name) {

        openConfigContextMenu("Credential Categories");
        CREATE_BUTTON.click();
        CRED_NAME_INPUT.sendKeys(name);
        SAVE_BUTTON.click();

        Boolean isPresent = driver.findElements(By.xpath(String.format(CREDENTIAL_CATEGORY_DROP_ITEM_XPATH, name))).size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean addProxyPortToNe(String neType, String proxyPort) {

        NE_TYPES_DROPDOWN.click();
        driver.findElement(By.xpath(String.format(NE_IMG_DROPDOWN_XPATH, neType))).click();
        driver.findElement(By.xpath(String.format(CLI_DROPDOWN_XPATH, neType))).click();
        PROXY_PORT_INCLI.click();
        driver.findElement(By.xpath(String.format(AVAILABLE_PROXY_PORT_XPATH, proxyPort))).click();
        ARROW_RIGHT.click();

        Boolean isPresent = driver.findElements(By.xpath(String.format(SELECTED_PROXY_PORT_XPATH, proxyPort))).size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean createSsoApplication(String neType, String ssoName, String executableScript) {

        NE_TYPES_DROPDOWN.click();
        driver.findElement(By.xpath(String.format(NE_IMG_DROPDOWN_XPATH, neType))).click();
        driver.findElement(By.xpath(String.format(CLI_DROPDOWN_XPATH, neType))).click();

        Actions actions = new Actions(driver);

        actions.contextClick(APPLICATIONS).build().perform();

        CREATE_BUTTON.click();
        APP_NAME_INPUT.sendKeys(ssoName);
        APP_DISPLAYNAME_INPUT.sendKeys(ssoName);
        APP_EXECUTABLE_CHECKBOX.click();
        APP_EXECUTABLE_SCRIPT_INPUT.sendKeys(executableScript);
        SAVE_BUTTON.click();

        Boolean isPresent = driver.findElements(By.xpath(String.format(APPLICATION_ITEM_XPATH, ssoName))).size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean createNewFunction(String functionName, Boolean videoLog, Boolean proxyLog, Boolean performTasks, Boolean privEscal, String credCategory) {

        openConfigContextMenu("Functions");
        CREATE_BUTTON.click();
        FUNCTION_NAME_INPUT.sendKeys(functionName);

        if (videoLog == false) {
            FUNCTION_VIDEO_CHECKBOX.click();
        }

        if (proxyLog == false) {
            FUNCTION_PROXY_CHECKBOX.click();
        }

        if (performTasks == true) {
            FUNCTION_TASKS_CHECKBOX.click();
        }

        if (privEscal == true) {
            FUNCTION_PRIVESCAL_CHECKBOX.click();
        }

        driver.findElement(By.xpath(String.format(SELECT_CRED_CATEGORY_XPATH, credCategory))).click();
        ARROW_RIGHT.click();
        SAVE_BUTTON.click();

        Boolean isPresent = driver.findElements(By.xpath(String.format(CONFIG_ITEM_XPATH, functionName))).size() > 0;

        if (isPresent) {
            return true;
        } else {
            return false;
        }
    }



}
