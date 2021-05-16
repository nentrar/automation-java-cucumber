package stepdefs.pages.wordpress;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.wordpress.loginPage.LoginPage;
import pages.wordpress.dashboardPage.DashboardPage;
import util.Configuration;

import java.io.IOException;

public class LoginPageStepDefinitions {

    private final int TIMEOUT_10SECONDS = 10;

    WebDriver driver;
    WebDriverWait wait;

    Configuration config = new Configuration();

    static Logger logger = Logger.getLogger(LoginPageStepDefinitions.class.getName());

    /**
     * Sekretna Biblioteczka Login Page Definitions
     */

    @Given("^user open Sekretna Biblioteczka login page$")
    public void niam_login_page_is_open() {

        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(config.getSekretnaUrl());
        driver.manage().window().maximize();
        logger.info("Sekretna Biblioteczka login page is open and ready for performing tests");


    }

    @When("^user enter \\\"([^\\\"]*)\\\" as login and \\\"([^\\\"]*)\\\" as password$")
    public void user_enter_login_credentials(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickEnterButton();

        logger.info("Login operation is performed with credentials " + username + "/" + password);

    }

    @Then("^user \\\"([^\\\"]*)\\\" log into Sekretna Biblioteczka wordpress dashboard with success$")
    public void user_log_to_niam_dashboard(String username) throws IOException, InterruptedException {
        //wait = new WebDriverWait(getDriver(), TIMEOUT_10SECONDS);

        DashboardPage sekretnaDashboard = new DashboardPage(driver);
        sekretnaDashboard.openProfilePage(username);

        logger.info("Wordpress dashboard page is open");


//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("testResults/wordpress_dashboard_log_screenshot.png"));

    }
}