package Chat;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Calendar.CalendarOverview;

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
   private JPanel panel;
   private JButton btnHistory;
   private MessageList history;
   
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
      try {
		history = Logger.loadDataOnDisk();
	  } catch (Exception e) { }
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
      panel_top.setLayout(new BoxLayout(panel_top, BoxLayout.X_AXIS));
      
      // Port number label //
      lblPortNumber = new JLabel("Send Port");
      lblPortNumber.setHorizontalAlignment(SwingConstants.LEFT);
      panel_top.add(lblPortNumber);
      
      // textbox sending port //
      txtSendPort = new JTextField();
      txtSendPort.setMaximumSize(new Dimension(80, 20));
      txtSendPort.setPreferredSize(new Dimension(80, 20));
      txtSendPort.setMinimumSize(new Dimension(80, 20));
      txtSendPort.setText("8823");
      txtSendPort.setColumns(5);
      panel_top.add(txtSendPort);
      
      // label ip address //
      lblIpAddress = new JLabel("IP address");
      lblIpAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
      panel_top.add(lblIpAddress);
      
      // textbox ip address //
      textField_IPAddress = new JTextField();
      textField_IPAddress.setPreferredSize(new Dimension(100, 20));
      textField_IPAddress.setMinimumSize(new Dimension(100, 20));
      textField_IPAddress.setMaximumSize(new Dimension(100, 20));
      textField_IPAddress.setText(getMyIP());
      panel_top.add(textField_IPAddress);
      
      // button connect //
      btnConnect = new JButton("Connect");
      btnConnect.setVisible(false);
      btnConnect.addActionListener(this);
      panel_top.add(btnConnect);
      
      // textbox listening port //
      txtListenPort = new JTextField();
      txtListenPort.setHorizontalAlignment(SwingConstants.TRAILING);
      txtListenPort.setPreferredSize(new Dimension(80, 20));
      txtListenPort.setMinimumSize(new Dimension(80, 20));
      txtListenPort.setMaximumSize(new Dimension(80, 20));
      txtListenPort.setText("8822");
      txtListenPort.getDocument().addDocumentListener(this);
      
      panel = new JPanel();
      panel_top.add(panel);
      txtListenPort.getDocument().putProperty("owner", txtListenPort);
      panel_top.add(txtListenPort);
      
      frame.getContentPane().add(panel_top, BorderLayout.NORTH);

      // chat display
      chatPanel = new JTextPane();
      chatPanel.setEditable(false);
      
      // middle panel //
      panel_middle = new JScrollPane(chatPanel);
      panel_middle.setVerticalScrollBarPolicy(
         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      panel_middle.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      panel_middle.setPreferredSize(new Dimension(250, 145));
      panel_middle.setMinimumSize(new Dimension(10, 10));
      frame.getContentPane().add(panel_middle, BorderLayout.CENTER);
      
      frame.getContentPane().add(panel_bottom, BorderLayout.SOUTH);
      panel_bottom.setLayout(new BoxLayout(panel_bottom, BoxLayout.X_AXIS));
      
      txtMessage = new JTextField();
      txtMessage.setText("Text here");
      txtMessage.getDocument().addDocumentListener(this);
      
      btnHistory = new JButton("History");
      btnHistory.addActionListener(this);
      panel_bottom.add(btnHistory);
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
   public static void displayMessage(MessageData msg, JTextPane chatPanel) {
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
         
         // files
         int size = msg.getFiles().size();
         if (size > 0) {
            StyleConstants.setBold(keyWord, true);
            //StyleConstants.setAlignment(keyWord, StyleConstants.);
            doc.insertString(doc.getLength(), 
               String.format("%d Attachment%s:\n", size, size > 1 ? "s" : ""), 
               keyWord );
         }
         
         for (FileData fd: msg.getFiles()) {
            chatPanel.setCaretPosition(doc.getLength());
            
            JLabel l=new JLabel(fd.getFileName());
            l.setFont(new Font(chatPanel.getFont().getFamily(), Font.ITALIC, 11));
            l.setForeground(Color.gray);
            l.setCursor(new Cursor(Cursor.HAND_CURSOR));
            l.setIcon(fd.getIcon());
            l.putClientProperty("FileDataObj", fd);
            l.addMouseListener(new MouseAdapter(){
               public void mouseClicked(MouseEvent me) {
                  JLabel lb = (JLabel)me.getSource();
                  FileData file = (FileData)lb.getClientProperty("FileDataObj");
                  try {
               Desktop.getDesktop().open(new File(file.getFileDir()));
              } catch (IOException e) { }
               }
            });
            chatPanel.insertComponent(l);
            doc.insertString(doc.getLength(), "\n", keyWord );
         }
         doc.insertString(doc.getLength(), "\n", keyWord );
      }
      catch(Exception e) { System.out.println(e); }
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
         game = new GameView(this);
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
 * @throws IOException 
    */
   private void saveMessage(MessageData msg) {
      history.addToArrayList(msg);
      try {
      Logger.saveInformationToDisk(history);
   } catch (IOException e) {
      // TODO Auto-generated catch block
      System.out.println("error saving message");
      e.printStackTrace();
   }
   }
   
   /**
    * method to send current message to destination
    */
   private void sendMessage() {
      String receiver_ip = textField_IPAddress.getText();
      int port = Integer.parseInt(txtSendPort.getText());
      
      currentMsg.setSenderIP(getMyIP());
      currentMsg.setMessage(txtMessage.getText());
      currentMsg.setMessageType(MessageType.Sending);
      currentMsg.updateMsgTime();
      msgStore.add(currentMsg);
      
      displayMessage(currentMsg, chatPanel);
      saveMessage(currentMsg);
      //System.out.println(currentMsg);
      
      MessageData copyMsg = (MessageData)currentMsg.clone();
      copyMsg.setMessageType(MessageType.Incoming);
      //System.out.println(copyMsg);
      
      MessageSender sender = new MessageSender(receiver_ip ,port, copyMsg);
      (new Thread(sender)).start();

      txtMessage.setText("");
      currentMsg = new MessageData();
      
      triggerGame();
   }
   
   /**
    * method used by game to send game specific information
    * @param x
    * @param y
    */
   public void sendGameMessage(int x, int y) {
      System.out.println("Game coordinates ready for sent:" + x + y);
      String receiver_ip = textField_IPAddress.getText();
      int port = Integer.parseInt(txtSendPort.getText());
      
      MessageData gmsg = 
         new MessageData(getMyIP(), String.format("%d,%d", x, y));
      gmsg.setMessageType(MessageType.GAME);
      gmsg.updateMsgTime();
      
      MessageSender sender = new MessageSender(receiver_ip ,port, gmsg);
      (new Thread(sender)).start();
   }

   /**
    * method to attach a file to current message
    */
   private void attachFile() {
      File[] files = FileChooser.show();
      if (files != null) {
         for (File f: files) {
            currentMsg.AttachFile(f.getAbsolutePath());
         }
      }
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
   
   private void saveAttachment(MessageData e) {
      for(FileData fd : e.getFiles()) {
         String home = System.getProperty("user.home");
         home = home+"\\Downloads\\" + fd.getFileName();
         fd.writeTo(home);
         fd.setFilePath(home);
      }
   }
   
   /**
    * 
    */
   private void showHistory() {
      try {
         CalendarOverview overview = new CalendarOverview(history);
      } catch (Exception e) {
         System.out.println("could not read the file");
         e.printStackTrace();
      }	
   }
   
   private void processGameMessage(MessageData d) {
      if (game == null)
         return;
      int x, y;
      String[] cord = d.getMessage().split(",");
      x = Integer.parseInt(cord[0]);
      y = Integer.parseInt(cord[1]);

     System.out.println("Coordinate received:" + x + y);
     game.setCoordinate(x,y);
   
     
   }
 
   /**
    * event handler to display incoming message
    */
   @Override
   public void processMessage(MessageData e) {
      if (e.getMessageType() == MessageType.GAME) {
         processGameMessage(e);
      } else {
         msgStore.add(e);
         saveMessage(e);
         saveAttachment(e);
         ChatView.displayMessage(e, chatPanel);
         triggerGame();
      }
   }
   
   /**
    * event handler for all button clicks
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btnConnect) { }
      else if (e.getSource() == btnSendMsg) { sendMessage(); }
      else if (e.getSource() == btnSelectFile) { attachFile(); }
      else if (e.getSource() == btnHistory) { showHistory(); }
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
   
   private String getMyIP() {
      InetAddress IP;
      try {
         IP = InetAddress.getLocalHost();
         return IP.getHostAddress();
      } catch (UnknownHostException e) {}
      return "error";
   }
}