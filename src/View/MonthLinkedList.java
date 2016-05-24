package View;

public class MonthLinkedList<T> {
	Node<T> head;
	int count;
	
public MonthLinkedList()
{
	head=null;
	count=0;
}
	
void add(Node<T> calendar){
	if(count==0){
		head= calendar;
	    count++;
	}else{
		Node<T> walker=head;
		
		while(walker.next!=null){
			walker=walker.getNext();
		}
		
		walker.setNext(calendar);
		calendar.setPrevious(walker);
		count++;
	}
}
	
}
