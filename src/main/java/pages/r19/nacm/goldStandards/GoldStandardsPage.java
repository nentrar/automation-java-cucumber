package pages.r19.nacm.goldStandards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class GoldStandardsPage {

    private final int TIMEOUT_10SECONDS = 10, TIMEOUT_30SECONDS = 30, TIMEOUT_1MINUTE = 60, TIMEOUT_2MINUTES = 120;

    WebDriver driver;

    @FindBy(xpath = "(//input[ancestor::div[@class='x-panel-bwrap' and preceding-sibling::div[descendant::span[text()='Search Criteria']]]])[3]")
    WebElement GS_SEARCH_INPUT;

    @FindBy(xpath = "//button[text()='Search']")
    WebElement GS_SEARCH_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'Assign to NEs...')]")
    WebElement ASSIGN_NE;

    @FindBy(xpath = "//button[contains(text(),'Assign Selected')]")
    WebElement ASSIGN_SELECTED_BUTTON;

    @FindBy(xpath = "//span[@role='heading' and contains(text(),'Question')]")
    WebElement QUESTION_HEADING;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement YES_BUTTON;

    @FindBy(xpath = "//button[contains(text(),'Close')]")
    WebElement CLOSE_BUTTON;

    final String GOLD_STANDARD = "//div[@qtip='%s']";
    final String NETWORK_ELEMENT = "//span[@qtip='%s']";
    final String IS_ASSIGNED_IMG = "//img[@title='Gold Standard is assigned' and ancestor::td[preceding-sibling::td[descendant::div[contains(text(),'%s')]]]]";

    public GoldStandardsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goldStandardSearch(String neName) {

        GS_SEARCH_INPUT.sendKeys(neName);
        GS_SEARCH_BUTTON.click();

    }

    public void openContextMenu(String gsName) {

        WebElement networkElement = driver.findElement(By.xpath(String.format(GOLD_STANDARD, gsName)));
        Actions action = new Actions(driver);
        action.contextClick(networkElement).build().perform();
    }

    public Boolean assignGoldStandard(String gsName, String neName) {

        openContextMenu(gsName);
        ASSIGN_NE.click();
        driver.findElement(By.xpath(String.format(NETWORK_ELEMENT, neName))).click();
        ASSIGN_SELECTED_BUTTON.click();
        YES_BUTTON.click();
        CLOSE_BUTTON.click();

        Boolean isAssigned = driver.findElements(By.xpath(String.format(IS_ASSIGNED_IMG, neName))).size() > 0;

        if (isAssigned) {
            return true;
        } else {
            return false;
        }



    }

}
