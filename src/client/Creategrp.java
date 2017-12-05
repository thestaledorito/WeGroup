package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Creategrp extends JPanel implements  ActionListener
{
	private static final long serialVersionUID = 4L;
	private JPanel panel;
	private JScrollPane scroll1 = new JScrollPane();
	private JScrollPane scroll2 = new JScrollPane();
	private final JTextField additemf = new JTextField();
	private final JLabel lblAddItem = new JLabel("add member:");
	private final JButton btnAdd = new JButton("add");
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblTitle = new JLabel("Title:");
	private final JList<String> list = new JList<String>();
	private final JButton btnCancel = new JButton("Cancel");
	private final JButton btnCreate = new JButton("Create");
	
	public Creategrp() 
	{
		textField_1.setColumns(10);
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{91, 212, 61, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 189, 21, 51, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 1;
		panel.add(lblTitle, gbc_lblTitle);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		
		
		GridBagConstraints gbc_Groupfield = new GridBagConstraints();
		gbc_Groupfield.gridwidth = 3;
		gbc_Groupfield.gridheight = 2;
		gbc_Groupfield.insets = new Insets(0, 0, 5, 0);
		gbc_Groupfield.fill = GridBagConstraints.BOTH;
		gbc_Groupfield.gridx = 0;
		gbc_Groupfield.gridy = 2;
		panel.add(scroll1, gbc_Groupfield);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		scroll1.setViewportView(list);
		GridBagConstraints gbc_lblAddItem = new GridBagConstraints();
		gbc_lblAddItem.anchor = GridBagConstraints.EAST;
		gbc_lblAddItem.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddItem.gridx = 0;
		gbc_lblAddItem.gridy = 4;
		panel.add(lblAddItem, gbc_lblAddItem);
		additemf.setColumns(10);
		
		
		GridBagConstraints gbc_message = new GridBagConstraints();
		gbc_message.fill = GridBagConstraints.HORIZONTAL;
		gbc_message.insets = new Insets(0, 0, 5, 5);
		gbc_message.gridx = 1;
		gbc_message.gridy = 4;
		panel.add(scroll2, gbc_message);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		scroll2.setViewportView(additemf);
		
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 4;
		panel.add(btnAdd, gbc_btnAdd);
		
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 5;
		panel.add(btnCancel, gbc_btnCancel);
		
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.gridx = 2;
		gbc_btnCreate.gridy = 5;
		panel.add(btnCreate, gbc_btnCreate);
		
	}
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == btnCreate)
		{	
			
		}
	}

	private static void GUI()
	{
		JFrame frame = new JFrame("Create new WeGroup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Creategrp());
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	public static void main ()
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
