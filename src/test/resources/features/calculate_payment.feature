Feature: Calculate the payment

  Scenario Outline: Calculating the payment
    Given <actor> worked on <employeeShift>
    When <actor1> checks what the payment is
    Then <actor1> should see payment $<payment>

    Examples:
      | actor | employeeShift   | actor1  | payment |
      | Mateo | <employeeShift> | Company | 25      |


