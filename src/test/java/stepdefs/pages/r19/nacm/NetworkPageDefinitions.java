package stepdefs.pages.r19.nacm;

import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.r19.nacm.network.NetworkPage;

public class NetworkPageDefinitions {

    WebDriver driver;

    @And("^NE Group \\\"([^\\\"]*)\\\" is open and adapter \\\"([^\\\"]*)\\\" is selected$")
    public void tested_adapter_is_selected(String groupName, String neName) {

        NetworkPage network = new NetworkPage(driver);

    }
}
