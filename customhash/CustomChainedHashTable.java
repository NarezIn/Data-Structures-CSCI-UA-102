package customhash;

public class CustomChainedHashTable implements IndexInterface_list {	
	// Note that our hash table is implemented as Integer LinkedList using LinkList class
	private LinkedList<Integer>[] table;
	int numItems = 0;

	//This is global variable representing NOT_FOUND. 
	// Please use it directly in your function implementation.
	public final int NOT_FOUND = -12345;
	
	// Constructor 1: Creating an empty linked hash table with the size of n.
	public CustomChainedHashTable(int n) {
		table = (LinkedList<Integer>[]) new LinkedList[n]; 
		for (int i = 0; i < n; i++)
			table[i] = new LinkedList<>();
		numItems = 0;
	} 
	
	// Hash function: we only considr this hash function for implementation
	// Please do not modify this function
	// below is the hash function of h(x) = x % m, where m is the size of hash table
	private int hash(Integer x) {                         
		return x % table.length; 
	}
	
	// Implementation of insert(): Inserting a key value with x into the hash table
	// If there is space in the hash table, use the hash function to obtain the hash value 
	// and store 'x' at the appropriate position in the hash table.
	// Consider to use add() operation in LinkList
	public void insert(Integer x) {	
	//***************Write your code in the below******************//
		table[hash(x)].add(0, x);
		numItems++;
	//*************************************************************//
	}
	
	// Implementation of search(): Searching a key value with x from the hash table
	// If the key value being searched for does not exist in the hash table, return null.
	// If it does exist, return the index where the key value is located.
	// To get the index of node with x in LinkedList, consider to use indexof() function.
	// To get the value of node with x, consider to use getNode() function
	public Node search(Integer x) {
	//***************Write your code in the below******************//
		int hashValue = hash(x);
		if(table[hashValue].isEmpty()){
			return null;
		}
		else{
			int index = table[hashValue].indexOf(x);
			//if the chain exist but maybe the value is not in the chain
			if(index == NOT_FOUND){
				return null;
			}
			else{
				return table[hashValue].getNode(index);
			}
		}
		//Question: do we return the hashValue or the index in the chain??
	//*************************************************************//
	}
	
	// Implementation of delete(): Deleteting a key value with x from the hash table
	// If the key value 'x' exists in the hash table, delete it.
	// Don't forget to store the global variable DELETED in the position 
	// where it was deleted to indicate that it has been removed.
	public void delete(Integer x) {
	//***************Write your code in the below******************//
		int hashValue = hash(x);
		if(!table[hashValue].isEmpty()){
			table[hashValue].removeItem(x); //do we need to indicate DELETED in LL?
			numItems--;
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
		table = (LinkedList<Integer>[]) new LinkedList[table.length];
		for (int i = 0; i < table.length; i++)
			table[i] = new LinkedList<>();
		numItems = 0;
	//*************************************************************//
	}

	//////////////////////////////////////////////

	public void printAll() {
		for (int i=0; i < table.length; i++) {
			System.out.print("Slot " + i + " : ");
			table[i].printAll();
		}
	}
} // 코드 12-1
