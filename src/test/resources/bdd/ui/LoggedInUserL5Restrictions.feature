@sanity
@login
Feature: Verify options on home page for logged in L5 external user

  @18
  Scenario: Login into webapp with L5 external users

    Given I am on the Home page
    And I am on the "LogIn" page
    When I fill L"5" Login and password
    Then My Subscriptions button is displayed
    And "Browse" button is displayed
    And "Search" button is displayed
    And "AskTheCommunity" button is displayed
    And "CreateTip" button is displayed
    And "LoungeLibel" button is not displayed
    And Try Access Lounge Announcements With Link