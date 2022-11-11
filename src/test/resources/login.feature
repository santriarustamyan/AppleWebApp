Feature: The User login test

  Scenario: Verify options on home page for logged in (L1-L4) external user

    Given I am on the Home page
    When I am on the Login page
    Then I fill L Login and password
    And My Subscriptions button is displayed
    And Browse button is displayed
    And Search button is displayed
    And Ask the Community button is displayed


  Scenario: Verify options on home page for logged in L5 external user

    Given I am on the Home page
    When I am on the Login page
    Then I fill L5 Login and password
    And My Subscriptions button is displayed
    And Browse button is displayed
    And Search button is displayed
    And Ask the Community button is displayed
    And Post User Tip button is displayed

  Scenario: Verify options on home page for logged in L6 external user

    Given I am on the Home page
    When I am on the Login page
    Then I fill L6 Login and password
    And My Subscriptions button is displayed
    And Browse button is displayed
    And Search button is displayed
    And Ask the Community button is displayed
    And Post User Tip button is displayed
    And Lounge button is displayed


  Scenario: Browse page - Verification of Links are functional

    Given I am on the Home page
    When I am on the Browse page
    When I click Name



