Feature: Apply search filters

  Scenario: get a filtered player list with my preferences
    Given the user wants to search based on their player
      | Id  | FirstName | LastName | Gender | Description |
      | 1   |  Omar     |   Marit  | Hombre | Play Valorant |
    When someone visits the player profile on their preference
    Then the information about the player about her preference is successfully