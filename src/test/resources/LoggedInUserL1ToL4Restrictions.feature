Feature: Verify options on home page for logged in (L1-L4) external user

  Scenario: Login into webapp with (L1 to L4) external users

    Given I am on the Home page
    When I am on the Login page
    And I fill L Login and password
    And My Subscriptions button is displayed
    And Browse button is displayed
    And Search button is displayed
    And Ask the Community button is displayed
    And Post User Tip button is not displayed
    And Lounge button is not displayed
    And Try Access Lounge Announcements With Link
    Then Try Access User Tip With Link
