package customstack;

public class CustomLinkedStackDemo {
	
	public static void main(String[] args) {
		System.out.println("CustomLinkedStack Demo!");
		CustomLinkedStack<Integer> stack = new CustomLinkedStack<>();

		// enqueue()
		stack.push(300);
		stack.push(200);
		stack.push(100);
		stack.printAll(); //expected output: "PrintAll: 100 200 300"

		// front()
		System.out.println("front(): " + stack.top()); //front(): 100"

		// dequeue()
		System.out.println("dequeue(): " + stack.pop()); //dequeue(): 100"
		System.out.println("dequeue(): " + stack.pop()); //dequeue(): 200"
		System.out.println("dequeue(): " + stack.pop()); //dequeue(): 300"

		// dequeueAll()
		stack.popAll();

		// isEmpty()
		System.out.println("isEmpty(): " + stack.isEmpty()); //expected output: "isEmpty(): true"
	}
} // 코드 6-5
