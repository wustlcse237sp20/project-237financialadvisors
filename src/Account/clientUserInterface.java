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

public class clientUserInterface {
	

	private JFrame frame;
	private Client client; // create field for controller
	private Account account;
	List<Account> Accounts = new ArrayList<Account>();

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
		
		JButton btnAddAccount = new JButton("add account");
		btnAddAccount.addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e) {
				 Account s = (Account)JOptionPane.showInputDialog(frame, "Enter Account Info", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				
			if ((s != null)) {
					client.addAccount(s);;
					return;
				}
			}
		});
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
		
		// trying to link JList to Accounts list in Client class
		
		DefaultListModel listModel = new DefaultListModel();
		for (int i=0; i< Accounts.size(); i++) {
			listModel.addElement(Accounts.get(i));
		}
		JList list = new JList();
		list.setModel(listModel);
		
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
	}

}
