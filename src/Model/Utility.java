package Model;

public class Utility {
	public static String EGG_QUESTION = "I solemly swear";
	public static String EGG_ANSWER = "that I am up to no good.";
	
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
