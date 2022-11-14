package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    private final By logInBtnPath = By.cssSelector("[class='localnav-button button button-reduced popup-action-button']");
    private final By browseBtnPath = By.cssSelector("[class='localnav-menu-link'][href='/browse']");
    private final By searchBtnPath = By.cssSelector("[class='localnav-menu-link'][href='/search']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBtnLogIn() {
        driver.findElement(logInBtnPath).click();
    }
    public void clickBtnBrows() {
        driver.findElement(browseBtnPath).click();
    }
    public void clickBtnSearch() {driver.findElement(searchBtnPath).click(); }

}
