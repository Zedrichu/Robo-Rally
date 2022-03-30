@tag
  Scenario: Generate set of random cards player "x"
  Given player "x"
  And card deck
  When draw cards
  Then player "x" has set of cards with 9 cards
  @tag
  Scenario Outline: Generate set of random cards player <name>
  Given player <name>
  And card deck
  When draw cards
  Then player <name> has set of cards with 9 cards
  @tag
  Scenarios:
  | name |
