package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThreadPage {
    WebDriver driver;
    private final By threadNamePath = By.cssSelector("[data-action='content-post-title-text']");

    public ThreadPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getThreadName() {
        return driver.findElement(threadNamePath).getText();
    }
}
