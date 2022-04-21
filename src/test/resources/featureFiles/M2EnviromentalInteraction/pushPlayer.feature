@tag
Feature: Push another player
  @tag
  Scenario Outline:
    Given A player1 <name1> at row <y1> column <x1> with direction <dir1>
    And A player2 <name2> at row <y2> column <x2> with direction <dir2>
    And A player1 <name1> has a MoveCard with intensity 2
    When player1 <name1> plays MoveCard
    Then player1 <name1> is at row <y2> column <x2> with direction <dir1>
    And player2 <name2> is pushed in direction <dir1> to new location at row <y3> column <x3> with direction <dir2>

    @tag
    Scenarios:
      | | name1 | name2 | x1 | y1 | dir1 | x2 | y2 | dir2 | x3 | y3 |
      | | "XX1" | "XX2" | 2  | 4  | 'S'  | 2  | 6  | 'W'  | 2  | 7  |
      | | "XX3" | "XX4" | 1  | 5  | 'N'  | 1  | 3  | 'W'  | 1  | 2  |

  @tag
  Scenario Outline:
    Given A player1 <name1> at row <y1> column <x1> with direction <dir1>
    And A player2 <name2> at row <y2> column <x2> with direction <dir2>
    And A player1 <name1> has a MoveCard with intensity 1
    When player1 <name1> plays MoveCard
    Then player1 <name1> is at row <y2> column <x2> with direction <dir1>
    And player2 <name2> is pushed in direction <dir1> to new location at row <y3> column <x3> with direction <dir2>

    @tag
    Scenarios:
      | | name1 | name2 | x1 | y1 | dir1 | x2 | y2 | dir2 | x3 | y3 |
      | | "XX1" | "XX2" | 2  | 4  | 'S'  | 2  | 5  | 'W'  | 2  | 6  |
      | | "XX3" | "XX4" | 1  | 5  | 'N'  | 1  | 4  | 'W'  | 1  | 3  |

  @tag
  Scenario Outline:
    Given A player1 <name1> at row <y1> column <x1> with direction <dir1>
    And A player2 <name2> at row <y2> column <x2> with direction <dir2>
    And A player1 <name1> has a MoveCard with intensity 3
    When player1 <name1> plays MoveCard
    Then player1 <name1> is at row <y2> column <x2> with direction <dir1>
    And player2 <name2> is pushed in direction <dir1> to new location at row <y3> column <x3> with direction <dir2>

    @tag
    Scenarios:
      | | name1 | name2 | x1 | y1 | dir1 | x2 | y2 | dir2 | x3 | y3 |
      | | "XX1" | "XX2" | 2  | 4  | 'S'  | 2  | 7  | 'W'  | 2  | 8  |
      | | "XX3" | "XX4" | 1  | 5  | 'N'  | 1  | 2  | 'W'  | 1  | 1  |


