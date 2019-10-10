package stepdefs.pages.r19.nacm;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.r19.nacm.network.NetworkPage;

public class NetworkPageDefinitions {

    WebDriver driver;

    @And("^NE Group \\\"([^\\\"]*)\\\" is open and adapter \\\"([^\\\"]*)\\\" is selected$")
    public void tested_adapter_is_selected(String groupName, String neName) {

        NetworkPage network = new NetworkPage(driver);

    }

    @And("^Network Element Group \\\"([^\\\"]*)\\\" is selected$")
    public void ne_group_is_selected(String groupName, String neName) {

        NetworkPage network = new NetworkPage(driver);

    }

    @Then("^Gold Standard is created from network element$")
    public void gold_standard_is_created() {


    }

    @And("^Gold Standard operation is confirmed$")
    public void gold_standard_confirmed() {

    }




}
