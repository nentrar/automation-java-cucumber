package stepdefs.pages.r19;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.sl.In;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.r19.nacm.goldStandards.GoldStandardsPage;
import pages.r19.netguard.loginPage.LoginPage;
import pages.r19.netguard.welcomePage.WelcomePage;
import pages.r19.niam.networkSnapshotBrowser.NetworkSnapshotBrowserPage;
import pages.r19.nacm.network.NetworkPage;
import stepdefs.pages.r19.netguard.LoginPageDefinitions;
import util.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class R19StepDefinitions {

    private final int TIMEOUT_10SECONDS = 10;

    WebDriver driver;
    WebDriverWait wait;

    Configuration config = new Configuration();

    static Logger logger = Logger.getLogger(R19StepDefinitions.class.getName());

    /** General Definitions */

    @And("^application is closed$")
    public void application_closed() {

        driver.close();
        logger.info("Netguard application has been closed.");
    }

    /** Login Page Definitions */

    @Given("^user open NIAM login page$")
    public void niam_login_page_is_open() {

        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(config.getNiamUrl());
        driver.manage().window().maximize();
        logger.info("NIAM login page is open and ready for performing tests");


        //driver.manage().timeouts().implicitlyWait(TIMEOUT_10SECONDS, TimeUnit.SECONDS);


    }

    @Given("^user open NACM login page$")
    public void nacm_login_page_is_open() {

        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(config.getNacmUrl());
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(TIMEOUT_10SECONDS, TimeUnit.SECONDS);
        logger.info("NACM login page is open and ready for performing tests");

    }

    @When("^user enter \\\"([^\\\"]*)\\\" as login and \\\"([^\\\"]*)\\\" as password$")
    public void user_enter_login_credentials(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickEnterButton();

        logger.info("Login operation is performed with credentials " + username + "/" + password);

    }

    @Then("^user \\\"([^\\\"]*)\\\" log into NIAM dashboard with success$")
    public void user_log_to_niam_dashboard(String username) throws IOException, InterruptedException {
        //wait = new WebDriverWait(getDriver(), TIMEOUT_10SECONDS);

        WelcomePage niamDashboard = new WelcomePage(driver);
        //Assert.assertTrue(niamDashboard.isUserLogged(username));

        logger.info("NACM login page is open and ready for performing tests");


//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("testResults/SeleniumEasy/open_seleniumeasy_webpage_screenshot.png"));

    }

    @Given("^user log into NACM application with login \\\"([^\\\"]*)\\\" and password \\\"([^\\\"]*)\\\"$")
    public void user_log_to_nacm(String login, String password) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(config.getNacmUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT_10SECONDS, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(login);
        loginPage.enterPassword(password);
        loginPage.clickEnterButton();

        WelcomePage niamDashboard = new WelcomePage(driver);
        Assert.assertTrue(niamDashboard.isUserLogged(login));

        logger.info("Login operation is performed with credentials " + login + "/" + password);


    }

    @Given("^user log into NACM application with login \\\"([^\\\"]*)\\\" and password \\\"([^\\\"]*)\\\" and open start$")
    public void log_and_open_start(String login, String password) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(config.getNacmUrl());
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_10SECONDS);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(login);
        loginPage.enterPassword(password);
        loginPage.clickEnterButton();

        WelcomePage niamDashboard = new WelcomePage(driver);
        niamDashboard.openMenuStart();

        logger.info("Login operation is performed with credentials " + login + "/" + password);


    }



    /** NACM Welcome Page Definitions  */

    @When("^Gold Standards section is open$")
    public void gold_standards_is_open() {

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.openMenuStart();
        welcomePage.openGoldStandards();

        logger.info("Gold Standard section is opened.");

    }

    /** NIAM Welcome Page Definitions */

    @When("^Resource Access Manager is open$")
    public void ram_is_open() {

        wait = new WebDriverWait(driver, TIMEOUT_10SECONDS);
        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.openMenuStart();
        welcomePage.openResourceAccessManager();

        logger.info("Resource Access Manager is open");

    }

    @And("^Network is open$")
    public void network_is_open() {

        wait = new WebDriverWait(driver, TIMEOUT_10SECONDS);
        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.openMenuStart();
        welcomePage.openNetwork();

        logger.info("Network is open");

    }

    @And("^Network Snapshot Browser is open$")
    public void network_snapshot_browser_is_open() throws InterruptedException{

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.openNetworkSnapshotBrowserDesktop();

        logger.info("Network Snapshot Browser is open");


    }

    /** Network Snapshot Browser Definitions */

    @When("^Network Element \\\"([^\\\"]*)\\\" is selected from the NE Group \\\"([^\\\"]*)\\\"$")
    public void network_element_is_selected(String neName, String neGroup) {

        NetworkSnapshotBrowserPage nsb = new NetworkSnapshotBrowserPage(driver);
        nsb.expandNeGroupDropdown(neGroup);
        nsb.selectNetworkElement(neName);

        logger.info("Network Element " + neName + " is selected from the NE Group " + neGroup);



    }

    @When("^Network Snapshot is taken from Network Element \\\"([^\\\"]*)\\\" of NE Group \\\"([^\\\"]*)\\\"$")
    public void snapshot_is_taken(String neName, String neGroup) {

        NetworkSnapshotBrowserPage nsb = new NetworkSnapshotBrowserPage(driver);
        nsb.openNeContextMenu(neName, neGroup);
        nsb.takeSnapshot();

        logger.info("Network Snapshot is taken from Network Element " + neName + " of the NE Group " + neGroup);


    }

    @Then("^Audit operation is executed for network element \\\"([^\\\"]*)\\\"$")
    public void audit_is_executed(String neName) {

        NetworkPage network = new NetworkPage(driver);
        network.openContextMenu(neName);
        network.runAudit();

    }

    @Then("^Audit operation is executed for network element \\\"([^\\\"]*)\\\" with retrival$")
    public void audit_is_executed_with_retrival(String neName) {

        NetworkPage network = new NetworkPage(driver);
        network.openContextMenu(neName);
        network.runRetrivalAndAudit();

    }

    @And("^Audit Completion has been verified$")
    public void audit_is_verified() throws InterruptedException {

        NetworkPage network = new NetworkPage(driver);
        Assert.assertTrue(network.verifyAuditCompleted());





    }

    /** Gold Standard Definitions */

    @Then("^Gold Standard \\\"([^\\\"]*)\\\" is assigned to Network Element \\\"([^\\\"]*)\\\"$")
    public void gold_standard_is_assigned(String gsName, String neName) {

        GoldStandardsPage gs = new GoldStandardsPage(driver);
        gs.assignGoldStandard(gsName, neName);

        logger.info("Gold Standard is assigned to Network Element " + neName);

    }

    @When("^Gold Standard is selected$")
    public void gold_standard_is_selected() {

    }

    @And("^assigning gold standard to network element \\\"([^\\\"]*)\\\" is confirmed$")
    public void gold_standard_confirmed(String neName) throws InterruptedException {

        GoldStandardsPage gs = new GoldStandardsPage(driver);
        //gs.clickRefreshButton();
        Thread.sleep(5000);
        Assert.assertTrue(gs.isGoldStandardAssigned(neName));

        logger.info("Gold Standard assign operation is confirmed");

    }

    @And("^audit discrepancies should be shown$")
    public void audit_discrepancies_shown() throws InterruptedException {

        NetworkPage network = new NetworkPage(driver);
        Assert.assertTrue(network.auditShowDiscrepancies(driver));

    }

    @And("^audit discrepancies should not be shown$")
    public void audit_discrepancies_not_shown() throws InterruptedException {

        NetworkPage network = new NetworkPage(driver);
        Assert.assertFalse(network.auditShowDiscrepancies(driver));

    }

    @Then("^automatic reconcile should be executed$")
    public void automatic_reconcile_is_executed() {

    }

    @And("^anomaly should be corrected$")
    public void anomaly_is_corrected() {

    }

    /** Network Definitions */

    @And("^Network Element \\\"([^\\\"]*)\\\" is selected$")
    public void network_element_is_selected(String neName) throws InterruptedException {

        NetworkPage network = new NetworkPage(driver);

        network.selectNetworkElement(neName);
        Thread.sleep(20000);
    }

    @Then("^Gold Standard \\\"([^\\\"]*)\\\" is created from network element \\\"([^\\\"]*)\\\"$")
    public void gold_standard_is_created(String gsName, String neName) {

        NetworkPage network = new NetworkPage(driver);

        network.openContextMenu(neName);
        network.createGoldStandard(neName,gsName);



    }

    @And("^Gold Standard operation is confirmed$")
    public void gold_standard_creation_is_confirmed() throws InterruptedException {

        NetworkPage network = new NetworkPage(driver);
        network.verifyGoldStandardCreation();

    }



}

