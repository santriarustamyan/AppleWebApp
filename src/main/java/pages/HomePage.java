package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private final By logInButtonPath = By.cssSelector("[class='localnav-button button button-reduced popup-action-button']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickBtnLogIn() {
        driver.findElement(logInButtonPath).click();
    }
}
