@tag
  Feature: Game Initialisation
    @tag1
    Scenario: game is initialised
      Given game settings
      And cardDeck
      When game initialisation
      Then place players on starting tiles