package custombst;

import java.util.Arrays;

public class selfTest {
    public static void main(String[] args) {
        System.out.println("Binary Search Tree!");
        System.out.println("Self Test");
        CustomBinarySearchTree bst1 = new CustomBinarySearchTree();
        bst1.insert(10);
        bst1.insert(20);
        bst1.insert(5);
        bst1.insert(80);
        bst1.insert(90);
        bst1.insert(75);
        bst1.insert(301);
        bst1.insert(77);
        bst1.insert(15);
        bst1.insert(40);
        bst1.insert(40); //duplicate
        bst1.insert(40); //duplicate
        bst1.insert(40); //duplicate
        bst1.insert(40); //duplicate
        bst1.insert(40); //duplicate
        bst1.insert(40); //duplicate
        bst1.insert(12);
        bst1.insert(17);
        bst1.insert(41);
        System.out.println(Arrays.toString(bst1.printPreOrder().toArray())); //expected output: "[10, 5, 20, 15, 80, 75, 40, 77, 90, 301]"
        Integer del1 = 20;
        bst1.delete(del1);
        System.out.println(del1 + " Deleted!"); //expected output: "20 Deleted!"
        bst1.delete(5);
        bst1.delete(90);
        bst1.delete(30);

        System.out.println(Arrays.toString(bst1.printPreOrder().toArray()));
    }
}
