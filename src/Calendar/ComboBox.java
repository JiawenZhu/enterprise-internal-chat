package Calendar;

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

/**
 * this class creates the panel (ComboBox) 
 * that will be added to the Calendar Frame.
 * There also gives the selected year to add corresponding 
 * panel to the frame
 * 
 * @author shuai9532
 *
 */
public class ComboBox extends JPanel 
{
final String defaultYear= "2016";
	private JComboBox box;
	static String year;
	
	//create all the choices, and set
	//the default choice "2016", add the
	//box into the panel
	ComboBox(){	
		
		box= new JComboBox();
		//3 years will be recorded here for testing
		for (int i=0; i<100;i++){
			box.addItem(Integer.parseInt(defaultYear)+i+"");
		} 
		box.setSelectedItem(defaultYear);
        year= defaultYear;
		
		box.addActionListener(new BoxActionListener());
		box.setEditable(false);
		this.add(new JLabel("select year: "));
		this.add(box);
	}

	/**
	 * class Listener is the action to 
	 * respond to every choice that is made
	 * @author shuai9532
	 *
	 */
	class BoxActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	
			 JComboBox box = (JComboBox) e.getSource();
			 
			 // year is changed to whatever chosen
              year = (String) box.getSelectedItem();
              // now call the method do add that to the frame;
             CalendarOverview.initializeAnnualCalendar();
	        }
     	}

	}


