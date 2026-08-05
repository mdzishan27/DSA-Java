/*
 * Platform      : LeetCode
 * Problem No.   : 110
 * Problem Name  : Balanced Binary Tree
 * Difficulty    : Easy
 *
 * Approach:
 * 1. Use Depth First Search (DFS) to compute the height of each subtree.
 * 2. For every node, calculate the height of its left and right subtrees.
 * 3. If the height difference is greater than 1, the tree is not balanced.
 * 4. Return the height of the current subtree to its parent.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(H)
 *   - H is the height of the tree.
 *
 * Concepts Used:
 * - Binary Tree
 * - Depth First Search (DFS)
 * - Recursion
 * - Height Calculation
 *
 * Key Learning:
 * A bottom-up DFS allows us to compute subtree heights while
 * simultaneously checking the balance condition at every node.
 */


class Solution {
    static boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        flag = true;
        levels(root);
        return flag;
    }

    public int levels(TreeNode root){
        if(root == null) return 0;

        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);

        if(Math.abs(leftLevels - rightLevels) > 1){
            flag = false;
        }

        return 1 + Math.max(leftLevels,rightLevels);
    }
}
