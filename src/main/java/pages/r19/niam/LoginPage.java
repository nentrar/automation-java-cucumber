package pages.r19.niam;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final int TIMEOUT_30SECONDS = 30;

    WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_30SECONDS);

    @FindBy(xpath = "//input[contains(@name,'username')]")
    WebElement USERNAME_INPUT;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    WebElement PASSWORD_INPUT;

    @FindBy(id = "pro-fam-name")
    WebElement LOGIN_PAGE_TXT;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {

        wait.until(ExpectedConditions.elementToBeClickable(USERNAME_INPUT));
        USERNAME_INPUT.sendKeys(username);
    }

    public void enterPassword(String password) {

        wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_INPUT));
        PASSWORD_INPUT.sendKeys(password);
    }

    public void clickEnterButton() {

        PASSWORD_INPUT.sendKeys(Keys.ENTER);
    }

    public String getLoginPageTxt() {

        return LOGIN_PAGE_TXT.getText();

    }


}
