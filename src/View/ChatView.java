package View;

import java.awt.*;
import java.awt.event.*;
import Model.MessageData;
import Model.Utility.MessageType;
import Controller.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;

/**
 * class of main chatting window
 * 
 * @author Jiawen
 * @author Sean
 *
 */
public class ChatView implements ActionListener, MessageListener {

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
   private JList<MessageData> lstChat;
   private JTextField txtListenPort;
   private JButton btnSaveMessage;
   private JButton btnReadMessage;
   private MessageReceiver rec;
   private MessageData currentMsg;
   
   
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
    * default constructor
    */
   public ChatView() {
      initialize();
      startListening();
      loadMessage();
      currentMsg = new MessageData();
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
      
      lstChat = new JList<MessageData>();
      lstChat.setVisibleRowCount(20);
      lstChat.setLayoutOrientation(JList.HORIZONTAL_WRAP);
      lstChat.setBorder(new LineBorder(new Color(0, 0, 0)));
      lstChat.setModel(new DefaultListModel<MessageData>());
      lstChat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      lstChat.setCellRenderer(new MyListCellThing());
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
      btnSaveMessage.setVisible(false);
      panel_bottom.add(btnSaveMessage);
      
      btnReadMessage = new JButton("Read Message");
      btnReadMessage.addActionListener(this);
      btnReadMessage.setVisible(false);  
      panel_bottom.add(btnReadMessage);

      btnSelectFile = new JButton("Attach File");
      btnSelectFile.addActionListener(this);
      panel_bottom.add(btnSelectFile);
   }

   /**
    * method to start listening at port specified by user 
    */
   private void startListening() {
      int port = Integer.parseInt(txtListenPort.getText());
      rec = new MessageReceiver(port);
      rec.addMessageListener(this);
      (new Thread(rec)).start();
   }
   
   /**
    * method to show new message to user
    * @param msg            message data
    */
   private void displayMessage(MessageData msg) {
      DefaultListModel<MessageData> mod = (DefaultListModel<MessageData>)lstChat.getModel();
      mod.addElement(msg);
   }
   
   /**
    * method to load limited amount of previous message as the program starts
    */
   private void loadMessage() {
      
   }
   
   /**
    * method to save the history of the chat
    * @param msg             message data
    */
   private void saveMessage(MessageData msg) {
      MessageData data =new MessageData(txtSendPort.getName(), txtSendPort.getText());
      ArrayList<MessageData> list = new ArrayList<MessageData>();
      list.add(data);
      Logger.saveLog(list);
   }
   
   /**
    * method to send current message to destination
    */
   private void sendMessage() {
      String address = textField_IPAddress.getText();
      int port = Integer.parseInt(txtSendPort.getText());
      
      MessageData msg = new MessageData(address, txtMessage.getText());
      msg.setMessageType(MessageType.Incoming);
      MessageSender sender = new MessageSender("localhost",port , msg);
      (new Thread(sender)).start();
      
      MessageData new_msg = new MessageData(address, msg.getMessage());
      new_msg.setMessageType(MessageType.Sending);
      displayMessage(new_msg);
      
      txtMessage.setText("");
   }
   
   /**
    * method to attach a file to current message
    */
   private void attachFile() {
      OpenFile openFile = new OpenFile();
      try {
         openFile.pickAFile();
      } catch (Exception e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
   }
   
   /**
    * event handler to display incoming message
    */
   @Override
   public void processMessage(MessageData e) {
      displayMessage(e);
      saveMessage(e);
   }
   
   /**
    * event handler for all button clicks
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btnConnect) { }
      else if(e.getSource()==btnSendMsg) { sendMessage(); }
      else if (e.getSource()==btnSelectFile) { attachFile(); }
   }
}


/**
 * Internal class for JList item color
 * 
 * @author sean
 *
 */
class MyListCellThing extends JLabel implements ListCellRenderer<MessageData> {
   private static final long serialVersionUID = 1L;
   
   public MyListCellThing() {
       setOpaque(true);
   }

   public Component getListCellRendererComponent(JList list, MessageData value, int index, boolean isSelected, boolean cellHasFocus) {
       if (!(value instanceof MessageData)) {
        return this;
       }
       MessageData msg = (MessageData)value;
       setText(msg.toString());
       
       if (msg.getMessageType() == MessageType.Sending) 
        setBackground(Color.green);
       else
        setBackground(Color.white);

       return this;
   }
}
