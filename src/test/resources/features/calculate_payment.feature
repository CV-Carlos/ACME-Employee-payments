Feature: Calculate the payment

  Scenario Outline: Calculating the payment, single time slot, not fractions of an hour
    Given <actor> worked on <employeeShift>
    When <actor1> checks what the payment is
    Then <actor1> should see payment $<payment>

    Examples:
      | actor | employeeShift   | actor1  | payment |
      | Mateo | MO:01:00-06:00  | Company | 125     |
      | Mateo | MO:10:00-18:00  | Company | 120     |
      | Mateo | MO:19:00-20:00  | Company | 20      |
      | Mateo | TU:01:00-06:00  | Company | 125     |
      | Mateo | TU:10:00-18:00  | Company | 120     |
      | Mateo | TU:19:00-20:00  | Company | 20      |
      | Mateo | WE:01:00-06:00  | Company | 125     |
      | Mateo | WE:10:00-18:00  | Company | 120     |
      | Mateo | WE:19:00-20:00  | Company | 20      |
      | Mateo | TH:01:00-06:00  | Company | 125     |
      | Mateo | TH:10:00-18:00  | Company | 120     |
      | Mateo | TH:19:00-20:00  | Company | 20      |
      | Mateo | FR:01:00-06:00  | Company | 125     |
      | Mateo | FR:10:00-18:00  | Company | 120     |
      | Mateo | FR:19:00-20:00  | Company | 20      |
      | Mateo | SA:01:00-06:00  | Company | 150     |
      | Mateo | SA:10:00-18:00  | Company | 20      |
      | Mateo | SA:19:00-20:00  | Company | 25      |
      | Mateo | SU:01:00-06:00  | Company | 150     |
      | Mateo | SU:10:00-18:00  | Company | 160     |
      | Mateo | SU:19:00-20:00  | Company | 25      |

  Scenario Outline: Calculating the payment single day, single time slot but with hour fractions
    Given <actor> worked on <employeeShift>
    When <actor1> checks what the payment is
    Then <actor1> should see payment $<payment>

    Examples:
      | actor | employeeShift   | actor1  | payment |
      | Mateo | MO:03:10-07:15  | Company | 61.25   |
      | Mateo | MO:12:01-15:20  | Company | 49.75   |
      | Mateo | MO:18:08-23:07  | Company | 124.58  |
      | Mateo | TU:03:10-07:15  | Company | 61.25   |
      | Mateo | TU:12:01-15:20  | Company | 49.75   |
      | Mateo | TU:18:08-23:07  | Company | 124.58  |
      | Mateo | WE:03:10-07:15  | Company | 61.25   |
      | Mateo | WE:12:01-15:20  | Company | 49.75   |
      | Mateo | WE:18:08-23:07  | Company | 124.58  |
      | Mateo | TH:03:10-07:15  | Company | 61.25   |
      | Mateo | TH:12:01-15:20  | Company | 49.75   |
      | Mateo | TH:18:08-23:07  | Company | 124.58  |
      | Mateo | FR:03:10-07:15  | Company | 61.25   |
      | Mateo | FR:12:01-15:20  | Company | 49.75   |
      | Mateo | FR:18:08-23:07  | Company | 124.58  |
      | Mateo | SA:03:10-07:15  | Company | 122.50  |
      | Mateo | SA:12:01-15:00  | Company | 66.33   |
      | Mateo | SA:18:01-23:00  | Company | 124.58  |
      | Mateo | SU:03:10-07:15  | Company | 122.50  |
      | Mateo | SU:12:01-15:00  | Company | 66.33   |
      | Mateo | SU:18:01-23:00  | Company | 124.58  |

  Scenario Outline: Calculating the payment with multiples time slots on a single day, different kind of inputs
    Given <actor> worked on <employeeShift>
    When <actor1> checks what the payment is
    Then <actor1> should see payment $<payment>

    Examples:
      | actor | employeeShift                 | actor1  | payment |
      | Mateo | MO:03:10-15:00                | Company | 235.58  |
      | Mateo | MO:12:01-15:00,MO:18:01-23:00 | Company | 174.33  |
      | Mateo | SA:03:10-12:15  		| Company | 240     |
      | Mateo | SA:12:01-15:00,SA:18:01-23:00 | Company | 190.913 |

  Scenario Outline: Calculating the payment with multiples days
    Given <actor> worked on <employeeShift>
    When <actor1> checks what the payment is
    Then <actor1> should see payment $<payment>

    Examples:
      | actor | employeeShift                                                            | actor1  | payment |
      | Mateo | MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00	| Company | 215	 	 |
      | Mateo | MO10:00-12:00,TH12:00-14:00,SU20:00-21:00 				                | Company | 85  	 |
      | Mateo | SA:12:01-15:20,MO:03:10-07:15,TH12:00-14:00,WE:10:00-18:00 		        | Company | 201  	 |
      | Mateo | MO:19:00-20:00,TH12:00-14:00,SA:18:08-23:07,WE:10:00-18:00 		        | Company | 294.58   |
      | Mateo | SU:12:01-15:20,MO:03:10-07:15,TU12:01-15:20,FR:01:00-06:00 		        | Company | 302.33   |

      | Mateo | MO:03:10-07:15,TU:10:00-18:00,WE:19:00-20:00,SA:12:01-15:00 		    | Company | 267.58   |
      | Mateo | FR:01:00-06:00,SA:12:01-15:00,SA:18:01-23:00,SU:03:10-12:15 		    | Company | 555.13   |









