package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    WebDriver driver;
    private final By profileNamePhat = By.cssSelector("[class='user-profile-name']");

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public String getProfileName(){
        return driver.findElement(profileNamePhat).getText();
    }
}
