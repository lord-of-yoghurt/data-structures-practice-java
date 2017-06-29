package singly_linked_list;

public class Node {
	public int value;
	Node next = null;
	
	public Node(int value) {
		this.value = value;
	}
	
	public void displayNode() {
		System.out.print("{ " + value + " } ");
	}
	
	public int getValue() {
		return value;
	}
}
