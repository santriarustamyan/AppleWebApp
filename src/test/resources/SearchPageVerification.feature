Feature: Search page

  Background:

    Given I am on the Home page
    When I am on the Search page

  Scenario:  Go to Search page and search for any query and check whether Filters work

    And Go Filter page
    And Discussions -> Solved -> iPhone -> verify results
    And Discussions -> UnSolved -> iPad -> verify results
    And UserTips -> AppleWatch -> verify results
    And People -> verify results
    And Author -> verify results
    Then Time -> verify results

  Scenario: Go to Search page and search for any query and check whether pagination works

    And I go next page
    And I am in page Two
    And I go previous page
    Then I am in page One
