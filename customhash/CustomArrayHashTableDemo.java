package customhash;

public class CustomArrayHashTableDemo {

	public static void main(String[] args) {
		System.out.println("Array Hash Table!");
		CustomArrayHashTable h = new CustomArrayHashTable(17); 

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
		h.insert(17);
		h.delete(40);
		System.out.println("  40 Deleted!");
		h.delete(17);
		System.out.println("  17 Deleted!");
		h.printAll();

		// expected outputs of the above code are as below //

		/*
		Array Hash Table!
		13 items inserted!
		Slots:
		0: null
		1: 40
		2: 80
		3: 15
		4: 30
		5: 5
		6: null
		7: 20
		8: 86
		9: null
		10: 10
		11: 75
		12: 90
		13: 77
		14: 38
		15: 49
		16: null
		75 Deleted!
		40 Deleted!
		17 Deleted!
		Slots:
		0: null
		1: -12345
		2: 80
		3: 15
		4: 30
		5: 5
		6: -12345
		7: 20
		8: 86
		9: null
		10: 10
		11: -12345
		12: 90
		13: 77
		14: 38
		15: 49
		16: null
		*/
		
		
		Integer key = 755;
		Integer slot = h.search(key);
		if (slot == CustomArrayHashTable.NOT_FOUND)
			System.out.println("Search Failed for " + key); // expected output : "Search Failed for 755"
		else 
			System.out.println("Successful search for " + h.getItem(slot));
		key = 75;
		slot = h.search(key);
		if (slot == CustomArrayHashTable.NOT_FOUND)
			System.out.println("Search Failed for " + key); // expected output : "Search Failed for 75"
		else 
			System.out.println("Successful search for " + h.getItem(slot));
		key = 38;
		slot = h.search(key);
		if (slot == CustomArrayHashTable.NOT_FOUND)
			System.out.println("Search Failed for " + key);
		else 
			System.out.println("Successful search for " + h.getItem(slot)); // expected output : "Successful search for 38"
		key = 5;
		slot = h.search(key);
		if (slot == CustomArrayHashTable.NOT_FOUND)
			System.out.println("Search Failed for " + key);
		else 
			System.out.println("Successful search for " + h.getItem(slot)); // expected output : "Successful search for 5"
	}

}
