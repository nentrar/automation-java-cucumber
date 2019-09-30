package pages.r19.niam.networkSnapshotBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class NetworkSnapshotBrowserPage {

    private final int TIMEOUT_30SECONDS = 30, TIMEOUT_2MINUTES = 120;

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Take Snapshot')]")
    WebElement TAKE_SNAPSHOT_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Delete Snapshot')]")
    WebElement DELETE_SNAPSHOT;

    @FindBy(xpath = "//a[contains(text(),'View NE Details...')]")
    WebElement VIEW_NE_DETAILS_BUTTON;

    @FindBy(xpath = "//span[contains(text(),'Retrieving snapshot from network...')]")
    WebElement RETRIVE_SNAPSHOT_INFO_TEXT;

    @FindBy(xpath = "//span[contains(text(),'NE Details')]")
    WebElement NE_DETAILS_WINDOW_TITLE;

    private final String NE_GROUP_DROPDOWN_XPATH = "//img[contains(@class,'x-tree3-node-joint') and following-sibling::img[contains(@class,'x-tree3-node-icon') and following-sibling::span[text()='%s']]]";
    final String NETWORK_ELEMENT = "//span[contains(text(),'%s')]";
    final String SNAPSHOT_NE = "//span[contains(text(),'%s') and ancestor::div[preceding-sibling::div[descendant::span[contains(text(),'%s')]]]]";

    public NetworkSnapshotBrowserPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void expandNeGroupDropdown(String groupName) {

        //WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_2MINUTES);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(NE_GROUP_DROPDOWN_XPATH, groupName))));
        driver.findElement(By.xpath(String.format(NE_GROUP_DROPDOWN_XPATH, groupName))).click();

    }

    public void selectNetworkElement(String neName) {

//        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_2MINUTES);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(NETWORK_ELEMENT, neName))));
        driver.findElement(By.xpath(String.format(NETWORK_ELEMENT, neName))).click();

    }

    public void openNeContextMenu(String neName, String groupName) {

        Actions actions = new Actions(driver);
        WebElement networkElement = driver.findElement(By.xpath(String.format(SNAPSHOT_NE, neName,groupName)));
        actions.contextClick(networkElement).build().perform();
    }

    public void takeSnapshot() {

        TAKE_SNAPSHOT_BUTTON.click();

    }

    public void deleteSnapshot() {

        DELETE_SNAPSHOT.click();
    }

    public void viewNeDetails() {

        VIEW_NE_DETAILS_BUTTON.click();
    }

    public void checkSnapshotOutcome(String neName, String groupName, String copyPath) {

        this.openNeContextMenu(neName, groupName);
        this.viewNeDetails();

    }






}
