package View;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Month;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

/**
 * create CalenarPanel of one month for Each year 
 * this class will be run 12 times.
 * @author shuai9532
 *
 */
public class AnnualSingleCalendar extends JPanel{
	int month;
	int year;

	public AnnualSingleCalendar(int month,int year){		
	
		
		this.setBackground(Color.white);
		this.addMouseListener( new InnerCalMouseListener());
		SpringLayout spring= new SpringLayout();
		this.setLayout(spring);
        
		this.month=month; 
		this.year= year;
		
		// make the title part of the calendar
		String stringMonth= Month.of(month).name();
		JLabel nam= new JLabel(stringMonth);
		nam.setForeground(Color.red);
		nam.setBorder(BorderFactory.createEmptyBorder());
		this.add(nam);

		JPanel cal= new JPanel();
		cal.setOpaque(isOpaque());
		cal.setBackground(Color.white);
		GridLayout grid = new GridLayout(6, 7);
		cal.setLayout(grid);
		grid.setHgap(6);
		grid.setVgap(2);
		// set up the time
		Calendar newCalendar= new GregorianCalendar(year,month,1);
		
		long startTime = System.currentTimeMillis();
		
		setDays(cal,newCalendar);
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(estimatedTime);
		
		
		
		this.add(cal);
		spring.putConstraint(SpringLayout.WEST, nam, 30, SpringLayout.WEST, this);
		spring.putConstraint(SpringLayout.NORTH, nam, 10, SpringLayout.NORTH, this);
		spring.putConstraint(SpringLayout.SOUTH, cal, 120, SpringLayout.NORTH, nam);
		spring.putConstraint(SpringLayout.WEST, cal, 68, SpringLayout.WEST, this);
	
	}

	/**
	 * this is where the Calendar part of the
	 * Calendar is made and added to the main Calendar JPanel
	 * @param p
	 * @param newCalendar
	 */
	private void setDays(JPanel p, Calendar newCalendar){

		// months range from 0-11
		// the data will be given by Calendar for a specific year and month
		int DaysInMonth= newCalendar.getActualMaximum(month-1);
		int dayOfWeekOfFirstDay= newCalendar.get(Calendar.DAY_OF_WEEK);

		String[] day= new String[]{"M","T", "W", "T", "F", "S","S"};

		//set Name of a week
		for (int i=0; i<7;i++){
			JLabel label= new JLabel(day[i]);
			label.setBackground(Color.WHITE);
			label.setForeground(Color.gray);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			p.add(label);
		}

		// set empty boxes until hit the first day, and leave that first day
		for(int i=1; i<dayOfWeekOfFirstDay; i++){
			JLabel label= new JLabel(" ");
			label.setBackground(Color.WHITE);
			label.setForeground(Color.gray);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			p.add(label);
		}

		// fill in the first day and the rest of the month
		int i=0;
		while(i<= DaysInMonth){
			JLabel label= new JLabel(" ");
			label.setBackground(Color.WHITE);
			label.setForeground(Color.gray);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			p.add(label);
			i++;
		}
		
	}

	public class InnerCalMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			CalendarOverview.hideWindow();
			MonthlyCalendarMaker maker= new MonthlyCalendarMaker();
			maker.drawCurrentMonth(month,year);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

}
