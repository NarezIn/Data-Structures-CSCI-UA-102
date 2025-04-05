package customlist;

public class CustomArrayList<E>{

	private E item[];
	private int numItems;
	
	private static final int DEFAULT_CAPACITY = 10;
 
	// Constructor 1: Creating an ArrayList with DEFAULT_CAPACITY.
	public CustomArrayList() { 					
		item = (E[]) new Object[DEFAULT_CAPACITY];	
		numItems = 0;
	}

	// Constructor 2: Creating an ArrayList of size n.
	public CustomArrayList(int n) {			
		item = (E[]) new Object[n];		
		numItems = 0;
	}	
	
	// Implementation of add(): Inserting element x at the 'index' position in the array list
	// Return -1 if an exception occurs when inserting an element into the list
	// Return 0 after the add() operation in other cases
	public int add(int index, E x) {
	//***************Write your code in the below******************//
		if(index > numItems || index < 0 || numItems >= item.length){
			return -1;
		}
		for(int i = numItems - 1; i >= index; i--){
			item[i + 1] = item[i];
		}
		item[index] = x;
		numItems++;
		return 0;
	//*************************************************************//
	}
	
	// Implementation of append(): Adding an element to the end of the array list
	// Return -1 if an exception occurs when inserting an element into the list
	// Return 0 after the add() operation in other cases
	public int append(E x) {
	//***************Write your code in the below******************//
		if(numItems >= DEFAULT_CAPACITY){
			return -1;
		}
		item[numItems] = x;
		numItems++;
		return 0;
	//*************************************************************//
	}
	
	// Implementation of remove(): Deleting an element at the 'index' position from the array list
	// Return null if an exception occurs when deleting an element from the list
	// Return the removed element after the remove() operation in other cases
	public E remove(int index) {
	//***************Write your code in the below******************//
		if(index < 0 || index >= numItems){
			return null;
		}
		E hold = item[index];
		for(int i = index; i < numItems - 1; i++) {
			item[i] = item[i + 1];
		}
		numItems--;
		return hold;
	//*************************************************************//
	}

	// Implementation of removeItem(): Removing element x from the array list
	// If there are multiple elements of the same value 'x', 
	// only the one closest to the index '0' will be removed.
	// Return false if element x does not exist in the list
	// Return true after the removal operation if x exists
	public boolean removeItem(E x) {
	//***************Write your code in the below******************//
		boolean exist = false;
		int index = 0;
		for(int i = 0; i < numItems; i++){
			if(item[i].equals(x)){
				exist = true;
				index = i;
				break;
			}
		}
		if(exist){
			for(int j = index; j < numItems - 1; j++){
				item[j] = item[j + 1];
			}
		}
		numItems--;
		return exist;
	//*************************************************************//
	}

	// Implementation of get(): Retrieving an element at the 'index' position from the list
	// The first element is labeled as the 0-th element
	// Return null if attempting to access an index that is out of bounds (exception)
	// Return the element at the specified index in other cases
	public E get(int index) {
		//***************Write your code in the below******************//
		if(index < 0 || index > numItems){
			return null;
		}
		return item[index];
		//*************************************************************//
	}

	// Implementation of set(): Replacing an element at the 'index' position in the array list with x
	// Return -1 if attempting to access an index that is out of bounds (exception)
	// Return 0 after the set operation in other cases
	public int set(int index, E x) {
		//***************Write your code in the below******************//
		if(index < 0 || index > numItems){
			return -1;
		}
		item[index] = x;
		return 0;
		//*************************************************************//
	}

	// Implementation of indexOf(): Determining the position of element x in the array list
	// Return -1 if the element does not exist in the list
	// Return the index of the element if it exists in other cases
	public int indexOf(E x) {
		//***************Write your code in the below******************//
		int index = -1;
		for(int i = 0; i < numItems; i++){
			if(item[i].equals(x)){
				index = i;
			}
		}
		return index;
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
		item = (E[]) new Object[DEFAULT_CAPACITY];
		numItems = 0;
		return;
		//*************************************************************//
	}

	public String printAll() {
		// System.out.print("Print list (#items=" + numItems + ") ");
		// for(int i = 0; i < numItems; i++)
		// 	System.out.print(item[i] + " ");
		String print_all = "Print list (#items=" + numItems + ") ";
		for(int i = 0; i < numItems; i++)
			print_all += item[i] + " ";
		System.out.println(print_all);
		return print_all;
	}
} 
