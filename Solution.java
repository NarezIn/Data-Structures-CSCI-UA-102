import java.util.*;
public class Solution {
    /* freely add functions to solve the problem */
    /* but do not change the name of class, the type of class and the type of solution function */
    /* if you want, you can use Node.java */

    int[][] result;

    public class TreeNode {
        int x, y, index;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int newKey) {//delete later
            index = newKey;
        }

        public TreeNode(int indexPosi, int x_value, int y_value) {
            index = indexPosi;
            x = x_value;
            y = y_value;
        }
    }

    public class BinaryTree{
        public TreeNode root;

        public BinaryTree(){
            root = null;
        }

        public void insert(TreeNode newbie){
            if(root == null){
                root = newbie;
            }
            else{
                TreeNode curr = root;
                while(true){
                    if(newbie.x < curr.x){
                        if(curr.left == null){
                            curr.left = newbie;
                            break;
                        }
                        curr = curr.left;
                    }
                    else{
                        if(curr.right == null){
                            curr.right = newbie;
                            break;
                        }
                        curr = curr.right;
                    }
                }
            }
        }

        /* Traversal of this tree in preOrder.
           Return a list with this tree in preOrder.
         */
        public void preOrder(TreeNode curr, List<Integer> construct){
            if(curr != null){
                construct.add(curr.index);
                preOrder(curr.left, construct);
                preOrder(curr.right, construct);
            }
        }

        /* Traversal fo this tree in postOrder.
           Return a list with this tree in postOrder.
         */
        public void postOrder(TreeNode curr, List<Integer> construct){
            if(curr != null){
                postOrder(curr.left, construct);
                postOrder(curr.right, construct);
                construct.add(curr.index);
            }
        }
    }


    /* Please do not modify the input (int[][]) and output variable (int[][]) of the solution() function. */
    public int[][] solution(int[][] nodeinfo) {
        /* Sort this 2d array, nodeinfo. */
        TreeNode[] nodeArr = new TreeNode[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeArr[i] = new TreeNode(i + 1, nodeinfo[i][0], nodeinfo[i][1]);//i or i + 1
        }

        /* Override the Arrays.sort() method.
           This function would compare two nodes, based on their x and y coordinates.
           For y coordinates, the TreeNode with bigger y should be in the front. (Descending order)
           For x coordinates, the TreeNode with smaller x should be in the front. (Ascending order)
         */
        Arrays.sort(nodeArr, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode n1, TreeNode n2) {
                if(n1.y == n2.y){
                    return n1.x - n2.x; //+ means dsc, - means as. X should be asc.
                }
                else{
                    return n2.y - n1.y; //+ means as, - means dsc. Y should be dsc.
                }
            }
        });

        /* Construct the BST based on the sorted Array<TreeNode>. */
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < nodeArr.length; i++) {
            tree.insert(nodeArr[i]);
        }

        List<Integer> preOrdered = new ArrayList<>();
        List<Integer> postOrdered = new ArrayList<>();
        tree.preOrder(tree.root, preOrdered);
        tree.postOrder(tree.root, postOrdered);
        result = new int[2][nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++){
            result[0][i] = preOrdered.get(i);
            result[1][i] = postOrdered.get(i);
        }
        return result;
    }

    public static TreeNode[] preOrder(TreeNode[] arr){
        TreeNode[] preOrdered = new TreeNode[arr.length];
        return preOrdered;
    }

    public static void main(String[] args)
    {
        int[][] input1 = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

        int[][] answer1;

        Solution s = new Solution();
        answer1 = s.solution(input1);

        System.out.println("answer1: " + Arrays.deepToString(answer1)); // Expected output: [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
    }
}
