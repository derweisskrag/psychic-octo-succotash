Feature: Google Sign-up Flow

  Scenario: User signs up for a new Google account
    Given I am on the Google sign-up page
    When I fill in the sign-up form with valid information
    And I submit the form
    Then I should be redirected to the Google account confirmation page
