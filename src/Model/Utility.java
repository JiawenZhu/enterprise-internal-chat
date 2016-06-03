package Model;

public class Utility {
	public static int SUCCESS = 0;
	public static int SEND_TEXT_ERROR = 101;
	public static int SEND_FILE_ERROR = 102;
	
	public enum MessageType {
		Incoming,
		Sending,
		GAME
	}

   public static boolean isNumeric(String s) {
      try { 
         Integer.parseInt(s); 
      } catch(NumberFormatException e) { 
        return false; 
      } catch(NullPointerException e) {
        return false;
      }
      // only got here if we didn't return false
      return true;
   }
}
