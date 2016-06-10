package Calendar;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Chat.MessageData;
import javax.swing.JTextPane;
import java.awt.BorderLayout;


public class MessageWindow {

	private ArrayList<MessageData>MessageList;
	JPanel details;
	
	MessageWindow (ArrayList<MessageData> receivedData) {
		this.MessageList= receivedData;
		
		
	JFrame history = new JFrame("History Display");
	history.getContentPane().setLayout(new GridLayout(1,2));
	
	JPanel displayList = new JPanel();
	addList(displayList);
	history.getContentPane().add(displayList);
	
	details = new JPanel();
	history.getContentPane().add(details);
	details.setLayout(new BorderLayout(0, 0));

	history.setVisible(true);
	history.setSize(600, 600);
	history.setResizable(false);
	
	}
	
	private void addList(JPanel listPanel){
		
		DefaultListModel<MessageData> model = new DefaultListModel<MessageData>();
		// add IP address to the list 
		for (MessageData data: MessageList){
		model.addElement(data);
		}
		JList<MessageData> list = new JList<MessageData>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(10);
		
		list.addListSelectionListener(new IPAddressSelection(list, details));
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(200,600));
		listPanel.add(listScroller);

	}
	
	class IPAddressSelection implements ListSelectionListener{
		JList<MessageData> list;
		JPanel detail;
		JScrollPane scroller;
		
		IPAddressSelection(JList<MessageData> list, JPanel details){
			this.list = list;
			this.detail = details;	
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			// add TextPane to the details 
			JTextPane current= new JTextPane();
			current.setEditable(false);
			MessageData selected = list.getSelectedValue();
		    current.setText(selected.getMessage());
		    scroller =new JScrollPane(current);
		    detail.add(scroller);
					
			}
			//add the content to the right panel	
		}

}
