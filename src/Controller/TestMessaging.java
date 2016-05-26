package Controller;

import Model.MessageData;

public class TestMessaging {
	public static void main(String[] args) {
		MessageData msg = new MessageData("localhost", "test message");
		//.AttachFile("ImageFile.jpg");
		//msg.AttachFile("TextFile.txt");
		
		MessageSender sender = new MessageSender("localhost", 8823, msg);
		(new Thread(sender)).start();
	}
}
