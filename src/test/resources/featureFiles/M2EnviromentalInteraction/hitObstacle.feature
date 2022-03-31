@tag
Feature: Hit Obstacle
  @tag
  Scenario Outline:
    Given Player <name> at row <y> column <x> with <lives> lives
    And acidTile at row <y> and column <x>
    When round is incremented
    Then player <name> has <lives-2> lives

    @tag
    Scenarios:
      | | name | x | y | lives |lives-2|
      | | "XX" | 3 | 2 |   3   |   1   |

  @tag
    Scenario Outline:
    Given player <name> at row <y> column <x> with card hand <hand> (as linked list)
    And pitTile at row <y> and column <x>
    When round is incremented
    Then player <name> with card hand <handNew>
    @tag
    Scenarios:
      | | name | x | y |          hand            |    handNew       |
      | | "XX" | 3 | 2 | ArrayList<CardHand> hand |  hand(head,null) |
  @tag
    Scenario Outline:
    Given Player <name> at row <y> column <x> with <lives> lives
    And laserTile at row <y>  and column <x>
    When round is incremented
    Then player <name> has <lives-1> lives
    @tag
    Scenarios:
      | | name | x | y | lives |lives-1|
      | | "XX" | 3 | 2 |   3   |   2   |

  @tag
    Scenario Outline:
    Given Player <name> on row <y> column <x> and direction <dir>
    And conveyorBelt is on row <y> column <x> with direction <convDir>
    When round is incremented
    Then Player <name> on row <ynew>  new column <xnew> and direction <dir>
    @tag
    Scenarios:
      | | name| x | y | dir | convDir | xnew | ynew |
      | | "XX"| 3 | 2 | 'E' |   'S'   |  3   |  3   |
      | | "XX"| 3 | 2 | 'E' |   'S'   |  3   |  3   |

  @tag
    Scenario Outline:
    Given Player <name> at row <y> column <x> with <lives> lives
    And laserTile at row <y>  and column <x>
    When round is incremented
    Then player <name> has <lives+1> lives