/*
 * Platform      : LeetCode
 * Problem No.   : 1038
 * Problem Name  : Binary Search Tree to Greater Sum Tree
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Perform an inorder traversal of the BST and store the
 *    node references in an ArrayList.
 * 2. Inorder traversal of a BST gives the nodes in ascending order.
 * 3. Reverse the ArrayList to get the nodes in descending order.
 * 4. Traverse the reversed list and maintain a cumulative sum.
 * 5. Replace each node's value with the sum of all values greater
 *    than or equal to the current node's original value.
 * 6. Return the original root after updating all node values.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * Concepts Used:
 * - Binary Search Tree
 * - Inorder Traversal
 * - Recursion
 * - ArrayList
 * - Reverse Traversal
 * - Prefix/Cumulative Sum
 *
 * Key Learning:
 * In a BST, inorder traversal gives values in ascending order.
 * Reversing the inorder sequence allows us to process nodes from
 * largest to smallest, so a running sum can be used to construct
 * the Greater Sum Tree.
 */


class Solution {

    public void inorder(TreeNode root,ArrayList<TreeNode> arr){
        if(root == null) return;
        inorder(root.left,arr);
        arr.add(root);
        inorder(root.right,arr);
    }
    public TreeNode bstToGst(TreeNode root) {
       ArrayList<TreeNode> arr = new ArrayList<>();
       inorder(root,arr);

       Collections.reverse(arr);
       int sum = 0;

       for(int i=0; i<arr.size(); i++){
        int value = arr.get(i).val;
        sum += value;
        arr.get(i).val = sum;

       }

       return root;
    }
}
