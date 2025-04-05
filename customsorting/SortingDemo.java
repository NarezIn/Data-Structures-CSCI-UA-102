package customsorting;

public class SortingDemo {
	
	static final int NUM_SCALE = 10000;
    static final int SIZE = 1000; // size of array
    static final int PRINTLEN = 10; // print length

    public static void main(String[] args) {

		// set random array A

		int[] A = new int[SIZE];
		System.out.println("Unsorted data");
		prepare(A);
	    printA(A,PRINTLEN);
		System.out.println("");
		System.out.println("");

		// copy the array A and sort it
		// the result of a sorted array should be same for all sorting alogirthms
		
		int[] A1 = A.clone();
		System.out.println("Bubble sort");
	    Sorting s1 = new Sorting(A1);
		final long startTime1 = System.nanoTime();
	    s1.bubbleSort();
		final long elapsedTimeMillis1 = System.nanoTime() - startTime1;
	    printA(A1,PRINTLEN);
		System.out.println("");
		System.out.println("Implementation time: " + elapsedTimeMillis1 + "ns");
		System.out.println("");


		int[] A2 = A.clone();
		System.out.println("Selection sort");
	    Sorting s2 = new Sorting(A2);
		final long startTime2 = System.nanoTime();
	    s2.selectionSort();
		final long elapsedTimeMillis2 = System.nanoTime() - startTime2;
	    printA(A2,PRINTLEN);
		System.out.println("");
		System.out.println("Implementation time: " + elapsedTimeMillis2 + "ns");
		System.out.println("");

		int[] A3 = A.clone();
		System.out.println("Insertion sort");
	    Sorting s3 = new Sorting(A3);
		final long startTime3 = System.nanoTime();
	    s3.insertionSort();
		final long elapsedTimeMillis3 = System.nanoTime() - startTime3;
	    printA(A3,PRINTLEN);
		System.out.println("");
		System.out.println("Implementation time: " + elapsedTimeMillis3 + "ns");
		System.out.println("");

		int[] A4 = A.clone();
		System.out.println("Merge sort");
	    Sorting s4 = new Sorting(A4);
		final long startTime4 = System.nanoTime();
	    s4.mergeSort();
		final long elapsedTimeMillis4 = System.nanoTime() - startTime4;
	    printA(A4,PRINTLEN);
		System.out.println("");
		System.out.println("Implementation time: " + elapsedTimeMillis4 + "ns");
		System.out.println("");

		int[] A5 = A.clone();
		System.out.println("Quck sort");
	    Sorting s5 = new Sorting(A5);
		final long startTime5 = System.nanoTime();
	    s5.quickSort();
		final long elapsedTimeMillis5 = System.nanoTime() - startTime5;
	    printA(A5,PRINTLEN);
		System.out.println("");
		System.out.println("Implementation time: " + elapsedTimeMillis5 + "ns");
		System.out.println("");

    }

    public static void prepare(int A[]) {
    	for(int i=0; i<A.length; i++) {
    		A[i] = (int)(NUM_SCALE*Math.random()); 
    	}
    }

    public static void printA(int A[], int printLen) {
		if (printLen == 0){
				
			for(int i=0; i<A.length; i++) {
				System.out.print(A[i]+ " ");
			}
		}
		else{

			for(int i=0; i<printLen; i++) {
				System.out.print(A[i]+ " ");
			}
		}
    }
    
} 

