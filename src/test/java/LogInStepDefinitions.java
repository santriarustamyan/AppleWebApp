import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BrowsPage;
import pages.HomePage;
import pages.LogInPage;
import pages.UserPage;

public class LogInStepDefinitions {

    WebDriver driver;
    HomePage homePage;
    LogInPage logInPage;
    BrowsPage browsPage;
    UserPage userPage;


    @Given("I am on the Home page")
    public void goHomePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://discussions.apple.com/welcome");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        browsPage = new BrowsPage(driver);
        userPage = new UserPage(driver);

    }

    @When("I am on the Login page")
    public void goSignInPage() {
        homePage.clickBtnLogIn();
    }

    @Then("I fill L Login and password")
    public void fillLUserData() {
        logInPage.login("apple.asc002+100@gmail.com", "Hampshire@123");
    }

    @Then("I fill L5 Login and password")
    public void fillL5UserData() {
        logInPage.login("johnjan2017@outlook.com", "Password@12");
    }

    @Then("I fill L6 Login and password")
    public void fillL6UserData() {
        logInPage.login("apple.asc003+100@gmail.com", "Hampshire@123");
    }

    @When("I am on the Browse page")
    public void goBrowsePage() {
        homePage.clickBtnBrows();
    }

    @When("I click Name")
    public void goThread() {
        browsPage.clickThreadLink();
    }


    @Then("My Subscriptions button is displayed")
    public void my_subscriptions_button_is_displayed() {
        Assert.isTrue(userPage.mySubscriptionsBtnIsDisplayed(), "My Subscriptions button is not displayed");
    }

    @Then("Browse button is displayed")
    public void browse_button_is_displayed() {
        Assert.isTrue(userPage.browseBtnIsDisplayed(), "Browse button is not displayed");
    }

    @Then("Search button is displayed")
    public void search_button_is_displayed() {
        Assert.isTrue(userPage.searchBtnIsDisplayed(), "Search button is not displayed");
    }

    @Then("Ask the Community button is displayed")
    public void post_question_button_is_displayed() {
        Assert.isTrue(userPage.askTheCommunityBtnIsDisplayed(), "Post Question button is not displayed");
    }

    @Then("Post User Tip button is displayed")
    public void post_user_tip_button_is_displayed() {
        Assert.isTrue(userPage.createTipBtnIsDisplayed(), "Post User Tip button is not displayed");
    }

    @Then("Lounge button is displayed")
    public void lounge_button_is_displayed() {
        Assert.isTrue(userPage.loungeBtnIsDisplayed(), "Lounge button is not displayed");
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
