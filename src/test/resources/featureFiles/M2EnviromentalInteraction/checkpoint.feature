@tag
  Feature: CheckPoints
    #Player on CheckPoint
    @tag
    Scenario Outline:
      Given player <name> on row <y> and column <x> with set of visited CheckPoints
      And CheckPoint <tile> on row <y> and column <x> with ID
      When round is incremented
      Then player <name> has new set of visited CheckPoints
      And if player <name> has complete set of CheckPoints then player wins

      @tag
      Scenarios:
        | | name | tile      | x | y |
        | | "XX" | 'cpTile'  | 3 | 0 |

    #CheckPoint already collected
    @tag
    Scenario Outline:
      Given player <name> on row <y> and column <x> with set of visited CheckPoints
      And CheckPoint <tile> on row <y> and column <x> with ID
      And full set of CheckPoints from board of size <size>
      When round is incremented
      Then player <name> has same set of CheckPoints as before

      @tag
      Scenarios:
      | | name | tile      | x | y |size|
      | | "XX" | 'cpTile'  | 3 | 0 |  3 |