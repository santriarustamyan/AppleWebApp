package stepDefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Then;
import pages.BrowsePage;
import pages.HomePage;
import pages.SearchPage;
import pages.SubCommunityPage;

public class HomePageStepDefinitions {
    HomePage homePage = CommonStepDefinitions.homePage;
    SearchPage searchPage = CommonStepDefinitions.searchPage;
    BrowsePage browsePage = CommonStepDefinitions.browsePage;
    SubCommunityPage subCommunityPage = CommonStepDefinitions.subCommunityPage;

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
        browsePage.clickButton(BrowsePage.Button.SubCommunityButton);
        homePage.switchTab(1);
        subCommunityPage.setSearchTextInput("Apple");
        Assert.isTrue(searchPage.buttonIsDisplayed(SearchPage.Button.AskTheCommunityButton), "Ask The Community button is not displayed");
        Assert.isTrue(searchPage.buttonIsDisplayed(SearchPage.Button.ThreadHeadingText), "Thread is not displayed");
    }

}
