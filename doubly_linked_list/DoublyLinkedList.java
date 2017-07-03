package doubly_linked_list;

public class DoublyLinkedList {
	private Node first = null;
	private Node last = null;
	
	// list is empty if there's no first or last
	public boolean isEmpty() {
		return (first == null && last == null);
	}
	
	// insert at the beginning of the list
	public void insertFirst(int value) {
		Node newNode = new Node(value);
		
		if (isEmpty()) {
			last = newNode; // list is empty, so we can start by assigning last
		} else {
			first.previous = newNode;	
		}
		// this will run if the list is empty, so first and last will both point to newNode
		// if the list is empty.
		newNode.next = first; // points to null if list is empty
		first = newNode; 
	}
	
	// insert at the end of the list
	public void insertLast(int value) {
		Node newNode = new Node(value);
		
		if (isEmpty()) {
			insertFirst(value); // since first will set both first and last
		} else {
			last.next = newNode; // point old last to new node
			newNode.previous = last; // new node's previous now refers to old last
			last = newNode; // last is now the new node
		}
	}
	
	// display entire list
	public void displayList() {
		if (isEmpty()) {
			System.out.println("Cannot display an empty list!");
			return;
		}
		Node current = first;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	// delete from the beginning of the list
	// "delete" methods return a node for better maintainability
	public Node deleteFirst() {
		if (isEmpty()) {
			System.out.println("Cannot delete from empty list!");
			return null;
		}
		
		Node temp = first;
		// check if just one element
		if (first.next == null) {
			first = null;
			last = null;
		} else {
			first.next.previous = null; // look at node after first, nullify its previous
			first = first.next; // reassign next node as first
		}
		return temp; // return deleted first node	
	}
	
	// delete from end of the list - this is O(n) because of "previous"
	public Node deleteLast() {
		if (isEmpty()) {
			System.out.println("Cannot delete from empty list!");
			return null;
		}
		
		Node temp = last;
		// if just one node, run deleteFirst and capture its return value
		if (last.previous == null) {
			temp = deleteFirst();
		} else {
			last.previous.next = null; // nullify the "next" of penultimate node
			last = last.previous; // reassign penultimate node as last
		}
		return temp;
	}
}