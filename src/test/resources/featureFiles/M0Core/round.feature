@tag
Feature: Round Operations
  @tag
  Scenario: Increment round counter
    Given round counter 3
    And set of players <S>
    And all in <S> have moved
    When increment round counter
    Then round counter is 4
  @tag
  Scenario Outline: Increment round counter
    Given round counter <x>
    And set of players <S>
    And all in <S> have moved
    When increment round counter
    Then round counter is <xnew>
    @tag
    Scenarios:
      | x  | xnew |
      | 4  | 5    |

  @tag
  Scenario:Reset round counter successfully
    Given round counter 5
    When reset round counter
    Then round counter is 0
  @tag
    Scenario Outline: Reset round counter successfully
    Given round counter <x>
    When reset round counter
    Then round counter is <xnew>
    @tag
    Scenarios:
      | x | xnew |
      | 5 | 0    |


  @tag
    Scenario Outline: Play round of cards
    Given set of players <S>
    And round counter {int}
    When play round
    Then all players have <5 - round number> cards
    @tag
    Scenarios:
      | round number |
      | 1 |




