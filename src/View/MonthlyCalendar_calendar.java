package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * this is the calendarPart, each day will store conversation history,
 * which is text file, and when user clicks the day label, the file list will appear.
 *
 * @author shuai9532
 *
 */

public class MonthlyCalendar_calendar extends JPanel {

	 public MonthlyCalendar_calendar(int monthInt, int year){
		 
		 this.setBackground(Color.WHITE);
    	 GridLayout grid = new GridLayout(6, 7);
	     this.setLayout(grid);
	     this.setSize(300,300);
	       
	     Calendar newCalendar= new GregorianCalendar(year,monthInt,1);
	     
	     System.out.println(" ")
;	     
	     System.out.println("this is the monthly window ");
	     System.out.println(Month.of(monthInt+1).name());
	    	int DaysInMonth= newCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	    	System.out.println("there are "+ DaysInMonth+ " in this month");
		    int dayOfWeekOfFirstDay= newCalendar.get(Calendar.DAY_OF_WEEK);
		    System.out.println("the first day is"+ dayOfWeekOfFirstDay);
	     String[] day= new String[]{"S","M","T", "W", "T", "F", "S"};
	     
			//set Name of a week
			for (int i=0; i<7;i++){
				JLabel label= new JLabel(day[i]);
				label.setBackground(Color.WHITE);
				label.setForeground(Color.gray);
				label.setOpaque(isOpaque());
				label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
				this.add(label);
			}

			// set the first day
			for(int i=1; i<dayOfWeekOfFirstDay; i++){
				JLabel label= new JLabel(" ");
				label.setBackground(Color.WHITE);
				label.setForeground(Color.gray);
				label.setOpaque(isOpaque());
				label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
				this.add(label);
			}

			// fill in the rest
			int i=0;
			while(i<DaysInMonth){
				JLabel label= new JLabel(i+1+"");
				label.setBackground(Color.WHITE);
				label.setForeground(Color.gray);
				label.setOpaque(isOpaque());
				label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
				this.add(label);
				i++;

			}   
	}
}
