# cse237-project: 237 Financial Advisors
This program acts as a pseudo financial advisor that handles a client’s wealth. It keeps track of all of an individual’s accounts across multiple institutions. The target audience is anyone looking to manage their money better.

Iteration 2:

User stories that were completed:

The financial advisor class was updated 
    -The client is able to further analyze their accounts. The consolidate accounts method now checks for multiple accounts of the same type, finds the account with the highest interest rate, and will transfer money from other accounts to this highest yield account then delete other accounts. This allows them to properly consolidate their accounts to maximize their yield. 
    -The client is also able to learn what their optimal ARR should be based on their age bracket, and this has been further edited to a range of ARRs to be more realistic, returning either the client’s ARR if their ARR is within a range considered optimal, or returning the lowest ARR from the range to suggest the minimum ARR they should reach.
    
The client class was updated with 5 methods that would increase functionality 
    -A client is now able to delete an account and transfer money between accounts
    -interestRateCalculator method was completed -- which calculates the total wealth balance of a client after a given time period to see how the interest rate has compounded and added wealth
    -A client can now withdraw and deposit money from the client class and not just the account class (needed for the user interface)
    -calculatePercentagesByAccountType() method was deleted as it become redundant once the consolidated accounts method was implemented fully 
    
User Interface
    -A client is able to view a list of all of their bank accounts through the user interface
    -A client is able to add an account and input the new account’s information to the list as well as delete selected accounts
    -A client can view options to add, delete, deposit, transfer, and withdraw functions on  the user interface 
The tests for these three accounts also currently pass. 

User stories to be completed next iteration: 

For the next iteration we intend to complete the following
    -The main method will sanitize user input more effectively by prompting again if info is entered incorrectly or in the improper format from the UI side
    -Have recommendHigherYieldAccount working
    -The client will be able to use the transfer, withdraw, and deposit buttons on the user interface
    -The client will be able to receive financial advice through the user interface
    -The client will be able to view the percentage of their wealth by type of account as well as how much (percentage) each individual account makes up their total wealth
    
Implemented methods that don’t work:
    -One method that is implemented but that currently doesn’t work is the recommendHigherYieldAccounts method in the Financial Advisor class. This method is meant to help the client see what other accounts they could possess in order to help their finances depending on what accounts they currently hold.
    -Although the delete button in the user interface class works, there is still an error with the function regarding an out of bounds error that needs to be fixed. The button can be used normally, however. Once the error is fixed this function will correctly remove an account from the client’s list if they press the delete button on a selected account.
    
Instructions:

** Instructions when entering the Client account information: When entering account type, please only type one of the following options (no spaces, no capital letters): savings, checkings, stocks, bonds.

When entering interest rate, overdraw allowance, and initial balance, be sure to do so in double format (for example, 12% would be 12.0 for interest rate, or $500 would be 500.0 for overdraw allowance). Regardless if there are decimals or not. ** We will work on sanitizing user input in the next iteration. 

Instructions to run on command line: ./runFinancialAdvisors.sh
**in case file permission is somehow incorrect, type in "chmod 755 runFinancialAdvisors.sh" then try running again
