package client;

import java.awt.*;
import java.awt.event.*;
import java.awt.Window.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Pchat extends JPanel implements  ActionListener
{
	private static final long serialVersionUID = 1L;
	private final static String newline = "\n";
	private JPanel panel;
	private JTextArea textArea;
	
	public Pchat() 
	{
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{501, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 189, 21, 51, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JTextArea groupfield = new JTextArea();
		GridBagConstraints gbc_Groupfield = new GridBagConstraints();
		gbc_Groupfield.gridheight = 2;
		gbc_Groupfield.gridwidth = 2;
		gbc_Groupfield.insets = new Insets(0, 0, 5, 0);
		gbc_Groupfield.fill = GridBagConstraints.BOTH;
		gbc_Groupfield.gridx = 0;
		gbc_Groupfield.gridy = 0;
		panel.add(groupfield, gbc_Groupfield);
		
		JButton btnNewButton = new JButton("Emote");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JTextArea message = new JTextArea();
		GridBagConstraints gbc_message = new GridBagConstraints();
		gbc_message.insets = new Insets(0, 0, 0, 5);
		gbc_message.fill = GridBagConstraints.BOTH;
		gbc_message.gridx = 0;
		gbc_message.gridy = 3;
		panel.add(message, gbc_message);
		
		JButton btnSend = new JButton("Send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.fill = GridBagConstraints.BOTH;
		gbc_btnSend.gridx = 1;
		gbc_btnSend.gridy = 3;
		panel.add(btnSend, gbc_btnSend);
		btnSend.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent evt)
	{
		if()
		//Tcp_client_side.send(); This would send the data to the appropriate method for sending to client
		
	}

	private static void GUI()
	{
		JFrame frame = new JFrame("WeGroup *group*");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new Pchat());
		
		frame.pack();
		frame.setLocationByPlatform(true);
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
