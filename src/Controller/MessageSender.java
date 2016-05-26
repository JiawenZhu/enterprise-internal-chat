package Controller;

import java.net.Socket;
import java.io.*;
import Model.*;

/**
 * class to send message to IP address
 * @author Sean
 *
 */
public class MessageSender implements Runnable {
	private String ip_address;
	private int port;
	private MessageData message;
	/**
	 * 2-parameter constructor
	 * @param ip_address        destination IP address
	 * @param port              destination port number
	 */
	public MessageSender(String ip_address, int port, MessageData msg) {
		this.ip_address = ip_address;
		this.port = port;
		this.message = msg;
	}
	
	public void run() {
        try {
        	// serialize the message object to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = null;
            out = new ObjectOutputStream(bos);   
            out.writeObject(message);
            out.close();
            bos.close();
            byte[] yourBytes = bos.toByteArray();
            
            // send the byte array to destination
            Socket s = new Socket(ip_address, port);
            s.getOutputStream().write(yourBytes);
            s.close();
        } catch (Exception ex) {
        	
        }
	}
}
