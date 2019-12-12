package pages.r19.netguard.welcomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

    private final int TIMEOUT_30SECONDS = 30;
    private final int TIMEOUT_60SECONDS = 60;

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement WARNING_WINDOW_BUTTON;

    @FindBy(xpath = "//button[contains(text(),'Nokia')]")
    WebElement NOKIA_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Network Access')]")
    WebElement NETWORKACCESS_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Network')]")
    WebElement NETWORK_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Named Credentials')]")
    WebElement NAMEDCREDENTIALS_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'NE Group Manager')]")
    WebElement NEGROUPMANAGER_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement LOGOUT_BUTTON;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement LOGOUTCONFIRM_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'User Security')]")
    WebElement USERSECURITY_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Administration')]")
    WebElement ADMINISTRATION_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Resource Access Manager')]")
    WebElement RAM_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Secure Access Scheduler')]")
    WebElement SECURE_ACCESS_SCHEDULER_XPATH;

    @FindBy(xpath = "//a[contains(text(),'Gold Standards')]")
    WebElement GOLD_STANDARDS;

//    @FindBy(xpath = "//div[contains(text(),'Network Snapshot Browser')]")
//    static WebElement NETWORK_SNAPSHOT_BROWSER_BUTTON;
    private final By NETWORK_SNAPSHOT_BROWSER_BUTTON = By.xpath("//div[contains(text(),'Network Snapshot Browser')]");
    private final String LOGGED_USER = "//div[@class='button-content' and contains(text(),'%s')]";


    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkWarningWindowPresence() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(WARNING_WINDOW_BUTTON));
            WARNING_WINDOW_BUTTON.click();
        } catch (TimeoutException e) {
            System.out.println("Warning window does not occured.");
        }

    }

    public Boolean isUserLogged(String username) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(LOGGED_USER, username))));
        Boolean isPresent = driver.findElements(By.xpath(String.format(LOGGED_USER, username))).size() > 0;

        return isPresent;


    }

    public void openMenuStart() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.visibilityOf(NOKIA_BUTTON));
        NOKIA_BUTTON.click();
    }

    public void openAdministration() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(ADMINISTRATION_BUTTON));
        ADMINISTRATION_BUTTON.click();
    }

    public void openNetworkAccess() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(NETWORKACCESS_BUTTON));
        NETWORKACCESS_BUTTON.click();
    }

    public void openNetwork() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(NETWORK_BUTTON));
        NETWORK_BUTTON.click();
    }

    public void openNamedCredentials() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(NAMEDCREDENTIALS_BUTTON));
        NAMEDCREDENTIALS_BUTTON.click();
    }

    public void openNeGroupManager() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(NEGROUPMANAGER_BUTTON));
        NEGROUPMANAGER_BUTTON.click();
    }

    public void openUserSecurity() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(USERSECURITY_BUTTON));
        USERSECURITY_BUTTON.click();
    }

    public void clickLogoutButton() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON));
        LOGOUT_BUTTON.click();
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUTCONFIRM_BUTTON));
        LOGOUTCONFIRM_BUTTON.click();
    }

    public void openResourceAccessManager() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(RAM_BUTTON));
        RAM_BUTTON.click();
    }

    public void openSecureAccessScheduler() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(SECURE_ACCESS_SCHEDULER_XPATH));
        SECURE_ACCESS_SCHEDULER_XPATH.click();
    }

    public void openGoldStandards() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(GOLD_STANDARDS));
        GOLD_STANDARDS.click();
    }

    public void openNetworkSnapshotBrowserDesktop() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_60SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(NETWORK_SNAPSHOT_BROWSER_BUTTON));

        driver.findElement(NETWORK_SNAPSHOT_BROWSER_BUTTON).click();
    }


}
