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

public class AnnualSingleCalendar extends JPanel{
	JFrame  importFrame;
	int month;
	int year;

	// pass in the month name and year
	public AnnualSingleCalendar(int month,int year){		

		this.setBackground(Color.white);
		this.month=month; 
		this.year= year;
		String stringMonth= Month.of(month+1).name();

		this.addMouseListener( new InnerCalMouseListener());
		SpringLayout spring= new SpringLayout();
		this.setLayout(spring);

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

		// setup the time
		Calendar newCalendar= new GregorianCalendar(year, month,1);

		setDays(cal,newCalendar);
		this.add(cal);
		spring.putConstraint(SpringLayout.WEST, nam, 30, SpringLayout.WEST, this);
		spring.putConstraint(SpringLayout.NORTH, nam, 10, SpringLayout.NORTH, this);
		spring.putConstraint(SpringLayout.SOUTH, cal, 120, SpringLayout.NORTH, nam);
		spring.putConstraint(SpringLayout.WEST, cal, 68, SpringLayout.WEST, this);
	}

	private void setDays(JPanel p, Calendar newCalendar){

		int DaysInMonth= newCalendar.getActualMaximum(month);
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

		// set the first day
		for(int i=1; i<dayOfWeekOfFirstDay; i++){
			JLabel label= new JLabel(" ");
			label.setBackground(Color.WHITE);
			label.setForeground(Color.gray);
			label.setOpaque(isOpaque());
			label.setFont(new Font("Chalkboard",Font.PLAIN, 12));
			p.add(label);
		}

		// fill in the rest
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
