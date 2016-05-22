package Model;

import java.io.*;

public class FileData implements Serializable {
   private static final long serialVersionUID = 1L;
   private String file_name;
   private byte[] fileData;
   
   public String getFileName() { return file_name; }
   
   /**
    * 1-parameter constructor
    * @param path
    */
   public FileData(String path) {
      FileInputStream fis = null;
       BufferedInputStream bis = null;
       
      try {
         File myFile = new File (path);
         fileData  = new byte [(int)myFile.length()];
         fis = new FileInputStream(myFile);
         bis = new BufferedInputStream(fis);
         bis.read(fileData,0,fileData.length);
         bis.close();
         fis.close();
         
         this.file_name = myFile.getName();
      }
      catch (Exception ex) {
         
      }
   }
}
