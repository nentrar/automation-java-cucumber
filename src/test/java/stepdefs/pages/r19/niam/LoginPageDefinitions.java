package stepdefs.pages.r19.niam;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.r19.niam.LoginPage;
import pages.r19.niam.WelcomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPageDefinitions {

    WebDriver driver;

    //final Logger log = Logger.getLogger(LoginPageDefinitions.class.getName());

//    Properties config = new Properties();
//    FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
//    config.load(inputStream);
//    public LoginPageDefinitions() throws FileNotFoundException {}

    @Given("^user open NIAM login page$")
    public void login_page_is_open(String niamUrl) {

        driver = new FirefoxDriver();
        driver.get(niamUrl);
        driver.manage().window().maximize();



    }

    @When("^user enter \\\"([^\\\"]*)\\\" as login and \\\"([^\\\"]*)\\\" as password$")
    public void user_enter_login_credentials(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickEnterButton();

    }

    @Then("^user \\\"([^\\\"]*)\\\" log into NIAM dashboard with success$")
    public void user_log_to_niam_dashboard(String username) throws IOException {

        WelcomePage niamDashboard = new WelcomePage(driver);
        Assert.assertTrue(niamDashboard.getLoggedUser().contains(username));

//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("testResults/SeleniumEasy/open_seleniumeasy_webpage_screenshot.png"));



    }




}
