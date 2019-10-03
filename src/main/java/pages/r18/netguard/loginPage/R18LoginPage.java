package pages.r18.netguard.loginPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class R18LoginPage {

    private final int TIMEOUT_30SECONDS = 30;

    WebDriver driver;

    //WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_30SECONDS);

    @FindBy(xpath = "//input[@id='x-auto-21-input']")
    WebElement USERNAME_INPUT;

    @FindBy(xpath = "//input[@id='x-auto-22-input']")
    WebElement PASSWORD_INPUT;

    @FindBy(id = "pro-fam-name")
    WebElement LOGIN_PAGE_TXT;


    public R18LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {

        //WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_30SECONDS);
        //wait.until(ExpectedConditions.elementToBeClickable(USERNAME_INPUT));
        USERNAME_INPUT.sendKeys(username);
    }

    public void enterPassword(String password) {

        //WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_30SECONDS);
        //wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_INPUT));
        PASSWORD_INPUT.sendKeys(password);
    }

    public void clickEnterButton() {

        PASSWORD_INPUT.sendKeys(Keys.ENTER);
    }

    public String getLoginPageTxt() {

        return LOGIN_PAGE_TXT.getText();

    }


}
