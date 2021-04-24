Feature: Player Level Progress


  Scenario Outline: Player Level Progress

    Given the player wants to get his <initial> level progress
    When he gains more experience <added> in game
    Then his <actual level> progress of the Game will be retrieved successfully

    Examples:

      | initial | added | actual level |
      | 300     | 5     | 305          |
      | 500     | 10    | 510          |
      | 800     | 30    | 830          |