package customhash;

public class CustomArrayHashTable implements IndexInterface{
	private Integer table[]; // Integer hash table
	int numItems;

	//These  are global variables representing DELETE and NOT_FOUND. 
	// Please use them directly in your function implementation.
	static final Integer DELETED = -12345, NOT_FOUND = -1; 
	
	// Constructor 1: Creating an empty array hash table with the size of n.
	public CustomArrayHashTable(int n) {
		table = new Integer[n];
		numItems = 0;
	 	for(int i = 0; i < n; i++) table[i] = null;
	}

	// Hash function: we only considr this hash function for implementation
	// Please do not modify this function
	// As a open adressing method, we use Linear Probing h_i(x)=(h(x) + ai + b)
	// Below is the simple implementation of it where h(x) = x%13, and a = 1 and b = 0.
	private int hash(int i, Integer x) {
		return (x%13 + i) % table.length;
	}
	
	// Implementation of insert(): Inserting a key value with x into the hash table
	// If the hash table is full, handle the exception by returning -1 instead of increasing the size.
	// If there is space in the hash table, use the hash function to obtain the hash value 
	// and store 'x' at the appropriate position in the hash table. And then return 0.
	public int insert(Integer x) {
	//***************Write your code in the below******************//
		if(numItems == table.length) {
			return -1;
		}
		int hashValue;
		for (int i = 0; i < table.length; i++) {
			hashValue = hash(i, x);
			if(table[hashValue] == null) {
				table[hashValue] = x;
				numItems++;
				break;
			}
		}
		return 0;
	//*************************************************************//
	} 
 
	// Implementation of search(): Searching a key value with x from the hash table
	// If the key value being searched for does not exist in the hash table, return the global variable NOT_FOUND.
	// If it does exist, return the index where the key value is located.
	public Integer search(Integer x) {
	//***************Write your code in the below******************//
		int hashValue;
		for (int i = 0; i < table.length; i++) {
			hashValue = hash(i, x);
			if(table[hashValue] != null && table[hashValue].equals(x)) {
				return hashValue;
			}
		}
		return NOT_FOUND;
	//*************************************************************//
	}
	
	// Implementation of delete(): Deleteting a key value with x from the hash table
	// If the key value 'x' exists in the hash table, delete it.
	// Don't forget to store the global variable DELETED in the position 
	// where it was deleted to indicate that it has been removed.
	public void delete(Integer x) {
	//***************Write your code in the below******************//
		int hashValue;
		for (int i = 0; i < table.length; i++) {
			hashValue = hash(i, x);
			if(table[hashValue].equals(x)) {
				table[hashValue] = DELETED;
				numItems--;
				break;
			}
		}
	//*************************************************************//
	}

	// Implementation of isEmpty(): check whether the hash table is empty
 	public boolean isEmpty() {
	//***************Write your code in the below******************//
		return numItems == 0;
	//*************************************************************//
 	}
	
	// Implementation of clear(): Clear the hash table
 	public void clear() {
	//***************Write your code in the below******************//
		table = new Integer[table.length];
		numItems = 0;
		for(int i = 0; i < table.length; i++) table[i] = null;
		//*************************************************************//
 	 }
	
	public Integer getItem(Integer i) {
		return table[i];
	}


	//////////////////////////////////////////////////
	public void printAll() {
		System.out.println("Slots:"); 
		for (int i=0; i < table.length; i++) {
			System.out.println("   " + i + ": " + table[i]);
		}
	}
} // 코드 12-3
