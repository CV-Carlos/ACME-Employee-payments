# ACME-payments

**Initial information and requirements**

Time slots - Payments

Monday - Friday

WEEK - SLOT 1: 00:01 - 09:00 25 USD

WEEK - SLOT 2: 09:01 - 18:00 15 USD

WEEK - SLOT 3: 18:01 - 00:00 20 USD

Saturday and Sunday

WEEKEND - SLOT 1: 00:01 - 09:00 30 USD

WEEKEND - SLOT 2: 09:01 - 18:00 20 USD

WEEKEND - SLOT 3: 18:01 - 00:00 25 USD


Input  {EMPLOYEE}={DAY}{TIME}-{TIME}

MO: Monday

TU: Tuesday

WE: Wednesday

TH: Thursday

FR: Friday

SA: Saturday

SU: Sunday

OUTPUT The amount to pay {EMPLOYEE} is:{AMOUNT} USD

**TESTING**

_SCENARIOS_

Feature: Calculate payment

	Scenario: Worked only during a day, single time slot, not fractions of an hour
	Given Mateo worked on {DAY) from {TIME} to {TIME}
	When Company check what his/her payment is
	Then His payment is equal to the value set for each hour on that time slot on that day
	
	Example
	Scenario: Calculating the payment
  	Given Mateo worked on MO:01:00-06:00
    	When Company checks what the payment is
    	Then Company should see payment $125

	Table of possible (expected) results - In this case, write logic for all days is cheap (just change the day)

    | Mateo | MO:01:00-06:00  | Company | 125     |
	| Mateo | MO:10:00-18:00  | Company | 120     |
	| Mateo | MO:19:00-20:00  | Company | 20      |
	| Mateo | (Iterate from Tuesday to Friday):(Repeat times above) | Company | 25      |
    | Mateo | SA:01:00-06:00  | Company | 150     |
    | Mateo | SA:10:00-18:00  | Company | 160     |
    | Mateo | SA:19:00-20:00  | Company | 25      |
	| Mateo | (Change sunday):(repeat times above)  | Company | (Repeat payments above)      |

	Scenario: Worked only during a day between a single time slot but with hour fractions
	Given Mateo worked on {DAY) from {TIME} to {TIME}
	When Company checks what the payment is
	Then His payment is equal to the value set for each hour on that time slot on that day
	
    | Mateo | MO:03:10-07:15  | Company | 61.25   |
	| Mateo | MO:12:01-15:20  | Company  | 49.75  |
	| Mateo | MO:18:08-23:07  | Company | 124.58  |
	| Mateo | (Iterate from Tuesday to Friday):(Repeat times above) | Company | (Repeat payments above)   |
    | Mateo | SA:03:10-07:15  | Company | 122.50  |
    | Mateo | SA:12:01-15:20  | Company | 66.33   |
    | Mateo | SA:18:08-23:07  | Company | 124.58  |
	| Mateo | (Change sunday):(repeat times above)  | Company | (Repeat payments above)    |

	Scenario: Worked during multiples time slots on a single day, different kind of inputs
	Given Mateo worked on {DAY) from {TIME} to {TIME} and {DAY} from {TIME} to {TIME} and {DAY}.........
	or
	Given Mateo worked on {DAY) from {TIME} to {TIME} (times overlap different timeslots)
	When Company checks what the payment is
	Then His payment is equal to a {TOTAL_MULTIPLE_SLOTS}

	Notice that at this point there is no need for extra day, they are included on above example
	Question: should this be allowed? Over 8 hours working? 

    | Mateo | MO:03:10-15:00  				| Company | 235.58  |
	| Mateo | MO:12:01-15:00,MO:18:01-23:00 | Company | 174.33  |
    | Mateo | SA:03:10-12:15  				| Company | 240     |
    | Mateo | SA:12:01-15:00,SA:18:01-23:00 | Company | 190.913 |

	Scenario: Worked during multiples days
	Given Mateo worked on {DAY) from {TIME} to {TIME} and {DAY} from {TIME} to {TIME} and {DAY}.........
	When Company checks what the payment is
	Then His payment is equal to a {TOTAL_MULTIPLE_SLOTS}


    | Mateo | MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00	| Company | 215	 	|
	| Mateo | MO10:00-12:00,TH12:00-14:00,SU20:00-21:00 							| Company | 85  	|
	| Mateo | SA:12:01-15:20,MO:03:10-07:15,TH12:00-14:00,WE:10:00-18:00 			| Company | 201  	|	
	| Mateo | MO:19:00-20:00,TH12:00-14:00,SA:18:08-23:07,WE:10:00-18:00 			| Company | 294.58  |
	| Mateo | SU:12:01-15:20,MO:03:10-07:15,TU12:01-15:20,FR:01:00-06:00 			| Company | 302.33  |

    | Mateo | MO:03:10-07:15,TU:10:00-18:00,WE:19:00-20:00,SA:12:01-15:00 			| Company | 267.58  |
    | Mateo | FR:01:00-06:00,SA:12:01-15:00,SA:18:01-23:00,SU:03:10-12:15 			| Company | 555.13  |






- Check input correctness - input sanatization:
	- {EMPLOYEE} is correct (can't include numbers)
	- Follow up by '=' 
	- Hours worked 1 or more
  		- Next input is {DAY} can only be one of the abbreviations
 		- Should follow starting {TIME}, only numbers on format HH:MM (24h format)
		- Should follow ending {TIME}, only numbers on format HH:MM (24h format)
	- No more inputs should follow

- Check input validity 
	- Is starting time before ending time?



