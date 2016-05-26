package View;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CalendarOverview {
static JFrame frame;
	public CalendarOverview(){
		JFrame CalFrame= new JFrame("Calendar");
        CalFrame.setLayout(null);
        
        // add a list box for different years    
        JRadioButton yearOption= new JRadioButton("Year");

        // changing the Panel when different year is selected.
		CalFrame.add(new CalendarOverview_calendar());
		
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
