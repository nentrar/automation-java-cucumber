package pages.wordpress.dashboardPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    private final int TIMEOUT_30SECONDS = 30;

    WebDriver driver;

    private final String USER_HELLO = "//a[contains(@class,'ab-item') and descendant::span[contains(text(),'%s')]]";

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openProfilePage(String profileName) {

        driver.findElement(By.xpath(String.format(USER_HELLO, profileName))).click();
    }

}
