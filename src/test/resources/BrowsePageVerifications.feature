Feature: Browse page

  Background:
    Given I am on the Home page
    When I am on the Browse page

  Scenario: Go to Browse page and check whether Links are functional

    Given Links should be functional

  Scenario: Go to Browse page and check whether Ability to select 20 or 60 items per page.

    Given Per pages 20 should be functional in Browse page
    Then Per pages 60 should be functional in Browse page