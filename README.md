# cse237-project: 237 Financial Advisors
This program acts as a pseudo financial advisor that handles a client’s wealth. It keeps track of all of an individual’s accounts across multiple institutions. The target audience is anyone looking to manage their money better.

Iteration 1:

User stories that were completed:

Through the Account class the client is able to view the name of their bank, the accounts they have under this bank, the account numbers, the type of each account (checking, saving, stocks, or bonds), and the interest rate for each account. The bank client is also able to withdraw any given amount from an account or deposit any given amount from an account. 

Through the Client class the bank client is able to view all of their accounts, their total wealth, their ARR, and the percentage of wealth that each individual account makes up. The client is also able to create a new account.

Through financial advisor class, the client is able to further analyze their accounts. The consolidate accounts method checks for multiple accounts of the same type, finds the highest interest rate within those accounts, and recommends that the client should move their money to the one with the highest interest rate. The client is also able to learn what their optimal ARR should be based on their age bracket and compare it to their current portfolio ARR.

The tests for these three accounts also currently pass. 

The main method gathers input from the client and prints out a summary of the Client’s financial situation. 

There is a user story for learning to write tests. Since we are all minors, we included this story to account for the extra time taken to do this, although there is no branch for it since it was done while simultaneously creating classes.


User stories to be completed next iteration: 

For the next iteration we intend to complete the following:
- Finalize interest rate user story, which will allow the client to view how their account balance is affected over time by compounding interest rate
- Add additional functionality to Client by allowing for transfers between account and the deletion of accounts
- The main method will sanitize user input more effectively by prompting again if information is entered incorrectly or in the improper format 
- Consolidate accounts method will be able to transfer funds and delete accounts accordingly
- Additional functionality for ARR optimization
- calculatePercentageByAccountType() will be able to calculate the percentage of wealth by account type  

Implemented methods that don’t work:

There were two methods implemented that currently do not work. The first is the method that is meant to display to the client the calculated percentages by account type. That is, how much of the client's total wealth is under savings, how much is under checking, how much is in bonds, and how much in stocks. The second is the consolidateAccount method that is meant to consolidate the client's accounts, checking for multiple accounts of the same type and determining which has a higher interest rate then moving money around to optimize the client portfolio. Math.round in two methods in the Client class are also currently not functioning properly, which we will further investigate in the next iteration.

Instructions:

** Instructions when entering the Client account information: When entering account type, please only type one of the following options (no spaces, no capital letters): savings, checkings, stocks, bonds.
When entering interest rate, overdraw allowance, and initial balance, be sure to do so in double format (for example, 12% would be 12.0 for interest rate, or $500 would be 500.0 for overdraw allowance). Regardless if there are decimals or not. ** 
We will work on sanitizing user input in the next iteration. 

Instructions to run on command line: ./runFinancialAdvisors.sh
