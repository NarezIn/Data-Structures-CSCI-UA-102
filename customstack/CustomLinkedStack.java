package customstack;
import customstack.Node;

public class CustomLinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode; // the top node of stack

	// Constructor 1: Creating an Linked.
	public CustomLinkedStack() {
		//**********************************//
		// Initialize topNode			    //
		topNode = new Node<>(null, null);
		//  Dummy Head (index = -1)
		//**********************************//
	}
	
	// Implementation of push(): Inserting element x to the stack
	// Return 0 after the push() operation in other cases
	public int push(E newItem) {
		topNode = new Node<>(newItem, topNode);
		return 0;
	}
	
	// Implementation of pop(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the pop operation
	public E pop() {
		if (topNode.next == null) {
			return null;
		}
		E temp = topNode.item;
		topNode = topNode.next;
		return temp;
	}
	
	// Implementation of top(): getting the top element in the stack
	// Return null if an exception occurs
	// Return false otherwise
	public E top() {
		if (topNode.next == null) {
			return null;
		}
		return topNode.item;
	}
	
	// Implementation of isEmpty(): Checking if the stack is empty
	// Return true if the stack is empty
	// Return false otherwise
	public boolean isEmpty() {
		return topNode.item == null;
	}
	
	// Implementation of dequeueAll(): Empty stack
	public void popAll() {
		topNode = new Node<>(null, null);
	}

	//////////////////////////////////////////////
	public void printAll() {
		Node<E> t;
		System.out.print("Stack from top: ");
		for(t=topNode; t != null; t = t.next) {
			System.out.print(t.item + " ");
		}
		System.out.println();
	}
} // 코드 6-4
