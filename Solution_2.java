import java.util.*;

public class Solution_2 {

    int A[];

    public Solution_2(int B[]) {
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
        for(int i = A.length; i > 1; i--) { //not "-1" would cause indexError
            for(int j = 0; j < i - 1; j++){ /* check the for loop range later */
                if(A[j] > A[j+1]){
                    tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
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
        for(int i = A.length - 1; i > 1; i--){
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
        int largest = 0;
        // ----------------- write your code here ----------------- //
        int largestItem = 0;
        //last the index of the current indices, last may change for each iteration.
        for(int i = 0; i < last; i++) {
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
        int position = 0;
        return position;
        // -------------------------------------------------------- //
    }

    public static void main(String[] args) {
        Solution_2 arr = new Solution_2(new int[]{4, 5, 1, 3, 2});
        //4, 2, 1, 3, 5
        //3, 2, 1, 4, 5
        //1, 2, 3, 4, 5
        arr.selectionSort();
        System.out.println(Arrays.toString(arr.A));

    }

}