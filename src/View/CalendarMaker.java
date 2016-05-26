
package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class CalendarMaker{
	
	JFrame importFrame;
	
	void drawCurrentMonth(String Month){
		
		JFrame newFrame = new JFrame(Month);
		GridLayout layout = new GridLayout(2,1);
		newFrame.setLayout(layout);
	//	newFrame.setLayout(layout);
		JPanel buttons = new JPanel();
JButton back = new JButton("back");
JButton next = new JButton("next Month");
buttons.add(back);
buttons.add(next);

		//button.setLocation(400, 400);
		newFrame.add(buttons);
		back.addActionListener(new backActionListener());
		next.addActionListener(new nextActionListener());
	   // button.setSize(new Dimension(30, 40));
		
	//	layout.putConstraint(SpringLayout.NORTH, button,400, SpringLayout.NORTH, newFrame);
	//	layout.putConstraint(SpringLayout.EAST, button,100, SpringLayout.EAST, newFrame);			
		
		JPanel monthCal = new MonthlyCalendar(Month);
		//monthCal.setSize(new Dimension(400,400));
		//monthCal.setLocation(50, 40);
	    newFrame.add(monthCal);
	    //layout.putConstraint(SpringLayout.NORTH, monthCal,50, SpringLayout.NORTH, newFrame);
		//layout.putConstraint(SpringLayout.WEST, monthCal,50, SpringLayout.WEST, newFrame);
	    
	    
    	newFrame.setSize(new Dimension(500, 500));
		newFrame.setVisible(true);
		newFrame.setResizable(false);
	}
	
	
	public class backActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//importFrame.setVisible(true);
			CalendarOverview.ShowWindow();
		}
		
		
		
	}
	public class nextActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	
	
}