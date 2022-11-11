import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BrowsPage;
import pages.HomePage;
import pages.LogInPage;

public class LogInStepDefinitions {

    WebDriver driver;
    HomePage homePage;
    LogInPage logInPage;
    BrowsPage browsPage;


    @Given("I am on the Home page")
    public void goHomePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://discussions.apple.com/welcome");
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        browsPage = new BrowsPage(driver);

    }

    @When("I am on the Login page")
    public void goSignInPage(){
        homePage.clickBtnLogIn();
    }

    @Then("I fill Login and password")
    public void fillUserData() {
        logInPage.login();
    }


    @When("I am on the Browse page")
    public void goBrowsePage() {
        homePage.clickBtnBrows();
    }


    @When("I am click Name")
    public void goThread() {
        browsPage.clickThreadLink();
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
