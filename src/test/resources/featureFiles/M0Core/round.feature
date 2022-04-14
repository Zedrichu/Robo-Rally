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
  Scenario: Increment round counter error
    Given round counter 3
    And set of players <S>
    And not all in <S> have moved
    When increment round counter
    Then round counter is 3
  @tag
  Scenario Outline: Increment round counter error
    Given round counter <x>
    And set of players <S>
    And not all in <S> have moved
    When increment round counter
    Then round counter is <xnew>
    @tag
    Scenarios:
      | x | xnew |
      | 4 | 4    |

  @tag
  Scenario:Reset round counter successfully
    Given round counter 5
    And set of players <S>
    And all in <S> have moved
    When reset round counter
    Then round counter is 1
  @tag
    Scenario Outline: Reset round counter successfully
    Given round counter <x>
    And set of players <S>
    And all in <S> have moved
    When reset round counter
    Then round counter is <xnew>
    @tag
    Scenarios:
      | x | xnew |
      | 5 | 1    |
    @pending
      Scenario: Draw Cards for each player on new round successfully
      Given round counter 1
      And any in <S> don't have any cards
      When draw cards
      Then all players have a card hand with 9 cards






