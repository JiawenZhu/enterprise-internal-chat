package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonthlyCalendar_calendar extends JPanel {

	 public MonthlyCalendar_calendar(String name){
		 
    	 GridLayout grid = new GridLayout(5, 7);
	    this.setLayout(grid);
	   ////  grid.setHgap(1);
	     //grid.setVgap(1);
	   //  this.setBorder(BorderFactory.createLineBorder(Color.black));
	     this.setSize(300,300);
	     
	     for(int i=0; i<(5*7);i++){
  			JLabel label= new JLabel(i+"");
  			label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
  			this.add(label);
  		}
	     
	     
	     System.out.println("yay");
	}
}
