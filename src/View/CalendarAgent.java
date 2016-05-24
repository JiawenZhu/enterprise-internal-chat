package View;

public class CalendarAgent {


	static MonthLinkedList<CalendarView> list;
	public CalendarAgent(){
		list= new MonthLinkedList<CalendarView>();
	}
	
	 public static void addToTheList(CalendarView c){
		 list.add(new Node(c));
		 
	 }
	
	
}
