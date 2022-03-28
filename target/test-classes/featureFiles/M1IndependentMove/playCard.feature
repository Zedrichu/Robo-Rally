@tag
Feature: Play Card
  @tag
  Scenario: Move one forward successfully
    Given player "x" at row 3 and column 2 and direction "E"
    And card of type MOVE and intensity 1
    When card is played
    Then player "x" is at row 3 and column 3 and direction "E"
  @tag
  Scenario Outline: Move one forward successfully
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type MOVE and intensity 1
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dir>

    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew |
      |  | "XX" | 3 | 2 | 'E' | 4    | 2    |

  @tag
  Scenario Outline: Move two forward successfully
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type MOVE and intensity 2
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dir>
    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew |
      |  | "XX" | 3 | 2 | 'E' | 5    | 2    |

  @tag
  Scenario Outline: Move three forward successfully
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type MOVE and intensity 3
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dir>
    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew |
      |  | "XX" | 3 | 2 | "E" | 6    | 2    |

  @tag
  Scenario Outline: Move one backwards successfully
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type MOVE and intensity -1
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dir>

    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew |
      |  | "XX" | 3 | 5 | "S" | 3    | 4    |

  @tag
  Scenario Outline: Rotate left successfully
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type ROTATE and intensity -1
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dirNew>

    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew | dirNew |
      |  | "XX" | 3 | 2 | "E" | 3    | 2    | "N"    |

  @tag
  Scenario Outline: Rotate right successfully
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type ROTATE and intensity 1
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dirNew>

    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew | dirNew |
      |  | "XX" | 1 | 4 | 'E' | 1    | 4    | 'S'    |
    
  @tag
  Scenario Outline: make U-turn successfully
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type ROTATE and intensity 2
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dirNew>

    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew | dirNew |
      |  | "XX" | 1 | 4 | 'E' | 1    | 4    | 'W'    |


  @tag
  Scenario Outline: move one tile out of bounds
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type MOVE and intensity 1
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dirNew>

    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew | dirNew |
      |  | "XX" | 0 | 2 | 'N' | 1    | 2    | 'N'    |




