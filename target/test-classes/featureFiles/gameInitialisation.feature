@tag
  Feature: Game Initialisation
    @tag1
    Scenario: initialise game of 4 players
      Given create game settings
      And create cardDeck
      When game initialisation
      Then generate board
      And view board
