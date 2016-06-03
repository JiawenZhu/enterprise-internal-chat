package Controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import Model.MessageData;

/**
 * class to receive message
 * @author Sean
 *
 */
public class MessageReceiver implements Runnable {
   private ServerSocket server;
   private int port;
   ArrayList<MessageListener> listeners = new ArrayList<MessageListener>();
    
   /**
    * 1-parameter constructor
    * @param port        the port number for receiving message
    */
   public MessageReceiver(int port) {
      this.port = port;
      startServer();
   }
   
   @Override
   public void run() {
      Socket clientSocket;
      MessageData message = null;
        try {
            while((clientSocket = server.accept()) != null){
               // read data and convert it to byte array
                InputStream is = clientSocket.getInputStream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] data = new byte[16384];
                while ((nRead = is.read(data, 0, data.length)) != -1) {
                   buffer.write(data, 0, nRead);
                }
                buffer.flush();

                // convert to message
                message = decodeMessage(buffer.toByteArray());
                if (message != null)
                   processMessage(message);
            }
        } catch (Exception ex) {
           
        }
   }
   
   /**
    * method to add event handler for message listener
    * @param toAdd            event handler
    */
   public void addMessageListener(MessageListener toAdd){ 
      listeners.add(toAdd); 
   }
    
   /**
    * method to raise event when receive message
    */
   private void processMessage(MessageData e) {
      for (MessageListener hl : listeners) hl.processMessage(e);
   }
   
   /**
    * method to convert byte array to message object
    * @param data         byte array
    * @return             message data object
    */
   private MessageData decodeMessage(byte[] data) {
      ByteArrayInputStream bis = new ByteArrayInputStream(data);
      ObjectInput in = null;
      MessageData message = null;
      
      try {
        in = new ObjectInputStream(bis);
        Object o = in.readObject(); 
        if (o instanceof MessageData)
           message = (MessageData)o;
      }
      catch (Exception ex) {
      
      }
      finally {
        try {
          bis.close();
        } catch (IOException ex) {
          // ignore close exception
        }
        try {
          if (in != null) {
            in.close();
          }
        } catch (IOException ex) {
          // ignore close exception
        }
      }
      return message;
   }

   private void startServer() {
      try {
         if (server != null)
            server.close();
         
         server = new ServerSocket(port);
      } catch (Exception ex) { }
   }
   
   public void UpdateListeningPort(int port) {
      this.port = port;
      startServer();
   }
}
