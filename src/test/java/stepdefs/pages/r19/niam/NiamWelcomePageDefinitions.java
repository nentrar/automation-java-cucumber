package stepdefs.pages.r19.niam;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.r19.netguard.welcomePage.WelcomePage;


public class NiamWelcomePageDefinitions {

    private final int TIMEOUT_10SECONDS = 10;

    WebDriver driver;
    WebDriverWait wait;

    static Logger logger = Logger.getLogger(NiamWelcomePageDefinitions.class.getName());



//    @When("^Resource Access Manager is open$")
//    public void ram_is_open() {
//
//        wait = new WebDriverWait(driver, TIMEOUT_10SECONDS);
//        WelcomePage welcomePage = new WelcomePage(driver);
//
//        welcomePage.openMenuStart();
//        welcomePage.openResourceAccessManager();
//
//        logger.info("Resource Access Manager is open");
//
//    }
//
//    @And("^Network is open$")
//    public void network_is_open() {
//
//        wait = new WebDriverWait(driver, TIMEOUT_10SECONDS);
//        WelcomePage welcomePage = new WelcomePage(driver);
//
//        welcomePage.openMenuStart();
//        welcomePage.openNetwork();
//
//        logger.info("Network is open");
//
//    }
//
//    @And("^Network Snapshot Browser is open$")
//    public void network_snapshot_browser_is_open() throws InterruptedException{
//
//        //wait = new WebDriverWait(driver, TIMEOUT_10SECONDS);
//        WelcomePage welcomePage = new WelcomePage(driver);
//
//        welcomePage.openNetworkSnapshotBrowserDesktop();
//
//        logger.info("Network Snapshot Browser is open");
//
//
//    }








}
