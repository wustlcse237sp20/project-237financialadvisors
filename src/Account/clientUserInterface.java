package Account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import FinancialAdvisor.FinancialAdvisor;
import Validator.Validator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class clientUserInterface {


	private JFrame frame;
	private Client client; 
	private FinancialAdvisor advisor;
	private Validator validator;
	private Account account;
	List<Account> Accounts = new ArrayList<Account>();
	private JTextField txtClientNameClient;
	private JTextField txtFinancialAdvisor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientUserInterface window = new clientUserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public clientUserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(238, 238, 238));
		frame.setBounds(200, 200, 1176, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int clientAge = 0;
		client = new Client(Accounts, clientAge); 
		advisor = new FinancialAdvisor();

		DefaultListModel<Account> listModel = new DefaultListModel<>();
		for (int i=0; i< client.Accounts.size(); i++) {
			listModel.addElement(client.Accounts.get(i));
		}
		frame.getContentPane().setLayout(null);
		JList<Account> list = new JList<Account>(listModel);
		list.setBounds(21, 52, 784, 269);
		list.setBackground(Color.WHITE);
		list.setFixedCellHeight(20);
		frame.getContentPane().add(list);

		JTextArea txtrArr = new JTextArea();
		txtrArr.setBounds(380, 332, 98, 16);
		txtrArr.setText("ARR: " + client.calculateAverageRateOfReturn());
		frame.getContentPane().add(txtrArr);

		JTextArea txtrTotalWealth = new JTextArea();
		txtrTotalWealth.setBounds(524, 333, 211, 16);
		txtrTotalWealth.setText("Total Wealth: ");
		frame.getContentPane().add(txtrTotalWealth);

		JTextArea txtrS = new JTextArea();
		txtrS.setText("Wealth Distribution by Account");
		txtrS.setBounds(842, 85, 305, 181);
		frame.getContentPane().add(txtrS);

		JButton btnAddAccount = new JButton("add account");
		btnAddAccount.setBounds(31, 385, 121, 29);
		btnAddAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Account newAccount = new Account(null, null, 0, 0.0, 0);
				String name = null;
				String interest = null;
				String overdraw = null;
				String accountNumber = null;

				String type = (String)JOptionPane.showInputDialog(frame, "Enter account type (savings, checkings, stocks, bonds)", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (Validator.validateAccountType(type) != true || type.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid acount type\n(checkings, savings, stocks, or bonds)");
				}

				if (Validator.validateAccountType(type) == true) { 
					name = (String)JOptionPane.showInputDialog(frame, "Enter bank name", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
					if (name.equals("")) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid name");
					}
					else { 
						interest = (String)JOptionPane.showInputDialog(frame, "Enter interest rate", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null); 
						if (Validator.validateDoubleInput(interest) != true || interest.equals("")) {
							JOptionPane.showMessageDialog(frame, "Please enter a valid interest rate.");
						}
						else { 
							overdraw = (String)JOptionPane.showInputDialog(frame, "Enter overdraw allowed ", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
							if (Validator.validateDoubleInput(overdraw) != true || overdraw.equals("")) {
								JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
							}
							else {
								accountNumber = (String)JOptionPane.showInputDialog(frame, "Enter your 8 digit account number", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
							}
						}
					}
				}

				if (Validator.validateAccountNumber(accountNumber) != true) {
					JOptionPane.showMessageDialog(frame, "Your account number must be 8 digits long, please re-enter account information");
				}
				else if (client.duplicateAccountNumber(client, Integer.parseInt(accountNumber)) == false) {
					JOptionPane.showMessageDialog(frame, "Account number already exists. Please enter new account information.");
				}
				else if (Validator.validateIntInput(accountNumber) != true || accountNumber.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid account number.");
				}

				else {
					if (Validator.validateAccountNumber(accountNumber) && Validator.validateAccountType(type) && Validator.validateIntInput(accountNumber)) {
						newAccount = new Account(type, name, Double.parseDouble(interest), Double.parseDouble(overdraw), Integer.parseInt(accountNumber));
						client.addAccount(newAccount);
						listModel.addElement(newAccount);
					}
				}
				txtrArr.setText("ARR: " + client.calculateAverageRateOfReturn());
				txtrTotalWealth.setText("Total Wealth: " + client.calculateTotalWealth());
				txtrS.setText(client.calculatePercentagesByAccount(client) + "\n");
				return;
			}
		});
		frame.getContentPane().add(btnAddAccount);

		JButton btnDeleteAccount = new JButton("delete account");
		btnDeleteAccount.setBounds(216, 385, 136, 29);
		btnDeleteAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				client.deleteAccount(list.getSelectedValue().getAccountNumber());
				listModel.removeElement(list.getSelectedValue());
				txtrS.setText(client.calculatePercentagesByAccount(client) + "\n");
				return;
			}
		});
		frame.getContentPane().add(btnDeleteAccount);

		JButton btnWithdrawal = new JButton("withdrawal");
		btnWithdrawal.setBounds(426, 385, 112, 29);
		btnWithdrawal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String withdrawal = (String)JOptionPane.showInputDialog(frame, "How much would you like to withdraw from the selected account?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (Validator.validateDoubleInput(withdrawal) != true || withdrawal.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid amount in the format: 0.00");
				}

				if (list.getSelectedValue().getBalance() - Double.parseDouble(withdrawal) < 0.0-list.getSelectedValue().getOverdrawAllowed()) {
					JOptionPane.showMessageDialog(frame, "Overdraw exceeded. Cannot complete transaction.");
				}

				else {
					if (withdrawal != null && list.getSelectedIndex() > -1 && Validator.validateDoubleInput(withdrawal)) {
						double withdrawAmount = Double.parseDouble(withdrawal);	
						client.getAccounts().get(list.getSelectedIndex()).withdraw(withdrawAmount);
						txtrS.setText(client.calculatePercentagesByAccount(client) + "\n");
						return;
					}
				}
			}
		});
		btnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnWithdrawal);

		JButton btnDeposit = new JButton("deposit");
		btnDeposit.setBounds(594, 385, 91, 29);
		btnDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String deposit = (String)JOptionPane.showInputDialog(frame, "How much would you like to deposit into the selected account?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (Validator.validateDoubleInput(deposit) != true || deposit.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid amount in the format: 0.00");
				}

				if (deposit != null && list.getSelectedIndex() > -1 && Validator.validateDoubleInput(deposit)) {
					double depositAmount = Double.parseDouble(deposit);
					client.getAccounts().get(list.getSelectedIndex()).deposit(depositAmount);
					txtrTotalWealth.setText("Total Wealth: " + client.calculateTotalWealth());
					txtrArr.setText("ARR: " + client.calculateAverageRateOfReturn());
					txtrS.setText(client.calculatePercentagesByAccount(client) + "\n");
					return;
				}
			}
		});
		frame.getContentPane().add(btnDeposit);

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(56, 327, 96, 29);
		btnTransfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String accountTransferTo = (String)JOptionPane.showInputDialog(frame, "What is the account number of the account you would like to transfer funds to?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (Validator.validateAccountNumber(accountTransferTo) != true || Validator.validateIntInput(accountTransferTo) != true || client.duplicateAccountNumber(client, Integer.parseInt(accountTransferTo)) || accountTransferTo.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid 8-digit account number that exists.");
				}
				else {
					String transferAmount = (String)JOptionPane.showInputDialog(frame, "How much would you like to transfer from selected account into account # " + accountTransferTo + " ?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
					if (Validator.validateDoubleInput(transferAmount) != true || accountTransferTo.equals("")) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid amount in the format: 0.00");
					}
					else {
						if (list.getSelectedIndex() > -1) {
							double amountToTransfer = Double.parseDouble(transferAmount);
							client.transferMoney(list.getSelectedValue().getAccountNumber(), Integer.parseInt(accountTransferTo), amountToTransfer);
							txtrTotalWealth.setText("Total Wealth: " + client.calculateTotalWealth());
							txtrArr.setText("ARR: " + client.calculateAverageRateOfReturn());
							txtrS.setText(client.calculatePercentagesByAccount(client) + "\n");
							return;
						}
					}
				}
			}
		});
		frame.getContentPane().add(btnTransfer);

		txtClientNameClient = new JTextField();
		txtClientNameClient.setBounds(173, 10, 365, 26);
		txtClientNameClient.setText("Click here to enter client name and age");
		txtClientNameClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String clientName = (String)JOptionPane.showInputDialog(frame, "What is your full name?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (clientName.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter a name.");
				}
				else { 
					String clientsAge = (String)JOptionPane.showInputDialog(frame, "What is your age?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null); 	
					if (Validator.validateIntInput(clientsAge) != true || clientsAge == null) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid age.");
					}
					else {
						if (clientName != null && clientsAge != null) {
							txtClientNameClient.setText(clientName + ", " + clientsAge);
							client.setAge(Integer.parseInt(clientsAge));
							return;
						}
					}
				}
			}
		});
		frame.getContentPane().add(txtClientNameClient);
		txtClientNameClient.setColumns(10);

		txtFinancialAdvisor = new JTextField();
		txtFinancialAdvisor.setText("Financial Advisor: ");
		txtFinancialAdvisor.setBounds(857, 303, 130, 29);
		frame.getContentPane().add(txtFinancialAdvisor);
		txtFinancialAdvisor.setColumns(10);

		JButton btnConsoldiateAccounts = new JButton("Consolidate Accounts");
		btnConsoldiateAccounts.setBounds(857, 344, 169, 29);
		btnConsoldiateAccounts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(client.getAccounts());
				if (advisor.consolidateAccounts(client)) {
					advisor.consolidateAccounts(client);
					JOptionPane.showMessageDialog(frame, "Accounts have been consolidated. Delete corresponding accounts with balance of zero.");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Consolidation not necessary.");
				}
				txtrS.setText(client.calculatePercentagesByAccount(client) + "\n");
				txtrArr.setText("ARR: " + client.calculateAverageRateOfReturn());
			}
		});
		frame.getContentPane().add(btnConsoldiateAccounts);

		JButton btnOptimalRiskBy = new JButton("Optimal Risk by Age");
		btnOptimalRiskBy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String msg = advisor.optimalRiskByAgeBracket(client);
				JOptionPane.showMessageDialog(frame, msg);
			}
		});
		btnOptimalRiskBy.setBounds(857, 373, 159, 29);
		frame.getContentPane().add(btnOptimalRiskBy);

		JButton btnRecommendedHigherYield = new JButton("Recommended Higher Yield");
		btnRecommendedHigherYield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, advisor.recommendHigherYieldAccounts(client));
			}
		});
		btnRecommendedHigherYield.setBounds(857, 405, 198, 29);
		frame.getContentPane().add(btnRecommendedHigherYield);

		JButton btnInterestRateCalculator = new JButton("Interest Rate Calculator");
		btnInterestRateCalculator.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String years = (String)JOptionPane.showInputDialog(frame, "How many years would you like to compound interest rate for?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (Validator.validateIntInput(years) != true || years.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid number of years.");
				}
				else {
					String compoundRate = (String)JOptionPane.showInputDialog(frame, "How many times per year would you like to compound interest rate?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null); 
					if (Validator.validateIntInput(compoundRate) != true || compoundRate.equals("")) {
						JOptionPane.showMessageDialog(frame, "Please enter a valid number of times to compound per year.");
					}
					else {
						System.out.println(client.getTotalWealth());
						JOptionPane.showMessageDialog(frame, client.interestRateCalculator(client, Integer.parseInt(years), Integer.parseInt(compoundRate)));
					}
				}
			}
		});
		btnInterestRateCalculator.setBounds(164, 327, 188, 29);
		frame.getContentPane().add(btnInterestRateCalculator);

	}
}
