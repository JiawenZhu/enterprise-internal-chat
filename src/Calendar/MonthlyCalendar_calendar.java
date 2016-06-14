package Calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import Chat.MessageData;
import Chat.MessageList;

/**
 * there are two parts: calendar and history
 * this is the calendarPart of the monthly Calendar,
 * each day will store conversation history,
 * and when user clicks the day label, the history will appear.
 * @author Shuai_Huang
 *
 */

public class MonthlyCalendar_calendar extends JPanel {
	private int monthInt;
	private int year;

	public MonthlyCalendar_calendar(int monthInt, int year){
		this.monthInt= monthInt;
		this.year=year;

		this.setBackground(Color.WHITE);
		GridLayout grid = new GridLayout(7, 7);
		this.setLayout(grid);
		this.setSize(350, 350);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Calendar newCalendar= new GregorianCalendar(year,monthInt,1);

		int DaysInMonth= newCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeekOfFirstDay= newCalendar.get(Calendar.DAY_OF_WEEK);
		setDayName();   	
		setTheFirstDay(dayOfWeekOfFirstDay);
		//this method will add history 
		setDaysAndAddFiles(DaysInMonth);
		fillInTheRest(DaysInMonth,dayOfWeekOfFirstDay);
	}
	
	/**
	 * set name "M","T"....
	 */
	private void setDayName(){
		String[] day= new String[]{"S","M","T", "W", "T", "F", "S"};
		//set Name of a week
		for (int i=0; i<7;i++){
			JPanel weekPanel= new JPanel();
			JLabel label= new JLabel(day[i]);
			weekPanel.add(label);
			weekPanel.setBackground(Color.WHITE);
			label.setBackground(Color.WHITE);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			this.add(weekPanel);
		}
	}

	/**
	 * find the first day for this month
	 * @param firstDay  the numerical representation of the day in a week
	 */
	private void setTheFirstDay(int firstDay){
		// set the first day
		for(int i=1; i<firstDay; i++){
			JPanel dayPanel= new JPanel();
			dayPanel.setBackground(Color.WHITE);
			dayPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
			JLabel label= new JLabel(" ");
			dayPanel.add(label);
			label.setBackground(Color.WHITE);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			this.add(dayPanel);
		}
	}

	/**
     if there some boxes left, fill it with empty text
	 * @param daysInMonth    days in one month
	 * @param firstDay       the numerical representation of the day in a week
	 */
	private	void fillInTheRest(int daysInMonth, int firstDay){
		int count= 7+firstDay-1+daysInMonth;
		while(count<49){
			JPanel dayPanel= new JPanel();
			dayPanel.setBackground(Color.WHITE);
			dayPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
			JLabel label= new JLabel(" ");
			dayPanel.add(label);
			label.setOpaque(isOpaque());
			label.setBackground(Color.white);
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			this.add(dayPanel);
			count++;
		}
	}

	/**
	 * populate the days and find days where files are needed to add
	 * @param days   number of days
	 */
	private void setDaysAndAddFiles(int days){
		int i=0;

		while(i<days){
			ArrayList<MessageData> messageForDay = new ArrayList<MessageData>();
			JPanel dayPanel= new JPanel();
			JLabel label= new JLabel(i+1+"");
			dayPanel.add(label);
			//add file and present it on the panel
			//the ArrayList is for this particular day
			addFile(dayPanel, i+1, messageForDay);
			//dayPanel.addMouseListener(new OpenFile(messageForDay));
			dayPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
			dayPanel.setBackground(Color.white);
			label.setBackground(Color.WHITE);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			this.add(dayPanel);
			i++;
		}
	}

	/**
	 * add files to the specific day and store 
	 *those files if the same day in the same ArrayList.
	 * @param dayPanel    the panel where day rests 
	 * @param day       one day
	 * @param messageForDay     collection of the messages that happened in one day
	 */
	private void addFile(JPanel dayPanel, int day, ArrayList<MessageData> messageForDay){

		// this ArrayList is from the MessageList class and stores 
		// all the history and not categorized by time
		ArrayList<MessageData> message = CalendarOverview.history;

		int count=0;
		for (int i=0; i<message.size(); i++){
			MessageData currentMessage= message.get(i);
			Date currentDate=currentMessage.getDateTime();
			int month=currentDate.getMonth();
			int year = currentDate.getYear();
			int dayNum= currentDate.getDay();

			if(month==monthInt && (year+1900)==this.year && dayNum==day){
				count++;
				//categorize the history to the day
				messageForDay.add(currentMessage);	
			}		
		}
		//set notification on the day panel if there is a chat
		if(count!=0){
			JLabel label = new JLabel(count+" messages");
			label.setFont(new Font(null, Font.BOLD, 9));
			dayPanel.add(label);
			dayPanel.addMouseListener(new OpenFile(messageForDay));
		}
	}
	/**
	 * open the history
	 * @author shuai9532
	 *
	 */
	class OpenFile implements MouseListener {

		private ArrayList<MessageData> messageCollection;

		OpenFile(ArrayList<MessageData> collection ){
			this.messageCollection = collection;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			JFrame frame = new JFrame("Conversation History");
			JTextPane chatPanel = new JTextPane();

			for(MessageData data:messageCollection){
				Chat.ChatView.displayMessage(data, chatPanel);
			}	

			frame.add(chatPanel);
			frame.setSize(500, 500);
			frame.setVisible(true);
		}

		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}

}
