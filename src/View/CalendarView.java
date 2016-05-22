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
		GridLayout layout=new GridLayout(1,7);	
		date.setLayout(layout);
		JLabel sun= new JLabel("Sun");
		date.add(sun);
		sun.setHorizontalAlignment(JLabel.RIGHT);
		JLabel mon=new JLabel("Mon");
		date.add(mon);
		mon.setHorizontalAlignment(JLabel.RIGHT);
		JLabel tue=new JLabel("Tue");
		date.add(tue);
		tue.setHorizontalAlignment(JLabel.RIGHT);
		JLabel wed=new JLabel("Wed");
		date.add(wed);
		wed.setHorizontalAlignment(JLabel.RIGHT);
		JLabel thu=new JLabel("Thu");
		date.add(thu);
		thu.setHorizontalAlignment(JLabel.RIGHT);
		JLabel fri=new JLabel("Fri");
		date.add(fri);
		fri.setHorizontalAlignment(JLabel.RIGHT);
		JLabel sat= new JLabel("Sat");
		date.add(sat);
		sat.setHorizontalAlignment(JLabel.RIGHT);
		date.setLocation(0,0);
		date.setSize(650, 40);
		
		JPanel day = new JPanel();
		day.setLayout(new GridLayout(5, 7));
		setBorder(day);
		day.setLocation(20,40);
		day.setSize(650,400);
		day.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		calendarFrame.add(date);
		calendarFrame.add(day);
		calendarFrame.setSize(700, 500);
		calendarFrame.setVisible(true);
		
	}
	
	void setBorder(JPanel p){
		for(int i=0; i<(5*7);i++){
			JLabel day= new JLabel(i+"");
			day.setBorder(BorderFactory.createLineBorder(Color.gray));
			p.add(day);
		}
		
	}
	
	
 public void getLogData(File eventData){
	event=eventData;
 }

}
