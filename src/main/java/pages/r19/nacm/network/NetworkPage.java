package pages.r19.nacm.network;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetworkPage {

    private final int TIMEOUT_10SECONDS = 10, TIMEOUT_30SECONDS = 30, TIMEOUT_1MINUTE = 60, TIMEOUT_2MINUTES = 120, TIMEOUT_5MINUTES = 300;

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Network Element Search')]")
    WebElement NETWORK_SEARCH;

    @FindBy(xpath = "//input[contains(@class,'x-form-text') and @style='width: 342px;' and ancestor::td[following-sibling::td[descendant::table[contains(@class,'x-unselectable')]]]]")
    WebElement NETWORK_SEARCH_INPUT;

    @FindBy(xpath = "//a[contains(text(),'View NE...')]")
    WebElement VIEW_NE_MENU;

    @FindBy(xpath = "//a[contains(text(),'View Network Snapshot')]")
    WebElement VIEW_NETWORK_SNAPSHOT;

    @FindBy(xpath = "//button[contains(text(),'Take Snapshot')]")
    WebElement TAKE_SNAPSHOT_BUTTON;

    @FindBy(xpath = "//span[contains(text(),'Retrieving snapshot from network...')]")
    WebElement RETRIEVE_SNAPSHOT_TEXT;

    @FindBy(xpath = "//div[contains(@class,'x-tool-close') and ancestor::div[following-sibling::span[contains(text(),'Network Snapshots')]]]")
    WebElement CLOSE_SNAPSHOT_WINDOW_BUTTON;

    @FindBy(xpath = "//div[contains(@class,'x-tool-close') and ancestor::div[following-sibling::span[contains(text(),'Network')]]]")
    WebElement CLOSE_NETWORK_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Run Audit Only Now')]")
    WebElement RUN_AUDIT;

    @FindBy(xpath = "//a[contains(text(),'Use Assigned Gold Standards')]")
    WebElement USE_ASSIGNED_PROFILE;

    @FindBy(xpath = "//a[contains(text(),'Run Retrieval and Audit Now')]")
    WebElement RUN_RETRIEVAL_AUDIT;

    @FindBy(xpath = "(//span[@qtip='Audit Completed'])[2]")
    WebElement AUDIT_COMPLETED_VERIFY;

    @FindBy(xpath = "//span[text()='Audit in progress...']")
    WebElement AUDIT_IN_PROGRESS;

    @FindBy(xpath = "//a[contains(text(),'Create Gold Standard Dataset from Network Element')]")
    WebElement CREATE_GS_NETWORK_ELEMENT;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement SAVE_BUTTON;

    @FindBy(xpath = "(//input[ancestor::div[preceding-sibling::label[contains(text(),'Name')]]])[1]")
    WebElement GS_NAME_INPUT;

    @FindBy(xpath = "//button[text()='Save' and ancestor::td[following-sibling::td[descendant::button[contains(text(),'Revert')]]]]")
    WebElement GS_SAVE_BUTTON;

    @FindBy(xpath = "//span[text()='Getting data snapshot from the Network Element...']")
    WebElement GS_CREATE_IN_PROCESS;

    @FindBy(xpath = "//span[text()='Audit in process...']")
    WebElement AUDIT_IN_PROCESS;


    final String NETWORK_ELEMENT = "//span[contains(text(),'%s')]";
    final String NETWORK_SNAPSHOTS_NE = "//span[text()='Network Snapshots - %s']";
    final String GOLD_STANDARD_CREATED_WINDOW_XPATH = "//span[contains(text(),'Create Gold Standard Dataset from Network Element - %s')]";
    final By AUDIT_COMPLETED = By.xpath("//span[@qtip='Audit Completed']");
    final By NO_DISCREPANCIES = By.xpath("(//div[contains(@class,'x-grid3-col-totalNumberOfDiscrepancies') and child::span[contains(text(),'0')]])[2]");

    public NetworkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean selectNetworkElement(String neName) {

        NETWORK_SEARCH.click();
        NETWORK_SEARCH_INPUT.sendKeys(neName);
        NETWORK_SEARCH_INPUT.sendKeys(Keys.ENTER);

        Boolean selectedNetworkElement = driver.findElements(By.xpath(String.format(NETWORK_ELEMENT, neName))).size() > 0;

        if (selectedNetworkElement) {
            return true;
        } else {
            return false;
        }
    }

    public void viewNeMenuDrop() {

        VIEW_NE_MENU.click();
    }

    public void viewNetworkSnapshot() {

        VIEW_NETWORK_SNAPSHOT.click();
    }

    public void takeSnapshot() {

        TAKE_SNAPSHOT_BUTTON.click();

        // tu jeszcze trzeba sprawdzenie czy nie pojawi sie popup ze snapshota nie ma i zeby kliknac wtedy "tak"
    }

    public Boolean verifySnapshot(String neName) {

        Boolean snapshotDone = driver.findElements(By.xpath(String.format(NETWORK_SNAPSHOTS_NE, neName))).size() > 0;

        if (snapshotDone) {
            return true;
        } else {
            return false;
        }
    }

    public void openContextMenu(String neName) {

        WebElement networkElement = driver.findElement(By.xpath(String.format(NETWORK_ELEMENT, neName)));

        Actions action = new Actions(driver);
        action.contextClick(networkElement).build().perform();
    }

    public void closeSnapshotWindow() {

        CLOSE_SNAPSHOT_WINDOW_BUTTON.click();
    }

    public void closeNetwork() {

        CLOSE_NETWORK_BUTTON.click();
    }

    public void runAudit() {

        RUN_AUDIT.click();
        USE_ASSIGNED_PROFILE.click();
    }

    public void runRetrivalAndAudit() {

        RUN_RETRIEVAL_AUDIT.click();
        USE_ASSIGNED_PROFILE.click();
    }

    public Boolean verifyAuditCompleted() throws InterruptedException {

        Thread.sleep(60000);

        Boolean auditDone = driver.findElements(AUDIT_COMPLETED).size() > 0;

        if (auditDone) {
            return true;
        } else {
            return false;
        }


    }

    public void createGoldStandard(String neName, String gsName) {

        openContextMenu(neName);
        CREATE_GS_NETWORK_ELEMENT.click();
        GS_NAME_INPUT.sendKeys(gsName);
        GS_SAVE_BUTTON.click();

        // dopisać jakaś metodą sprawdzającą, że GS się rzeczywiście utworzył
    }

    public void verifyGoldStandardCreation() throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_5MINUTES);
//        wait.until(ExpectedConditions.invisibilityOf(GS_CREATE_IN_PROCESS));
        Thread.sleep(180000);
        SAVE_BUTTON.click();


    }

    public Boolean auditShowDiscrepancies(WebDriver driver) throws InterruptedException {

        Thread.sleep(120000);

        Boolean auditDone = this.driver.findElements(NO_DISCREPANCIES).size() < 0;

        if (auditDone) {
            return true;
        } else {
            return false;
        }


    }

    public Boolean auditShowNoDiscrepancies() throws InterruptedException{

        Thread.sleep(120000);

        Boolean auditDone = driver.findElements(NO_DISCREPANCIES).size() > 0;

        if (auditDone) {
            return true;
        } else {
            return false;
        }


    }





}
