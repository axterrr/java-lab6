Feature: Stack Operations

  Scenario Outline: Push and Pop operations
    Given an empty stack

    When I push <value1> into the stack
    And I push <value2> into the stack
    And I push <value3> into the stack
    Then the size of the stack should be 3

    When I pop from the stack
    Then the size of the stack should be 2
    And the value popped from the stack should be <value3>

    When I pop from the stack
    Then the size of the stack should be 1
    And the value popped from the stack should be <value2>

    When I pop from the stack
    Then the stack should be empty
    And the value popped from the stack should be <value1>

    Examples:
      | value1       | value2    | value3   |
      | "one"        | "two"     | "tree"   |
      | "Vladyslav"  | "Maksym"  | "Zakhar" |
      | "java"       | "c++"     | "kotlin" |
      | "stack"      | "queue"   | "bag"    |
