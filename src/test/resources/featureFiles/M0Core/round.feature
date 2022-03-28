Feature: Round
  Scenario Outline: Increment round counter
    Given round counter <x>
    And set of players <S>
    And all in <S> have moved
    When increment round counter
    Then round counter is <xnew>
  Scenarios:
    | x |  | xnew |
    | 4 |  | 5    |

  Scenario:Reset round counter successfully
    Given round counter 5
    When reset round counter
    Then round counter is 0


