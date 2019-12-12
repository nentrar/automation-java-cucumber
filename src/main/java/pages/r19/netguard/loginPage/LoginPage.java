package pages.r19.netguard.loginPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final int TIMEOUT_30SECONDS = 30;

    WebDriver driver;

    //WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_30SECONDS);

    @FindBy(xpath = "//input[contains(@name,'username')]")
    static WebElement USERNAME_INPUT;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    static WebElement PASSWORD_INPUT;

    @FindBy(id = "pro-fam-name")
    static WebElement LOGIN_PAGE_TXT;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void enterUsername(String username) {

        //WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_30SECONDS);
        //wait.until(ExpectedConditions.elementToBeClickable(USERNAME_INPUT));
        USERNAME_INPUT.sendKeys(username);
    }

    public static void enterPassword(String password) {

        //WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_30SECONDS);
        //wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_INPUT));
        PASSWORD_INPUT.sendKeys(password);
    }

    public static void clickEnterButton() {

        PASSWORD_INPUT.sendKeys(Keys.ENTER);
    }

    public String getLoginPageTxt() {

        return LOGIN_PAGE_TXT.getText();

    }


}
