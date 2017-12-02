package client;

//import data_types.*;
//import tcp_bridge.Tcp_client_side;
/*
public class Main_page 
{

	// Initialize this class
	public void Init()
	{
		m_tcp = new Tcp_client_side();
		m_tcp.Init();
		m_tcp.Register_reciver(this);
	}
	
	// Data received from TCP
	public void Data_received(Base_data data)
	{
		
	}
	
	// Class to send TCP
	protected Tcp_client_side m_tcp;
}
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main_page extends JPanel implements  ActionListener
{
	private static final long serialVersionUID = 3L;
	private JPanel panel = new JPanel();
	private JList<String> lists = new JList<String>();
	private JList<String> polls = new JList<String>();
	private JList<String> members = new JList<String>();
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JScrollPane scrollPane = new JScrollPane();
	private JScrollPane scrollPane_1 = new JScrollPane();
	private JTextArea textArea = new JTextArea();
	private JTextArea textArea_1 = new JTextArea();
	private final JButton btnSend = new JButton("Send");
	private final JButton btnEmote = new JButton("emote");
	
	public Main_page() 
	{
		setLayout(new BorderLayout(0, 0));
		
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{216, 351, 69, 0};
		gbl_panel.rowHeights = new int[]{308, 58, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 3;
		gbc_tabbedPane.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		panel.add(tabbedPane, gbc_tabbedPane);
		
		
		tabbedPane.addTab("New tab", null, members, null);
		
		
		tabbedPane.addTab("New tab", null, lists, null);
		
		
		tabbedPane.addTab("New tab", null, polls, null);
		
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		
		
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		
		scrollPane_1.setViewportView(textArea_1);
		
		GridBagConstraints gbc_btnEmote = new GridBagConstraints();
		gbc_btnEmote.insets = new Insets(0, 0, 5, 0);
		gbc_btnEmote.gridx = 2;
		gbc_btnEmote.gridy = 1;
		panel.add(btnEmote, gbc_btnEmote);
		
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 2;
		panel.add(btnSend, gbc_btnSend);
	
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		
	}
	
	private static void GUI()
	{
		JFrame frame = new JFrame("WeGroup *group name*");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new Main_page());
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		//frame.setLocationByPlatform(true);
		//frame.setResizable(false);
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
