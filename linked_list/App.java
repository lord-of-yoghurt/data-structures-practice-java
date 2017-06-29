package linked_list;

public class App {

	public static void main(String[] args) {
		Node nodeA = new Node(4);
		Node nodeB = new Node(3);
		Node nodeC = new Node(7);
		Node nodeD = new Node(8);

		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		
		System.out.println(listLength(nodeA)); // => 4
	}
	
	// count length of list
	public static int listLength(Node someNode) {
		int len = 0;
		Node current = someNode;
		
		while (current != null) {
			len++;
			current = current.next;
		}
		
		return len;
	}
	
	// recursively count length of list
	public static int listLengthRec(Node someNode) {
		int len = 1;
		if (someNode.next != null) {
			len += listLength(someNode.next);
		}
		
		return len;
	}
	

}
