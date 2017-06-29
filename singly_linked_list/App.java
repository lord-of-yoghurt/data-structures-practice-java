package singly_linked_list;

public class App {

	public static void main(String[] args) {
		SinglyLinkedList awesomeList = new SinglyLinkedList();
		awesomeList.insertFirst(1);
		awesomeList.insertFirst(2);
		awesomeList.insertFirst(3);
		awesomeList.insertFirst(4);
		awesomeList.insertLast(0);

		awesomeList.displayList();
	}

}
