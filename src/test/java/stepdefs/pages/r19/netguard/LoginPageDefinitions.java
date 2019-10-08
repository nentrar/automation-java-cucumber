package stepdefs.pages.r19.netguard;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.r19.netguard.loginPage.LoginPage;
import pages.r19.netguard.welcomePage.WelcomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPageDefinitions {

    WebDriver driver;

    private final int TIMEOUT_10SECONDS = 10;



    //final Logger log = Logger.getLogger(LoginPageDefinitions.class.getName());

//    Properties config = new Properties();
//    FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
//    config.load(inputStream);
//    public LoginPageDefinitions() throws FileNotFoundException {}

    @Given("^user open NIAM login page$")
    public void niam_login_page_is_open(String niamUrl) {

        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.56.1:8080/netguard_iam/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT_10SECONDS, TimeUnit.SECONDS);



    }

    @Given("^user open NACM login page$")
    public void nacm_login_page_is_open(String niamUrl) {

        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.56.1:8080/netguard_acm/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT_10SECONDS, TimeUnit.SECONDS);



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

    @Given("^user log into NACM application with login \\\"([^\\\"]*)\\\" and password \\\"([^\\\"]*)\\\"$")
    public void user_log_to_nacm(String login, String password) {

        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.56.1:8080/netguard_iam/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT_10SECONDS, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(login);
        loginPage.enterPassword(password);
        loginPage.clickEnterButton();

        WelcomePage niamDashboard = new WelcomePage(driver);
        Assert.assertTrue(niamDashboard.getLoggedUser().contains(login));


    }




}
