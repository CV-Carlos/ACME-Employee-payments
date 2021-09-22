# ACME-payments

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

TESTING

SCENARIOS

Feature: Calculate payment

	Scenario: Worked only during a day between a complete single time slot (not overlapping, not fractions)
	Given Mateo worked on {DAY) from {TIME} to {TIME}
	When Company check what his/her payment is
	Then His payment is equal to the value set for single (complete) time slot for giving day
	
	Example
	Scenario: Calculating the payment
  	    Given Mateo worked on MO:00:01-09:00
    	When Company check what his/her payment is
    	Then Company should see payment $25


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



