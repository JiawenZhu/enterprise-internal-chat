package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.Month;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CalendarOverview_calendar extends JPanel {

	int year;

	CalendarOverview_calendar(int Year){

		this.year= Year;
		this.setLocation(20, 20);
		GridLayout layout=new GridLayout(4,3);
		layout.setHgap(30);
		layout.setVgap(30);
		this.setLayout(layout);

	
		// months in the array range from 0 to 11
		int[] months = {Calendar.JANUARY, Calendar.FEBRUARY, Calendar.MARCH, 
				Calendar.APRIL, Calendar.MAY, Calendar.JUNE, Calendar.JULY, 
				Calendar.AUGUST, Calendar.SEPTEMBER, Calendar.OCTOBER, 
				Calendar.NOVEMBER, Calendar.DECEMBER };
		
		for(int i=0; i< months.length; i++){
			// when convert back to String, int
			//value needs to add 1 because int<0 || int>12 is not valid 
			System.out.println("month"+ months[i]);
			this.add(new AnnualSingleCalendar(months[i], year));	
			 }	
	     }
	
	public int getYear(){
		return year;
	}
}
