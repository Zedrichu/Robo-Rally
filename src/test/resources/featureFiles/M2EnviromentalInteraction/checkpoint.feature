@tag
  Feature: CheckPoints
    #Player on CheckPoint
    @tag
    Scenario Outline:
      Given player <name> on row <y> and column <x> with set of visited CheckPoints
      And CheckPoint <tile> on row <y> and column <x> with ID <cpID>
      When round is incremented
      Then player <name> has new set of visited CheckPoints

      @tag
      Scenarios:
        | | name | tile      | y | x | cpID |
        | | "XX" | 'cpTile'  | 3 | 2 |  2   |


    #Player has all CheckPoint
    @tag
    Scenario Outline:
      Given player <name> at position row <y> and column <x> has set of CheckPoints excepted <cpID>
      And CheckPoint <tile> on row <y> column <x> with ID <cpID>
      When round is incremented
      Then player <name> has a completed set of checkpoints and wins

      @tag
      Scenarios:
       | | name |   tile   | y | x | cpID  |
       | | "XX" | 'cpTile' | 2 | 4 |   3   |



    #CheckPoint already collected
    @tag
    Scenario Outline:
      Given player <name>  on row <y> and column <x> with set of visited CheckPoints including ID <cpID>
      And CheckPoint <tile>  on row <y> and column <x> with ID <cpID>
      When round is incremented
      Then player <name> has same set of CheckPoints as before

      @tag
      Scenarios:
      | | name | tile      | x | y | cpID |
      | | "XX" | 'cpTile'  | 3 | 2 |  4   |