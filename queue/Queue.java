package queue;

public class Queue {
	
	private int maxSize; // initialize with a set number of slots
	private long[] qArray; // storage for the data
	private int front; // similar to 'top' in a stack; keep track of front of queue
	private int rear; // also an index position to track the back of the line
	private int nItems; // counter to maintain the number of items
	
	public Queue(int size) {
		this.maxSize = size;
		this.qArray = new long[size];
		front = 0; // index position of the front
		rear = -1; // index position of the rear to start with (no last item yet)
		nItems = 0; // nothing in the array yet
	}
	
	public void insert(long i) {
		// protect from overflow - circular queue (overwriting)
		if (rear == maxSize - 1) {
			rear = -1;
		}
		
		rear++;
		qArray[rear] = i; // joining the queue, i.e. standing at the end of it
		nItems++;
	}
	
	// remove item from the front of the queue
	public long remove() {
		long tmp = qArray[front]; // assign current front to temp var to return later
		front++; // next in line!
		if (front == maxSize) {
			front = 0; // set front back to 0th index to utilize the array again
		}
		nItems--;
		return tmp;
	}
	
	// see who's in the beginning
	public long peekFront() {
		return qArray[front];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	// see the entire queue
	public void view() {
		System.out.print("[ ");
		for (int i = 0; i < qArray.length; i++) {
			System.out.print(qArray[i] + " ");
		}
		System.out.println("]");
	}
}
