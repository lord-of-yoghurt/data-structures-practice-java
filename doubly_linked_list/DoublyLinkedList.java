package doubly_linked_list;

public class DoublyLinkedList {
	private Node first = null;
	private Node last = null;
	
	private Node foundNode = null;
	
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
	
	// a versatile insert method for before/after
	public boolean insert(String where, int key, int value) {
		// check if the first argument is passed in correctly
		if (where != "before" && where != "after") {
			System.out.println("First argument must be \"before\" or \"after\"!");
			return false;
		}
		
		// find the node by key; return false if not found
		foundNode = findNode(key);
		if (foundNode == null) {
			return false;
		}
		
		// if only one node in the list or if found node is last,
		// decide where to insert based on "where" passed in
		if (first.next == null || foundNode == last) {
			if (where == "before") {
				insertFirst(value);
			} else {
				insertLast(value);
			}
			return true;
		}
		
		// insert based on where the user wants the new node
		if (where == "before") {
			insertBefore(value);
		} else {
			insertAfter(value);			
		}
		foundNode = null; // nullify foundNode to be re-used
		return true;
	}
	
	// delete from the middle of the list
	public Node delete(int key) {
		// locate the node by key
		foundNode = findNode(key);
		
		// null is returned (with error msg in console) if nothing is found
		if (foundNode == null) {
			return foundNode;
		}
		
		// check if it's the only node or if it's first/last
		if (first.next == null || foundNode == last) {
			return deleteLast();
		} else if (foundNode == first) {
			return deleteFirst();
		}
		Node temp = foundNode;
		// point foundNode's previous' next to foundNode's next
		foundNode.previous.next = foundNode.next; 
		// vice versa
		foundNode.next.previous = foundNode.previous;
		// nullify foundNode to be used again
		foundNode = null;
		return temp;
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
				System.out.println("Could not find a node with the key of " + key + "!");
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
	
	// helper to insert before a certain node
	private void insertBefore(int value) {
		Node newNode = new Node(value);
		newNode.next = foundNode;
		newNode.previous = foundNode.previous;
		foundNode.previous.next = newNode;
		foundNode.previous = newNode;
	}
	
	// helper to insert after a certain node
	private void insertAfter(int value) {
		Node newNode = new Node(value);
		newNode.next = foundNode.next;
		newNode.previous = foundNode;
		foundNode.next.previous = newNode;
		foundNode.next = newNode;
	}
}