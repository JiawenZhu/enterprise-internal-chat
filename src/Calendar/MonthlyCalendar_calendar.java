package Calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Chat.MessageData;
import Chat.MessageList;

/**
 * this is the calendarPart, each day will store conversation history,
 * which is text file, and when user clicks the day label, the file list will appear.
 *
 * @author Shuai_Huang
 *
 */

public class MonthlyCalendar_calendar extends JPanel {
	int monthInt;
	int year;

	
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
		
		
		 //this method will add the events 
		 
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
	 * @param firstDay
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
 * @param daysInMonth
 * @param firstDay
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
 * @param days
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
			dayPanel.addMouseListener(new OpenFile(messageForDay));
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
	 * @param dayPanel
	 * @param day
	 * @param messageForDay
	 */
	void addFile(JPanel dayPanel, int day, ArrayList<MessageData> messageForDay){
	// this ArrayList is from the MessageList class and stores 
    // all the events and not categorized
		
		ArrayList<MessageData> message = CalendarOverview.history;
	for (int i=0; i<message.size(); i++){
		
		MessageData currentMessage= message.get(i);
		Date currentDate=currentMessage.getDateTime();
		int month=currentDate.getMonth();
		int year = currentDate.getYear();
		int dayNum= currentDate.getDay();
		
		if(month==monthInt && (year+1900)==this.year && dayNum==day){
			System.out.println("month: "+Month.of(month+1).name()+ " year: "+(year+1900)+ " day: "+ dayNum);
			dayPanel.add(new JLabel(currentMessage.getSenderIP()+""));
			messageForDay.add(currentMessage);
			
		}	
		
	}
		
	}
	
/**
 * open
 * @author shuai9532
 *
 */
	class OpenFile implements MouseListener {
		ArrayList<MessageData> messageCollection;
		
		OpenFile(ArrayList<MessageData> collection ){
			this.messageCollection = collection;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		MessageWindow messageList = new MessageWindow(messageCollection);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
			
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
