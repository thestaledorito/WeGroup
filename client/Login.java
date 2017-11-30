package client;

import java.awt.*;
import java.awt.event.*;
import java.awt.Window.*;
import javax.swing.*;

public class Login extends JPanel implements  ActionListener
{
	private static final long serialVersionUID = 1L;
	private final static String newline = "\n";
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField pwdPassword;
	
	public Login() 
	{
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
			
		JLabel lblNewLabel = new JLabel("Group Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 35, SpringLayout.NORTH, this);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNewLabel);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 122, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -12, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, textField_1);
		add(textField_1);
		textField_1.setColumns(10);
		
		pwdPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, pwdPassword, 17, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, pwdPassword);
		springLayout.putConstraint(SpringLayout.NORTH, pwdPassword, 84, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -6, SpringLayout.NORTH, pwdPassword);
		pwdPassword.setColumns(10);
		add(pwdPassword);
		
		JButton btnOk = new JButton("OK");
		springLayout.putConstraint(SpringLayout.EAST, btnOk, -28, SpringLayout.EAST, this);
		add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 23, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 28, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, btnOk, 0, SpringLayout.NORTH, btnCancel);
		add(btnCancel);
	
	}
	
	/*public void actionPerformed(ActionEvent evt)
	{
		
	}
	*/
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
