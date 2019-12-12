package stepdefs.pages.r19.nacm;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.r19.niam.networkSnapshotBrowser.NetworkSnapshotBrowserPage;

import java.util.logging.Logger;

public class NetworkSnapshotBrowserDefinitions {

    WebDriver driver;

    //static Logger logger = Logger.getLogger(NetworkSnapshotBrowserDefinitions.class.getName());

//    @When("^Network Element \\\"([^\\\"]*)\\\" is selected from the NE Group \\\"([^\\\"]*)\\\"$")
//    public void network_element_is_selected(String neName, String neGroup) {
//
//        NetworkSnapshotBrowserPage nsb = new NetworkSnapshotBrowserPage(driver);
//        nsb.expandNeGroupDropdown(neGroup);
//        nsb.selectNetworkElement(neName);
//
//        logger.info("Network Element " + neName + " is selected from the NE Group " + neGroup);
//
//
//
//    }
//
//    @When("^Network Snapshot is taken from Network Element \\\"([^\\\"]*)\\\" of NE Group \\\"([^\\\"]*)\\\"$")
//    public void snapshot_is_taken(String neName, String neGroup) {
//
//        NetworkSnapshotBrowserPage nsb = new NetworkSnapshotBrowserPage(driver);
//        nsb.openNeContextMenu(neName, neGroup);
//        nsb.takeSnapshot();
//
//        logger.info("Network Snapshot is taken from Network Element " + neName + " of the NE Group " + neGroup);
//
//
//    }
//
//    @Then("^Audit operation is executed$")
//    public void audit_is_executed() {
//
//    }
//
//    @And("^Audit Completion has been verified$")
//    public void audit_is_verified() {
//
//    }
}
