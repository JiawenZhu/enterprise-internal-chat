package Calendar;

import java.util.ArrayList;

import Chat.MessageData;
import Chat.MessageList;

public class CalendarFeatureTest {

	public void test() {
		
		MessageList list=  new MessageList();
			list.addToArrayList(new MessageData("1234","hello how are you"));
			list.addToArrayList(new MessageData("23456","I am great"));
		CalendarOverview testCal = new CalendarOverview(list);
	//	ComboBox.year= "2016";
		//testCal.initializeAnnualCalendar();
	}

}
