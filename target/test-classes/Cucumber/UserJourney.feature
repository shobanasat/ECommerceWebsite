@tag
Feature: Ecommerce Website E2E Journey Flows

  Background: 
  Given I have landed in the application

  @NotNegative
  Scenario Outline: Positive E2E Journey Flow
    Given I have logged in using username <name> and password <pwd>
    When I select product <productName> and add to cart
    And Provide payment details and checkout product <productName>
    Then "THANKYOU FOR THE ORDER." message should be displayed

    Examples: 
      | name                          | pwd       | productName     |
      | shobanasathyanathan@gmail.com | Shobikr@1 | ADIDAS ORIGINAL |
