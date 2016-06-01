
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MonthlyCalendarMaker{
	
	JFrame importFrame;
	String month;
	int year;
	
	void drawCurrentMonth(int month, int year){
		this.month=Month.of(month).name();
		this.year=year;
		JFrame newFrame = new JFrame(this.month);
		
		importFrame= newFrame;
		BorderLayout layout = new BorderLayout();
		
		newFrame.setLayout(layout);
	//	newFrame.setLayout(layout)
		JPanel buttons = new JPanel();
JButton back = new JButton("back");
JButton next = new JButton("next Month");
JButton comment= new JButton("comment");
buttons.add(back);
buttons.add(next);
buttons.add(comment);
		newFrame.add(buttons, BorderLayout.NORTH);
		back.addActionListener(new backActionListener());
		next.addActionListener(new nextActionListener());
		next.addActionListener(new commentActionListener());
	   // button.setSize(new Dimension(30, 40));

	//	layout.putConstraint(SpringLayout.NORTH, button,400, SpringLayout.NORTH, newFrame);
	//	layout.putConstraint(SpringLayout.EAST, button,100, SpringLayout.EAST, newFrame);			
		
		JPanel monthCal = new MonthlyCalendar_calendar(this.month, year);
		//monthCal.setSize(new Dimension(400,400));
		//monthCal.setLocation(50, 40);
	    newFrame.add(monthCal, BorderLayout.CENTER);
	    //layout.putConstraint(SpringLayout.NORTH, monthCal,50, SpringLayout.NORTH, newFrame);
		//layout.putConstraint(SpringLayout.WEST, monthCal,50, SpringLayout.WEST, newFrame);
	    
	   JPanel fillLeft= new JPanel();
	 //  comment.setSize(100, 400);
	   newFrame.add(fillLeft, BorderLayout.WEST);
	   
	   
	   JPanel fill= new JPanel();
		 //  comment.setSize(100, 400);
		   newFrame.add(fill, BorderLayout.EAST);
		   
		   JPanel fillBottom= new JPanel(); 
		   newFrame.add(fillBottom, BorderLayout.SOUTH);
		
	    
	    
        newFrame.setSize(new Dimension(500, 500));
		newFrame.setVisible(true);
		newFrame.setResizable(false);
		
		
		
	   }
	public class backActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			importFrame.setVisible(false);
			CalendarOverview.ShowWindow();
		}
	}
	
	public class nextActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	
			
			// for test      
			drawCurrentMonth(Calendar.JUNE, year);
			
		}
	
	}
	
	public class commentActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	
}