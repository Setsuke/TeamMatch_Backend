Feature: ChampionTournamentPrize


  Scenario: ChampionTournamentPrize
    Given the user wants to know the <initial prize> of the tournament
    And the system added a new <player enrollment> to the tournament
    When I refresh the view
    Then the user will see the <actual prize> of the tournament successfully


