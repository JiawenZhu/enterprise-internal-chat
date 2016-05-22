package Controller;

import java.util.ArrayList;
import Model.MessageData;

/**
 * Class to save and load past messages
 * @author Sean
 *
 */
public class Logger {
	public static String LOG_PATH = "LOG.txt";
	
	public static void saveLog() {
		
	}
	
	/**
	 * method to load history messages
	 * @return        a list of message
	 */
	public static ArrayList<MessageData> requestLog() {
		ArrayList<MessageData> list = new ArrayList<MessageData>();
		
		// testing data
		MessageData msg = new MessageData("192.178.1.2", "Hello, how are you?");
		list.add(msg);
		
		msg = new MessageData("192.168.1.245", "Here is the file you asked.");
		msg.AttachFile("TextFile.txt");
		list.add(msg);
		
		msg = new MessageData("203.1.23.45","This is bullshit!!!");
		list.add(msg);
		
		msg = new MessageData("40.30.22.234","Nice flowers!");
		msg.AttachFile("ImageFile.jpg");
		list.add(msg);
		return list;
	}
}
