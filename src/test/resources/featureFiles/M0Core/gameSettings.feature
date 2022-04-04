@tag
Feature: Game Settings
  @tag2
  Scenario:Game settings are selected
  Given new game
  When select settings
  Then game settings has EASY and 2 players
  @tag2
  Scenario Outline: Game settings are selected
  Given new game
  When select settings
  Then game settings has <y> and <x> players
    @tag2
    Scenarios:
      | y    | x |
      | EASY | 2 |