# new feature
# Tags: optional

Feature: Validation triggered for Email Address

  @web @register
  Scenario: User Registration Validation
    Given a user is on the Register page
    When the About You details are entered
    And the Where You Live details are entered
    And the Contact Preferences are entered
    And the Your Password details are entered
    And the Agree And Consent are selected
    Then the expected results validation is displayed