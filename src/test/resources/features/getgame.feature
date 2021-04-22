Feature: Retrieving Gamef


  Scenario: Getting a Gamef
    Given the user wants to get the information about a game with id 1
    When someone visits the game details
    Then the information about the Gamef will be retrieved successfully