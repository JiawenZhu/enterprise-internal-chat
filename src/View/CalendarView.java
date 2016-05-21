package View;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

public class CalendarView {
	
	File event;
	
	public CalendarView(){
		JFrame calendarFrame= new JFrame("Calendar");
		calendarFrame.setLayout(null);
		
		
		JPanel date= new JPanel();
		FlowLayout layout=new FlowLayout(FlowLayout.LEADING, 65, 10);
		
		date.setLayout(layout);
	    date.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		date.add(new JLabel("Sun"));
		date.add(new JLabel("Mon"));
		date.add(new JLabel("Tue"));
		date.add(new JLabel("Wed"));
		date.add(new JLabel("Thu"));
		date.add(new JLabel("Fri"));
		date.add(new JLabel("Sat"));
		
		date.setLocation(0,0);
		date.setSize(700, 40);
		
		JPanel day = new JPanel();
		day.setLayout(new GridLayout(5, 7));
		day.setLocation(0,40);
		day.setSize(700,400);
		day.setBorder(
				 BorderFactory.createLineBorder(Color.black));
		
		
		calendarFrame.add(date);
		
		calendarFrame.add(day);
		calendarFrame.setSize(700, 500);
		calendarFrame.setVisible(true);
		
	}
	
	
	
	
	
 public void getLogData(File eventData){
	event=eventData;
 }

}
