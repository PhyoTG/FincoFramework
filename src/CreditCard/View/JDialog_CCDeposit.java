package CreditCard.View;
import java.awt.*;
import javax.swing.*;

import CreditCard.CreditCard;
import Framework.Finco;
import Framework.Account.Account;
import Framework.View.FincoController;
import Framework.View.IFincoController;

public class JDialog_CCDeposit extends javax.swing.JDialog
{
    

    private CreditCard parentframe;
    private String name;
    private String accnr;
    private IFincoController creditController = new CreditCardController();
    
	public JDialog_CCDeposit(CreditCard parent, String aname, String a)
	{
		super(parent);
		parentframe=parent;
		name=aname;
		accnr = a;
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parses your Java file into its visual envirenment. 
		//{{ INIT_CONTROLS 
		setTitle("Deposit");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(268,126);
		setVisible(false);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,48,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,144,24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84,48,144,24);
		//}}
	    JTextField_NAME.setText(name);
	    
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		//}}
	}



	//{{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
        parentframe.amountDeposit=JTextField_Deposit.getText();
        
        Account accNo = new Account(accnr, null, "S");
        for (Account acc : creditController.getAccounts()) {
			if(acc.getAccountNumber().equals(this.accnr)) {
				accNo = acc;
			}
		}
		double amount = Double.parseDouble(JTextField_Deposit.getText());
		creditController.deposit(accNo,amount);
        dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}

}