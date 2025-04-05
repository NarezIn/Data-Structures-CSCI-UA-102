package customlist;

public class CustomLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("Linked List Demo!");
		CustomLinkedList<Integer> list = new CustomLinkedList<>();

		// add()
		list.add(0, 300);  
		list.add(0, 200);
		list.add(0, 100); 
		list.printAll(); // expected output: "Print list (#items=3) 100 200 300"

		// append()
		list.append(500);
		list.append(600); 
		list.printAll(); // expected output: "Print list (#items=5) 100 200 300 500 600"

		// remove()
		list.remove(3); 
		list.printAll(); // expected output: "Print list (#items=4) 100 200 300 600"

		// add()
		list.add(3, 250);
		list.add(1, 50);
		list.add(0, 10); 
		list.printAll(); // expected output: "Print list (#items=7) 10 100 50 200 300 250 600"

		// append()
		list.append(700); 
		list.printAll(); // expected output: "Print list (#items=8) 10 100 50 200 300 250 600 700"

		// remove() and removeItem
		list.remove(1);
		list.removeItem(600); 
		list.printAll(); // expected output: "Print list (#items=6) 10 50 200 300 250 700"

		// get()
		Integer num1 = list.get(1); 
		System.out.println("get(1) : " + num1); // expected output: "get(1) : 50"

		// set()
		list.set(1, 123); 
		list.printAll(); // expected output: "Print list (#items=6) 10 123 200 300 250 700"

		list.remove(2, 4);
		list.printAll();
		/*
		// indextOf()
		int num2 = list.get(1); 
		System.out.println("indextOf(1) : " + num2); // expected output: "indextOf(1) : 123"

		// len()
		int num3 = list.len(); 
		System.out.println("len() : " + num3); // expected output: "len() : 6"

		// isEmpty()
		boolean bool1 = list.isEmpty(); 
		System.out.println("isEmpty() : " + bool1); // expected output: "isEmpty() : false"

		// clear()
		list.clear(); 
		list.printAll(); // expected output: "Print list (#items=0)"

		// isEmpty()
		boolean bool2 = list.isEmpty(); 
		System.out.println("isEmpty() : " + bool2); // expected output: "isEmpty() : true"

		 */
	}
} 
