package custombst;

import java.util.Arrays;

public class CustomBinarySearchTreeDemo {
	public static void main(String[] args) {
		System.out.println("Binary Search Tree!");
		CustomBinarySearchTree bst1 = new CustomBinarySearchTree(); 
		bst1.insert(50);
		bst1.insert(10);
		bst1.insert(60);
		bst1.insert(55);
		bst1.insert(70);
		bst1.insert(65);
		bst1.insert(67);
		bst1.delete(60);
		System.out.println(Arrays.toString(bst1.printPreOrder().toArray())); //expected output: "[10, 5, 20, 15, 80, 75, 40, 77, 90, 301]"
		Integer del1 = 20;
		bst1.delete(del1); System.out.println(del1 + " Deleted!"); //expected output: "20 Deleted!"
		System.out.println(Arrays.toString(bst1.printPreOrder().toArray())); //expected output: "[10, 5, 40, 15, 80, 75, 77, 90, 301]"
		Integer del2 = 20;
		bst1.delete(del2); System.out.println(del2 + " Deleted!"); //expected output: "20 Deleted!"
		System.out.println(Arrays.toString(bst1.printPreOrder().toArray())); //expected output: "[10, 5, 40, 15, 80, 75, 77, 90, 301]"
		
		Integer tmp = 755;
		TreeNode res = bst1.search(tmp);
		if(res ==  null) {
			System.out.println("Search for " + tmp + " failed" ); //expected output: "Search for 755 failed"
		} else {
			System.out.println("Search for " + tmp + " returned the node of " + res.key);	
		}
		tmp = 5;
		res = bst1.search(tmp);
		if(res ==  null) {
				System.out.println("Search for " + tmp + " Failed");
		} else {
			System.out.println("Search for " + tmp + " returned the node of " + res.key); //expected output: "Search for 5 returned the node of 5"
		}
	}
} 
