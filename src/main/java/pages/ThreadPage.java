package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ThreadPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By threadNamePath = By.cssSelector("[data-action='content-post-title-text']");

    public ThreadPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getThreadName() {
        return wait.until(ExpectedConditions.elementToBeClickable(threadNamePath)).getText();
    }
}



