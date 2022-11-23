package Bank.View;

import javax.security.auth.Refreshable;
import javax.swing.UIManager;

import Framework.View.FincoController;
import Framework.View.FincoFramework;
import Framework.View.JDialog_AddCompAcc;
import Framework.View.JDialog_AddPAcc;

public class BankView extends FincoFramework{
	
	BankView myframe;
	public FincoController viewController;

	public BankView(String typeOfView) {
		super(typeOfView);
		myframe = this;
		viewController  = new BankViewController();
	}
	
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
			(new BankView("Bank ")).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
	@Override
	public void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		BankJDialog_AddPAcc pac = new BankJDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
        super.refreshTable(this.viewController.getAccounts());
    }
	
	@Override
	public void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/
		
		BankJDialog_AddCompAcc pac = new BankJDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		super.refreshTable(this.viewController.getAccounts());

	}

}
