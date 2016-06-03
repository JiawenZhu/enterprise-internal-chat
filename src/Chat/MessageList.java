package Chat;

import java.util.ArrayList;
import java.io.Serializable;

public class MessageList implements Serializable {
	/**
	 * create default sericalVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <MessageData> messageList;
	
	public MessageList(){
		messageList = new ArrayList<MessageData>();
	}
	
	public void addToArrayList(MessageData message){
		messageList.add(message);
	}
	public String toString() {
		String result = "";
		for (MessageData message : messageList) {
			result = result + message + "\n\n";
		}
		return result;
	}

}
