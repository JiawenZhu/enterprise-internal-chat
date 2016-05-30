package View;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class ComboBox extends JPanel //implements ActionListener
{
	JPanel currentYear;
	private JComboBox box;
	
	//create all the choices, and set
	//the default choice "2016", add the
	//box into the panel, and the panel 
	//will be added to the frame of CalendarOverview
	ComboBox(){	
		currentYear=null;
		box= new JComboBox();
		for (int i=0; i<100;i++){
			box.addItem(2016+i+"");
		} 
		box.setSelectedItem("2016");
		box.addActionListener(new BoxActionListener());
		box.setEditable(false);
		this.add(new JLabel("select year: "));
		this.add(box);
	}
	
	// class Listener is the action to respond to every choice that is made
	class BoxActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			 JComboBox box = (JComboBox) e.getSource();
             String selected = (String) box.getSelectedItem();
             
             // test case
             if(Integer.parseInt(selected.toString())==2017){
            	currentYear= new JPanel();
            	currentYear.add(new JLabel("yes"));
            	CalendarOverview.setCalendar(CalendarOverview.frame);
            	System.out.println("it is 2017");
             }
             else {
             //create a calendar for every year number 
             //selected and assign it to the currentYear
             JPanel calendar=new CalendarOverview_calendar(Integer.parseInt(selected.toString()));
			 setCalendarPanel(calendar);
			 // call the method in the CalendarOverview 
			 //class to initialize the attachment
			 CalendarOverview.setCalendar(CalendarOverview.frame);	
             }
		}
	}
	
	// for the class CalendarOverview
	public JPanel getCalendarForYear(){
			return currentYear;
		}
	
	private void setCalendarPanel(JPanel x){
		this.currentYear= x;
	}
	

	}


