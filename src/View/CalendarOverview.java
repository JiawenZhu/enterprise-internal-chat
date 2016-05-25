package View;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalendarOverview {

	public CalendarOverview(){
		JFrame overView= new JFrame("calendar");
		overView.setLayout(null);
		JPanel background= new JPanel();
		background.setSize(new Dimension(750, 650));
		background.setLocation(20, 20);
		GridLayout layout=new GridLayout(4,3);
		layout.setHgap(30);
        layout.setVgap(30);
        background.setLayout(layout);
		
		 String[] months = {"January", "February", "March","April","May","June","July", "August",
					"September", "October", "November","December"};
			     for(int i=0; i< months.length; i++){
			         background.add(new Calendar(months[i]));	
			         }		
		overView.add(background);
		overView.setSize(800, 700);
		overView.setResizable(false);
		overView.setVisible(true);
		
		
		
		
		
		
		
	}

}
