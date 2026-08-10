/*
 * Platform      : LeetCode
 * Problem No.   : 236
 * Problem Name  : Lowest Common Ancestor of a Binary Tree
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Start from the root and check whether p and q are present
 *    in the left subtree.
 * 2. If both p and q are in the left subtree, recursively move
 *    to the left subtree.
 * 3. If both p and q are not in the left subtree, they must be
 *    in the right subtree, so recursively move to the right.
 * 4. If one node lies in the left subtree and the other lies
 *    in the right subtree, the current root is their LCA.
 * 5. If the current root is p or q, return the current root.
 *
 * The exists() helper function checks whether a target node
 * exists in a given subtree.
 *
 * Time Complexity : O(N^2) in the worst case
 * Space Complexity: O(H)
 *   - H is the height of the tree due to recursion.
 *
 * Concepts Used:
 * - Binary Tree
 * - Depth First Search (DFS)
 * - Recursion
 * - Lowest Common Ancestor
 *
 * Key Learning:
 * At every node, determine where p and q lie:
 * - Both left  -> move left
 * - Both right -> move right
 * - One on each side -> current node is the LCA
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return root;

        if(root == p || root == q) return root;

        boolean pLiesInLeft = exists(root.left,p);
        boolean qLiesInLeft = exists(root.left,q);

        if(pLiesInLeft && qLiesInLeft) return lowestCommonAncestor(root.left, p,q);

        else if(!pLiesInLeft && !qLiesInLeft) return lowestCommonAncestor(root.right, p,q);

        else return root;


    }

    private boolean exists(TreeNode root, TreeNode target){
        if(root == null) return false;
        if(root == target) return true;
        return exists(root.left, target) || exists(root.right,target);

    }
}
