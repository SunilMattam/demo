Feature: Filter
  As a end user
  I want to filter
  So that i can view filtered products

  Scenario Outline: Filter by rating
    Given I am on the home page
    When I search for a product "nike"
    And I select filter "<value>"
    Then I should see results filtered by "<expectedValue>"

    Examples:
      | value | expectedValue |
      | 5only | 5.0           |

