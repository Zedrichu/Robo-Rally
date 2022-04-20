@tag
  Feature: CheckPoints
    #Player on CheckPoint
    @tag
    Scenario Outline:
      Given player <name> on row <y> and column <x> with set of visited CheckPoints
      And CheckPoint <tile> on row <y> and column <x> with ID <cpID>
      When round is incremented
      Then player <name> has new set of visited CheckPoints
      And if player <name> has complete set of CheckPoints then player wins

      @tag
      Scenarios:
        | | name | tile      | y | x | cpID |
        | | "XX" | 'cpTile'  | 3 | 2 |  2   |

    #CheckPoint already collected
    @tag
    Scenario Outline:
      Given player <name> on row <y> and column <x> with set of visited CheckPoints including Checkpoint <cpID>
      And CheckPoint <tile> on row <y> and column <x> with ID <cpID>
      And full set of CheckPoints from board of size <size>
      When round is incremented
      Then player <name> has same set of CheckPoints as before

      @tag
      Scenarios:
      | | name | tile      | x | y | cpID |size|
      | | "XX" | 'cpTile'  | 3 | 2 |  4   |  3 |