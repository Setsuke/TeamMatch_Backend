Feature: CreateRoom

  Scenario Outline: Create a room
    Given the organizer wants to create <room> professional
    And the system added <Id> to the room
    When when the organizer needs to recruit professional players
    Then He creates <room create> successfully
    Examples:
      | room |   Id  | room create |
      |   1  |   6   |      7      |