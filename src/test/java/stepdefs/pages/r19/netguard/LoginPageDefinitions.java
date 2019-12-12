package stepdefs.pages.r19.netguard;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.r19.netguard.loginPage.LoginPage;
import pages.r19.netguard.welcomePage.WelcomePage;
import util.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPageDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    private final int TIMEOUT_10SECONDS = 10;

    Configuration config = new Configuration();

    static Logger logger = Logger.getLogger(LoginPageDefinitions.class.getName());




    //final Logger log = Logger.getLogger(LoginPageDefinitions.class.getName());

//    Properties config = new Properties();
//    FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
//    config.load(inputStream);
//    public LoginPageDefinitions() throws FileNotFoundException {}

//    @Given("^user open NIAM login page$")
//    public void niam_login_page_is_open() {
//
//        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
//        driver.get(config.getNiamUrl());
//        driver.manage().window().maximize();
//        logger.info("NIAM login page is open and ready for performing tests");
//
//
//        //driver.manage().timeouts().implicitlyWait(TIMEOUT_10SECONDS, TimeUnit.SECONDS);
//
//
//    }
//
//    @Given("^user open NACM login page$")
//    public void nacm_login_page_is_open(String niamUrl) {
//
//        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
//        driver.get(config.getNacmUrl());
//        driver.manage().window().maximize();
//        //driver.manage().timeouts().implicitlyWait(TIMEOUT_10SECONDS, TimeUnit.SECONDS);
//        logger.info("NACM login page is open and ready for performing tests");
//
//    }
//
//    @When("^user enter \\\"([^\\\"]*)\\\" as login and \\\"([^\\\"]*)\\\" as password$")
//    public void user_enter_login_credentials(String username, String password) {
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//        loginPage.clickEnterButton();
//
//        logger.info("Login operation is performed with credentials " + username + "/" + password);
//
//    }
//
//    @Then("^user \\\"([^\\\"]*)\\\" log into NIAM dashboard with success$")
//    public void user_log_to_niam_dashboard(String username) throws IOException, InterruptedException {
//        //wait = new WebDriverWait(getDriver(), TIMEOUT_10SECONDS);
//
//        WelcomePage niamDashboard = new WelcomePage(driver);
//        //Assert.assertTrue(niamDashboard.isUserLogged(username));
//
//        logger.info("NACM login page is open and ready for performing tests");
//
//
////        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
////        FileUtils.copyFile(scrFile, new File("testResults/SeleniumEasy/open_seleniumeasy_webpage_screenshot.png"));
//
//    }
//
//    @Given("^user log into NACM application with login \\\"([^\\\"]*)\\\" and password \\\"([^\\\"]*)\\\"$")
//    public void user_log_to_nacm(String login, String password) throws InterruptedException {
//
//        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
//        driver.get(config.getNacmUrl());
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(TIMEOUT_10SECONDS, TimeUnit.SECONDS);
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.enterUsername(login);
//        loginPage.enterPassword(password);
//        loginPage.clickEnterButton();
//
//        WelcomePage niamDashboard = new WelcomePage(driver);
//        Assert.assertTrue(niamDashboard.isUserLogged(login));
//
//        logger.info("Login operation is performed with credentials " + login + "/" + password);
//
//
//    }
//
//    @Given("^user log into NACM application with login \\\"([^\\\"]*)\\\" and password \\\"([^\\\"]*)\\\" and open start$")
//    public void log_and_open_start(String login, String password) throws InterruptedException {
//
//        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
//        driver.get(config.getNacmUrl());
//        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_10SECONDS);
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.enterUsername(login);
//        loginPage.enterPassword(password);
//        loginPage.clickEnterButton();
//
//        WelcomePage niamDashboard = new WelcomePage(driver);
//        niamDashboard.openMenuStart();
//
//        logger.info("Login operation is performed with credentials " + login + "/" + password);
//
//
//    }


}




