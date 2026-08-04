/*
 * Platform      : LeetCode
 * Problem No.   : 101
 * Problem Name  : Symmetric Tree
 * Difficulty    : Easy
 *
 * Approach:
 * 1. Check if the root is null. If yes, the tree is symmetric.
 * 2. Recursively compare the left and right subtrees.
 * 3. Two nodes are symmetric if:
 *      - Both nodes are null.
 *      - Both nodes have the same value.
 *      - Left subtree of the first node is symmetric with the right subtree of the second node.
 *      - Right subtree of the first node is symmetric with the left subtree of the second node.
 * 4. Return true only if all mirror comparisons are true.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(H)
 *   - O(log N) for a balanced tree.
 *   - O(N) in the worst case for a skewed tree.
 *
 * Concepts Used:
 * - Binary Tree
 * - Recursion
 * - Depth First Search (DFS)
 * - Mirror Tree
 */


class Solution {
     
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }
   boolean helper (TreeNode r1,TreeNode r2){
        if(r1 == null && r2 == null)  return true;
        if((r1 == null || r2 == null) || (r1.val != r2.val))
        return  false;
        return helper (r1.left,r2.right) && helper(r1.right,r2.left);
    }
}
