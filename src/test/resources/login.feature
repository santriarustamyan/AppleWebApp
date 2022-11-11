Feature: The User login test

  Scenario: Verify options on home page for logged in (L1-L4) external user

    Given I am on the Home page
    When I am on the Login page
    Then I fill Login and password


  Scenario: Browse page - Verification of Links are functional

    Given I am on the Home page
    When I am on the Browse page
    When I am click Name



