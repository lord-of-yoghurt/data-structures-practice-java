package doubly_linked_list;

public class DoublyLinkedList {
	private Node first = null;
	private Node last = null;
	
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
	
	// delete from end of the list - this is O(1) because of "previous"
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
	
	// insert after a specific node
	public boolean insertAfter(int key, int value) {
		// search for node to insert after
		Node foundNode = findNode(key);
		if (foundNode == null) {
			return false;
		}
		
		// if only one node in the list or if found node is last,
		// default to inserting new node as last
		if (first.next == null || foundNode == last) {
			insertLast(value);
			return true;
		}
		
		// at this point, create a new node and make the insertion
		Node newNode = new Node(value);
		newNode.next = foundNode.next;
		newNode.previous = foundNode;
		foundNode.next.previous = newNode;
		foundNode.next = newNode;
		return true;
	}
	
	//---------------------------------------------//
	//-------------- UTILITY METHODS --------------//
	//---------------------------------------------//
	
	// list is empty if there's no first or last
	public boolean isEmpty() {
		return (first == null && last == null);
	}
	
	// find a specific node
	public Node findNode(int key) {
		// start looking from the beginning of the list
		Node current = first;
		while (current.value != key) {
			current = current.next;
			if (current == null) {
				System.out.println("Could not find node!");
				return null;
			}
		}
		return current;
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
}