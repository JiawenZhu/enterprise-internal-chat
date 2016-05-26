
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CalendarMaker{
	
	JFrame importFrame;
	
	void drawCurrentMonth(String Month, JFrame frame){
		this.importFrame= frame;
		JFrame newFrame = new JFrame(Month);
		newFrame.add( new PrivateCalendar(Month,frame));
		
		JButton button = new JButton("back");
		button.addActionListener(new ButtonActionListener());
		newFrame.add(button);
		newFrame.setSize(500, 500);
		newFrame.setVisible(true);
		newFrame.setResizable(false);
	}
	
	
	public class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			importFrame.setVisible(true);
		}
		
		
		
	}
	
	
	
	
	
}