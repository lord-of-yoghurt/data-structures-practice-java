package circular_linked_list;

public class CircularLinkedList {
	// circular linked list knows about its first AND last element
	private Node first = null;
	private Node last = null;
	
	// check if list is empty
	public boolean isEmpty() {
		return (first == null);
	}
	
	// insert new node as first
	public void insertFirst(int value) {
		Node newNode = new Node(value);
		if (this.isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			newNode.next = first;
			first = newNode;
		}
	}
	
	// insert new node as last - more efficient now with O(1)
	public void insertLast(int value) {
		Node newNode = new Node(value);
		last.next = newNode;
		last = newNode;
	}
	
	// delete first node
	public int deleteFirst() {
		Node temp = first;
		
		if (!isEmpty()) {
			// check if this is the only node
			if (first.next == null) {
				last = null;
			}
			
			// reassign first to the node that goes immediately after
			first = first.next; 
			return temp.value;
		}
		System.out.println("The list is empty!");
		return -1;
	}
	
	// delete last node - still O(n) because nodes are not aware of their previous node
	public int deleteLast() {
		if (!isEmpty()) {
			Node temp = last;
			if (first.next != null) {
				Node beforeLast = first;
				while (beforeLast.next != last) {
					beforeLast = beforeLast.next;
				}
				beforeLast.next = null;
				beforeLast = last;
				return temp.value;
			}
			first = null;
			last = null;
			return temp.value;
		}
		System.out.println("The list is empty!");
		return -1;
	}
	
	// display the whole list
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
