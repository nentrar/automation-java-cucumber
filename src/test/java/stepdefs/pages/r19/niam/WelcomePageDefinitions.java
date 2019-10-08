package stepdefs.pages.r19.niam;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.r19.netguard.welcomePage.WelcomePage;


public class WelcomePageDefinitions {

    WebDriver driver;

    private final int TIMEOUT_10SECONDS = 10;

    @When("^Resource Access Manager is open$")
    public void ram_is_open() {

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.openMenuStart();
        welcomePage.openResourceAccessManager();

    }

    @And("^Network is open$")
    public void network_is_open() {

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.openMenuStart();
        welcomePage.openNetwork();

    }

    @And("^Network Snapshot Browser is open$")
    public void network_snapshot_browser_is_open() {

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.openMenuStart();


    }






}
