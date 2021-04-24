Feature: ChampionTournamentPrize


  Scenario Outline: ChampionTournamentPrize
    Given the user wants to know the <initial prize> of the tournament
    And the system added a new <player enrollment> to the tournament
    When I refresh the view
    Then the user will see the <actual prize> of the tournament successfully


    Examples:

      | initial prize | player enrollment | actual prize |
      | 8             | 5                 | 13           |
      | 10            | 6                 | 16           |
      | 10            | 8                 | 18           |