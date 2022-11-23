package stepDefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

public class BrowsePageStepDefinitions {

    WebDriver driver;
    HomePage homePage;
    BrowsePage browsePage;
    ThreadPage threadPage;
    ProfilePage profilePage;
    SubCommunityPage subCommunityPage;


    @Then("Per pages {string} should be functional in Browse page")
    public void perPagesShouldBeFunctionalInBrowsePage(String countPage) {
        browsePage.checkPerPageButton(countPage);
    }

    @When("I click filter button in browse page")
    public void clickFilterInBrowsePage() {
        browsePage.clickButton(BrowsePage.Button.FilterButton);
    }


    @Then("Discussions -> Solved -> iPhone -> verify results browse page")
    public void clickIPhoneVerifyResultInBrowsePage() {
        String expectedNameOfSearching = "\"Discussions\", \"Solved questions\" and \"iPhone\"";
        browsePage.clickButton(BrowsePage.Button.DiscussionsButton);
        browsePage.waitButtonVisibility();
        browsePage.clickButton(BrowsePage.Button.SolvedQuestionsButton);
        browsePage.clickButton(BrowsePage.Button.CommunityButton);
        browsePage.clickButton(BrowsePage.Button.IPhoneButton);
        Assert.isTrue(expectedNameOfSearching.equals(browsePage.getButtonText(BrowsePage.Button.FilteredByText)), "Steps dont working right");
    }

    @Then("Discussions -> UnSolved -> iPad -> verify results browse page")
    public void clickIPadVerifyResultInBrowsePage() throws InterruptedException {
        String expectedNameOfSearching = "\"Discussions\", \"Unsolved questions\" and \"iPad\"";
        Thread.sleep(4000);
        browsePage.clickButton(BrowsePage.Button.DiscussionsButton);
        browsePage.waitButtonVisibility();
        browsePage.clickButton(BrowsePage.Button.UnsolvedQuestionsButton);
        browsePage.clickButton(BrowsePage.Button.CommunityButton);
        browsePage.clickButton(BrowsePage.Button.IPadButton);
        Assert.isTrue(expectedNameOfSearching.equals(browsePage.getButtonText(BrowsePage.Button.FilteredByText)), "Steps dont work right");
    }

    @Then("UserTips -> AppleWatch -> verify results browse page")
    public void clickAppleWatchVerifyResultInBrowsePage() throws InterruptedException {
        String expectedNameOfSearching = "\"User Tips\" and \"Apple Watch\"";
        browsePage.waitButtonVisibility();
        browsePage.clickButton(BrowsePage.Button.UserTipsButton);
        browsePage.clickAppleWatchBtn();
        Assert.isTrue(expectedNameOfSearching.equals(browsePage.getButtonText(BrowsePage.Button.FilteredByText)), "Steps dont work right");
    }

    @When("Link thread name should be functional")
    public void linkThreadAreFunctional() {
        String expectedThreadName = browsePage.getButtonText(BrowsePage.Button.ThreadName);
        browsePage.clickButton(BrowsePage.Button.ThreadName);
        homePage.switchTab(1);
        String actualTreadName = threadPage.getThreadName();
        Assert.isTrue(actualTreadName.equals(expectedThreadName), "Link is not working");
        driver.close();
        homePage.switchTab(0);
    }

    @And("Link2 author name work right browse page")
    public void link2AuthorNameWorkRightBrowsePage() {
        String expectedName = browsePage.getButtonText(BrowsePage.Button.AuthorNameButton2);
        browsePage.clickButton(BrowsePage.Button.AuthorNameButton2);
        homePage.switchTab(1);
        String actualName = profilePage.getProfileName();
        driver.close();
        homePage.switchTab(0);
        Assert.isTrue(expectedName.equals(actualName), "Link 2 no worked");
    }

    @And("Link1 author name work right browse page")
    public void linkAuthorNameWorkRightBrowsePage() {
        String expectedName = browsePage.getButtonText(BrowsePage.Button.AuthorNameButton1);
        browsePage.clickButton(BrowsePage.Button.AuthorNameButton1);
        String actualName = browsePage.getButtonText(BrowsePage.Button.PopupUserName).replaceFirst("User profile information for user:\n", "");
        browsePage.clickButton(BrowsePage.Button.PopupClose);
        Assert.isTrue(expectedName.equals(actualName), "Link 1 no worked");
    }

    @And("Link sub community button right browse page")
    public void linkSubCommunityButtonRightBrowsePage() {
        String expectedName = browsePage.getButtonText(BrowsePage.Button.SubCommunityButton);
        browsePage.clickButton(BrowsePage.Button.SubCommunityButton);
        homePage.switchTab(1);
        String actualName = subCommunityPage.getButtonText(SubCommunityPage.Button.CommunityName);
        driver.close();
        homePage.switchTab(0);
        Assert.isTrue(expectedName.equals(actualName), "Link Sub Community In no worked");
    }

}
