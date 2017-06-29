package stack;

// define and execute a reverseString() method, which is
// a good use case for a Stack

public class App {

	public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}
	
	public static String reverseString(String str) {
		int stackSize = str.length();
		Stack strStack = new Stack(stackSize);
		String newStr = "";
		for (int i = 0; i < stackSize; i++) {
			strStack.push(str.charAt(i));
		}
		
		while (!strStack.isEmpty()) {
			newStr += strStack.pop();
		}
		return newStr;
	}

}
