package stepdefs.pages.r19.niam;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.r19.netguard.welcomePage.WelcomePage;


public class WelcomePageDefinitions {

    WebDriver driver;

    private final int TIMEOUT_10SECONDS = 10;

    @When("^Resource Access Manager is open$")
    public void user_enter_login_credentials(String username, String password) {

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.openMenuStart();
        welcomePage.openResourceAccessManager();

    }






}
