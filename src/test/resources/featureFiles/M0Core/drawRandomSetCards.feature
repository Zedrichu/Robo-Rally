Feature: Generate set of random cards
@tag
  Scenario: Generate set of random cards player "x"
  Given player "x"
  And card deck
  When draw cards
  Then player "x" has card hand with 9 cards