# ACME-payments

**Initial information **

<details><summary>Click to expand</summary>
Time slots - Payments
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
Monday - Friday
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
WEEK - SLOT 1: 00:01 - 09:00 25 USD
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
WEEK - SLOT 2: 09:01 - 18:00 15 USD
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
WEEK - SLOT 3: 18:01 - 00:00 20 USD
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
Saturday and Sunday
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
WEEKEND - SLOT 1: 00:01 - 09:00 30 USD
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
WEEKEND - SLOT 2: 09:01 - 18:00 20 USD
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
WEEKEND - SLOT 3: 18:01 - 00:00 25 USD
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
Input  {EMPLOYEE}={DAY}{TIME}-{TIME}
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
MO: Monday
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
TU: Tuesday
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
WE: Wednesday
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
TH: Thursday
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
FR: Friday
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
SA: Saturday
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
SU: Sunday
</details>
<details><summary>Click to expand</summary>

</details>
<details><summary>Click to expand</summary>
OUTPUT The amount to pay {EMPLOYEE} is:{AMOUNT} USD
</details>


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



