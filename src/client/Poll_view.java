package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import data_types.*;

public class Poll_view extends JPanel implements  ActionListener
{
	private static final long serialVersionUID = 7L;
	private JPanel panel;
	private DefaultTableModel tablemod = new DefaultTableModel(0,2);
	private final JTextField additemf = new JTextField();
	private final JLabel lblTitle = new JLabel("Title:");
	private final JButton btnCancel = new JButton("Cancel");
	private final JScrollPane scroll = new JScrollPane();
	private final JTable polled = new JTable(new DefaultTableModel(
													new Object[][] {},
													new String[] {"Option", "Total Votes"}));
	
	public Poll_view() 
	{
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{212, 0};
		gbl_panel.rowHeights = new int[]{0, 189, 51, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		panel.add(lblTitle, gbc_lblTitle);
		additemf.setColumns(10);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scroll, gbc_scrollPane);
		
		
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.WEST;
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 2;
		panel.add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(this);
		polled.setSurrendersFocusOnKeystroke(true);
		
		scroll.setViewportView(polled);	
		tablemod.setColumnCount(2);
	}
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == btnCancel)
		{	
			System.exit(0);
		}
	}
	/*public void pollres(Array result[])
	{
		for(int i=0; i < result; i++)
		{
			tablemod.addRow(add object here);
		}
	}*/
	private static void GUI()
	{
		JFrame frame = new JFrame("View Poll");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Poll_view());
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
