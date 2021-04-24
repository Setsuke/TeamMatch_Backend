Feature: PaymentTournamentCost


  Scenario Outline: PaymentTournamentCost
    Given the player wants to know the <enrollment cost> of the tournament
    And the system added <taxes> to make the payment
    When the player wants to pay the enrollment payment of the tournament
    Then he should have paid <total enrollment payment> successfully

    Examples:

      | enrollment cost | taxes         | total enrollment payment |
      | 7               | 2             | 9                       |
      | 5               | 6             | 11                       |
      | 10              | 5             | 15                       |