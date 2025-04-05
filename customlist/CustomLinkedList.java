package customlist;

public class CustomLinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numItems;

	// Constructor 1: Creating an LinkedList with Dummy Head.
	// We consider that the index of Dummy Head as '-1'.
	public CustomLinkedList() { 			
		numItems = 0;
		head = new Node<>(null, null); 	//  Dummy Head (index = -1)
	}

	// Implementation of getNode(): Retrieving a node at the 'index' position in the list
	// If the index is -1, we consider that it as searching for the dummy head.
	// Return null if attempting to access an index that is out of bounds (exception)
	// Return the i-th node after the getNode operation in other cases
	public Node<E> getNode(int index) {
	//***************Write your code in the below******************//
		if (index < -1 || index >= numItems){
			return null;
		}
		Node<E> currNode = head;
		for(int i = 0; i < index + 1; i++) {
			currNode = currNode.next;
		}
		return currNode;
	//*************************************************************//
	}

	public void remove(int index, int k){
		if (index >= 0 && index <= numItems -1 ) {
			Node<E> prev = getNode(index - 1);
			prev.next = prev.next.next;
			k--;
			numItems--;
			if (k > 0) {
				remove(index, k);
			}
		}
	}
	
	// Implementation of add(): Inserting element x at the 'index' position in the list
	// Return -1 if an exception occurs when inserting an element into the list
	// Return 0 after the add() operation in other cases
	public int add(int index, E item) {
	//***************Write your code in the below******************//
		if (index < 0 || index > numItems){
			return -1;
		}
		Node<E> prevNode = getNode(index - 1);
		Node<E> newNode = new Node<>(item, prevNode.next);
		prevNode.next = newNode;
		numItems++;
		return 0;
	//*************************************************************//
	}
 
	// Implementation of append(): Adding an element to the end of the list
	// Return 0 after the add() operation
	public int append(E item) {
	//***************Write your code in the below******************//
		add(numItems, item);
		return 0;
	//*************************************************************//
	}

	// Implementation of remove(): Deleting an element at the 'index' position from the list
	// Return null if an exception occurs when deleting an element from the list
	// Return the removed element after the remove() operation in other cases
	public E remove(int index) {
	//***************Write your code in the below******************//
		if (index < 0 || index >= numItems){
			return null;
		}
		E hold = getNode(index).item;
		Node<E> prevNode = getNode(index - 1);
		prevNode.next = prevNode.next.next;
		numItems--;
		return hold;
	//*************************************************************//
	}

	// Implementation of removeItem(): Removing element x from the list

	// If there are multiple nodes of the same item 'x', 
	// only the one node closest to the index '0' will be removed.

	// Return false if element x does not exist in the list
	// Return true after the removal operation if x exists
	public boolean removeItem(E x) {
	//***************Write your code in the below******************//
		boolean exist = false;
		Node<E> currNode = head.next;
		int index = 0;
		for(int i = 0; i < numItems; i++){
			if(currNode.item.equals(x)){
				exist = true;
				index = i;
				break;
			}
			currNode = currNode.next;
		}
		if(exist){
			remove(index);
		}
		return exist;
	//*************************************************************//
	}

	// Implementation of get(): Retrieving an item at the 'index' position from the list
	// Return null if attempting to access an index that is out of bounds (exception)
	// Return the element at the specified index in other cases
	public E get(int index) {
	//***************Write your code in the below******************//
		if (index < 0 || index >= numItems){
			return null;
		}
		return getNode(index).item;
	//*************************************************************//
	}

	// Implementation of set(): Replacing an item at the 'index' position in the list with x
	// Return -1 if attempting to access an index that is out of bounds (exception)
	// Return 0 after the set operation in other cases
	public int set(int index, E x) {
	//***************Write your code in the below******************//
		if (index < 0 || index >= numItems){
			return -1;
		}
		getNode(index).item = x;
		return 0;
	//*************************************************************//
	}

	// Implementation of indexOf(): Determining the position of element x in the list
	// Return -1 if the element does not exist in the list
	// Return the index of the element if it exists in other cases
	public int indexOf(E x) {
	//***************Write your code in the below******************//
		for(int i = 0; i < numItems; i++){
			if(getNode(i).item.equals(x)){
				return i;
			}
		}
		return -1;
	//*************************************************************//
	}
	
	// Implementation of len(): Retrieving the total number of elements in the list
	// Return the total number of elements in the list
	public int len() {
	//***************Write your code in the below******************//
		return numItems;
	//*************************************************************//
	}
	
	// Implementation of isEmpty(): Checking if the list is empty
	// Return true if the list is empty
	// Return false otherwise
	public boolean isEmpty() {
	//***************Write your code in the below******************//
		return (numItems == 0);
	//*************************************************************//
	}

	// Implementation of clear(): Cleaning the list thoroughly
	// Empty the entire list
	public void clear() {
	//***************Write your code in the below******************//
		numItems = 0;
		head = new Node<>(null, null);
	//*************************************************************//
		
	}
	
	///////////////////////////////////////////////////////////////////////
	public String printAll() {
		Node<E> t;
		// System.out.print("Print list (#items=" + numItems + ") ");
		// for(t=head.next; t != null; t = t.next) {
		// 	System.out.print(t.item + " ");
		// }
		// System.out.println();

		String print_all = "Print list (#items=" + numItems + ") ";
		for(t=head.next; t != null; t = t.next) 
			print_all += t.item + " ";
		System.out.println(print_all);
		return print_all;

	}
} 
