
package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MonthlyCalendarMaker{
	
	JFrame SpecificMonthFrame;
	String month;
	int year;
	
	/**
	 * when user clicks the specific month overview on the CalendarOverview Window,
	 * this specific month appears and the mainWindow is hidden.
	 * 
	 * @param name
	 * @param year
	 */
	public void drawCurrentMonth(int monthInt, int year){
		// here the month # is from 1-12, so monthInt does not need to be subtracted by 1
		this.month=Shared.Utility.getMonth(monthInt);
		this.year=year;
		// new Frame is created for the specific month
		JFrame newFrame = new JFrame(this.month);
		BorderLayout layout = new BorderLayout();
		newFrame.setLayout(layout);   
		
		

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
		comment.addActionListener(new commentActionListener());
		
		JPanel monthCal = new MonthlyCalendar_calendar(monthInt,year);
	    newFrame.add(monthCal, BorderLayout.CENTER);

	   JPanel fillLeft= new JPanel();
	   newFrame.add(fillLeft, BorderLayout.WEST);
	   JPanel fill= new JPanel();
	   newFrame.add(fill, BorderLayout.EAST);
	   JPanel fillBottom= new JPanel(); 
	   newFrame.add(fillBottom, BorderLayout.SOUTH);
		
        newFrame.setSize(new Dimension(500, 500));
		newFrame.setVisible(true);
		newFrame.setResizable(false);
	
	 // store current monthFrame so that it can be referred back in the future.
	 // maybe create a doubly linked list OR an array for it? which is more easily accessed.
		this.SpecificMonthFrame= newFrame;	
	   }
	
	
	public class backActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			SpecificMonthFrame.setVisible(false);
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