package Chat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.util.ArrayList;
import Game.GameView;
import Shared.Logger;
import Shared.Utility;
import Shared.Utility.MessageType;

/**
 * class of main chatting window
 * 
 * @author Jiawen
 * @author Sean
 *
 */
public class ChatView implements 
ActionListener, MessageListener, DocumentListener {

   private JFrame frame;
   private JLabel lblPortNumber;
   private JTextField txtSendPort;
   private JLabel lblIpAddress;
   private JTextField textField_IPAddress;
   private JPanel panel_top;
   private JScrollPane panel_middle;      
   private JPanel panel_bottom;
   private JTextField txtMessage;
   private JButton btnSendMsg;
   private JButton btnSelectFile;
   private JButton btnConnect;
   private JTextPane chatPanel;
   private JTextField txtListenPort;
   private JButton btnSaveMessage;
   private JButton btnReadMessage;
   private MessageReceiver rec;
   private MessageData currentMsg;
   private ArrayList<MessageData> msgStore;
   private GameView game;
   
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
      msgStore = new ArrayList<MessageData>();
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
      txtListenPort.getDocument().addDocumentListener(this);
      txtListenPort.getDocument().putProperty("owner", txtListenPort);
      panel_top.add(txtListenPort);
      
      frame.getContentPane().add(panel_top, BorderLayout.NORTH);

      // chat display
      chatPanel = new JTextPane();
      chatPanel.setEditable(false);
      
      // middle panel //
      panel_middle = new JScrollPane(chatPanel);
      panel_middle.setVerticalScrollBarPolicy(
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      panel_middle.setPreferredSize(new Dimension(250, 145));
      panel_middle.setMinimumSize(new Dimension(10, 10));
      frame.getContentPane().add(panel_middle, BorderLayout.CENTER);
      
      frame.getContentPane().add(panel_bottom, BorderLayout.SOUTH);
      panel_bottom.setLayout(new BoxLayout(panel_bottom, BoxLayout.X_AXIS));
      
      txtMessage = new JTextField();
      txtMessage.setText("Text here");
      txtMessage.getDocument().addDocumentListener(this);
      txtMessage.getDocument().putProperty("owner", txtMessage);
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
      try {
         StyledDocument doc = chatPanel.getStyledDocument();
         
         SimpleAttributeSet keyWord = new SimpleAttributeSet();
         StyleConstants.setForeground(keyWord, Color.BLUE);
         
         // time
         doc.insertString(doc.getLength(), msg.getTime() + " ", keyWord );
         
         // name
         boolean isMe = msg.getMessageType() == MessageType.Sending;
         String name = isMe ? "Me" : msg.getSenderIP();
         StyleConstants.setForeground(keyWord, !isMe ? Color.BLUE : Color.black);
         StyleConstants.setBold(keyWord, !isMe);
         doc.insertString(doc.getLength(), name + ": ", keyWord );
         
         // message
         StyleConstants.setForeground(keyWord, Color.black);
         StyleConstants.setBold(keyWord, false);
         doc.insertString(doc.getLength(), msg.getMessage() + "\n", keyWord );
      }
      catch(Exception e) { System.out.println(e); }
      triggerGame();
   }
   
   /**
    * method to test if the game should start
    */
   private void triggerGame() {
      int size = msgStore.size();
      if (size <= 1) 
         return;
      MessageData m1 = msgStore.get(size - 2); // previous message
      MessageData m2 = msgStore.get(size - 1); // current message
      
      if (m1.getMessage().equals(Utility.EGG_QUESTION) &&
         m2.getMessage().equals(Utility.EGG_ANSWER) && 
         m1.getMessageType() != m2.getMessageType()) {
         game = new GameView();
      }
   }
   /**
    * method to load limited amount of previous message as the program starts
    */
   private void loadMessage() {
      chatPanel.setText("");
      try {
         StyledDocument doc = chatPanel.getStyledDocument();
         
         SimpleAttributeSet keyWord = new SimpleAttributeSet();
         StyleConstants.setForeground(keyWord, Color.black);
         StyleConstants.setFontSize(keyWord, 12);
         StyleConstants.setBold(keyWord, true);
         StyleConstants.setAlignment(keyWord, StyleConstants.ALIGN_CENTER);
         doc.setParagraphAttributes(0, doc.getLength(), keyWord, false);
         doc.insertString(doc.getLength(), "- Today -\n\n", keyWord );
         
         StyleConstants.setAlignment(keyWord, StyleConstants.ALIGN_LEFT);
         doc.setParagraphAttributes(doc.getLength(), 0, keyWord, false);
      }
      catch(Exception e) { System.out.println(e); }
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
      String receiver_ip = textField_IPAddress.getText();
      int port = Integer.parseInt(txtSendPort.getText());
      
      currentMsg.setSenderIP("localhost");
      currentMsg.setMessage(txtMessage.getText());
      currentMsg.setMessageType(MessageType.Sending);
      currentMsg.updateMsgTime();
      msgStore.add(currentMsg);
      
      displayMessage(currentMsg);
      //System.out.println(currentMsg);
      
      MessageData copyMsg = (MessageData)currentMsg.clone();
      copyMsg.setMessageType(MessageType.Incoming);
      //System.out.println(copyMsg);
      
      MessageSender sender = new MessageSender(receiver_ip ,port, copyMsg);
      (new Thread(sender)).start();

      txtMessage.setText("");
      currentMsg = new MessageData();
   }
   
   /**
    * method to attach a file to current message
    */
   private void attachFile() {
      
   }
   
   /**
    * method to reset server listening port when port number is changed
    */
   private void resetListeningPort() {
      String port_str = txtListenPort.getText();
     
      if (!Utility.isNumeric(port_str)){
         return;
      }
         
      int port = Integer.parseInt(port_str);
      rec.UpdateListeningPort(port);
      (new Thread(rec)).start();
   }
   
   /**
    * method used by game to send game specific information
    * @param x        
    * @param y
    */
   public void sendGameMessage(int x, int y) {
      
   }
   
   /**
    * event handler to display incoming message
    */
   @Override
   public void processMessage(MessageData e) {
      msgStore.add(e);
      saveMessage(e);
      displayMessage(e);
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

   /**
    * event handlers for all text field changes
    */
   @Override
   public void changedUpdate(DocumentEvent e) { handleTextFieldChange(e); }
   
   @Override
   public void insertUpdate(DocumentEvent e) { handleTextFieldChange(e); }

   @Override
   public void removeUpdate(DocumentEvent e) { handleTextFieldChange(e); }
   
   private void handleTextFieldChange(DocumentEvent e) {
      Object owner = e.getDocument().getProperty("owner");
      if (owner == txtListenPort) { resetListeningPort();}
      else if (owner == txtMessage) { }
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
