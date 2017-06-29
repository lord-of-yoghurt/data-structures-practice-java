package circular_linked_list;

public class App {

	public static void main(String[] args) {
		CircularLinkedList myAwesomeList = new CircularLinkedList();
		
		for (int i = 1; i < 6; i++) {
			myAwesomeList.insertFirst(i * 10);
		}
		
		myAwesomeList.insertLast(2);
		
		myAwesomeList.insertFirst(52);
		
		System.out.println(myAwesomeList.deleteFirst()); // prints 52
		System.out.println(myAwesomeList.deleteLast()); // prints 2
		
		myAwesomeList.displayList(); // should be { 50 } { 40 } { 30 } { 20 } { 10 }
	}

}
