package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    private final By logInBtnPath = By.cssSelector("[class='localnav-button button button-reduced popup-action-button']");
    private final By browseBtnPath = By.cssSelector("[class='localnav-menu-link'][href='/browse']");
    private final By searchBtnPath = By.cssSelector("[class='localnav-menu-link'][href='/search']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickBtnLogIn() {
        wait.until(ExpectedConditions.elementToBeClickable(logInBtnPath)).click();
    }

    public void clickBtnBrows() {
        wait.until(ExpectedConditions.elementToBeClickable(browseBtnPath)).click();
    }

    public void clickBtnSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtnPath)).click();
    }

}

