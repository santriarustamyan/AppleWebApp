Feature: Search page

  Background:

    Given I am on the Home page
    And I am on the Search page
    When Fill and search

  @12
  Scenario:  Go to Search page and search for any query and check whether Filters work

    Given Go Filter page
    Then Discussions -> Solved -> iPhone -> verify results
    And Discussions -> UnSolved -> iPad -> verify results
    And UserTips -> AppleWatch -> verify results
    And People -> verify results
    And Author -> verify results
    Then Time -> verify results

  @20
  Scenario: Go to Search page and search for any query and check whether pagination works

    When I go next page
    And I am in page Two
    And I go previous page
    Then I am in page One

  @13
  Scenario: Go to search page and search for any query and check whether All clickable links navigate to the relevant pages / locations / profiles

    Then Link reply to work right
    And Link1 author name work right
    And Link2 author name work right
    And Link where thread In work right

