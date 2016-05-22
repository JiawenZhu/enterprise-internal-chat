package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageData implements Serializable {
   private static final long serialVersionUID = 1L;
   private String sender_ip;
   private String message;
   private ArrayList<FileData> files;
   
   public String getSenderIP() {return sender_ip;}
   public String getMessage() {return message;}
   public ArrayList<FileData> getFiles() {return files;}
   
   /**
    * 2-parameter constructor
    * @param sender        sender ip address
    * @param msg           message body
    */
   public MessageData(String sender, String msg) {
      this.sender_ip = sender;
      this.message = msg;
      files = new ArrayList<FileData>();
   }
   
   /**
    * method to add file to this message
    * @param path          file location
    */
   public void AttachFile(String path) {
      files.add(new FileData(path));
   }
}
