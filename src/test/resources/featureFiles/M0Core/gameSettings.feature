@tag
Feature: Game Settings
  @tag2
  Scenario:EASY Game settings are selected
  Given new game
  When select settings EASY
  Then game settings has EASY and 2 players

  @tag
  Scenario:MEDIUM Game settings are selected
  Given new game
  When select settings MEDIUM
  Then game settings has MEDIUM and 2 players

  @tag
  Scenario: HARD Game settings are selected
  Given new game
  When select settings HARD
  Then game settings has HARD and 2 players

