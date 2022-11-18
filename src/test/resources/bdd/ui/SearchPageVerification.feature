@sanity
@search
Feature: Search page

  Background:

    Given I am on the Home page
    And I am on the Search page
    When Fill and search

  @12
  Scenario:  Go to Search page and search for any query and check whether Filters work

    Given I click filter button in search page
    Then Discussions -> Solved -> iPhone -> verify results search page
    And Discussions -> UnSolved -> iPad -> verify results search page
    And UserTips -> AppleWatch -> verify results search page
    And People -> verify results search page
    And Author -> verify results search page
    Then Time -> verify results search page

  @13
  Scenario: Go to search page and search for any query and check whether All clickable links navigate to the relevant pages / locations / profiles

    Then Link reply to work right search page
    And Link1 author name work right search page
    And Link2 author name work right search page
    And Link sub community button right search page


  @20
  Scenario: Go to Search page and search for any query and check whether pagination works

    When I go next page
    And I am in page Two
    And I go previous page
    Then I am in page One
