package View;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

public class PrivateCalendar extends JPanel{
    JFrame  importFrame;
	String month;
	
	public PrivateCalendar(JFrame frame){
		this.importFrame= frame;
	}
	     public PrivateCalendar(String name,JFrame frame){		
	    	 month=name;
	    	 
	    	 this.addMouseListener( new InnerCalMouseListener());
	    	SpringLayout spring= new SpringLayout();
	    	 this.setLayout(spring);
	    	 
	    	 JLabel nam= new JLabel(name);
	    	 nam.setBorder(BorderFactory.createEmptyBorder());
	    	 
	    	 this.add(nam);
	    	 
	    	 JPanel cal= new JPanel();
	    	 GridLayout grid = new GridLayout(5, 7);
		     cal.setLayout(grid);
		     grid.setHgap(4);
		     grid.setVgap(2);
		     
		     setDays(cal);
		     this.add(cal);
		     spring.putConstraint(SpringLayout.WEST, nam, 30, SpringLayout.WEST, this);
		     spring.putConstraint(SpringLayout.NORTH, nam, 10, SpringLayout.NORTH, this);
		     spring.putConstraint(SpringLayout.SOUTH, cal, 110, SpringLayout.NORTH, nam);
		     spring.putConstraint(SpringLayout.WEST, cal, 40, SpringLayout.WEST, this);
		     this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
     	void setDays(JPanel p){
     		
     		for(int i=0; i<(5*7);i++){
     			JLabel label= new JLabel(i+"");
     			p.add(label);
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
		importFrame.setVisible(false);
			CalendarMaker maker= new CalendarMaker();
			maker.drawCurrentMonth(month, importFrame);
			
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
