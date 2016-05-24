package View;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
		
		JPanel buttons = new JPanel();
		SpringLayout spring = new SpringLayout();
		buttons.setLayout(spring);
		buttons.setLocation(0,0);
		buttons.setSize(650, 40);
		JButton previous= new JButton("previous");
	    buttons.add(previous);
		JButton next = new JButton("next");
	
		next.addActionListener(new nextActionListener());
		
		
		
		buttons.add(next);
		spring.putConstraint(SpringLayout.WEST,previous,5,SpringLayout.WEST, buttons);
		spring.putConstraint(SpringLayout.NORTH,previous,15,SpringLayout.NORTH, buttons);
		spring.putConstraint(SpringLayout.EAST,next,5,SpringLayout.EAST, buttons);
		spring.putConstraint(SpringLayout.NORTH,next,15,SpringLayout.NORTH, buttons);
		calendarFrame.add(buttons);
	
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
		date.setLocation(20,40);
		date.setSize(650, 40);
		
		JPanel day = new JPanel();
		day.setLayout(new GridLayout(5, 7));
		setBorder(day);
		day.setLocation(20,80);
		day.setSize(650,400);
		day.setBorder(BorderFactory.createLineBorder(Color.black));
		
		calendarFrame.add(date);
		calendarFrame.add(day);
		calendarFrame.setSize(700, 600);
		calendarFrame.setResizable(false);
		calendarFrame.setVisible(true);	
	}
	
	
void makeCalendar(){
	
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
 
 class nextActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// repaint the calendar and add to the calendarList
		if(next==null){
		CalendarView nextCalendar = new CalendarView();
		CalendarAgent.addToTheList(nextCalendar);}
		else{
			getNext();
		}
		
		
		// this shoudld be calendar.getNext();

	}
	 
 }
 

}
