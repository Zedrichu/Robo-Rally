@tag
  Feature: Game Initialisation
    @tag1
    Scenario: initialise game of 4 players
      Given 4 players
      And a deck of cards
      When game initialisation
      Then generate board
      And view board

@tag
  Feature: Game Settings
  @tag2
    Scenario: create game settings
      Given a board with size
      And a complexity
      And set of player settings
      When create game settings
      Then allow game to start