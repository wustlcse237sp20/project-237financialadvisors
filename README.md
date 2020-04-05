# cse237-project: 237 Financial Advisors
This program acts as a pseudo financial advisor that handles a client’s wealth. It keeps track of all of an individual’s accounts across multiple institutions. The target audience is anyone looking to manage their money better.

Iteration 1:
Through the Account class the client is able to view the name of their bank, the accounts they have under this bank, the account numbers, the type of each account (checking, saving, stocks, or bonds), and the interest rate for each account. The bank client is also able to withdraw any given amount from an account or deposit any given amount from an account. If a withdrawal or deposit amount is not able to be processed the client will be notified.

Through the Client class the bank client is able to view all of their accounts, their total wealth, their optimal average rate of return (ARR) for their age bracket, which is compared to their current ARR, and the percentage of wealth that each individual account makes up. The client is also able to create a new account.

** Instructions when entering the Client account information: When entering account type, please only type one of the following options (no spaces, no capital letters): savings, checkings, stocks, bonds.
When entering interest rate, overdraw allowance, and initial balance, be sure to do so in double format (for example, 12% would be 12.0 for interest rate, or $500 would be 500.0 for overdraw allowance). Regardless if there are decimals or not. **

For the next iteration we intend to complete the following: finalize interest rate user story, which will allow the client to view how their account balance is affected over time by compounding interest rates, ensure the client can transfer funds between account, the client will be able to delete accounts, and sanitize user input.

There were two methods implemented that currently do not work. The first, is the method that is meant to display to the client the calculated percentages by account type. That is, how much of the client's total wealth is under savings, how much is under checking, how much is in bonds, and how much in stocks. The second is the consolidateAccount method that is meant to consolidate the client's accounts, checking for multiple accounts of the same type and determining which has a higher interest rate then moving money around to optimize the client portfolio.
