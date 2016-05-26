package View;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalendarOverview {
static JFrame frame;
	public CalendarOverview(){
		JFrame CalFrame= new JFrame("Calendar");
        CalFrame.setLayout(null);
		JPanel background= new JPanel();
		background.setSize(new Dimension(750, 650));
		background.setLocation(20, 20);
		GridLayout layout=new GridLayout(4,3);
		layout.setHgap(30);
        layout.setVgap(30);
        background.setLayout(layout);
		
		 String[] months = {"January", "February", "March","April","May","June","July", "August",
					"September", "October", "November","December"};
			     for(int i=0; i< months.length; i++){
			    	 //PrivateCalendar passFrame = new PrivateCalendar(calendar);
			         background.add(new PrivateCalendar(months[i]));	
			         }		
		CalFrame.add(background);
		CalFrame.setSize(800, 700);
		CalFrame.setResizable(false);
		CalFrame.setVisible(true);
		
		frame=CalFrame;
	}
	public static void hideWindow(){
		frame.setVisible(false);
	}
	public static void ShowWindow(){
		frame.setVisible(true);
	}

}
