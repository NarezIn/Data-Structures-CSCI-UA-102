package customqueue;
import customqueue.Node;

public class CustomLinkedQueue<E> implements QueueInterface<E>{
	private Node<E> tail;

	// Constructor 1: Creating an LinkedQueue.
	public CustomLinkedQueue( ) {
		//**********************************//
		// 			Initialize tail 		//
		//**********************************//
		tail = null;
	}
 
	// Implementation of enqueue(): Inserting element x to the queue
	// Return -1 if an exception occurs when inserting an element into the queue
	// Return 0 after the enqueue() operation in other cases
	public int enqueue(E newItem) {
		if (tail == null) {
			tail = new Node(newItem); //if tail is null.
			tail.next = tail;
		}
		else{
			Node<E> newNode = new Node(newItem, tail.next);
			tail.next = newNode;
			tail = newNode;
		}
		return 0;
	}
		
	// Implementation of dequeue(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the dequeue operation
	public E dequeue( ) {
		if (tail == null) {
			return null;
		}
		else if (tail.next == tail) {
			E temp = tail.item;
			tail = null;
			return temp;
		}
		Node<E> front = tail.next;
		tail.next = front.next;
		return front.item;
	}
		
	// Implementation of front(): getting the front element in the queue
	// Return null if an exception occurs
	// Return false otherwise
	public E front() {
		if (tail == null) {
			return null;
		}
		return tail.next.item;
	}
		
	// Implementation of isEmpty(): Checking if the queue is empty
	// Return true if the queue is empty
	// Return false otherwise
	public boolean isEmpty() {
		return tail.item == null;
	}
		 
	// Implementation of dequeueAll(): Empty queue
	public void dequeueAll ( ) {
		tail = null;
	} 
	
	/////////////////////////////////////////////////////
	public void printAll() {
		Node<E> t = tail;
		System.out.println("Queue from front to tail");
		if (!isEmpty()) 
			do {
				t = t.next;
				System.out.println(t.item);
			} while (t != tail);
		else System.out.println("Empty Queue!");
	}
} 
