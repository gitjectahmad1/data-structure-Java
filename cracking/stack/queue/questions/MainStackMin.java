package cracking.stack.queue.questions;

public class MainStackMin {
	public static void main(String[] args) {
		
		StackMin newStack = new StackMin();
		newStack.push(3);
		newStack.push(2);
		newStack.push(5);
		newStack.push(1);
		System.out.println(newStack.min());
		newStack.pop();
		System.out.println(newStack.min());
	}

}
