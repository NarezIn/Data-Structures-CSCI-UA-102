package customsorting;

import java.util.Arrays;

public class Sorting {

	int A[];

	public Sorting(int B[]) {
		A = B;
	}
	
	// Please write code in the given function to complete the bubble sort.
	// Utilize the 'swapped' variable to check whether any element swaps occur in the for-loop.
	// This will enable achieving the best-case time complexity of 'n'.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	public void bubbleSort() {
		int tmp = 0;
		boolean swapped;
		// ----------------- write your code here ----------------- //
		/* dont forget to optimize */
		for(int i = A.length; i > 1; i--) { //not "-1" would cause indexError
			swapped = false;
            for(int j = 0; j < i - 1; j++){ /* check the for loop range later */
                if(A[j] > A[j+1]){
                    tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
					swapped = true;
                }
            }
			if(!swapped){
				break;
			}
        }
		// -------------------------------------------------------- //
	}

	// Please complete the selection sort by writing code in the given function.
	// Implement it using the theLargest function, which finds the largest number A[k] among A[0,...,last].
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	public void selectionSort() {
		int k; int tmp;
		// ----------------- write your code here ----------------- //
		// using theLargest()
		for(int i = A.length - 1; i >= 1; i--){
            k = theLargest(i);
            tmp = A[i];
            A[i] = A[k];
            A[k] = tmp;
        }
		// -------------------------------------------------------- //
	}
	
	// Implement the theLargest function that returns the index of the largest element in the array A[0...last].
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private int theLargest(int last) {
		int largest = 0; //the index
		// ----------------- write your code here ----------------- //
		int largestItem = A[0];
        //last the index of the current indices, last may change for each iteration.
        for(int i = 1; i <= last; i++) {
            if(A[i] > largestItem) {
                largestItem = A[i];
                largest = i;
            }
        }
        //return the index of the largest.
		// -------------------------------------------------------- //
		return largest;
	}
	
	
	// Write code in the provided function to complete the insertion sort.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	public void insertionSort() {
		// ----------------- write your code here ----------------- //
		/* the front part is sorted array. The latter one is unsorted. */
		int curr, j;
		for(int i = 1; i < A.length; i++){ //to iterate through this array
			curr = A[i];
			j = i - 1;
			while(j >= 0 && curr < A[j]){
				A[j + 1] = A[j]; //left shift if current item is smaller
				j--;
			}
			//swap
			A[j + 1] = curr;
		}
		// -------------------------------------------------------- //
	}
	
	// write code in the functions mSort() and merge() to complete the merge sort.
	public void mergeSort() { 
		int[] B = new int[A.length];
		mSort(0, A.length-1, B);
	}
	
	// write code in the given function to complete the mSort() function.
	// The mSort function should be structured as follows:
	// First, calculate the midpoint between p and r.
	// Second, perform sorting on the first half.
	// Third, perform sorting on the second half.
	// Finally, merge the results using the merge() function.
	// Notably, the second and third steps should be implemented as recursive calls to mSort().
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private void mSort(int p, int r, int[] B) { 
		if (p < r) {
		// ----------------- write your code here ----------------- //
			int q = (r - p) / 2 + p; // -1 or +1, or not?
			mSort(p, q, B);
			mSort(q + 1, r, B);
			merge(p, q, r, B);
            System.arraycopy(B, p, A, p, r - p + 1);
			//B is the source array, p is the starting point, r-p is the ending point.
		// -------------------------------------------------------- //
		} 
	}

	// Write code in the provided function to complete the merge() function.
	// Merge the arrays A[p, ..., q] and A[q+1, ..., r] to create a sorted array A[p, ..., r]. 
	// Note that A[p, ..., q] and A[q+1, ..., r] are already sorted.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private void merge(int p, int q, int r, int[] B) {
	// ----------------- write your code here ----------------- //
		int i = p, j = q + 1, t = p;
		/* i is the start of the first half. j is the start of the second half.
		   t is the current index of array B.
		 */
		while(i <= q && j <= r){
			if(A[i] < A[j]){
				B[t] = A[i];
				t++;
				i++;
			}
			else{
				B[t] = A[j];
				t++;
				j++;
			}
		}

		//Add the rest of the subarray.
		int k = i > q ? j : i;
		int end = k == j ? r : q;
		while(k <= end){
			B[t] = A[k];
			k++;
			t++;
		}

		/*
		int[] temp = new int[r - p + 1];
		while(i <= q && j <= r){
			if(A[i] < A[j]){
				temp[t] = A[i];
				t++;
				i++;
			}
			else{
				temp[t] = A[j];
				t++;
				j++;
			}
		}

		//Add the rest of the subarray.
		int k = i > q ? j : i;
		int end = k == j ? r : q;
		while(k <= end){
			temp[t] = A[k];
			k++;
			t++;
		}
		//Copy items from temp to B.

		for(int l = 0; l < t; l++){
			B[l + p] = temp[l];
		}
		//or:
		//System.arraycopy(temp, 0, B, p, t);

		 */
	// -------------------------------------------------------- //
	}

	// Write code in the functions qSort() and partition() to complete the quicksort.
	public void quickSort() {
			qSort(0, A.length-1);
	}

	// Write code in the given function to complete the qSort() function.
	// The qSort function should be structured as follows:
	// First, the partition() function returns the pivot element q.
	// Second, sort the left sub-array using p and q.
	// Third, sort the right sub-array using q and r.
	// Notably, the second and third steps should be implemented as recursive calls to qSort().
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private void qSort(int p, int r) {
		if (p < r) {
		// ----------------- write your code here ----------------- //
			int q = partition(p, r); //pivot
			qSort(p, q - 1);
			qSort(q + 1, r);
		// -------------------------------------------------------- //
		}
	}
	
	// The partition() function rearranges the elements of the array A[p, ..., r] on either side 
	// based on their relative sizes compared to the pivot element A[r]. 
	// It then returns the position where the pivot element is placed.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private int	partition(int p, int r) {	
	// ----------------- write your code here ----------------- //
		int position, i = p - 1, j = p;
		// i is the end of the left subarray. (smaller than the pivot).
		// j is the start of the right subarray. (larger than the pivot).
		int temp; //for swap
		while(j < r){
			if(A[j] < A[r]){
				i++;
				temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
			j++;
		}
		position = i + 1; //the pivot middle point
		temp = A[position];
		A[position] = A[r];
		A[r] = temp;
		return position;
	// -------------------------------------------------------- //
	}

	public static void main(String[] args) {
		int[] A3 = {15, 8, 21, 37, 46, 66, 69, 74, 89, 91};
		System.out.println("Selection sort");
		Sorting s3 = new Sorting(A3);
		s3.selectionSort();
		System.out.println(Arrays.toString(A3));

	}
	
} 
