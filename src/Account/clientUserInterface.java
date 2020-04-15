package Account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class clientUserInterface {
	
	//test

	private JFrame frame;
	private JTextField txtBankName;
	private Client client;

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
		
		JButton btnAddAccount = new JButton("add account");
		springLayout.putConstraint(SpringLayout.WEST, btnAddAccount, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddAccount, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnAddAccount);
		
		JButton btnDeleteAcccount = new JButton("delete acccount");
		springLayout.putConstraint(SpringLayout.NORTH, btnDeleteAcccount, 0, SpringLayout.NORTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.WEST, btnDeleteAcccount, 2, SpringLayout.EAST, btnAddAccount);
		frame.getContentPane().add(btnDeleteAcccount);
		
		JButton btnWithdrawal = new JButton("withdrawal");
		btnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnWithdrawal, 0, SpringLayout.NORTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.WEST, btnWithdrawal, 6, SpringLayout.EAST, btnDeleteAcccount);
		frame.getContentPane().add(btnWithdrawal);
		
		JList<String> list = new JList<>(i.toArray());
		springLayout.putConstraint(SpringLayout.NORTH, list, 77, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 56, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(list);
		
		JButton btnDeposit = new JButton("deposit");
		springLayout.putConstraint(SpringLayout.NORTH, btnDeposit, 0, SpringLayout.NORTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.WEST, btnDeposit, 23, SpringLayout.EAST, btnWithdrawal);
		frame.getContentPane().add(btnDeposit);
		
		JButton btnTransfer = new JButton("Transfer");
		springLayout.putConstraint(SpringLayout.WEST, btnTransfer, 0, SpringLayout.WEST, btnAddAccount);
		springLayout.putConstraint(SpringLayout.SOUTH, btnTransfer, -29, SpringLayout.NORTH, btnAddAccount);
		frame.getContentPane().add(btnTransfer);
		
		txtBankName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtBankName, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtBankName, 207, SpringLayout.WEST, frame.getContentPane());
		txtBankName.setText("Bank Name");
		frame.getContentPane().add(txtBankName);
		txtBankName.setColumns(10);
	}

}
