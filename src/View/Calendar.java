package View;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

public class Calendar extends JPanel{
       
	     public Calendar(String name){		
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
     			//label.setBorder(BorderFactory.createLineBorder(Color.gray));
     			p.add(label);
     		}
     	}
     	
	

}
