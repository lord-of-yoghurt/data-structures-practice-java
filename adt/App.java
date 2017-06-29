package adt;

public class App {

	public static void main(String[] args) {
		Counter myCounter = new Counter("My Awesome Counter");
		
		for (int i = 0; i < 5; i++) {
			myCounter.increment();
		}
		
		System.out.println(myCounter.getCurrentValue());
		System.out.println(myCounter.toStr());
	}

}
