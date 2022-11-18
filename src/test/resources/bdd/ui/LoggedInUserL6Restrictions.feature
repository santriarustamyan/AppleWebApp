@sanity
@login
Feature: Verify options on home page for logged in L6 external user

  @19
  Scenario: Login into webapp with L6 external user

    Given I am on the Home page
    And I am on the Login page
    When I fill L6 Login and password
    Then My Subscriptions button is displayed
    And Browse button is displayed
    And Search button is displayed
    And Ask the Community button is displayed
    And Post User Tip button is displayed
    And Lounge button is displayed
    And Access Lounge Announcements