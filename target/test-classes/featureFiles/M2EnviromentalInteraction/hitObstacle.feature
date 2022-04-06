@tag
Feature: Hit Obstacle
  @tag
  Scenario Outline: Interaction with acidTile
    Given Player <name> at row <y> column <x> with <lives> lives
    And acidTile <tile> at row <y> and column <x>
    When round is incremented
    Then player <name> has <lives> add <damage> lives which leaves them at <newLives> lives

    @tag
    Scenarios:
      | | name |  tile        | x | y | lives | damage | newLives |
      | | "XX" |  'acidTile'  | 3 | 2 |   3   |   -2   |    1     |

  @tag
  Scenario Outline: Interaction with pitTile
    Given player <name> at row <y> column <x> with CardHand
    And pitTile <tile> at row <y> and column <x>
    When round is incremented
    Then player <name> with new CardHand
    @tag
    Scenarios:
      | | name | tile      | x | y |
      | | "XX" | 'pitTile' | 3 | 2 |

  @tag
  Scenario Outline: Interaction with laserTile
    Given Player <name> at row <y> column <x> with <lives> lives
    And laserTile <tile> at row <y>  and column <x>
    When round is incremented
    Then player <name> has <lives> add <damage> lives which leaves them at <newLives> lives
    @tag
    Scenarios:
      | | name |   tile          | x | y | lives | damage | newLives|
      | | "XX" |   'laserTile'   | 3 | 2 |   3   |   -1   |    2     |


 @tag

  Scenario Outline:
   Given Player <name> on row <y> column <x> and direction <dir>
   And conveyorBelt <tile> is on row <y> column <x> with direction <convDir>
   When round is incremented
   Then Player <name> on row <ynew>  new column <xnew> and direction <dir>
  @tag
  Scenarios:

  | | name| tile            | x | y | dir | convDir | xnew | ynew |
  | | "XX"| 'conveyorBelt'  | 3 | 2 | 'E' |   'S'   |  3   |  4   |
  | | "XX"| 'conveyorBelt'  | 2 | 5 | 'W' |   'N'   |  2   |  3   |

  @tag
  Scenario Outline:
    Given Player <name> at row <y> column <x> with <lives> lives
    And lifeToken <tile> at row <y>  and column <x>
    When round is incremented
    Then player <name> has <lives> add <life> lives which leaves them at <newLives> lives
    @tag
    Scenarios:
      | | name |tile       | x | y | lives | life | newLives |
      | | "XX" |'lifeToken'| 3 | 2 |   3   |   1  |    4     |