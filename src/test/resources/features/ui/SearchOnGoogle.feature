@TestingType=Regression @TestingType=Smoke
Feature:Searching on Google

  Scenario Outline: Search on google by keyword
    When I open the browser and navigate to the google.com
    And I search for keyword "<keyword>"
    Then The result should contain the search keyword


    Examples:
      | keyword  |
      | Audi     |
      | BMW      |
      | Serenity |