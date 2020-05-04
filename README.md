# cse237-project: 237 Financial Advisors

This program acts as a pseudo financial advisor that handles a client’s wealth. It keeps track of all of an individual’s accounts across multiple institutions. The target audience is anyone looking to manage their money better.

Final Iteration:
User stories that were completed during Iteration 3:

Testing: This iteration, we focused on the testing component of our project. Around 20 tests were added since the last iteration to account for various edge cases and improper input from the user. From adding these tests, we realized that many of our methods did not account for certain edge cases and inputs so those were also updated and fixed accordingly.

Validating input: we created 4 validator methods to sanitize user input with two tests each. These were to ensure that the client is inputing a valid account type, a valid account number, and valid amounts (i.e. ints and doubles) where relevant.

User Interface: Another big portion of this iteration was getting the interface up and running, so now the user can treat it as an app and visually see all of their accounts as well as use various interactive buttons and functions to update their accounts and get advice from the financial advisor portion of the interface.

Adding methods: recommendHigherYieldAccount method was implemented along with necessary tests so that based on the user's account interest rates, they can see recommendations for an account that has a higher interest rate. A few methods were added to the Client class as well in order to ease UI functionality.

Fixing methods: Using the feedback we received we fixed the calculate ARR method.


For the client:
- A client is able to view a list of all of their bank accounts
- A client is able to add and delete bank accounts
- A client is able to withdraw or deposit any given amount of money from or to a selected account
- A client is able to transfer funds from one account to another selected, existing account
- A client is able to input their name and age to the app
- A client is able to view their updated Average Rate of Return (ARR) and Total Wealth while using the app
- A client is able to view a calculated total wealth that accounts for compounding interest rates and a given number of years passed
- A client is able to view a break down of how much each of their accounts (in percentages) makes up their of their total wealth
- A client is able to receive advice from the financial advisor regarding optimal risk for their age bracket
- A client is able eto receive advice from the financial advisor regarding opening new accounts in order to receive higher yields
- A client is able to have the financial advisor consolidate their accounts in order to optimize their wealth management
- A client will be notified if a transaction cannot be completed or if their input is not valid for the app


For the future
Incomplete:
- The consolidate button in the UI works partially in that it is able to transfer an amount from one account the the higher yielding account, but we could not get it to also delete the account(s) that was/were not optimal for the client. If we were to keep working on this we would have the button fully transfer and delete accounts that are not necessary.

If we were to continue to add to this project:
- We would add an interest calculator method that would calculate compounded total wealth for individual accounts alongside the already existing method that calculates this for total wealth
- Further develop financial advisor class
        - Have it include an API with with comprehensive bank information (i.e. different bank account rates, customer service ratings, etc.) so that the user can have a more in-depth recommendation for potential accounts
        - Have it include stocks/bonds anaylisis and recommendation in order to maximize gains based on user goals such as long-term stable savings, short term earnings, etc.
- Add credit card functionalities, including personal credit score, reccomendation on how to increase credit score, recommend credit cards based on user info (credit score, lifestyle)
- Add user log in/log out options so that multiple users can access the app
- Beautify the UI


Instructions:
**Please do not directly type anything into the text boxes. They will automatically update on their own through the use of buttons and other prompts.

When entering name and age, click on the text box above the accounts list. Do not type name and age directly into the text box.

Instructions when entering the Client account information: When entering account type, please only type one of the following options (no spaces, no capital letters): savings, checkings, stocks, bonds. A pop up message will appear when using UI if input does not match.

After creating an account, the initial balance will be zero, make a deposit by selecting the account and clicking the deposit button.

When transfering, depositing, and withdrawing amounts, please select the account in the list that you would like to transfer from, deposit to, or withdraw from before pressing a button. When deleting an account, please select the account you would like to delete before pressing the delete button.

If a button doesn’t work on the first click, click it again until a prompt appears or action ensues.

When entering interest rate, overdraw allowance, and initial balance, be sure to do so in double format (for example, 12% would be 12.0 for interest rate, or $500 would be 500.0 for overdraw allowance). Regardless if there are decimals or not. The UI is equppied with tests for this so that pop up messages will appear if inputs are not valid.

**The UI includes input sanitation so that the user will be prompted for the correct input if any input is incorrect in format.

Instructions to run on the command line: ./runFinancialAdvisors.sh
**in case file permission is somehow incorrect, type in "chmod 755 runFinancialAdvisors.sh" then try running again
