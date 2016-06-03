package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * this class creates a CALENDAR where user can choose the year
 * @author shuai9532
 *
 */
public class CalendarOverview {
	// frame for each year with changing calendar
	static JFrame frame; 
	// basic final frame
	static JFrame CalFrame; 
	static ComboBox x;
	static ArrayList<CalendarOverview_calendar> AnnualCalendar;

	public CalendarOverview(){
        
		// right now, there will be only three years here for testing
		AnnualCalendar= new ArrayList<CalendarOverview_calendar>(3);
		CalendarOverview.CalFrame = new JFrame("Calendar");
		CalFrame.setBackground(Color.WHITE);
		CalFrame.setLayout(new BorderLayout());
		// get a box Panel 
		x = new ComboBox();  
		CalFrame.add(x,BorderLayout.NORTH);
		// set annual calendar
		initializeAnnualCalendar();
		setCalendar();
		
	}
	
	/**
	 * create all the calendar Panels for the years 
	 */
	private void initializeAnnualCalendar(){
		
		// three years for test
		for(int i=0; i<3; i++){
			AnnualCalendar.add(new CalendarOverview_calendar(2016+i));
		}
	}
	
	/**
	 * hide the window when monthly 
	 * calendar is requested to show
	 */
	public static void hideWindow(){
		frame.setVisible(false);
	}
	/**
	 * show window when "back" 
	 * button is pressed
	 */
	public static void ShowWindow(){
		frame.setVisible(true);
	}

	/**
	 * set annual calendar panel to the frame
	 * @param newFrame
	 */
	static void setCalendar(){
		//close the frame that contains previous months of the year
	//	frame.setVisible(false);
		
		// new Calendar starts here
		JFrame Alternative = CalFrame; 
		int i=0;
		while(i<AnnualCalendar.size()){
			CalendarOverview_calendar current =AnnualCalendar.get(i);

			if(Integer.parseInt(ComboBox.year) == current.getYear()){
				Alternative.add(current,BorderLayout.CENTER);
				Alternative.add(new JPanel(), BorderLayout.SOUTH); 
				Alternative.setSize(800, 700);
				Alternative.setResizable(false);
				Alternative.setVisible(true); 
				frame= Alternative;
				break;
			}
			i++;
		}	
	}			
}
