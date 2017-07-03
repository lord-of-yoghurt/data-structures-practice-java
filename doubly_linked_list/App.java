package doubly_linked_list;

public class App {

	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();
		
//		for (int i = 5; i >= 1; i--) {
//			myList.insertFirst(i * 10);
//		}
		
		myList.insertLast(30);
		
		myList.insertAfter(30, 35);
		
		myList.displayList();
		
	}

}