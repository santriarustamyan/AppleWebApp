@sanity
Feature: My Subscriptions page


  Background:
    Given I am on the Home page
    When I am on the Login page
    And I fill L Login and password
    Then Go in My Subscriptions

  @4
  Scenario: Go to My Subscriptions page and check whether Links are functional

    Given Profile link is a functional

  @5
  Scenario: Go to My Subscriptions page and check whether Filters function as intended

    Given I click filter button in my subscriptions page
    Then  Click user tips verify results my subscriptions page


  @6
  Scenario: Go to My Subscriptions page and check whether Able to select 20 or 60 items per page

    Given Per pages 20 should be functional in My Subscriptions
    Then Per pages 60 should be functional in My Subscriptions

  @7
  Scenario: Go to My Subscriptions page and check whether Able to sort columns for Latest Activity, Community, Thread

    Then Community button is functional in My Subscriptions
    And Thread button is functional in My Subscriptions
    And Latest activity button is functional in My Subscriptions
