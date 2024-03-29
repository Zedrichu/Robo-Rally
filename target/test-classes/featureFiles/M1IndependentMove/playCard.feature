@tag
Feature: Play Card
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
      |  | "XX" | 3 | 2 | 'E' | 6    | 2    |

  @tag
  Scenario Outline: Move one backwards successfully
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type MOVE and intensity -1
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dir>

    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew |
      |  | "XX" | 3 | 5 | 'S' | 3    | 4    |

  @tag
  Scenario Outline: Rotate left successfully
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type ROTATE and intensity -1
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dirNew>

    @tag
    Scenarios:
      |  | name | x | y | dir | xnew | ynew | dirNew |
      |  | "XX" | 3 | 2 | 'E' | 3    | 2    | 'N'    |

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
  Scenario Outline: move tile out of bounds
    Given player <name> at row <y> and column <x> and direction <dir>
    And card of type MOVE and intensity <intens>
    When card is played
    Then player <name> is at row <ynew> and column <xnew> and direction <dirNew>

    @tag
    Scenarios:
      |  | name | x | y | dir | intens | xnew | ynew | dirNew |
      |  | "XX" | 0 | 0 | 'N' | 1      | 0    | 0    | 'N'    |
      |  | "XX" | 0 | 1 | 'N' | 2      | 0    | 1    | 'N'    |
      |  | "XX" | 2 | 2 | 'W' | 3      | 2    | 2    | 'W'    |
      |  | "XX" | 0 | 0 | 'S' | -1     | 0    | 0    | 'S'    |




