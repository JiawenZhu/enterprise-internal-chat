package Controller;

import Model.MessageData;

public class TestMessaging {
	public static void main(String[] args) {
		MessageData msg = new MessageData("localhost", "test message");
		msg.AttachFile("ImageFile.jpg");
		msg.AttachFile("TextFile.txt");
		
		MessageSender sender = new MessageSender("localhost", 8876, msg);
		sender.run();
	}
}
