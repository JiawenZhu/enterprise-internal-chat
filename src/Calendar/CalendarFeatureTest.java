package Calendar;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import Chat.MessageData;
import Chat.MessageList;

public class CalendarFeatureTest {

	@Test
	public void test() {
		
		ArrayList<MessageData> list=  new ArrayList<MessageData>();
			list.add(new MessageData("1234","hello how are you"));
			list.add(new MessageData("23456","I am great"));
		CalendarOverview testCal = new CalendarOverview(list);
	//	ComboBox.year= "2016";
		//testCal.initializeAnnualCalendar();
	}

}
