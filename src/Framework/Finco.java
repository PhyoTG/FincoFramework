package Framework;

import java.awt.BorderLayout;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Framework.Account.Account;
import Framework.View.FincoController;
import Framework.View.IFincoController;
import Framework.View.JDialog_AddCompAcc;
import Framework.View.JDialog_AddPAcc;
import Framework.View.JDialog_Deposit;
import Framework.View.JDialog_Withdraw;

/**
 * A basic JFC based application.
 **/
public class Finco extends javax.swing.JFrame
{
    /****
     * init variables in the object
     ****/
    String accountnr, clientName,street,city,zip,state,accountType,clientType;
	public String amountDeposit;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    Finco myframe;
    private Object rowdata[];
    public IFincoController viewController;
    
	public Finco(String typeOfView)
	{
		myframe = this;
		viewController = new FincoController();
		
		setTitle( typeOfView +" Application");
		
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(675,410);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,660,410);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowdata = new Object[8];
        newaccount=false;
        
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];
		
		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,190,34);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Addinterest.setBounds(448,20,106,33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		//$$ lineBorder1.move(24,312);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		
	}

	
	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
			(new Finco("Finco Default")).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == Finco.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
			
		}
	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	public void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		refreshTable(this.viewController.getAccounts());
            
    }

	public void refreshTable(Collection<Account> aa) {
		DefaultTableModel dtm = (DefaultTableModel) JTable1.getModel();
		dtm.setRowCount(0);
		Collection<Account> accounts = aa;
		for (Account account : accounts) {
			Object[] row = new Object[8];
			row[0] = account.getAccountNumber();
			row[1] = account.getCust().getName();
			row[2] = account.getCust().getCity();

			if (account.getCust() instanceof Framework.Customer.Person) {
				row[3] = 'P';
			} else {
				row[3] = 'C';
			}
			row[4] = account.getAccType();

			row[5] = account.getCurrentAmount();

			model.addRow(row);
		}

		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}


	public void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/
		
		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		refreshTable(this.viewController.getAccounts());

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    // compute new amount
//            long deposit = Long.parseLong(amountDeposit);
//            Double samount = (Double)model.getValueAt(selection, 5);
//		    long newamount=(long) (samount+deposit);
//		    model.setValueAt(String.valueOf(newamount),selection, 5);
		    refreshTable(this.viewController.getAccounts());
		}
		
		
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(myframe,accnr);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
    		
		    // compute new amount
//            long deposit = Long.parseLong(amountDeposit);
//            double samount = (double)model.getValueAt(selection, 5);
////            long currentamount = Long.parseLong(samount);
//		    long newamount=(long) (samount-deposit);
//		    model.setValueAt(String.valueOf(newamount),selection, 5);
//		    if (newamount <0){
//		       JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
//		    }
		    refreshTable(this.viewController.getAccounts());
		}
		
		
	}
	
	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		  JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
		  viewController.addInterest();
		  refreshTable(this.viewController.getAccounts());
	}
}
