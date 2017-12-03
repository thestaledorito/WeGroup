package client;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Poll_vote extends JPanel implements  ActionListener
{
	private static final long serialVersionUID = 4L;
	private JPanel panel;
	private final JLabel lblTitle = new JLabel("*Poll Title*");
	private final JButton btnCancel = new JButton("Cancel");
	private final JButton btnVote = new JButton("Vote");
	private DefaultComboBoxModel<String> boxmod = new DefaultComboBoxModel<String>();
	private final JComboBox<String> comboBox = new JComboBox<String>(boxmod);
	
	public Poll_vote() 
	{
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{91, 140, 61, 0};
		gbl_panel.rowHeights = new int[]{0, 47, 51, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		panel.add(lblTitle, gbc_lblTitle);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 2;
		panel.add(btnCancel, gbc_btnCancel);
		
		GridBagConstraints gbc_btnVote = new GridBagConstraints();
		gbc_btnVote.gridx = 2;
		gbc_btnVote.gridy = 2;
		panel.add(btnVote, gbc_btnVote);
		
	}
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == btnVote)
		{	
			//send data for update to server
		}
		else if (evt.getSource() == btnCancel)
		{
			System.exit(0);
		}
	}
	
	public void pollvote(ArrayList<String> data)
	{
		int index = data.size() - 1;
		for(int i=0; i<index; i++)
		{
			boxmod.addElement(data.get(i));
		}
	}
	
	private static void GUI()
	{
		JFrame frame = new JFrame("Poll Vote");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Poll_vote());
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
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //attempt to use system look for UI
				} catch (Exception useDefault) {}
				GUI();
			}
		});
	}
}
