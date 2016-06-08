package Calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
 * @author shuai9532
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

	void setDayName(){

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

	private void setDaysAndAddFiles(int days){
		int i=0;
		while(i<days){
			
			
			JPanel dayPanel= new JPanel();
			dayPanel.addMouseListener(new OpenFile());
			JLabel label= new JLabel(i+1+"");
			dayPanel.add(label);
			//add file and present it on the panel
			
			// days start with 1 ?
			addFile(dayPanel, i+1);
			
			
			
			dayPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
			dayPanel.setBackground(Color.white);
			label.setBackground(Color.WHITE);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			this.add(dayPanel);
			i++;
		}

	}
	void addFile(JPanel dayPanel, int day){
	ArrayList<MessageData> message = CalendarOverview.history;
	for (int i=0; i<message.size(); i++){
		
		MessageData currentMessage= message.get(i);
		Date currentDate=currentMessage.getDateTime();
		int month=currentDate.getMonth();
		int year = currentDate.getYear();
		int dayNum= currentDate.getDay();
		
		if(month==monthInt && year==this.year && dayNum== day){
			
			dayPanel.add(new JLabel(currentMessage.getSenderIP()+""));
		}
		
		
	}
		
	}
	
	
	
	
	
	
	

	class OpenFile implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

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
