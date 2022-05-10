package cracking.stack.queue.questions;

public class Main {

	public static void main(String[] args) {
		
		ThreeInOne newStacks = new ThreeInOne(3);
		
		boolean result = newStacks.isFull(2);
		System.out.println(result);
		
		boolean result1 = newStacks.isEmpty(0);
		System.out.println(result1);
		
		newStacks.push(0, 1);
		newStacks.push(0, 2);
		newStacks.push(1, 4);
		newStacks.push(1, 5);
		newStacks.push(2, 8);
		
		int result2 = newStacks.pop(0);
		System.out.println(result2);
		
		int result3 = newStacks.peek(0);
		System.out.println(result3);
	}

}
