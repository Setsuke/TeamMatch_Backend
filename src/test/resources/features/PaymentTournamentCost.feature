Feature: PaymentTournamentCost


  Scenario: PaymentTournamentCost
    Given the player wants to know the <enrollment cost> of the tournament
    And the system added <taxes> to make the payment
    When the player wants to pay the enrollment payment of the tournament
    Then he should have paid <total enrollment payment> successfully

