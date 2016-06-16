package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
 * Thus, each year year is created upon request. This requires program to sort the
 * history for the corresponding time and them to the correct time in the correct year.
 * 
 * @author Shuai_Huang
 *
 */
public class CalendarOverview {
	// basic final frame
	static JFrame CalFrame; 
	static ComboBox x;
    static CalendarOverview_calendar currentCalendar;
	static MessageList history;

	public CalendarOverview(MessageList history){
		
		this.history= history;
		CalFrame = new JFrame("Calendar");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		CalFrame.setLocation(dim.width/6-CalFrame.getSize().width/6, dim.height/6-CalFrame.getSize().height/6);
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
	 * the default year is 2016, so when there is no request,
	 * the calendar for year 2016 is created.
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
	 * hide yearly calendar window when monthly 
	 * calendar is requested to show
	 */
	public static void hideWindow(){
		CalFrame.setVisible(false);
	}

	/**
	 * show yearly window when "back" 
	 * button is pressed
	 */
	public static void ShowWindow(){
		CalFrame.setVisible(true);
	}

}
