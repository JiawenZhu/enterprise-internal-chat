
package Calendar;

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

/**
 * this class makes the monthly calendar 
 * @author shuai9532
 *
 */
public class MonthlyCalendarMaker{
	
	private JFrame SpecificMonthFrame;
	private String month;
	private int year;
	
	/**
	 * when user clicks the specific month overview on the CalendarOverview Window,
	 * this specific month appears and the mainWindow is hidden.
	 * @param monthInt  number of days in a month
	 * @param year  the year number
	 */
	public void drawCurrentMonth(int monthInt, int year){
		// here the monthInt needs to be 1-12 to be converted to String
		// so monthInt needs to be added by 1
		this.month=Month.of(monthInt+1).name();
		this.year=year;
		// new Frame is created for the specific month
		JFrame newFrame = new JFrame(this.month);
		BorderLayout layout = new BorderLayout();
		newFrame.setLayout(layout);   

		JPanel buttons = new JPanel();
		JButton back = new JButton("back");
		buttons.add(back);
		newFrame.add(buttons, BorderLayout.NORTH);
		back.addActionListener(new backActionListener());

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


	
	
}