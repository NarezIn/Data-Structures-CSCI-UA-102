package customavl;

import custombst.CustomBinarySearchTree;
import custombst.TreeNode;

import java.util.List;
import java.util.ArrayList;

public class CustomAVLTree implements IndexInterface<AVLNode>{
	private AVLNode root;

	// NIL is a special node in AVLTree that represents a NULL node with null values for item, right, and left attributes. 
	// However, it has a height of 0. 
	// This node is typically used as the root node for an empty tree or as a leaf node. 
	// In AVLTree implementation, we need to use this node as a leaf node or the root node for an empty node, 
	// because setting a leaf node as null (not a NULL node) would prevent us from calculating the height of its parent node.
	static final AVLNode NIL = new AVLNode(null, null, null, 0);

	public List<Comparable> tree_print;
	
	// Constructor 1: Creating an empty AVLTree.
	public CustomAVLTree() {
 		root = NIL;
 	} 
 
	// Implementation of search(): Searching searchKey in the AVLTree
 	public AVLNode search(Comparable x) {
 		return searchItem(root, x);
 	}

	// Implement the searchItem function using the searchItem function recursively.
	// Perform a recursive search on the left and right subtrees based on key value comparisons.
	// Return null if the search fails.
	// If the search is successful, return the corresponding node.
 	private AVLNode searchItem(AVLNode tNode, Comparable x) {
	//***************Write your code in the below******************//
		if(tNode == null || tNode == NIL){
			return NIL; //or return null; or return tNode???
		}
		else if(x.compareTo(tNode.item) == 0){
			return tNode;
		}
		else if(x.compareTo(tNode.item) < 0){
			return searchItem(tNode.left, x);
		}
		else{
			return searchItem(tNode.right, x);
		}
	//*************************************************************//
 	} 
  
	// Implementation of insert(): Inserting a node with newKey into the AVLTree
 	public void insert(Comparable x) {
	//***************Write your code in the below******************//
		root = insertItem(root, x);
	//*************************************************************//
 	}
 
	// Implement the insertItem function using the insertItem function recursively.
	// Perform a recursive search on the left and right subtrees based on key value comparisons.
	// When reaching a leaf node (or it is empty tree), create a new node and return that node.
	// Followings steps should be additionally considered for AVLTree.
	// 1) Upon adding a node, it's crucial to recalculate the height of certain nodes.
	// 2) Furthermore, this function needs to assess whether the subtree rooted at tNode is balanced or not.
 	private AVLNode insertItem(AVLNode tNode, Comparable x) {
	//***************Write your code in the below******************//
		if(tNode == NIL || tNode == null){
			tNode = new AVLNode(x, NIL, NIL, 1); //would h always be 0??
			return tNode;
		}
		else if(x.compareTo(tNode.item) < 0){
			tNode.left = insertItem(tNode.left, x);
		}
		else{
			tNode.right = insertItem(tNode.right, x);
		}
		tNode.height = Math.max(tNode.left.height, tNode.right.height) + 1;
		int type = needBalance(tNode);
		if(type != NO_NEED){
			tNode = balanceAVL(tNode, type);
		}
		return tNode;
		//check the modifying height and balance later
	//*************************************************************//
 	} 
 	
	// Implementation of delete(): Deleting a node with searchKey from the AVLTree
 	public void delete(Comparable x) {
	//***************Write your code in the below******************//
		if(root.height == 1){
			root = NIL;
		}
		root = deleteItem(root, x);
	//*************************************************************//
 	}
	
