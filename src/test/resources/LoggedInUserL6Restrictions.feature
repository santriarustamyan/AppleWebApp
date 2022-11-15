Feature: Verify options on home page for logged in L6 external user

  Scenario: Login into webapp with L6 external user

    Given I am on the Home page
    When I am on the Login page
    And I fill L6 Login and password
    And My Subscriptions button is displayed
    And Browse button is displayed
    And Search button is displayed
    And Ask the Community button is displayed
    And Post User Tip button is displayed
    And Lounge button is displayed
    Then Access Lounge Announcements