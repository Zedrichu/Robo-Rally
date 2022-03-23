Feature: Independent Move
  Scenario: Move one forward successfully
    Given player "x"  at row 3 and column 2 and direction "E"
    And card Move1Forward
    When card is played
    Then player "x" is at row 3 and column 3 and direction "E"

  Scenario Outline: Move <steps> forward successfully
    Given player <name> at row <x> and column <y> and direction <dir>
    And card Move<steps>Forward
    When card is played
    Then player <name> is at row <xnew> and column <ynew> and direction <dir>

  Scenarios:
    | steps | name | x | y | dir | xnew | ynew |
    | 1     | "XX" | 3 | 2 | 'E' | 3    | 3    |
