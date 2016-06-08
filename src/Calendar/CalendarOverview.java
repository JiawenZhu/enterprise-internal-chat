package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Chat.MessageData;
import Chat.MessageList;

/**
 * this class creates a CALENDAR where user can choose the year
 * the design:
 * every year is not created beforehand due to the large memory. 
 * Thus, each year year is created upon request. This requires to sort the
 * file for the corresponding time and them to the correct time in the correct year.
 * 
 * @author shuai9532
 *
 */
public class CalendarOverview {
	// basic final frame
	static JFrame CalFrame; 
	static ComboBox x;
	static ArrayList<CalendarOverview_calendar> AnnualCalendar;
	static CalendarOverview_calendar currentCalendar;
	static ArrayList<MessageData> history;

	public CalendarOverview( ArrayList<MessageData> history){
		this.history= history;

		AnnualCalendar= new ArrayList<CalendarOverview_calendar>();
		CalendarOverview.CalFrame = new JFrame("Calendar");
		CalFrame.setBackground(Color.WHITE);
		CalFrame.setLayout(new BorderLayout());
		// get a box Panel 
		x = new ComboBox();  
		CalFrame.add(x,BorderLayout.NORTH);
		currentCalendar=null;
		// set annual calendar
		initializeAnnualCalendar();
	}

	/**
	 * create calendar Panels for the year
	 */
	static void initializeAnnualCalendar(){

		if (currentCalendar!=null){
			CalFrame.remove(currentCalendar);
		}
		currentCalendar= new CalendarOverview_calendar(Integer.parseInt(ComboBox.year));
		CalFrame.add(currentCalendar,BorderLayout.CENTER);
		CalFrame.add(new JPanel(), BorderLayout.SOUTH); 
		CalFrame.setSize(800, 700);
		CalFrame.setResizable(false);
		CalFrame.setVisible(true); 
	}

	/**
	 * hide the window when monthly 
	 * calendar is requested to show
	 */
	public static void hideWindow(){
		CalFrame.setVisible(false);
	}

	/**
	 * show window when "back" 
	 * button is pressed
	 */
	public static void ShowWindow(){
		CalFrame.setVisible(true);
	}

}
