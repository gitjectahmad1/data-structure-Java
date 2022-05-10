package stack.array;

public class Main {

	public static void main(String[] args) {
		
		Stack newStack = new Stack(4);

		boolean result = newStack.isEmpty();
		System.out.println(result);
		
		boolean result1 = newStack.isFull();
		System.out.println(result1);
		
		newStack.push(1);
		newStack.push(2);
		newStack.push(3);
		newStack.push(4);

		int result2 = newStack.pop();
		System.out.println(result2);
		int result3 = newStack.pop();
		System.out.println(result3);
		
		
		int result4 = newStack.peek();
		System.out.println(result4);

	    int result5 = newStack.peek();
	    System.out.println(result5);
	    
	    newStack.deleteStack();
	}
	
}
