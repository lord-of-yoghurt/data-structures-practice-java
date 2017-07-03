package doubly_linked_list;

public class Node {
	public int value;
	Node next = null; // knows about its next node, AND
	Node previous = null; // knows about its previous node
	
	public Node(int value) {
		this.value = value;
	}
	
	public void displayNode() {
		System.out.print("{ " + value + " } ");
	}
}
