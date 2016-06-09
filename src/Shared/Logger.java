package Shared;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Chat.MessageData;
import Chat.MessageList;

import java.io.Serializable;

/**
 * Class to save and load past messages
 * @author Sean, Jiawen
 *
 */
public class Logger implements Serializable{
	/**
	 * create a default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	public static String LOG_PATH = "LOG.txt";
	final static String FILENAME = "LOG.ser";

	
	public static void saveLog(ArrayList<MessageData> data) {
		data = new ArrayList<MessageData>();
		
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
		
	   msg = new MessageData("localhost","shit!");
	   list.add(msg);
	      
		msg = new MessageData("40.30.22.234","Nice flowers!");
		msg.AttachFile("ImageFile.jpg");
		list.add(msg);
		return list;
	}
	/**
	 * Saves information to the disk.
	 * 
	 * @author Jiawen
	 */
	public void saveInformationToDisk(MessageList list)
			throws IOException {
		FileOutputStream fout = new FileOutputStream(FILENAME);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(list);
		oos.close();
	}

	/**
	 * Loads information to the disk.
	 * 
	 * @author Jiawen
	 */
	public MessageData loadDataOnDisk() throws Exception {
		FileInputStream finput = new FileInputStream(FILENAME);
		ObjectInputStream oinput = new ObjectInputStream(finput);
		MessageData result = (MessageData) oinput.readObject();
		oinput.close();
		return result;
	}

}
