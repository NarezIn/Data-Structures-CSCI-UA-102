package customstack;

public class CustomArrayStackDemo {

	public static void main(String[] args) {
		System.out.println("CustomArrayStack Demo!"); 
		CustomArrayStack<Integer> stack = new CustomArrayStack<>();

		// enqueue()
		stack.push(300);
		stack.push(200);
		stack.push(100);
		stack.printAll(); //expected output: "PrintAll: 100 200 300"

		// isFull()
		System.out.println("isFull(): " + stack.isFull()); //isFull(): false"

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
}  
