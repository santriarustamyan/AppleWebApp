package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    WebDriver driver;
    WebDriverWait wait;

    private final By profileNamePhat = By.cssSelector("[class='user-profile-name']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getProfileName() {
        return wait.until(ExpectedConditions.elementToBeClickable(profileNamePhat)).getText();
    }
}

