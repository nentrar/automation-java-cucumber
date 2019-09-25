package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class InternetBrowser {

    class Browser {

        private WebDriver driver;
        public String browser;

        public void InternetBrowser(WebDriver driver) {
            this.driver = driver;
        }


    }


    public void setDriver(String browser) {

        switch(browser) {
            case "firefox":
                driver = new FirefoxDriver();

            case "chrome":
                driver = new ChromeDriver();

            case "safari":
                driver = new SafariDriver();

            case "ie":
                driver = new InternetExplorerDriver();

            default: {
                driver = new ChromeDriver();
            }
        }

    }
}
