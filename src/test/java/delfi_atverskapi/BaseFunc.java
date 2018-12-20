package delfi_atverskapi;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;

public class BaseFunc {

    WebDriver browser;

    public BaseFunc() {
        System.setProperty("webdriver.gecko.driver","c:/geckodriver.exe" );
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
    }

    public void goToURL(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        browser.get(url);

    }
    public WebElement getElement(By locator) {
        Assertions.assertFalse(browser.findElements(locator).isEmpty(), "There is no element");
        return browser.findElement(locator);
    }


    public void fillField(By locator,String name) {

        getElement(locator).sendKeys(name);
    }

    public void timeForUserToCompleteCaptcha() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(120000);
    }


}
