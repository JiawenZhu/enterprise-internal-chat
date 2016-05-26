package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonthlyCalendar extends JPanel {

	 public MonthlyCalendar(String name){
		 
    	 GridLayout grid = new GridLayout(5, 7);
	    this.setLayout(grid);
	     grid.setHgap(2);
	     grid.setVgap(1);
	     this.setBorder(BorderFactory.createLineBorder(Color.black));
	     
	     for(int i=0; i<(5*7);i++){
  			JLabel label= new JLabel(i+"");
  			this.add(label);
  		}
	     
	     
	     System.out.println("yay");
	}
}
