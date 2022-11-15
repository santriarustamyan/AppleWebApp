package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommunityPage {
    WebDriver driver;
    WebDriverWait wait;

    private final By communityNamePath = By.cssSelector("[data-action='drop-down-button-text']");

    public CommunityPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getCommunityName() {
        return wait.until(ExpectedConditions.elementToBeClickable(communityNamePath)).getText();
    }
}



