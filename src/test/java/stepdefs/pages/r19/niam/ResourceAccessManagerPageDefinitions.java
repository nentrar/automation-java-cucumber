package stepdefs.pages.r19.niam;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.r19.niam.resourceAccessManager.ResourceAccessManagerPage;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class ResourceAccessManagerPageDefinitions {

    WebDriver driver;

    private final int TIMEOUT_10SECONDS = 10;

    static Logger logger = Logger.getLogger(ResourceAccessManagerPageDefinitions.class.getName());

//    @And("^NE Group \\\"([^\\\"]*)\\\" is open and adapter \\\"([^\\\"]*)\\\" is selected$")
//    public void tested_adapter_is_selected(String groupName, String neName) {
//
//        ResourceAccessManagerPage ram = new ResourceAccessManagerPage(driver);
//        ram.groupDropdown(groupName);
//        ram.selectNetworkElement(neName);
//
//        Assert.assertTrue(ram.isAccessPresent());
//    }

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
    public void select_user_database(String databaseName) {

        ResourceAccessManagerPage ram = new ResourceAccessManagerPage(driver);
        ram.selectUserDatabaseTab(databaseName);

        logger.info("Store name " + databaseName + " is selected.");

    }

    @Then("^password for the credential \\\"([^\\\"]*)\\\" is changed to \\\"([^\\\"]*)\\\" with success$")
    public void password_of_credential_is_changed(String credentialName, String newPassword) {

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




}
