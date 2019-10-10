package stepdefs.pages.r19.nacm;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.r19.netguard.welcomePage.WelcomePage;

public class NacmWelcomePageDefinitions {

    WebDriver driver;

    @When("^Gold Standards section is open$")
    public void gold_standards_is_open() {

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.openMenuStart();
        welcomePage.openGoldStandards();

    }


}
