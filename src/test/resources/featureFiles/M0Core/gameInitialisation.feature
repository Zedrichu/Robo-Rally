@tag
  Feature: Game Initialisation
    @tag1
    Scenario: game is initialised
      Given game settings with EASY and 2 players
      And cardDeck
      When game initialisation
      Then players are on starting tiles