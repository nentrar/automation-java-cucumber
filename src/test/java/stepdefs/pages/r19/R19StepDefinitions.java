package stepdefs.pages.r19;


import cucumber.api.DataTable;
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
import pages.r18.netguard.networkAccess.NetworkElementsPage;
import pages.r19.nacm.goldStandards.GoldStandardsPage;
import pages.r19.netguard.loginPage.LoginPage;
import pages.r19.netguard.welcomePage.WelcomePage;
import pages.r19.niam.networkSnapshotBrowser.NetworkSnapshotBrowserPage;
import pages.r19.nacm.network.NetworkPage;
import pages.r19.niam.resourceAccessManager.ResourceAccessManagerPage;
import pages.r19.niam.secureAccessScheduler.SecureAccessSchedulerPage;
import stepdefs.pages.r19.netguard.LoginPageDefinitions;
import util.Configuration;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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

    @Given("^user log into NIAM application with login \\\"([^\\\"]*)\\\" and password \\\"([^\\\"]*)\\\"$")
    public void user_log_to_niam(String login, String password) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "driver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(config.getNiamUrl());
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


    /** Netguard General Welcome Page Definitions */

    @When("^Network Access is open$")
    public void network_access_open() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openMenuStart();
        welcomePage.openAdministration();
        welcomePage.openNetworkAccess();

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

    @And("^Secure Access Scheduler is open$")
    public void secure_access_scheduler_open() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.openSecureAccessScheduler();
        logger.info("Secure Access Scheduler is open");


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

    @And("^NE Group \\\"([^\\\"]*)\\\" is open and adapter \\\"([^\\\"]*)\\\" is selected$")
    public void tested_adapter_is_selected(String groupName, String neName) {

        NetworkPage network = new NetworkPage(driver);



        logger.info("NE Group " + groupName + " is open and adapter " + neName + " is selected");

    }

    /** Resource Access Manager Definitions */

    @Then("^user creates Network Account Credentials for adapter \\\"([^\\\"]*)\\\" with following parameters$")
    public void user_create_credentials_with_parameters(String neName, DataTable dt) {

        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        ResourceAccessManagerPage ram = new ResourceAccessManagerPage(driver);
        ram.openNeContextMenu(neName);
        ram.openCreateCredentials();
        Assert.assertTrue(ram.createNetworkAccountCredentials(list.get(0).get("Login ID"), list.get(0).get("Password")));

        logger.info("User creates Network Account Credentials for adapter " + neName + " with login " + list.get(0).get("Login ID") + " and password " + list.get(0).get("Password"));
    }

    @And("^create new account credential \\\"([^\\\"]*)\\\" in \\\"([^\\\"]*)\\\" databases is confirmed$")
    public void create_credentials_confirmed(String credentialName, String databaseName) {

        ResourceAccessManagerPage ram = new ResourceAccessManagerPage(driver);
        ram.selectUserDatabaseTab(databaseName);
        Assert.assertTrue(ram.confirmCredentialExist(credentialName));

        logger.info("User create new account credential " + credentialName + " in " + databaseName + " database with success.");

    }

    @And("^store name \\\"([^\\\"]*)\\\" is selected$")
    public void select_user_database(String databaseName) throws InterruptedException {

        Thread.sleep(5000);
        ResourceAccessManagerPage ram = new ResourceAccessManagerPage(driver);
        ram.selectUserDatabaseTab(databaseName);

        logger.info("Store name " + databaseName + " is selected.");

    }

    @Then("^password for the credential \\\"([^\\\"]*)\\\" is changed to \\\"([^\\\"]*)\\\" with success$")
    public void password_of_credential_is_changed(String credentialName, String newPassword) throws InterruptedException{

        Thread.sleep(5000);
        ResourceAccessManagerPage ram = new ResourceAccessManagerPage(driver);
        Assert.assertTrue(ram.changePasswordManually(credentialName, newPassword));

        logger.info("Password for the " + credentialName + " is changed to " +  newPassword + " with success");
    }

    @Then("^from network element \\\"([^\\\"]*)\\\" a credential \\\"([^\\\"]*)\\\" is deleted with success$")
    public void credential_deleted(String neName, String credentialName) {

        ResourceAccessManagerPage ram = new ResourceAccessManagerPage(driver);

        ram.openNeContextMenu(neName);
        ram.openDeleteCredentials();
        Assert.assertTrue(ram.deleteNetworkAccountCredential(credentialName));

        logger.info("Credential " + credentialName + "is deleted from Network Element " + neName + " with success.");


    }

    @When("^Assign Network Security Profile is performed for the selected user \\\"([^\\\"]*)\\\"$")
    public void assign_network_security_profile(String userName) {

        ResourceAccessManagerPage ram = new ResourceAccessManagerPage(driver);
        ram.openAccountContextMenu(userName);
        ram.assignNetworkSecurityProfile(userName);

        logger.info("Security Profile has been assigned to selected user " + userName);
    }

    @Then("^Network Security Profile should be assigned successfully$")
    public void assign_secprof_success() {

        ResourceAccessManagerPage ram = new ResourceAccessManagerPage(driver);
        ram.isAccessPresent();
        logger.info("Security Profile Assign action result in success.");



    }

    /** Network Access Definitions */

    @When("^Verify Configuration on Network Element \\\"([^\\\"]*)\\\" is performed$")
    public void verify_configuration(String neName) throws InterruptedException {

        NetworkElementsPage networkElements =  new NetworkElementsPage(driver);
        networkElements.changeManagementState(neName, "Unmanaged");
        networkElements.changeManagementState(neName, "Under Test");
        networkElements.verifyConfiguration(neName);


    }

    @Then("^Fingerprint operation should finish in success$")
    public void fingerprint_success() {

        NetworkElementsPage networkElements =  new NetworkElementsPage(driver);
        Assert.assertTrue(networkElements.verifyFingerprintSuccess());

    }

    /** Secure Access Scheduler */

    @When("^user creates new Password Rotation Schedule with following parameters$")
    public void password_rotation_create(DataTable dt) {

        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        SecureAccessSchedulerPage scheduler = new SecureAccessSchedulerPage(driver);
        scheduler.clickCreateButton();
        scheduler.enterScheduleName(list.get(0).get("Name"));
        scheduler.enterScheduleTime(list.get(0).get("Schedule Hour"), list.get(0).get("Schedule Minute"), list.get(0).get("Schedule Clock"));
        scheduler.selectNetworkElementsTab();
        scheduler.addNewNetworkElement(list.get(0).get("Network Element"));
        scheduler.saveSchedule();


    }

    @Then("^Password Rotation Schedule \\\"([^\\\"]*)\\\" is performed within the time set with success$")
    public void password_rotation_success(String scheduleName) {

        SecureAccessSchedulerPage scheduler = new SecureAccessSchedulerPage(driver);
        scheduler.waitForPasswordRotationPerformed(scheduleName);



    }





}

