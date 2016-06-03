package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
import Model.Utility.*;

public class MessageData implements Serializable {
   private static final long serialVersionUID = 1L;
   private String sender_ip;
   private String message;
   private ArrayList<FileData> files;
   private MessageType msg_type;
   private Date date;
   
   public String getSenderIP() {return sender_ip;}
   public String getMessage() {return message;}
   public ArrayList<FileData> getFiles() {return files;}
   public boolean isGameMessage() { return msg_type == MessageType.GAME; }
   public void setMessageType(MessageType t) { msg_type = t;}
   public Date getDateTime() {return date;}
   
   /**
    * 2-parameter constructor
    * @param sender        sender IP address
    * @param msg           message body
    */
   public MessageData(String sender, String msg) {
      this.sender_ip = sender;
      this.message = msg;
      files = new ArrayList<FileData>();
      msg_type = MessageType.REGULAR;
      date = getCurrentTime();
   }
   
   /**
    * method to add file to this message
    * @param path          file location
    */
   public void AttachFile(String path) {
      files.add(new FileData(path));
   }
   
   /**
    * method to get current time
    * @return              current time
    */
   private Date getCurrentTime() {
	   Calendar cal = Calendar.getInstance();
	   return cal.getTime();
   }
   
   public String toString() {
	   return "[" + date + "][" + sender_ip + "]: " + message;
   }
}
