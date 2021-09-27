Feature: Calculate the payment

  Scenario Outline: Calculating the payment, single time slot, not fractions of an hour
    Given <actor> worked on <employeeShift>
    When <actor1> checks what the payment is
    Then <actor1> should see payment $<payment>

    Examples:
      | actor | employeeShift   | actor1  | payment |
      | Mateo | MO01:00-06:00  | Company | 125     |
      | Mateo | MO10:00-18:00  | Company | 120     |
      | Mateo | MO19:00-20:00  | Company | 20      |
      | Mateo | TU01:00-06:00  | Company | 125     |
      | Mateo | TU10:00-18:00  | Company | 120     |
      | Mateo | TU19:00-20:00  | Company | 20      |
      | Mateo | WE01:00-06:00  | Company | 125     |
      | Mateo | WE10:00-18:00  | Company | 120     |
      | Mateo | WE19:00-20:00  | Company | 20      |
      | Mateo | TH01:00-06:00  | Company | 125     |
      | Mateo | TH10:00-18:00  | Company | 120     |
      | Mateo | TH19:00-20:00  | Company | 20      |
      | Mateo | FR01:00-06:00  | Company | 125     |
      | Mateo | FR10:00-18:00  | Company | 120     |
      | Mateo | FR19:00-20:00  | Company | 20      |
      | Mateo | SA01:00-06:00  | Company | 150     |
      | Mateo | SA10:00-18:00  | Company | 160     |
      | Mateo | SA19:00-20:00  | Company | 25      |
      | Mateo | SU01:00-06:00  | Company | 150     |
      | Mateo | SU10:00-18:00  | Company | 160     |
      | Mateo | SU19:00-20:00  | Company | 25      |

  Scenario Outline: Calculating the payment single day, single time slot but with hour fractions
    Given <actor> worked on <employeeShift>
    When <actor1> checks what the payment is
    Then <actor1> should see payment $<payment>

    Examples:
      | actor | employeeShift   | actor1  | payment |
      | Mateo | MO03:10-07:15  | Company  | 102.08  |
      | Mateo | MO12:01-15:20  | Company  | 49.75   |
      | Mateo | MO18:08-23:07  | Company  | 99.67   |
      | Mateo | TU03:10-07:15  | Company  | 102.08  |
      | Mateo | TU12:01-15:20  | Company  | 49.75   |
      | Mateo | TU18:08-23:07  | Company  | 99.67   |
      | Mateo | WE03:10-07:15  | Company  | 102.08  |
      | Mateo | WE12:01-15:20  | Company  | 49.75   |
      | Mateo | WE18:08-23:07  | Company  | 99.67   |
      | Mateo | TH03:10-07:15  | Company  | 102.08  |
      | Mateo | TH12:01-15:20  | Company  | 49.75   |
      | Mateo | TH18:08-23:07  | Company  | 99.67   |
      | Mateo | FR03:10-07:15  | Company  | 102.08  |
      | Mateo | FR12:01-15:20  | Company  | 49.75   |
      | Mateo | FR18:08-23:07  | Company  | 99.67   |
      | Mateo | SA03:10-07:15  | Company  | 122.50  |
      | Mateo | SA12:01-15:00  | Company  | 59.67   |
      | Mateo | SA18:01-23:00  | Company  | 124.58  |
      | Mateo | SU03:10-07:15  | Company  | 122.50  |
      | Mateo | SU12:01-15:00  | Company  | 59.67   |
      | Mateo | SU18:01-23:00  | Company  | 124.58  |

  Scenario Outline: Calculating the payment with multiples time slots on a single day, different kind of inputs
    Given <actor> worked on <employeeShift>
    When <actor1> checks what the payment is
    Then <actor1> should see payment $<payment>

    Examples:
      | actor | employeeShift                 | actor1  | payment |
      | Mateo | MO03:10-15:00                 | Company | 235.58  |
      | Mateo | MO12:01-15:00,MO18:01-23:00   | Company | 144.42  |
      | Mateo | SA03:10-12:15  	              | Company | 239.67  |
      | Mateo | SA12:01-15:00,SA18:01-23:00   | Company | 184.25  |

  Scenario Outline: Calculating the payment with multiples days
    Given <actor> worked on <employeeShift>
    When <actor1> checks what the payment is
    Then <actor1> should see payment $<payment>

    Examples:
      | actor | employeeShift                                                           | actor1  | payment  |
      | Mateo | MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00	| Company | 215	 	 |
      | Mateo | MO10:00-12:00,TH12:00-14:00,SU20:00-21:00 				                | Company | 85  	 |
      | Mateo | SA12:01-15:20,MO03:10-07:15,TH12:00-14:00,WE10:00-18:00 		        | Company | 318.42	 |
      | Mateo | MO19:00-20:00,TH12:00-14:00,SA18:08-23:07,WE10:00-18:00 		        | Company | 294.58   |
      | Mateo | SU12:01-15:20,MO03:10-07:15,TU12:01-15:20,FR01:00-06:00 		        | Company | 343.17   |

      | Mateo | MO03:10-07:15,TU10:00-18:00,WE19:00-20:00,SA12:01-15:00 		        | Company | 301.75   |
      | Mateo | FR01:00-06:00,SA12:01-15:00,SA18:01-23:00,SU03:10-12:15 		        | Company | 548.92   |









