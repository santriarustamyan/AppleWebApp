Feature: Browse page

  Background:
    Given I am on the Home page
    And I am on the Browse page

  @1
  Scenario: Go to Browse page and check whether Links are functional

    Then Links should be functional

  @2
  Scenario: Go to Browse page and check whether Filters function as intended
    Given I click filter button in browse page
    Then Discussions -> Solved -> iPhone -> verify results browse page
    And Discussions -> UnSolved -> iPad -> verify results browse page
    And UserTips -> AppleWatch -> verify results browse page


  @3
  Scenario: Go to Browse page and check whether Ability to select 20 or 60 items per page.

    Then Per pages 20 should be functional in Browse page
    And Per pages 60 should be functional in Browse page