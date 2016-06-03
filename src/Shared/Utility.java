package Shared;

import java.text.DateFormatSymbols;

public class Utility {
	public static String EGG_QUESTION = "1"; //"I solemly swear";
	public static String EGG_ANSWER = "2"; //"that I am up to no good.";
	
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
   
   public static String getMonth(int month) {
       return new DateFormatSymbols().getMonths()[month+1];
    }
}