	// Implement the deleteItem function using the deleteItem function recursively.
	// Perform a recursive search on the left and right subtrees based on key value comparisons.
	// Return null if the search fails.
	// If the search is successful, call deleteNode function.
	// Finally, deleteItem return the root node after recursive calls.
	// Followings steps should be additionally considered.
	// Followings steps should be additionally considered for AVLTree.
	// 1) Upon deleting a node, it's crucial to recalculate the height of certain nodes.
	// 2) Furthermore, this function needs to assess whether the subtree rooted at tNode is balanced or not.
 	private AVLNode deleteItem(AVLNode tNode, Comparable x) {
	//***************Write your code in the below******************//
		if(tNode == null || tNode == NIL || x == null){
			return NIL; //or NIL??
		}
		else if(x.compareTo(tNode.item) < 0){
			tNode.left = deleteItem(tNode.left, x);
		}
		else if(x.compareTo(tNode.item) > 0) {
			tNode.right = deleteItem(tNode.right, x);
		}
		else{
			tNode = deleteNode(tNode);
			return tNode;
		}
		tNode.height = Math.max(tNode.left.height, tNode.right.height) + 1;
		int type = needBalance(tNode);
		if (type != NO_NEED) {
			tNode = balanceAVL(tNode, type);
		}
		return tNode;
	//*************************************************************//
 	}
 	
	// To implement deleteNode, consider three cases
	// 1. if tNode is a leaf node
	// 2. if tNode has only one child node.
	// 3. if tNode has two child nodes.
	// For the case 3, call deleteMinItem function to delete the node which has two child nodes.
	// Followings steps should be additionally considered for AVLTree.
	// 1) Upon deleting a node, it's crucial to recalculate the height of certain nodes.
	// 2) Furthermore, this function needs to assess whether the subtree rooted at tNode is balanced or not.
 	private AVLNode deleteNode(AVLNode tNode){
	//***************Write your code in the below******************//
		if(tNode.left == NIL && tNode.right == NIL){
			return NIL;
		}
		else if(tNode.left == NIL){
			return tNode.right;
		}
		else if(tNode.right == NIL){
			return tNode.left;
		}
		else{
			CustomAVLTree.returnPair p = deleteMinItem(tNode.right);
			tNode.item = p.getItem();
			tNode.right = p.getNode();
			tNode.height = Math.max(tNode.left.height, tNode.right.height) + 1;
			int type = needBalance(tNode);
			if(type != NO_NEED){
				tNode = balanceAVL(tNode, type);
			}
			//tNode.height = Math.max(tNode.left.height, tNode.right.height) + 1;

			return tNode;
		}
	//*************************************************************//
 	}
 	 
	// Implement the deleteMinItem function using the returnPair function below
	// Implement the deleteMinItem function using the deleteminItem function recursively.
	// Refer to the pseudo code on the lecture slide.
	// Followings steps should be additionally considered for AVLTree.
	// 1) Upon deleting a node, it's crucial to recalculate the height of certain nodes.
	// 2) Furthermore, this function needs to assess whether the subtree rooted at tNode is balanced or not.
 	private returnPair deleteMinItem(AVLNode tNode) {
	//***************Write your code in the below******************//
		if(tNode.left == NIL){
			return new returnPair(tNode.item, tNode.right);
		}
		else{
			returnPair p = deleteMinItem(tNode.left);
			Comparable minItem = p.getItem();
			AVLNode node = p.getNode();
			tNode.left = node;

			tNode.height = Math.max(tNode.left.height, tNode.right.height) + 1;
			int type = needBalance(tNode);
			if(type != NO_NEED){
				tNode = balanceAVL(tNode, type);
			}
			//tNode.height = Math.max(tNode.left.height, tNode.right.height) + 1;

			return new returnPair(minItem, tNode);
		}
	//*************************************************************//
 	}
 	
 	private class returnPair {
 		private Comparable item;
 		private AVLNode node;
 		private returnPair(Comparable it, AVLNode nd) {
 			item = it;
 			node = nd;
 		}
		private Comparable getItem(){
			return item;
		}
		private AVLNode getNode(){
			return node;
		}
 	}

 	// Implementation of balanceAVL()
	// This function addresses the four cases of imbalance in a subtree with node t as the root.
	// You must implement a solution for each case using the rightRotate or leftRotate functions.
 	private AVLNode balanceAVL(AVLNode tNode, int type) {
	//***************Write your code in the below******************//
		if(type == LL){
			tNode = rightRotate(tNode);
		}
		else if(type == LR){
			tNode.left = leftRotate(tNode.left);
			tNode = balanceAVL(tNode, LL);
		}
		else if(type == RR){
			tNode = leftRotate(tNode);
		}
		else if(type == RL){
			tNode.right = rightRotate(tNode.right);
			tNode = balanceAVL(tNode, RR);
		}
		return tNode;//check this later.
	//*************************************************************//
 	}
 	
