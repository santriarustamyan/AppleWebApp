@sanity
@subComm
Feature: Sub Community page

  Background:
    Given I am on the Home page
    And I am on the Browse page
    Then Go sub community page

  @11
  Scenario: Go to sub community page and check whether All clickable links

    Then Link icon author is functional sub community page
    And Link name author is functional sub community page
    Then Link thread name is functional sub community page

