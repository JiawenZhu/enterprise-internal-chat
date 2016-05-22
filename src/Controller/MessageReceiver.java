package Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import Model.MessageData;

interface MessageListener {
    public void processMessage(MessageData e);
}

public class MessageReceiver implements Runnable {
	private ServerSocket server;
	private int port;
    ArrayList<MessageListener> listeners = new ArrayList<MessageListener>();
    
    /**
     * 1-parameter constructor
     * @param port        the port number for receiving message
     */
	public MessageReceiver(int port) {
		this.port = port;
        try {
            server = new ServerSocket(port);
        } catch (Exception ex) {
        	
        }
	}
	
	@Override
	public void run() {
		Socket clientSocket;
		MessageData message = null;
        try {
            while((clientSocket = server.accept()) != null){
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                
                // deserialize bytes to MessageData object
                
                
                // trigger message receive event
                processMessage(message);
            }
        } catch (Exception ex) {
        	
        }
	}
	
	/**
	 * method to add event handler for message listener
	 * @param toAdd            event handler
	 */
    public void addMessageListener(MessageListener toAdd){ 
    	listeners.add(toAdd); 
    }
    
    /**
     * method to 
     */
	private void processMessage(MessageData e) {
		for (MessageListener hl : listeners) hl.processMessage(e);
	}
}
