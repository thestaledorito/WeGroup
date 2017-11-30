package client;

import java.awt.event.*;
import javax.swing.*;

public class Login extends JPanel implements  ActionListener
{
	private static final long serialVersionUID = 1L;
	private JTextField groupname;
	private JTextField username;
	private JTextField pwd;
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	private String[] data;
	
	public Login() 
	{
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
			
		JLabel grouplabel = new JLabel("Group Name:");
		springLayout.putConstraint(SpringLayout.NORTH, grouplabel, 35, SpringLayout.NORTH, this);
		add(grouplabel);
		
		JLabel userlabel = new JLabel("User Name:");
		springLayout.putConstraint(SpringLayout.WEST, grouplabel, 0, SpringLayout.WEST, userlabel);
		add(userlabel);
		
		JLabel passlabel = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.WEST, passlabel, 0, SpringLayout.WEST, userlabel);
		add(passlabel);
		
		groupname = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, groupname, -3, SpringLayout.NORTH, grouplabel);
		springLayout.putConstraint(SpringLayout.WEST, groupname, 6, SpringLayout.EAST, grouplabel);
		add(groupname);
		groupname.setColumns(10);
		
		username = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, username, 122, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, userlabel, -12, SpringLayout.WEST, username);
		springLayout.putConstraint(SpringLayout.NORTH, userlabel, 3, SpringLayout.NORTH, username);
		add(username);
		username.setColumns(10);
		
		pwd = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, pwd, 17, SpringLayout.EAST, passlabel);
		springLayout.putConstraint(SpringLayout.NORTH, passlabel, 3, SpringLayout.NORTH, pwd);
		springLayout.putConstraint(SpringLayout.NORTH, pwd, 84, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, username, -6, SpringLayout.NORTH, pwd);
		pwd.setColumns(10);
		add(pwd);
		
		
		springLayout.putConstraint(SpringLayout.EAST, btnOk, -28, SpringLayout.EAST, this);
		add(btnOk);
		btnOk.addActionListener(this);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 23, SpringLayout.SOUTH, passlabel);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 28, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, btnOk, 0, SpringLayout.NORTH, btnCancel);
		add(btnCancel);
		btnCancel.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource() == btnOk)
		{
			String grp = groupname.getText().trim();
			String usr = username.getText().trim();
			String pass = pwd.getText().trim();
			String [] data = {grp, usr, pass}; //read contents of text area  into data
			if(!data.equals(null)) //verify their is anything to send
			{
				//Tcp_client_side.auth(data); //This would send the data to the appropriate method for authenticating client	
				groupname.setText(""); //clears out the field area
				username.setText("");
				pwd.setText("");
			}
		}
		else if (evt.getSource() == btnCancel)
		{
			System.exit(0);
		}
	}
	
	public void recauth(String reply)
	{
		if(reply == "true")
		{
			data[2]="tl;dr"; //change the password element of array so it doesn't enter main_page
			Main_page.main(data);
		}
	}
	private static void GUI()
	{
		JFrame frame = new JFrame("WeGroup Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new Login());
		
		frame.pack();
		frame.setSize(285,190);
		frame.setLocationRelativeTo(null);
		//frame.setLocationByPlatform(true);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main (String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception useDefault) {}
				GUI();
			}
		});
	}
}
