package stepdefs.pages.r19.nacm;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.r19.nacm.network.NetworkPage;

import java.util.logging.Logger;

public class NetworkPageDefinitions {

    WebDriver driver;

    static Logger logger = Logger.getLogger(NetworkPageDefinitions.class.getName());

//    @And("^NE Group \\\"([^\\\"]*)\\\" is open and adapter \\\"([^\\\"]*)\\\" is selected$")
//    public void tested_adapter_is_selected(String groupName, String neName) {
//
//        NetworkPage network = new NetworkPage(driver);
//
//        logger.info("NE Group " + groupName + " is open and adapter " + neName + " is selected");
//
//    }

    @And("^Network Element Group \\\"([^\\\"]*)\\\" is selected$")
    public void ne_group_is_selected(String groupName, String neName) {

        NetworkPage network = new NetworkPage(driver);

        logger.info("Network Element Group " + groupName + " is selected.");

    }

//    @Then("^Gold Standard is created from network element \\\"([^\\\"]*)\\\" of ne group \\\"([^\\\"]*)\\\"$")
//    public void gold_standard_is_created(String neName, String groupName) {
//
//
//
//
//    }

//    @And("^Gold Standard operation is confirmed$")
//    public void gold_standard_confirmed() {
//
//    }




}
