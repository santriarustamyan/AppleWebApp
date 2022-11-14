Feature: The User login test

  Scenario: Verify options on home page for logged in (L1-L4) external user

    Given I am on the Home page
    When I am on the Login page
    Then I fill L Login and password
    And My Subscriptions button is displayed
    And Browse button is displayed
    And Search button is displayed
    And Ask the Community button is displayed
    And Post User Tip button is not displayed
    Then Lounge button is not displayed
#    Then Ask Question
    Then Try Access Lounge Announcements With Link
    And Try Access User Tip With Link


  Scenario: Verify options on home page for logged in L5 external user

    Given I am on the Home page
    When I am on the Login page
    And I fill L5 Login and password
    And My Subscriptions button is displayed
    And Browse button is displayed
    And Search button is displayed
    And Ask the Community button is displayed
    And Post User Tip button is displayed
    And Lounge button is not displayed
#    Then Ask Question
#    And Create Tip
    Then Try Access Lounge Announcements With Link


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
#    Then Ask Question
#    And Create Tip
    Then Access Lounge Announcements


  Scenario: Browse page - Verification of Links are functional

    Given I am on the Home page
    When I am on the Browse page
    Then Links should be functional


  Scenario: Browse page - Verification of Ability to select 20 or 60 items per page
    Given I am on the Home page
    When I am on the Browse page
    And Per pages 20 should be functional in Browse page
    Then Per pages 60 should be functional in Browse page


  Scenario: My Subscriptions page - Verification of Links are functional

    Given I am on the Home page
    When I am on the Login page
    And I fill L Login and password
    Then Go in My Subscriptions
    And Profile link is a functional


  Scenario: My Subscriptions page - Verification of Ability to select 20 or 60 items per page

    Given I am on the Home page
    When I am on the Login page
    And I fill L Login and password
    Then Go in My Subscriptions
    And Per pages 20 should be functional in My Subscriptions
    Then Per pages 60 should be functional in My Subscriptions

  Scenario:  Go to Search page and search for any query and check whether Filters work

    Given I am on the Home page
    When I am on the Search page
    And Go Filter page
    And Discussions -> Solved -> iPhone -> verify results
    And Discussions -> UnSolved -> iPad -> verify results
    And UserTips -> AppleWatch -> verify results
    And People -> verify results
    And Author -> verify results
    Then Time -> verify results

  Scenario: Search page - Verification of pagination

    Given I am on the Home page
    When I am on the Search page
    And I go next page
    Then I am in page Two
    Then I go previous page
    Then I am in page One
