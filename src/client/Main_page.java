package client;

import data_types.*;
import tcp_bridge.Tcp_client_side;
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

public class Main_page extends JPanel //implements  ActionListener
{
	private static final long serialVersionUID = 3L;
//	private final static String newline = "\n";
	
	public Main_page() 
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{209, 294, 87, 0};
		gridBagLayout.rowHeights = new int[]{27, 316, 29, 40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JMenuBar menuBar = new JMenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_menuBar.anchor = GridBagConstraints.NORTH;
		gbc_menuBar.insets = new Insets(0, 0, 5, 0);
		gbc_menuBar.gridwidth = 3;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		add(menuBar, gbc_menuBar);
		
		JMenuItem Filemenu = new JMenuItem("File");
		menuBar.add(Filemenu);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane.gridheight = 3;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		add(tabbedPane, gbc_tabbedPane);
		
		JList members = new JList();
		tabbedPane.addTab("Members", null, members, null);
		
		JList lists = new JList();
		tabbedPane.addTab("Lists", null, lists, null);
		
		JList polls = new JList();
		tabbedPane.addTab("Polls", null, polls, null);
		
		JTextArea msgcenter = new JTextArea();
		GridBagConstraints gbc_msgcenter = new GridBagConstraints();
		gbc_msgcenter.fill = GridBagConstraints.BOTH;
		gbc_msgcenter.insets = new Insets(0, 0, 5, 0);
		gbc_msgcenter.gridwidth = 2;
		gbc_msgcenter.gridx = 1;
		gbc_msgcenter.gridy = 1;
		add(msgcenter, gbc_msgcenter);
		
		JTextArea typemsg = new JTextArea();
		GridBagConstraints gbc_typemsg = new GridBagConstraints();
		gbc_typemsg.fill = GridBagConstraints.BOTH;
		gbc_typemsg.insets = new Insets(0, 0, 0, 5);
		gbc_typemsg.gridheight = 2;
		gbc_typemsg.gridx = 1;
		gbc_typemsg.gridy = 2;
		add(typemsg, gbc_typemsg);
		
		JButton btnemote = new JButton("Emote");
		btnemote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnemote = new GridBagConstraints();
		gbc_btnemote.fill = GridBagConstraints.VERTICAL;
		gbc_btnemote.insets = new Insets(0, 0, 5, 0);
		gbc_btnemote.gridx = 2;
		gbc_btnemote.gridy = 2;
		add(btnemote, gbc_btnemote);
		
		JButton btnSend = new JButton("Send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.fill = GridBagConstraints.VERTICAL;
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 3;
		add(btnSend, gbc_btnSend);
	
	}
	
	/*public void actionPerformed(ActionEvent evt)
	{
		
	}
	*/
	
	
	
	// You will need this block of code to talk through the bridge
	//////////////////////////////////////////////////////////////

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
	
	/////////////////////////////////////////////////////////////
	
	
	
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
