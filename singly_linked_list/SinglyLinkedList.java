package singly_linked_list;

public class SinglyLinkedList {
	
	// point to the first node of the list
	private Node first; 
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	// insert at the beginning of the list
	public void insertFirst(int value) {
		Node newNode = new Node(value); // create new node with value passed in
		// if the list is empty, the new node is both first and last
		newNode.next = first; // new node's "next" now points to the old "first" node
		first = newNode; // and now "first" points to the new node
	}
	
	// insert at the end of the list
	// !! this is O(n) and not very efficient
	public void insertLast(int value) {
		Node current = first;
		Node newNode = new Node(value);
		
		// find the last node
		while (current.next != null) {
			current = current.next; 
		}
		current.next = newNode;
	}
	
	// delete from the beginning
	public int deleteFirst() {
		Node temp = first; // temporary variable to return later
		first = first.next; // reassign "first" - it now points to previous first's "next"
		return temp.value; // return the value of deleted node
	}
	
	// print the whole list out
	public void displayList() {
		System.out.println("Displaying List (first --> last)");
		Node current = first;
		
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
}
