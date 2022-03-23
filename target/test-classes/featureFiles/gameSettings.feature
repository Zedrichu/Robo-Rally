@tag
Feature: Game Settings
  @tag2
  Scenario: game settings are created
    Given a board_ID
    And a complexity
    And set of player settings
    When create game settings
    Then game initialisation