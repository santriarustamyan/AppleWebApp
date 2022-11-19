@sanity
@login
Feature: Verify options on home page for logged in L6 external user

  @19
  Scenario: Login into webapp with L6 external user

    Given I am on the Home page
    And I am on the "LogIn" page
    When I fill L"6" Login and password
    Then My Subscriptions button is displayed
    And "Browse" button is displayed
    And "Search" button is displayed
    And "AskTheCommunity" button is displayed
    And "CreateTip" button is displayed
    And "LoungeLibel" button is displayed
    And Access Lounge Announcements