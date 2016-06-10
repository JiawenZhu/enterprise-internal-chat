package Chat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Shared.Utility;
import Shared.Utility.*;

public class MessageData implements Serializable, Cloneable{
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
   public void setMessage(String msg) { message = msg;}
   public void setSenderIP(String ip) {sender_ip = ip;}
   public Date getDateTime() {return date;}
   public MessageType getMessageType() { return msg_type;}
   
   /**
    * default constructor
    */
   public MessageData() {
      sender_ip = "";
      message = "";
      files = new ArrayList<FileData>();
      msg_type = MessageType.Incoming;
   }
   
   /**
    * 2-parameter constructor
    * @param sender        sender IP address
    * @param msg           message body
    */
   public MessageData(String sender, String msg) {
      this.sender_ip = sender;
      this.message = msg;
      files = new ArrayList<FileData>();
      msg_type = MessageType.Incoming;
      date = getCurrentTime();
   }
   
   /**
    * method to add file to this message
    * @param path          file location
    */
   public void AttachFile(String path) {
      files.add(new FileData(path));
   }
   
   public void AttachFile(FileData fd) {
      files.add(fd);
   }
   
   /**
    * method to get current time
    * @return              current time
    */
   private Date getCurrentTime() {
      Calendar cal = Calendar.getInstance();
      return cal.getTime();
   }
   
   public void updateMsgTime() {
      date = getCurrentTime();
   }
   
   public String getTime() {
         return new SimpleDateFormat("HH:mm:ss").format(date);
   }
   
   public String toString() {
      return "[" + date + "][" + sender_ip + "]";
   }

   public Object clone() {
      MessageData newMsg = new MessageData(sender_ip, message);
      newMsg.date = this.date;
      newMsg.msg_type = this.msg_type;
      for(FileData d: files) {
         newMsg.files.add((FileData)d.clone());
      }
      return newMsg;
   }
}
