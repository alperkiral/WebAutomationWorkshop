@workshop2
Feature: Finding store

  Scenario Outline: find store by city and state and put it into txt
    Given user accepts cookies
    When the user clicks to Stores on Footer
    And the user selects <City> and <State> from search box
    Then listed stores in <City>, <State> should be saved into a text file

    Examples:
      | City     | State         |
      | "Ankara" | "yenimahalle" |