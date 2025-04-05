package customhash;

public class CustomChainedHashTableDemo {
	public static void main(String[] args) {
		System.out.println("ChainedHashTable!~!!");
		CustomChainedHashTable h = new CustomChainedHashTable(11); 
		h.insert(10);
		h.insert(20);
		h.insert(5);
		h.insert(80);
		h.insert(90);
		h.insert(75);
		h.insert(86);
		h.insert(30);
		h.insert(77);
		h.insert(15);
		h.insert(40);
		h.insert(38);
		h.insert(49);
		System.out.println(" 13 items inserted!");
		h.printAll();
		h.delete(75);
		System.out.println("  75 Deleted!");
		h.delete(40);
		System.out.println("  40 Deleted!");
		h.printAll();


		// expected outputs of the above code are as below //

		/*
		ChainedHashTable!~!!
		13 items inserted!
		Slot 0 : Print list (#items=1) 77 
		Slot 1 : Print list (#items=0) 
		Slot 2 : Print list (#items=1) 90 
		Slot 3 : Print list (#items=1) 80 
		Slot 4 : Print list (#items=1) 15 
		Slot 5 : Print list (#items=3) 49 38 5 
		Slot 6 : Print list (#items=0) 
		Slot 7 : Print list (#items=1) 40 
		Slot 8 : Print list (#items=1) 30 
		Slot 9 : Print list (#items=3) 86 75 20 
		Slot 10 : Print list (#items=1) 10 
		75 Deleted!
		40 Deleted!
		Slot 0 : Print list (#items=1) 77 
		Slot 1 : Print list (#items=0) 
		Slot 2 : Print list (#items=1) 90 
		Slot 3 : Print list (#items=1) 80 
		Slot 4 : Print list (#items=1) 15 
		Slot 5 : Print list (#items=3) 49 38 5 
		Slot 6 : Print list (#items=0) 
		Slot 7 : Print list (#items=0) 
		Slot 8 : Print list (#items=1) 30 
		Slot 9 : Print list (#items=2) 86 20 
		Slot 10 : Print list (#items=1) 10 
		*/
		
		int key = 755;
		Node<Integer> nd = h.search(key);
		if (nd == null)
			System.out.println("Search Failed for " + key); // expected output : "Search Failed for 755"
		else 
			System.out.println("Successful search for " + nd.item);
		key = 75; nd = h.search(key);
		if (nd == null)
			System.out.println("Search Failed for " + key); // expected output : "Search Failed for 75"
		else 
			System.out.println("Successful search for " + nd.item);
		key = 38; nd = h.search(key);
		if (nd == null)
			System.out.println("Search Failed for " + key);
		else 
			System.out.println("Successful search for " + nd.item); // expected output : "Successful search for 38"
		key = 5; nd = h.search(key);
		if (nd == null)
			System.out.println("Search Failed for " + key);
		else 
			System.out.println("Successful search for " + nd.item); // expected output : "Successful search for 5"

		h.clear();
		h.insert(33);
		h.clear();
	}


} 
