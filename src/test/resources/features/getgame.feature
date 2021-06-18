Feature: Retrieving Game


  Scenario: Getting a Game
    Given the user wants to get the information about a game with id 1
    When someone visits the game details
    Then the information about the Game will be retrieved successfully