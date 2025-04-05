package customqueue;

public class CustomLinkedQueueDemo {
	public static void main(String[] args) {
		System.out.println("CustomLinkedQueue Demo!");
		CustomLinkedQueue<Integer> queue = new CustomLinkedQueue<>();

		// enqueue()
		queue.enqueue(300);
		queue.enqueue(200);
		queue.enqueue(100);
		queue.printAll(); //expected output: "PrintAll: 300 200 100"

		// front()
		System.out.println("front(): " + queue.front()); //front(): 300"

		// dequeue()
		System.out.println("dequeue(): " + queue.dequeue()); //dequeue(): 300"
		System.out.println("dequeue(): " + queue.dequeue()); //dequeue(): 200"
		System.out.println("dequeue(): " + queue.dequeue()); //dequeue(): 100"

		// dequeueAll()
		queue.dequeueAll();

		// isEmpty()
		System.out.println("isEmpty(): " + queue.isEmpty()); //expected output: "isEmpty(): true"

	}
} 
