package Chat;

import java.io.*;

/**
 * Class to store file data
 * @author Sean
 *
 */
public class FileData implements Serializable, Cloneable{
   private static final long serialVersionUID = 1L;
   private String file_name;
   private String file_path;
   private byte[] fileData;
   
   public String getFileName() { return file_name; }
   public String getFilePath() { return file_path; }
   public void setFilePath(String path) { file_path = path; }
   
   /**
    * default constructor
    */
   public FileData() {
      
   }
   
   /**
    * 1-parameter constructor
    * @param path
    */
   public FileData(String path) {
      FileInputStream fis = null;
      BufferedInputStream bis = null;
      this.file_path = path;
      
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
   
   /**
    * method to save file to specific location
    * @param path          full path of destination
    * @return              true if success
    */
   public boolean SaveTo(String path) {
      try {
         FileOutputStream fos = new FileOutputStream(path);
         fos.write(fileData);
         fos.close();
         return true;
      }
      catch (Exception ex) {
         return false;
      }
   }
   
   public String getFileDir() {
       File f = new File(file_path);
       return f.getAbsoluteFile().getParentFile().getAbsolutePath();
   }
   
   public void writeTo(String path) {
      try {
         FileOutputStream fos = new FileOutputStream(path);
         fos.write(fileData);
         fos.close();
      } catch (IOException e) { }
   }
   
   public Object clone() {
      FileData newFD = new FileData();
      newFD.file_name = this.file_name;
      newFD.fileData = this.fileData;
      return newFD;
   }
}
