package View;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class CalendarOverview_calendar extends JPanel {

	
	
	CalendarOverview_calendar(){
		this.setSize(new Dimension(750, 650));
		this.setLocation(20, 20);
		GridLayout layout=new GridLayout(4,3);
		layout.setHgap(30);
        layout.setVgap(30);
       this.setLayout(layout);
		
		 String[] months = {"January", "February", "March","April","May","June","July", "August",
					"September", "October", "November","December"};
			     for(int i=0; i< months.length; i++){
			    	 //PrivateCalendar passFrame = new PrivateCalendar(calendar);
			         this.add(new AnnualSingleCalendar(months[i]));	
			         }		
		
		
	}
	
	
	
	
}
