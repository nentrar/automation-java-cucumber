package stepdefs.pages.r19.nacm;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.r19.niam.networkSnapshotBrowser.NetworkSnapshotBrowserPage;

public class NetworkSnapshotBrowserDefinitions {

    WebDriver driver;

    @When("^Network Element \\\"([^\\\"]*)\\\" is selected from the NE Group \\\"([^\\\"]*)\\\"$")
    public void network_element_is_selected(String neName, String neGroup) {

        NetworkSnapshotBrowserPage nsb = new NetworkSnapshotBrowserPage(driver);
        nsb.expandNeGroupDropdown(neGroup);
        nsb.selectNetworkElement(neName);



    }

    @When("^Network Snapshot is taken from Network Element \\\"([^\\\"]*)\\\" of NE Group \\\"([^\\\"]*)\\\"$")
    public void snapshot_is_taken(String neName, String neGroup) {

        NetworkSnapshotBrowserPage nsb = new NetworkSnapshotBrowserPage(driver);
        nsb.openNeContextMenu(neName, neGroup);
        nsb.takeSnapshot();


    }

    @Then("^Audit operation is executed$")
    public void audit_is_executed() {

    }

    @And("^Audit Completion has been verified$")
    public void audit_is_verified() {

    }
}
