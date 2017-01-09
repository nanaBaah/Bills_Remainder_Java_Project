Bills Remainder
===============

This assignment can be solved simply, but use it to show your programming skills. 
We are not only going to check the result of your program but also evaluate the quality and readability of your code.
You can use one of the following programming languages to solve the assignment: **Java**


The Task:
---------

A friend of yours is having some issues to pay his rent and energy on time. 
He always forgets which day he is supposed to pay it. 
So he asks you to create a program that creates a sheet for him which contains the dates on which he has to transfer the money.

Requirements:
-------------

* The rent has to be paid monthly. 
Always at the last day of the month, unless that day is a weekend (Saturday or Sunday). 
In this case, the rent must be paid before the weekend. 
(You don’t have to worry about public holidays for this solution)

* The energy is paid monthly too, but at the 10th of a month, unless this day is a weekend (Saturday or Sunday). 
In this case, the money should be paid on the following Tuesday after the weekend.

* Your program should receive a file name that should be used to output the calculation.

* The output file should be a .csv file containing the dates your friend has to pay his rent and energy for the next year. 
Example: If today is 15.10.2015, it should calculate from October 2015 until September 2016.

* The csv file should have three columns: 
name of the month, day of the month the rent should be paid on and day of the month the energy should be paid on.


**********************
Example Output:
---------------

**Month**  | **Pay Rent** | **Pay Energy** 
------------ | -------------
July  | 29th | 12th
August | 31th | 10th
... | ... | ...
