Feature: Player Level Progress


  Scenario: Player Level Progress
    Given the player wants to get his level progress
    When someone visits his game details on his profile
    Then his level progress of the Game will be retrieved successfully

