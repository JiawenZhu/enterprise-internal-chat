package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Model.LogData;
import Model.MessageData;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;

import java.awt.CardLayout;

import javax.swing.SwingConstants;

import java.awt.GridLayout;
import Controller.*;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;

/**
 * class of main chatting window
 * 
 * @author Jiawen
 * @author Sean
 *
 */
public class ChatView {

	private JFrame frame;
	private JLabel lblPortNumber;
	private JTextField txtSendPort;
	private JLabel lblIpAddress;
	private JTextField textField_IPAddress;
	private JPanel panel_top;
	private JPanel panel_middle;		
	private JPanel panel_bottom;
	private JTextField txtMessage;
	private JButton btnSendMsg;
	private JButton btnSelectFile;
	private JLabel displaytxtLabel;
	private JButton btnConnect;
	private JList lstChat;
	private JTextField txtListenPort;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatView window = new ChatView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChatView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// main frame //
		frame = new JFrame();
		frame.setBackground(new Color(238, 238, 238));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// top panel //
		panel_top = new JPanel();
		
		//  middle panel //
		panel_middle = new JPanel();
		
		// bottom panel //
		panel_bottom = new JPanel();
		panel_bottom.setBackground(new Color(238, 238, 238));
		panel_top.setLayout(new GridLayout(0, 6, 0, 0));
		
		
		lblPortNumber = new JLabel("Send Port");
		lblPortNumber.setHorizontalAlignment(SwingConstants.LEFT);
		panel_top.add(lblPortNumber);
		panel_top.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblPortNumber, txtSendPort, textField_IPAddress, lblIpAddress}));
		
		txtSendPort = new JTextField();
		txtSendPort.setText("8823");
		txtSendPort.setColumns(5);
		panel_top.add(txtSendPort);
		
		
		// text field port number listener // 
		txtSendPort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			// connect to the port //
			}
		});
		
		lblIpAddress = new JLabel("IP address");
		lblIpAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_top.add(lblIpAddress);
		
		textField_IPAddress = new JTextField();
		textField_IPAddress.setText("localhost");
		panel_top.add(textField_IPAddress);
		
		// text field IP address listener //
		textField_IPAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if (e.getSource()==Connec)
			}
		});
		
		btnConnect = new JButton("Connect");
		panel_top.add(btnConnect);
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnConnect) {
					int port = Integer.parseInt(txtListenPort.getText());
					MessageReceiver rec = new MessageReceiver(port);
					rec.addMessageListener(new MessageListener() {

						@Override
						public void processMessage(MessageData e) {
							//System.out.println(e.getMessage());
							DefaultListModel mod = (DefaultListModel)lstChat.getModel();
							mod.addElement("[" + e.getDateTime() + "][" + e.getSenderIP() + "]: " + e.getMessage());
						}
					});
					
					(new Thread(rec)).start();
				}
			}
		});
		
		txtListenPort = new JTextField();
		txtListenPort.setText("8822");
		panel_top.add(txtListenPort);
		txtListenPort.setColumns(10);
		
		
		frame.getContentPane().add(panel_top, BorderLayout.NORTH);
		frame.getContentPane().add(panel_middle, BorderLayout.CENTER);
		panel_middle.setLayout(new BorderLayout(0, 0));
		
		lstChat = new JList();
		lstChat.setVisibleRowCount(20);
		lstChat.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lstChat.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstChat.setModel(new DefaultListModel());
		lstChat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_middle.add(lstChat);
		frame.getContentPane().add(panel_bottom, BorderLayout.SOUTH);
		panel_bottom.setLayout(new BoxLayout(panel_bottom, BoxLayout.X_AXIS));
		
		txtMessage = new JTextField();
		txtMessage.setText("Text here");
		panel_bottom.add(txtMessage);
		txtMessage.setColumns(20);
		txtMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==txtMessage){
					// set message into the messageData //
					MessageData md = new MessageData(null, null);
					
				}
			}
		});
		
		// send button // 
		btnSendMsg = new JButton("Send");
		panel_bottom.add(btnSendMsg);
		btnSendMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==txtMessage || e.getSource()==btnSendMsg){
					String address = textField_IPAddress.getText();
					int port = Integer.parseInt(txtSendPort.getText());
					MessageData msg = new MessageData(address, txtMessage.getText());
					MessageSender sender = new MessageSender("localhost",port , msg);
					(new Thread(sender)).start();
				}
				
			}
		});
		btnSelectFile = new JButton("Attach File");
		panel_bottom.add(btnSelectFile);
		
		
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSelectFile){
					DefaultListModel<String> mod = (DefaultListModel<String>)lstChat.getModel();
					OpenFile openFile = new OpenFile();
					try {
						openFile.pickAFile();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					mod.addElement(openFile.sb.toString());
					
					// create a file image on the middle panel....// 
				}
			}
		});
	
	}

}