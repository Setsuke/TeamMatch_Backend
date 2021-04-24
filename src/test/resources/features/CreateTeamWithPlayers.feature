Feature: Creating Team with players


  Scenario: Create a team
    Given someone wants to get the information about a player
      | Id  |   FirstName   | LastName |
      | 1   |      Omar     |  Clavier |
    When the player create a team
    Then the information about the team will be creating successfully
