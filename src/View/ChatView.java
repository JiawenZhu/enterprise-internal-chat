package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
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

public class ChatView {

	private JFrame frame;
	private JLabel lblPortNumber;
	private JTextField textField_portNumber;
	private JLabel lblIpAddress;
	private JTextField textField_IPAddress;
	private JPanel panel_top;
	private JPanel panel_middle;		
	private JPanel panel_bottom;
	private JTextField txtTextHere;
	private JButton send;
	private JButton selectFile;

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
		panel_top.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//  middle panel //
		panel_middle = new JPanel();
		panel_middle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// bottom panel //
		panel_bottom = new JPanel();
		panel_bottom.setBackground(new Color(238, 238, 238));
		panel_bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		lblPortNumber = new JLabel("Port Number");
		panel_top.add(lblPortNumber);
		
		textField_portNumber = new JTextField();
		textField_portNumber.setText("8823");
		textField_portNumber.setColumns(4);
		panel_top.add(textField_portNumber);
		
		lblIpAddress = new JLabel("IP address");
		panel_top.add(lblIpAddress);
		
		textField_IPAddress = new JTextField();
		textField_IPAddress.setText("192.168.1.1");
		panel_top.add(textField_IPAddress);
		
		
		frame.getContentPane().add(panel_top, BorderLayout.NORTH);
		panel_top.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblPortNumber, textField_portNumber, textField_IPAddress, lblIpAddress}));
		frame.getContentPane().add(panel_middle, BorderLayout.CENTER);
		frame.getContentPane().add(panel_bottom, BorderLayout.SOUTH);
		
		txtTextHere = new JTextField();
		txtTextHere.setText("Text here");
		panel_bottom.add(txtTextHere);
		txtTextHere.setColumns(20);
		
		
		// text field port number listener // 
		textField_portNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			// connect to the port //
			}
		});
		
		// text field IP address listener //
		textField_IPAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			// ... connect to the IP address //
			}
		});
		
		
		
		// send button // 
		send = new JButton("Send");
		panel_bottom.add(send);
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		selectFile = new JButton("Select file");
		panel_bottom.add(selectFile);
		
		selectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			// ... //
			}
		});
		
		
	
	}

}
