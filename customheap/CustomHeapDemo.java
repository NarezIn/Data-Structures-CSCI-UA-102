package customheap;

public class CustomHeapDemo {

	public static void main(String[] args) {
		CustomHeap<Integer> h = new CustomHeap<>(5);
		h.insert(1);
		h.insert(10);
		h.insert(30);
		System.out.println(h.heapPrint());

		h.clear();
		h.insert(10);
		h.insert(30);
		h.insert(20);
		h.insert(40);
		System.out.println(h.heapPrint());

		System.out.println("deleteMax(): " + h.deleteMax()); //deleteMax(): 40"
		h.insert(1);
		System.out.println(h.heapPrint());

		System.out.println("deleteMax(): " + h.deleteMax()); //deleteMax(): 30"

		System.out.println(h.heapPrint()); //expected output: "PrintAll: 20 10 1

	  }
} 
