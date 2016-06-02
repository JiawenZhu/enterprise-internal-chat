package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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

	public CalendarOverview(){

		this.CalFrame= new JFrame("Calendar");
		CalFrame.setBackground(Color.WHITE);
		CalFrame.setLayout(new BorderLayout());
		// get a box Panel 
		x= new ComboBox();  
		CalFrame.add(x,BorderLayout.NORTH);
		// set annual calendar
		setCalendar(CalFrame);
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
		//make sure that each calendar is set on different JFrame
		//and that is why I used the Alternative to represent different JFrame

		// if no year is chosen, then currentYear Panel is null
		// then, there will be a nullPointerException

		// if there is a year chosen, then the according calendar 
		//will be created and added to the JFrame.
		try{ 
			JFrame Alternative = newFrame;  
			Alternative.add(x.getCalendarPanel(), BorderLayout.CENTER);
			Alternative.add(new JPanel(), BorderLayout.SOUTH); 
			Alternative.setSize(800, 700);
			Alternative.setResizable(false);
			Alternative.setVisible(true);       
			frame= Alternative;
		}	

		// there is a nullPointer, 
		//then we set CurrentYear to the default value
		catch (Exception e){
			JFrame Alternative = newFrame; 
			Alternative.add(new CalendarOverview_calendar(2016),BorderLayout.CENTER);
			Alternative.add(new JPanel(), BorderLayout.SOUTH); 
			Alternative.setSize(800, 700);
			Alternative.setResizable(false);
			Alternative.setVisible(true); 
			frame= Alternative;
		}

	}
}
