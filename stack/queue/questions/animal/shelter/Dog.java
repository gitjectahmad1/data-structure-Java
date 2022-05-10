package stack.queue.questions.animal.shelter;

public class Dog extends Animal {
	
	public Dog(String n) {
		super(n);
	}

	@Override
	public String name() {
		return "Dog: " + name;
	}

}
