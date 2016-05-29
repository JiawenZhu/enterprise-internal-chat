package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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

       setCalendar(CalFrame);
     
	}
	
	public static void hideWindow(){
		frame.setVisible(false);
	}
	
	public static void ShowWindow(){
		frame.setVisible(true);
	}
	static void setCalendar(JFrame newFrame){
		// if no year is chosen, then currentYear Panel is null
    	// then, there will be a nullPointerException
		try{ 
		JFrame Alternative = newFrame;  
		Alternative.add(x.getCalendarForYear(), BorderLayout.CENTER);
         Alternative.add(new JPanel(), BorderLayout.SOUTH); 
         Alternative.setSize(800, 700);
         Alternative.setResizable(false);
         Alternative.setVisible(true);       
	  frame= Alternative;
		}
		  catch (Exception e){
	    	   // there is a nullPointer, 
	    	   //then we set CurrentYear to the default value
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
