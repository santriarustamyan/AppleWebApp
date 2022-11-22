package stepDefinitions;

import classes.Requests;
import data.Users;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class CommonStepDefinitions {

    WebDriver driver;
    HomePage homePage;
    LogInPage logInPage;
    BrowsePage browsPage;
    UserPage userPage;
    AskTheCommunityPage askTheCommunityPage;
    CreateTipPage createTipPage;
    Requests requests;
    ThreadPage threadPage;
    MySubscriptionsPage mySubscriptionsPage;
    ProfilePage profilePage;
    SearchPage searchPage;
    SubCommunityPage subCommunityPage;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        browsPage = new BrowsePage(driver);
        userPage = new UserPage(driver);
        askTheCommunityPage = new AskTheCommunityPage(driver);
        createTipPage = new CreateTipPage(driver);
        requests = new Requests();
        threadPage = new ThreadPage(driver);
        mySubscriptionsPage = new MySubscriptionsPage(driver);
        profilePage = new ProfilePage(driver);
        searchPage = new SearchPage(driver);
        subCommunityPage = new SubCommunityPage(driver);
    }

    @Given("I am on the Home page")
    public void goHomePage() {
        driver.get("https://discussions.apple.com/welcome");
        driver.manage().window().maximize();
        homePage.clickButton(HomePage.Button.ClosePopUpAlert);
    }

    @When("I fill L{string} Login and password")
    public void iFillLLoginAndPassword(String levelNumber) {
        Users data = new Users();
        String userName = data.users.keySet().toArray()[Integer.parseInt(levelNumber)-1].toString();
        String password = data.users.get(userName);
        logInPage.login(userName, password);
    }

    @And("{string} button is displayed")
    public void buttonIsDisplayed(String buttonName) {
        Assert.isTrue(userPage.buttonIsDisplayed(
                UserPage.Button.valueOf(buttonName)), buttonName + " button is not displayed");
    }

    @And("{string} button is not displayed")
    public void buttonIsNotDisplayed(String buttonName) {
        Assert.isTrue(!userPage.buttonIsDisplayed(
                UserPage.Button.valueOf(buttonName)), buttonName + " button is displayed");
    }

    @And("I am on the {string} page")
    public void iAmOnThePage(String buttonName) {
        homePage.clickButton(HomePage.Button.valueOf(buttonName));
    }

    @Then("Per pages {string} should be functional in Browse page")
    public void perPagesShouldBeFunctionalInBrowsePage(String countPage) {
        browsPage.checkPerPageButton(countPage);
    }

    @Then("Per pages {string} should be functional in My Subscriptions")
    public void perPagesShouldBeFunctionalInMySubscriptions(String countPage) {
        mySubscriptionsPage.checkPerPageButton(countPage);
    }

    @When("Fill and search")
    public void fillAndSearch() {
        searchPage.setSearchText("Apple");
        searchPage.clickButton(SearchPage.Button.SearchButton);
    }

    @When("I click filter button in search page")
    public void clickFilterInSearchPage() {
        searchPage.clickButton(SearchPage.Button.FilterButton);
    }

    @When("I click filter button in browse page")
    public void clickFilterInBrowsePage() {
        browsPage.clickButton(BrowsePage.Button.FilterButton);
    }

    @Then("Discussions -> Solved -> iPhone -> verify results search page")
    public void clickIPhoneVerifyResultInSearchPage() throws InterruptedException {
        String expectedNameOfSearching = "\"Discussions\", \"Solved questions\" and \"iPhone\"";
        searchPage.clickButton(SearchPage.Button.DiscussionsButton);
        searchPage.waitButtonVisibility();
        searchPage.clickSolvedBtn();
        searchPage.clickButton(SearchPage.Button.CommunityButton);
        searchPage.clickButton(SearchPage.Button.IPhoneButton);
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Steps dont working right");
    }

    @Then("Discussions -> Solved -> iPhone -> verify results browse page")
    public void clickIPhoneVerifyResultInBrowsePage() {
        String expectedNameOfSearching = "\"Discussions\", \"Solved questions\" and \"iPhone\"";
        browsPage.clickButton(BrowsePage.Button.DiscussionsButton);
        browsPage.waitButtonVisibility();
        browsPage.clickButton(BrowsePage.Button.SolvedQuestionsButton);
        browsPage.clickButton(BrowsePage.Button.CommunityButton);
        browsPage.clickButton(BrowsePage.Button.IPhoneButton);
        Assert.isTrue(expectedNameOfSearching.equals(browsPage.getButtonText(BrowsePage.Button.FilteredByText)), "Steps dont working right");
    }

    @Then("Discussions -> UnSolved -> iPad -> verify results search page")
    public void clickIPadVerifyResultInSearchPage() throws InterruptedException {
        String expectedNameOfSearching = "\"Discussions\", \"Unsolved questions\" and \"iPad\"";
        Thread.sleep(4000);
        searchPage.clickButton(SearchPage.Button.DiscussionsButton);
        searchPage.waitButtonVisibility();
        searchPage.clickUnSolvedBtn();
        searchPage.clickButton(SearchPage.Button.CommunityButton);
        searchPage.clickButton(SearchPage.Button.IPadButton);
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Steps dont work right");
    }

    @Then("Discussions -> UnSolved -> iPad -> verify results browse page")
    public void clickIPadVerifyResultInBrowsePage() throws InterruptedException {
        String expectedNameOfSearching = "\"Discussions\", \"Unsolved questions\" and \"iPad\"";
        Thread.sleep(4000);
        browsPage.clickButton(BrowsePage.Button.DiscussionsButton);
        browsPage.waitButtonVisibility();
        browsPage.clickButton(BrowsePage.Button.UnsolvedQuestionsButton);
        browsPage.clickButton(BrowsePage.Button.CommunityButton);
        browsPage.clickButton(BrowsePage.Button.IPadButton);
        Assert.isTrue(expectedNameOfSearching.equals(browsPage.getButtonText(BrowsePage.Button.FilteredByText)), "Steps dont work right");
    }

    @Then("UserTips -> AppleWatch -> verify results search page")
    public void clickAppleWatchVerifyResultInSearchPage() throws InterruptedException {
        String expectedNameOfSearching = "\"User Tips\" and \"Apple Watch\"";
        searchPage.waitButtonVisibility();
        searchPage.clickButton(SearchPage.Button.UserTipsButton);
        searchPage.clickAppleWatchBtn();
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Steps dont work right");
    }

    @Then("UserTips -> AppleWatch -> verify results browse page")
    public void clickAppleWatchVerifyResultInBrowsePage() throws InterruptedException {
        String expectedNameOfSearching = "\"User Tips\" and \"Apple Watch\"";
        browsPage.waitButtonVisibility();
        browsPage.clickButton(BrowsePage.Button.UserTipsButton);
        browsPage.clickAppleWatchBtn();
        Assert.isTrue(expectedNameOfSearching.equals(browsPage.getButtonText(BrowsePage.Button.FilteredByText)), "Steps dont work right");
    }

    @Then("People -> verify results search page")
    public void clickPeopleVerifyResultInSearchPage() {
        String expectedNameOfSearching = "\"People\"";
        searchPage.clickButton(SearchPage.Button.PeopleButton);
        searchPage.peopleAvatar();
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Step click People dont work right");
    }

    @Then("Author -> verify results search page")
    public void clickAuthorVerifyResultInSearchPage() {
        searchPage.clickButton(SearchPage.Button.DiscussionsButton);
        searchPage.waitButtonVisibility();
        searchPage.clickButton(SearchPage.Button.AuthorButton);
        Assert.isTrue(searchPage.searchByAuthorBtnIsVisible(), "Step click Author dont work right");
    }

    @Then("Time -> verify results search page")
    public void clickTimeVerifyResultInSearchPage() {
        String expectedNameOfSearching = "\"Discussions\" and \"Last day\"";
        searchPage.clickButton(SearchPage.Button.TimeButton);
        searchPage.clickButton(SearchPage.Button.DayButton);
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Steps dont work right");
    }

    @When("Link thread name should be functional")
    public void linkThreadAreFunctional() {
        String expectedThreadName = browsPage.getButtonText(BrowsePage.Button.ThreadName);
        browsPage.clickButton(BrowsePage.Button.ThreadName);
        homePage.switchTab(1);
        String actualTreadName = threadPage.getThreadName();
        Assert.isTrue(actualTreadName.equals(expectedThreadName), "Link is not working");
        driver.close();
        homePage.switchTab(0);
    }

    @Then("Go sub community page")
    public void goSubCommunityPage() {
        browsPage.clickButton(BrowsePage.Button.SubCommunityButton);
        homePage.switchTab(1);
    }

    @Then("My Subscriptions button is displayed")
    public void my_subscriptions_button_is_displayed() {
        userPage.clickButton(UserPage.Button.Profile);
        Assert.isTrue(userPage.buttonIsDisplayed(UserPage.Button.MySubscriptions), "My Subscriptions button is not displayed");
    }

    @Then("Go in My Subscriptions")
    public void clickMySubscriptionsButton() {
        userPage.clickButton(UserPage.Button.Profile);
        userPage.clickButton(UserPage.Button.MySubscriptions);
    }

    @Then("Profile link is a functional")
    public void profileLinkFunctional() {
        String profileName = mySubscriptionsPage.getButtonText(MySubscriptionsPage.Button.NameProfile);
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.NameProfile);
        homePage.switchTab(1);
        String profilePageName = profilePage.getProfileName();
        Assert.isTrue(profileName.equals(profilePageName), "Profile link is not functional");
    }

    @Then("Access Lounge Announcements")
    public void goLoungeAnnouncements() {
        userPage.clickButton(UserPage.Button.More);
        userPage.clickButton(UserPage.Button.Lounge);
    }

    @Then("Try Access Lounge Announcements With Link")
    public void TryFindLoungeAnnouncementsWithLink() {
        int statusCode = requests.getStatusCode("https://discussions.apple.com/community/lounge/announcements");
        Assert.isTrue(statusCode == 404, "Page is accessible");
    }

    @Then("Try Access User Tip With Link")
    public void TryFindUserTipWithLink() {
        driver.get("https://discussions.apple.com/post/userTip");
        String expectedTitle = "Error - Access Denied - Apple Community";
        String currentTitle = driver.getTitle();
        Assert.isTrue(currentTitle.equals(expectedTitle), "Page is accessible");
    }

    @When("I go {string} page")
    public void iGoPage(String buttonName) {
        searchPage.clickButton(SearchPage.Button.valueOf(buttonName));
    }

    @Then("I should be in {string}")
    public void iShouldBeIn(String pageName) throws InterruptedException {
        Assert.isTrue(pageName.equals(searchPage.getPageNumberName()), "Button no working");
    }

    @And("Link reply to work right search page")
    public void linkReplyToWorkRightSearchPage() {
        String expectedName = searchPage.getButtonText(SearchPage.Button.NameReplyToButton);
        searchPage.clickButton(SearchPage.Button.NameReplyToButton);
        Assert.isTrue(("Re: " + threadPage.getThreadName()).equals(expectedName), "ReplyTo no worked");
        driver.navigate().back();
    }

    @And("Link1 author name work right search page")
    public void link1AuthorNameWorkRightSearchPage() {
        String expectedName = searchPage.getButtonText(SearchPage.Button.AuthorNameButton1);
        searchPage.clickButton(SearchPage.Button.AuthorNameButton1);
        String actualName = searchPage.getButtonText(SearchPage.Button.PopupUserName).replaceFirst("User profile information for user:\n", "");
        searchPage.clickButton(SearchPage.Button.PopupClose);
        Assert.isTrue(expectedName.equals(actualName), "Link 1 no worked");
    }

    @And("Link2 author name work right search page")
    public void link2AuthorNameWorkRightSearchPage() {
        String expectedName = searchPage.getButtonText(SearchPage.Button.AuthorNameButton2);
        searchPage.clickButton(SearchPage.Button.AuthorNameButton2);
        String actualName = profilePage.getProfileName();
        driver.navigate().back();
        Assert.isTrue(expectedName.equals(actualName), "Link 2 no worked");
    }

    @And("Link2 author name work right browse page")
    public void link2AuthorNameWorkRightBrowsePage() {
        String expectedName = browsPage.getButtonText(BrowsePage.Button.AuthorNameButton2);
        browsPage.clickButton(BrowsePage.Button.AuthorNameButton2);
        homePage.switchTab(1);
        String actualName = profilePage.getProfileName();
        driver.close();
        homePage.switchTab(0);
        Assert.isTrue(expectedName.equals(actualName), "Link 2 no worked");
    }

    @Given("I click filter button in my subscriptions page")
    public void iClickFilterButtonInMySubscriptionsPage() {
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.FilterButton);
    }

    @Then("Click user tips verify results my subscriptions page")
    public void clickUserTipsVerifyResultsMySubscriptionsPage() {
        String expectedName = "\"Content\", \"Following\" and \"User Tips\"";
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.UserTipsButton);
        mySubscriptionsPage.waitButtonClickable(MySubscriptionsPage.Button.AuthorNameButton1);
        String actualName = mySubscriptionsPage.getButtonText(MySubscriptionsPage.Button.FilteredByText);
        Assert.isTrue(expectedName.equals(actualName), "Filter User Tips no working");
    }

    @Then("Latest activity button is functional in My Subscriptions")
    public void latestActivityButtonIsFunctionalInMySubscriptions() {
        String expectedAttributeName = "icon icon-after icon-chevrondown";
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.TopicsLatestActivityButton);
        mySubscriptionsPage.waitButtonClickable(MySubscriptionsPage.Button.TopicsLatestActivityButton);
        String actualAttributeName = mySubscriptionsPage.getButtonAttributeText(MySubscriptionsPage.Button.TopicsLatestActivitySpanButton, "class");
        Assert.isTrue(expectedAttributeName.equals(actualAttributeName), "Activity button no functional");
    }

    @And("Thread button is functional in My Subscriptions")
    public void threadButtonIsFunctionalInMySubscriptions() {
        String expectedAttributeName = "icon icon-after icon-chevrondown";
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.TopicsThreadButton);
        mySubscriptionsPage.waitButtonClickable(MySubscriptionsPage.Button.TopicsThreadButton);
        String actualAttributeName = mySubscriptionsPage.getButtonAttributeText(MySubscriptionsPage.Button.TopicsThreadButtonSpan, "class");
        Assert.isTrue(expectedAttributeName.equals(actualAttributeName), "Activity button no functional");
    }

    @And("Community button is functional in My Subscriptions")
    public void communityButtonIsFunctionalInMySubscriptions() {
        String expectedAttributeName = "icon icon-after icon-chevrondown";
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.TopicsCommunityButton);
        mySubscriptionsPage.waitButtonClickable(MySubscriptionsPage.Button.TopicsCommunityButton);
        String actualAttributeName = mySubscriptionsPage.getButtonAttributeText(MySubscriptionsPage.Button.TopicsCommunitySpanButton, "class");
        Assert.isTrue(expectedAttributeName.equals(actualAttributeName), "Activity button no functional");
    }

    @And("Link1 author name work right browse page")
    public void linkAuthorNameWorkRightBrowsePage() {
        String expectedName = browsPage.getButtonText(BrowsePage.Button.AuthorNameButton1);
        browsPage.clickButton(BrowsePage.Button.AuthorNameButton1);
        String actualName = browsPage.getButtonText(BrowsePage.Button.PopupUserName).replaceFirst("User profile information for user:\n", "");
        browsPage.clickButton(BrowsePage.Button.PopupClose);
        Assert.isTrue(expectedName.equals(actualName), "Link 1 no worked");
    }

    @And("Link sub community button right browse page")
    public void linkSubCommunityButtonRightBrowsePage() {
        String expectedName = browsPage.getButtonText(BrowsePage.Button.SubCommunityButton);
        browsPage.clickButton(BrowsePage.Button.SubCommunityButton);
        homePage.switchTab(1);
        String actualName = subCommunityPage.getButtonText(SubCommunityPage.Button.CommunityName);
        driver.close();
        homePage.switchTab(0);
        Assert.isTrue(expectedName.equals(actualName), "Link Sub Community In no worked");
    }

    @And("Link sub community button right search page")
    public void linkSubCommunityButtonRightSearchPage() {
        String expectedName = searchPage.getButtonText(SearchPage.Button.SubCommunityButton);
        searchPage.clickButton(SearchPage.Button.SubCommunityButton);
        String actualName = subCommunityPage.getButtonText(SubCommunityPage.Button.CommunityName);
        driver.navigate().back();
        Assert.isTrue(expectedName.equals(actualName), "Link Sub Community In no worked");
    }

    @And("Link name author is functional sub community page")
    public void linkNameAuthorClickIsFunctionalSubCommunityPage() {
        String expectedName = subCommunityPage.getButtonText(SubCommunityPage.Button.AuthorName);
        subCommunityPage.clickButton(SubCommunityPage.Button.AuthorName);
        String actualName = subCommunityPage.getButtonText(SubCommunityPage.Button.PopupUserName).replaceFirst("User profile information for user:\n", "");
        subCommunityPage.clickButton(SubCommunityPage.Button.PopupClose);
        Assert.isTrue(expectedName.equals(actualName), "Link author name no worked");
    }

    @Then("Link icon author is functional sub community page")
    public void linkIconAuthorClickIsFunctionalSubCommunityPage() {
        String expectedName = subCommunityPage.getButtonText(SubCommunityPage.Button.AuthorName);
        subCommunityPage.clickButton(SubCommunityPage.Button.AuthorIcon);
        String actualName = subCommunityPage.getButtonText(SubCommunityPage.Button.PopupUserName).replaceFirst("User profile information for user:\n", "");
        subCommunityPage.clickButton(SubCommunityPage.Button.PopupClose);
        Assert.isTrue(expectedName.equals(actualName), "Link icon no worked");
    }

    @Then("Link thread name is functional sub community page")
    public void linkThreadNameIsFunctionalSubCommunityPage() {
        String expectedThreadName = subCommunityPage.getButtonText(SubCommunityPage.Button.ThreadName);
        subCommunityPage.clickButton(SubCommunityPage.Button.ThreadName);
        String actualTreadName = threadPage.getThreadName();
        Assert.isTrue(actualTreadName.equals(expectedThreadName), "Link is no functional");
    }

    @Then("Search text is functional on home page")
    public void searchTextIsFunctionalOnHomePage() {
        homePage.setSearchTextInput("Apple");
        Assert.isTrue(searchPage.buttonIsDisplayed(SearchPage.Button.AskTheCommunityButton), "Ask The Community button is not displayed");
        Assert.isTrue(searchPage.buttonIsDisplayed(SearchPage.Button.ThreadHeadingText), "Thread is not displayed");
    }

    @Then("Search text is functional on search page")
    public void searchTextIsFunctionalOnSearchPage() {
        homePage.clickButton(HomePage.Button.Search);
        searchPage.setSearchText("Apple");
        searchPage.clickButton(SearchPage.Button.SearchButton);
        Assert.isTrue(searchPage.buttonIsDisplayed(SearchPage.Button.AskTheCommunityButton), "Ask The Community button is not displayed");
        Assert.isTrue(searchPage.buttonIsDisplayed(SearchPage.Button.ThreadHeadingText), "Thread is not displayed");
    }

    @Then("Search text is functional on sub community page")
    public void searchTextIsFunctionalOnSubCommunityPage() {
        homePage.clickButton(HomePage.Button.Browse);
        browsPage.clickButton(BrowsePage.Button.SubCommunityButton);
        homePage.switchTab(1);
        subCommunityPage.setSearchTextInput("Apple");
        Assert.isTrue(searchPage.buttonIsDisplayed(SearchPage.Button.AskTheCommunityButton), "Ask The Community button is not displayed");
        Assert.isTrue(searchPage.buttonIsDisplayed(SearchPage.Button.ThreadHeadingText), "Thread is not displayed");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
