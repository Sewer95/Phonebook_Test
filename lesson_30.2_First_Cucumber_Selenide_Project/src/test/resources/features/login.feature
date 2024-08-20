Feature: Login
  @LoginPositive
  Scenario: Successful login
    Given User is on HomePage
    When User clicks on Login icon
    Then User is verifies Login form
    When User enters valid credentials
    And Clicks on Anmelden button
    Then User verifies User Name status
    When User clicks on the User icon
    Then User verifies User Name
