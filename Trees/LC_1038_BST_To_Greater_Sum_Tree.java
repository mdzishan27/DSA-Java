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


/*
 * Platform      : LeetCode
 * Problem No.   : 1038
 * Problem Name  : Binary Search Tree to Greater Sum Tree
 * Difficulty    : Medium
 *
 * Approach:optimised
 * 1. Use Reverse Inorder Traversal (Right -> Root -> Left).
 * 2. Since the tree is a BST, reverse inorder visits the nodes
 *    from largest value to smallest value.
 * 3. Maintain a running sum using an integer array.
 * 4. Add the current node's value to sum[0].
 * 5. Update the current node's value with the running sum.
 * 6. Continue the traversal for the remaining smaller values.
 *
 * Why int[] sum?
 * Java passes primitive values by value. Using an integer array
 * allows all recursive calls to share and update the same sum[0].
 *
 * Time Complexity : O(N)
 * Space Complexity: O(H)
 *   - H is the height of the tree due to recursion.
 *
 * Concepts Used:
 * - Binary Search Tree
 * - Reverse Inorder Traversal
 * - Recursion
 * - Cumulative Sum
 * - Array
 *
 * Key Learning:
 * Reverse inorder traversal processes the largest values first,
 * so a running sum can be maintained to update each node with
 * the sum of itself and all greater values.
 *
 * Optimization:
 * Unlike the previous ArrayList approach, this solution does not
 * store all nodes. It directly updates each node during traversal,
 * reducing the extra space from O(N) to O(H).
 */


class Solution {
    
    public void revInorder(TreeNode root,int[] sum){
        if(root == null) return;

        revInorder(root.right,sum);
        sum[0] += root.val;
        root.val = sum[0];
    
        
        revInorder(root.left,sum);

    }
    public TreeNode convertBST(TreeNode root) {
        int[] sum = {0};
        revInorder(root,sum);
        return root;
    }
}
