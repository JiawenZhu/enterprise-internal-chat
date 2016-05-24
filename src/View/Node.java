package View;

public class Node<T> {
	Node<T> next;
	Node<T> previous;
	T calendar;

	public Node(T calendarView){
		calendar= calendarView;
		next=null;
		previous=null;
	}

	Node<T> getPrevious(){

		return previous;
	}


	Node<T> getNext(){
		return next;
	}
	
	void setNext(Node<T> nextCalendar){
		next= nextCalendar;
	}
	
	void setPrevious(Node<T> previousCalendar){
		previous = previousCalendar;
	}
	
	T getValue(){
		return calendar;
	}
}
