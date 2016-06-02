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

		int[] months = {Calendar.JANUARY, Calendar.FEBRUARY, Calendar.MARCH, 
				Calendar.APRIL, Calendar.MAY, Calendar.JUNE, Calendar.JULY, 
				Calendar.AUGUST, Calendar.SEPTEMBER, Calendar.OCTOBER, 
				Calendar.NOVEMBER, Calendar.DECEMBER };
		for(int i=0; i< months.length; i++){
			//PrivateCalendar passFrame = new PrivateCalendar(calendar);

			System.out.println(months[i]);
			System.out.println(months[2]);
			String stringMonth= Month.of(months[i]+1).name();
			this.add(new AnnualSingleCalendar(months[i], year));	
		}		 

	}

	
	
	
}
