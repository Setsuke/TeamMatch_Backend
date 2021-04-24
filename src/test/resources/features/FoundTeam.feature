Feature: Retrieving Team

  Scenario: Getting a Team
    Given the app wants to get information about a team
      | Id  | Name     | TeamSize | LevelAverage | HoursPlayed|
      | 1   | Infamous |   2      |   12.20      |    24.5    |
    When someone visits the team profile
    Then the information about the Team will be retrieved successfully