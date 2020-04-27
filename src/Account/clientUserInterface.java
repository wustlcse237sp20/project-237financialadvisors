package Account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
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

public class clientUserInterface {
	

	private JFrame frame;
	private Client client; // create field for controller
	private Account account;
	List<Account> Accounts = new ArrayList<Account>();
	private JTextField txtClientNameClient;

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
		frame.setBounds(200, 200, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		client = new Client(Accounts, 0); //trying to call constructor on controller (Client)
		
		DefaultListModel<Account> listModel = new DefaultListModel<>();
		for (int i=0; i< client.Accounts.size(); i++) {
			listModel.addElement(client.Accounts.get(i));
		}
		
		JList<Account> list = new JList<Account>(listModel);
		springLayout.putConstraint(SpringLayout.WEST, list, 138, SpringLayout.WEST, frame.getContentPane());
		list.setBackground(Color.WHITE);
		frame.getContentPane().add(list);
		
		JButton btnAddAccount = new JButton("add account");
		springLayout.putConstraint(SpringLayout.WEST, list, 11, SpringLayout.WEST, btnAddAccount);
		btnAddAccount.addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e) {
				 String type = (String)JOptionPane.showInputDialog(frame, "Enter account type", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		 		 String name = (String)JOptionPane.showInputDialog(frame, "Enter bank name", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		 		 String interest = (String)JOptionPane.showInputDialog(frame, "Enter interest rate", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		 		 String overdraw = (String)JOptionPane.showInputDialog(frame, "Enter overdraw allowed ", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		 		 String account = (String)JOptionPane.showInputDialog(frame, "Enter account number", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		 		 
			if ((type != null && name != null && interest != null && overdraw != null && account != null)) {	
					Account x = new Account(type, name, Double.parseDouble(interest), Double.parseDouble(overdraw), Integer.parseInt(account));
					client.addAccount(x);
					listModel.addElement(x);
					return;
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnAddAccount, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddAccount, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnAddAccount);
		
		JButton btnDeleteAccount = new JButton("delete acccount");
		btnDeleteAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				client.deleteAccount(list.getSelectedValue().getAccountNumber());
				listModel.removeElement(list.getSelectedValue());
				list.remove(list.getSelectedIndex());
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDeleteAccount, 0, SpringLayout.NORTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.WEST, btnDeleteAccount, 2, SpringLayout.EAST, btnAddAccount);
		frame.getContentPane().add(btnDeleteAccount);
		
		JButton btnWithdrawal = new JButton("withdrawal");
		btnWithdrawal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double s = (double)JOptionPane.showInputDialog(frame, "How much would you like to withdraw from the selected account?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				
				if (s != 0 && s >= account.getBalance() && list.getSelectedIndex() > -1) {
						list.getSelectedValue().withdraw(s);
						return;
					}
			}
		});
		btnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnWithdrawal, 0, SpringLayout.NORTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.WEST, btnWithdrawal, 6, SpringLayout.EAST, btnDeleteAccount);
		frame.getContentPane().add(btnWithdrawal);
		
		JButton btnDeposit = new JButton("deposit");
		btnDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double s = (double)JOptionPane.showInputDialog(frame, "How much would you like to deposit into the selected account?",  "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				
				if (s != 0 && s <= account.getOverdrawAllowed() && list.getSelectedIndex() > -1) {
						list.getSelectedValue().deposit(s);
						return;
					}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDeposit, 0, SpringLayout.NORTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.WEST, btnDeposit, 23, SpringLayout.EAST, btnWithdrawal);
		frame.getContentPane().add(btnDeposit);
		
		JButton btnTransfer = new JButton("Transfer");
		springLayout.putConstraint(SpringLayout.SOUTH, list, -6, SpringLayout.NORTH, btnTransfer);
		springLayout.putConstraint(SpringLayout.EAST, list, 141, SpringLayout.WEST, btnTransfer);
		springLayout.putConstraint(SpringLayout.WEST, btnTransfer, 56, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnTransfer, -29, SpringLayout.NORTH, btnAddAccount);
		frame.getContentPane().add(btnTransfer);
		
		//list.setSize(100, 100);
		//list.setFixedCellHeight(50);
		//list.setFixedCellWidth(60);
		
		txtClientNameClient = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, list, 17, SpringLayout.SOUTH, txtClientNameClient);
		springLayout.putConstraint(SpringLayout.EAST, list, 63, SpringLayout.EAST, txtClientNameClient);
		springLayout.putConstraint(SpringLayout.NORTH, txtClientNameClient, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtClientNameClient, 173, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtClientNameClient, -201, SpringLayout.EAST, frame.getContentPane());
		txtClientNameClient.setText("Client Name, Client Age");
		frame.getContentPane().add(txtClientNameClient);
		txtClientNameClient.setColumns(10);
	}
}