 	// Implementation of leftRotate()
 	private AVLNode leftRotate(AVLNode t) {
	//***************Write your code in the below******************//
		AVLNode RChild= t.right;
		/*
		 Check the positions of these four lines later.
		 */
		AVLNode RLChild = RChild.left;
		t.right = RLChild;//you swapped this two lines' position
		RChild.left = t;
		t.height = Math.max(t.left.height, t.right.height) + 1;
		RChild.height = Math.max(RChild.left.height, RChild.right.height) + 1;
		return RChild;
	//*************************************************************//
 	}
 
 	// Implementation of rightRotate()
 	private AVLNode rightRotate(AVLNode t) {
	//***************Write your code in the below******************//
		AVLNode LChild= t.left;
		AVLNode LRChild = LChild.right;
		t.left = LRChild;//you swapped this two lines' position
		LChild.right = t;
		t.height = Math.max(t.left.height, t.right.height) + 1;
		LChild.height = Math.max(LChild.left.height, LChild.right.height) + 1;
		return LChild;
	//*************************************************************//
 	}
 
	// Static variables on the types of imbalance
 	private final int LL = 1, LR =2, RR = 3, RL = 4, NO_NEED = 0, ILLEGAL = -1;
	
	// Implementation of needBalance()
	// This function determines the type of imbalance for a given node t.
	// There are four cases of imbalance in a subtree with node t as the root.
	// The function returns one of the static variables: 'LL, LR, RR, RL, NO_NEED, ILLEGAL', as described above.
 	private int needBalance(AVLNode t) {
	//***************Write your code in the below******************//
		//may raise nullpointer exception.
		int leftHeight = (t.left != null && t.left != NIL) ? t.left.height : 0;
		int rightHeight = (t.right != null && t.right != NIL) ? t.right.height : 0;

		if (rightHeight - leftHeight <= -2) {
			int leftRightHeight = (t.left.right != null && t.left.right != NIL) ? t.left.right.height : 0;
			int leftLeftHeight = (t.left.left != null && t.left.left != NIL) ? t.left.left.height : 0;
			if (leftRightHeight - leftLeftHeight <= -1) {
				return LL;
			} else {
				return LR;
			}
		} else if (rightHeight - leftHeight >= 2) {
			int rightRightHeight = (t.right.right != null && t.right.right != NIL) ? t.right.right.height : 0;
			int rightLeftHeight = (t.right.left != null && t.right.left != NIL) ? t.right.left.height : 0;
			if (rightRightHeight - rightLeftHeight >= 1) {
				return RR;
			} else {
				return RL;
			}
		}
		return NO_NEED;
	//*************************************************************//
 	}
 	
	// Implementation of isEmpty(): Checking if the AVLTree is empty
	// Return true if the AVLTree is empty
	// Return false otherwise
 	public boolean isEmpty() {
	//***************Write your code in the below******************//
		return root == NIL; //check later
	//*************************************************************//
 	}
 
	// Implementation of clear(): Clear the AVLTree
 	public void clear() {
	//***************Write your code in the below******************//
		root = NIL;
	//*************************************************************//
 	 }

	/////////////////////////////////////////////////////
	
	public List printPreOrderKey() {
		tree_print = new ArrayList<Comparable>();
		prPreOrderKey(root);
		return tree_print;
	}
	public void prPreOrderKey(AVLNode tNode) {
		if (tNode != NIL) {
			// System.out.println(tNode.key);
			tree_print.add(tNode.item);
			prPreOrderKey(tNode.left);
			prPreOrderKey(tNode.right);
		}
	}
	public List printPreOrderHeight() {
		tree_print = new ArrayList<Comparable>();
		prPreOrderHeight(root);
		return tree_print;
	}
	public void prPreOrderHeight(AVLNode tNode) {
		if (tNode != NIL) {
			// System.out.println(tNode.key);
			tree_print.add(tNode.height);
			prPreOrderHeight(tNode.left);
			prPreOrderHeight(tNode.right);
		}
	}
}