package custombst;

public class selfTest2 {

    public static void main(String[] args) {
        System.out.println("Binary Search Tree!");
        System.out.println("Self Test");
        CustomBinarySearchTree bst1 = new CustomBinarySearchTree();
        bst1.insert(10);
        bst1.insert(20);

        bst1.delete(10);
        bst1.insert(30);
        bst1.delete(10);
        bst1.delete(30);
        bst1.delete(20);
    }
}
