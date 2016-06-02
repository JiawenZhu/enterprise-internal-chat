package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Model.MessageData;

import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.GridLayout;

import Controller.*;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;

/**
 * class of main chatting window
 * 
 * @author Jiawen
 * @author Sean
 *
 */
public class ChatView implements ActionListener {

   private JFrame frame;
   private JLabel lblPortNumber;
   private JTextField txtSendPort;
	private JTextField txtSendPort;
   private JLabel lblIpAddress;
   private JTextField textField_IPAddress;
   private JPanel panel_top;
   private JPanel panel_middle;
   private JTextField txtMessage;		
   private JPanel panel_bottom;
	private JTextField txtMessage;
   private JButton btnSendMsg;
   private JButton btnSelectFile;
   private JLabel displaytxtLabel;
   private JButton btnConnect;
   
   private JTextField txtListenPort;private JList lstChat;
	private JTextField txtListenPor
   private JButton btnSaveMessage;t;
	private JButton btnSaveMessage;
   private JButton btnReadMessage;
	private JButton btnReadMessage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
   }		EventQueue.invokeLater(new Runnab
   /**
    * Create the application.
    */
   public ChatView() {
      initialize();
   }le() {
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
   private JButton btnSaveMessage;
   private JButton btnReadMessage;
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
   private JButton btnSaveMessage;
   private JButton btnReadMessage;
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
		frame.setBounds(100, 100, 550, 400);
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
		
		btnSaveMessage = new JButton("Save Message");
		btnSaveMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSaveMessage);
				MessageData data =new MessageData(txtSendPort.getName(), txtSendPort.getText());					
		ArrayList<MessageData> list = new ArrayList<MessageData>();
				list.addToArrayList(data);
				Logger logger = new Logger(); 
				
				try {
					logger.saveInformationToDisk(list);
				} catch (IOException e1) {
					System.out.println("Failed to save message on disk.");
					e1.printStackTrace();
				}
			}
		});
		panel_bottom.add(btnSaveMessage);
		
		btnReadMessage = new JButton("Read Message");
		btnReadMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnReadMessage);
//				MessageData data =new MessageData(txtSendPort.getName(), txtSendPort.getText());					
//				MessageList list = new MessageList();
//				list.addToArrayList(data);
				Logger logger = new Logger(); 
				try {
					System.out.println(logger.loadDataOnDisk());
				} catch (Exception e1) {
					System.out.println("Failed to read message on disk.");
					e1.printStackTrace();
				}
			}
		});
		panel_bottom.add(btnReadMessage);
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
   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      // main frame //
      frame = new JFrame();
      frame.setBackground(new Color(238, 238, 238));
      frame.setBounds(100, 100, 550, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // top panel //
      panel_top = new JPanel();
      
      // middle panel //
      panel_middle = new JPanel();
      
      // bottom panel //
      panel_bottom = new JPanel();
      panel_bottom.setBackground(new Color(238, 238, 238));
      panel_top.setLayout(new GridLayout(0, 6, 0, 0));
      
      // Port number label //
      lblPortNumber = new JLabel("Send Port");
      lblPortNumber.setHorizontalAlignment(SwingConstants.LEFT);
      panel_top.add(lblPortNumber);
      panel_top.setFocusTraversalPolicy(new FocusTraversalOnArray(
         new Component[]{lblPortNumber, txtSendPort, textField_IPAddress, lblIpAddress}));
      
      // textbox sending port //
      txtSendPort = new JTextField();
      txtSendPort.setText("8823");
      txtSendPort.setColumns(5);
      panel_top.add(txtSendPort);
      
      // label ip address //
      lblIpAddress = new JLabel("IP address");
      lblIpAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
      panel_top.add(lblIpAddress);
      
      // textbox ip address //
      textField_IPAddress = new JTextField();
      textField_IPAddress.setText("localhost");
      panel_top.add(textField_IPAddress);
      
      // button connect //
      btnConnect = new JButton("Connect");
      btnConnect.addActionListener(this);
      panel_top.add(btnConnect);
      
      // textbox listening port //
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
      
      // send button // 
      btnSendMsg = new JButton("Send");
      panel_bottom.add(btnSendMsg);
      btnSendMsg.addActionListener(this);
      
      btnSaveMessage = new JButton("Save Message");
      btnSaveMessage.addActionListener(this);
      panel_bottom.add(btnSaveMessage);
      
      btnReadMessage = new JButton("Read Message");
      btnReadMessage.addActionListener(this);
      panel_bottom.add(btnReadMessage);
      btnSelectFile = new JButton("Attach File");
      panel_bottom.add(btnSelectFile);
      
      btnSelectFile.addActionListener(this);
   }

   @Override
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
      else if(e.getSource()==btnSendMsg) {
         String address = textField_IPAddress.getText();
         int port = Integer.parseInt(txtSendPort.getText());
         MessageData msg = new MessageData(address, txtMessage.getText());
         MessageSender sender = new MessageSender("localhost",port , msg);
         (new Thread(sender)).start();
      }
      else if (e.getSource()==btnSaveMessage) {
         MessageData data =new MessageData(txtSendPort.getName(), txtSendPort.getText());             
         ArrayList<MessageData> list = new ArrayList<MessageData>();
         list.add(data);
         Logger.saveLog(list);
      }
      else if(e.getSource()==btnReadMessage) {
         System.out.println(Logger.requestLog());
      }
      else if (e.getSource()==btnSelectFile) {
         DefaultListModel<String> mod = (DefaultListModel<String>)lstChat.getModel();
         OpenFile openFile = new OpenFile();
         try {
            openFile.pickAFile();
         } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         
         mod.addElement(openFile.sb.toString());
      }
   }
}
					
					// create a file image on the middle panel....// 
				}
			}
		});
	
	}

}
