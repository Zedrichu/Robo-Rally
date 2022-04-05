Feature: Choose a number of cards from the initially drawn cards
  @tag
  Scenario: player "x" selects the list of cards to be used
    Given player "x"
    And card hand of player "x" with 9 cards
    When choose 5 cards
    Then player "x" has card hand with 5 cards

