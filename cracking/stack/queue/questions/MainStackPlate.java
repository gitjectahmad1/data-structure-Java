package cracking.stack.queue.questions;

public class MainStackPlate {

	public static void main(String[] args) {
/*		
		Stack newStack = new Stack(3);
		System.out.println(newStack.isFull());
		
		newStack.push(1);
		newStack.push(2);
		System.out.println(newStack.pop());
*/		
		SetOfStacks newStack1 = new SetOfStacks(3);
		newStack1.push(1);
		newStack1.push(2);
		newStack1.push(3);
		newStack1.push(4);
		newStack1.push(5);
	//	System.out.println(newStack1.pop());
		
		System.out.println(newStack1.popAt(0));
		System.out.println(newStack1.popAt(0));
	}

}
