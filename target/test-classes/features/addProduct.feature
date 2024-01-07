@workshop
Feature: Adding product to basket

  Scenario: adding product to basket and increase amount to 2
    Given user accepts cookies
    When user searches for kulaklık
    And user selects "Bluetooth Kulaklık" from the subcategory
    And user adds the first item to basket
    And user adds the last item to basket
    And user navigates to basket
    And user increases the amount of the cheapest item to 2
    And user clicks to checkout
    And user clicks continue without register
    Then user enters the email address for
