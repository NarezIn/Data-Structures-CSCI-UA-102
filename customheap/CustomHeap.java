package customheap;

public class CustomHeap<E extends Comparable> implements PQInterface<E> {
	private E[] A;
	private int numItems;

	// Constructor 1: Creating an empty heap.
	public CustomHeap(int arraySize) {
		A = (E[]) new Comparable[arraySize];
		numItems = 0;
	}

	// Constructor 2: Creating a heap using the given array.
	public CustomHeap(E[] B, int numElements) {
		A = B; 
		numItems = numElements;
	}

	// Implementation of insert(): Inserting newItem to the heap
	// You should consider using percorlateUp() function
	// Return -1 if an exception occurs when inserting newItem into the heap
	// Return 0 after the insert() operation in other cases
	public int insert(E newItem) {
	//***************Write your code in the below******************//
		if (numItems == A.length) {
			return -1;
		}
		A[numItems] = newItem;
		percolateUp(numItems);
		numItems++;
		return 0;
	//*************************************************************//
	} 

	// Implementation of percolateUp()
	// Adjust the elements starting from A[i] to satisfy the heap property
	// The elements in A[0...i-1] are already satisfying the heap property
	// You need to implement this function using a recursive approach
	private void percolateUp(int i) {
	//***************Write your code in the below******************//
		//if k is the parent node, 2k + 1 is the first child node, 2k + 2 is the second child.
		int parent = (i - 1) / 2;
		E temp;
		if(i > 0 && (int) A[i] > (int) A[parent]){
			temp = A[i];
			A[i] = A[parent];
			A[parent] = temp;
			percolateUp(parent);
		}
	//*************************************************************//
	}

	// Implementation of deleteMax(): Deleting a root node from the heap
	// You should consider using percolateDown() function
	// Return the maximum value if the operation is successful 
	// Return null if an exception occurs
	public E deleteMax() {
	//***************Write your code in the below******************//
		if (numItems == 0) {
			return null;
		}
		E maxi = A[0];
		A[0] = A[numItems - 1];
		numItems--;
		percolateDown(0);
		return maxi;
	//*************************************************************//
	}
	
	// Implementation of percolateDown(): Inserting newItem to the heap
	// Percolating down A[i] to become the root in A[0...numItems-1]
	// You need to implement this function using a recursive approach
	private void percolateDown(int i) {
	//***************Write your code in the below******************//
		int child = i * 2 + 1;
		E temp;
		if(child <= numItems - 1) {
			/* if child2 is larger than child1, we percolate down child1*/
			if (child + 1 <= numItems - 1 && (int) A[child] < (int) A[child + 1]) {
				child = child + 1;
			}
			if ((int) A[i] < (int) A[child]) {
				temp = A[i];
				A[i] = A[child];
				A[child] = temp;
				percolateDown(child);
			}
		}
	//*************************************************************//
	}
	
	// Implementation of buildHeap():  Building a new heap
	// Note that array A[] is already initialized by a Constructor
	// You need to implement this function using percolateDown()
	public void buildHeap() {
	//***************Write your code in the below******************//
		for (int i = (numItems - 1) / 2; i >= 0; i--) {
			percolateDown(i);
		}
	//*************************************************************//
	}
	
	// Implementation of max(): Getting the maximum value from the heap
	// You should consider using percolateDown() function
	// Return the maximum value if the operation is successful 
	// Return null if an exception occurs
	public E max() {
	//***************Write your code in the below******************//
		if (numItems == 0) {
			return null;
		}
		return A[0];
	//*************************************************************//
	}

	// Implementation of isEmpty(): Checking if the heap is empty
	// Return true if the heap is empty
	// Return false otherwise
	public boolean isEmpty() { 
	//***************Write your code in the below******************//
		return numItems == 0;
	//*************************************************************//
	}

	// Implementation of clear(): Clear the heap
	public void clear() {
	//***************Write your code in the below******************//
		A = (E[]) new Comparable[A.length];
		numItems = 0;
	//*************************************************************//
    }

	//////////////////////////////////////////////////
	public String heapPrint() {
		String print_all = "Print list (#items=" + numItems + ") ";
		for(int i=0; i<=numItems-1; i++) {
			print_all += A[i] + " ";
		}
		return print_all;
	}

} 
