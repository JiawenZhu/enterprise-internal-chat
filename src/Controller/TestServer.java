package Controller;

import Model.MessageData;

public class TestServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageReceiver receiver  = new MessageReceiver(8876);
		receiver.addMessageListener(
			new MessageListener() {
				@Override
				public void processMessage(MessageData e) {
					System.out.println(e.getMessage() + ", " + e.getFiles().size());
				} 
		    }
		);		
		receiver.run();
	}
}
