package Calendar;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import java.text.DateFormatSymbols;
import java.time.Month;

/**
 * create CalenarPanel of one month for Each year 
 * this class will be run 12 times.
 * @author shuai_Huang
 *
 */
public class AnnualSingleCalendar extends JPanel{
	private int month;
	private int year;

	public AnnualSingleCalendar(int month,int year){
		this.setBackground(Color.white);
		this.addMouseListener( new InnerCalMouseListener());
		SpringLayout spring= new SpringLayout();
		this.setLayout(spring);
		this.month=month; 
		this.year= year;
		
		// make the title part of the calendar
		// when convert back to String, int value 
		// needs to add 1 because int<0 || int>12 is not valid 
		String stringMonth=Month.of(month+1).name();
		JLabel nam= new JLabel(stringMonth);
		nam.setForeground(Color.red);
		nam.setBorder(BorderFactory.createEmptyBorder());
		this.add(nam);
        // this Panel is for each month that 
		//will be added to the yearly window
		JPanel cal= new JPanel();
		cal.setOpaque(isOpaque());
		cal.setBackground(Color.white);
		GridLayout grid = new GridLayout(7, 7);
		cal.setLayout(grid);
		grid.setHgap(6);
		grid.setVgap(2);
		// set up the time		
		Calendar newCalendar= new GregorianCalendar(year,month,1);	
		setDays(cal,newCalendar);
		this.add(cal);
		spring.putConstraint(SpringLayout.EAST, nam, -10, SpringLayout.WEST, cal);
		spring.putConstraint(SpringLayout.NORTH, nam, 20, SpringLayout.NORTH, this);
		spring.putConstraint(SpringLayout.SOUTH, cal, 120, SpringLayout.NORTH, nam);
		spring.putConstraint(SpringLayout.WEST, cal, 80, SpringLayout.WEST, this);
		spring.putConstraint(SpringLayout.NORTH, cal, 5, SpringLayout.NORTH, this);
	
	}
	/**
	 * this is where the Calendar part of the
	 * Calendar is made and added to the main Calendar JPanel
	 * @param p    Panel for the month
	 * @param newCalendar   get info of the required month in the year
	 */
	private void setDays(JPanel p, Calendar newCalendar){

		// months range from 0-11
		// the data will be given by Calendar for a specific year and month
		int DaysInMonth = newCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeekOfFirstDay= newCalendar.get(Calendar.DAY_OF_WEEK);

		String[] day= new String[]{"S","M","T", "W", "T", "F", "S"};

		//set Name of a week
		for (int i=0; i<7;i++){
			JLabel label= new JLabel(day[i]);
			label.setBackground(Color.WHITE);
			label.setForeground(Color.gray);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			p.add(label);
		}
        int count=7;
		// set empty boxes until hit the first day, and leave that first day
		for(int i=1; i<dayOfWeekOfFirstDay; i++){
			JLabel label= new JLabel(" ");
			label.setBackground(Color.WHITE);
			label.setForeground(Color.gray);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			p.add(label);
			
		}
		count=count+dayOfWeekOfFirstDay-1;
		// fill in the first day and the rest of the month
		int i=0;
		while(i< DaysInMonth){
			JLabel label= new JLabel(i+1+"");
			label.setBackground(Color.WHITE);
			label.setForeground(Color.gray);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			p.add(label);
			Date date= new Date();
			if((i+1)==date.getDate()&&(date.getYear()+1900)==year&& date.getMonth()==month){
				label.setForeground(Color.red);
				label.setFont(new Font("Chalkboard",Font.BOLD, 15));
			}
			i++;
		}
		count=count+DaysInMonth;
		// the rest is empty
		while (count<49){
			JLabel label= new JLabel(" ");
			label.setBackground(Color.WHITE);
			label.setForeground(Color.gray);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			p.add(label);
			count++;
		}
	}

	public class InnerCalMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {
			CalendarOverview.hideWindow();
			MonthlyCalendarMaker maker= new MonthlyCalendarMaker();
			maker.drawCurrentMonth(month,year);
		}
		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}

}
