package stack;

public class Stack {
	
	private int maxSize; 	   // stores the size of the stack
	private char[] stackArray; // the list of items
	private int top; 		   // represents the index position of the last inserted item
	
	// the constructor
	public Stack(int size) {
		this.maxSize = size; // set the max size at initialization
		this.stackArray = new char[maxSize]; // create the array of specified size
		this.top = -1; // because the array is empty at initialization and the first item
					   // will be at index 0
	}
	
	// add an item to stack (has to be 'long' datatype)
	public void push(char j) {
		if (this.isFull()) {
			System.out.println("The stack is full! Maximum allowed size is " + maxSize);
		} else {
			top++; // increment the top, THEN
			stackArray[top] = j; // place item in stackArray
		}
	}
	
	// pop item from stack. IMPORTANT: this doesn't actually
	// remove the data from the array - it simply reassigns 
	// the top and returns the value we have popped
	public char pop() {
		if (this.isEmpty()) {
			System.out.println("The stack is empty! Can't remove anything else.");
			return '1';
		} else {
			int old_top = top; // save the current position of top
			top--;
			return stackArray[old_top];
		}
	}
	
	// see what's currently on top of the stack
	public char peak() {
		return stackArray[top];
	}
	
	// see if the stack is empty
	public boolean isEmpty() {
		return (top == -1);
	}
	
	// see if the stack is full
	public boolean isFull() {
		return ((maxSize - 1) == top);
	}
	
}
