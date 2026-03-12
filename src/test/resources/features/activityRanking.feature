@sanity
Feature: Activity ranking based on weather forecast

  Scenario: Autocomplete suggestions appear while typing city
    Given user opens activity search screen
    When user types city "Lon"
    Then autocomplete suggestions should appear

  Scenario: Selecting suggestion triggers ranking results
    Given user types city "Lon"
    When user selects first suggestion
    Then ranked activities for 7 days should be displayed

  Scenario Outline: Verify activity ranking information
    Given user selects city "London"
    Then each day should show "<date>","<activity>","<rank>","<reason>"
    Examples:
      | date | activity            | rank | reason     |
      | Mon  | Outdoor Sightseeing | 9    | Sunny 23°C |
      | Tue  | Surfing             | 6    | Windy      |

  Scenario: Verify behaviour when invalid city entered
    When user types city "XYZABC"
    Then no suggestions should be displayed