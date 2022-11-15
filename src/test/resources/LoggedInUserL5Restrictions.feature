Feature: Verify options on home page for logged in L5 external user

  @18
  Scenario: Login into webapp with L5 external users

    Given I am on the Home page
    And I am on the Login page
    When I fill L5 Login and password
    Then My Subscriptions button is displayed
    And Browse button is displayed
    And Search button is displayed
    And Ask the Community button is displayed
    And Post User Tip button is displayed
    And Lounge button is not displayed
    And Try Access Lounge Announcements With Link