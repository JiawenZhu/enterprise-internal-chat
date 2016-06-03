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
	
	
	static JFrame frame;
	JFrame CalFrame;
	static ComboBox x;
	static JPanel calendar;
	static ArrayList<CalendarOverview_calendar> AnnualCalendar;

	public CalendarOverview(){
        
		AnnualCalendar= new ArrayList<CalendarOverview_calendar>();
		this.CalFrame= new JFrame("Calendar");
		CalFrame.setBackground(Color.WHITE);
		CalFrame.setLayout(new BorderLayout());
		// get a box Panel 
		x= new ComboBox();  
		CalFrame.add(x,BorderLayout.NORTH);
		// set annual calendar
		initializeAnnualCalendar();
		setCalendar(CalFrame);
		
	}
	
	/**
	 * create all the calendar Panels for the years 
	 */
	private void initializeAnnualCalendar(){
		
		for(int i=0; i<101; i++){
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
	static void setCalendar(JFrame newFrame){
		JFrame Alternative = newFrame; 
		
		int i=0;
		while(i<AnnualCalendar.size()){
			CalendarOverview_calendar current =AnnualCalendar.get(i);
			
			if(Integer.parseInt(x.year)==current.getYear()){
		    Alternative.add(calendar,BorderLayout.CENTER);
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
