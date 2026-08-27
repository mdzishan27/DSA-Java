/*
 * Platform      : LeetCode
 * Problem No.   : 235
 * Problem Name  : Lowest Common Ancestor of a Binary Search Tree
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Use the Binary Search Tree property to determine the
 *    direction in which p and q can be found.
 * 2. If both p and q have values smaller than the current root,
 *    their LCA must be in the left subtree.
 * 3. If both p and q have values greater than the current root,
 *    their LCA must be in the right subtree.
 * 4. Otherwise, p and q are on different sides of the current
 *    root, or the current root is p or q. Therefore, the current
 *    root is their Lowest Common Ancestor.
 *
 * Time Complexity : O(H)
 * Space Complexity: O(H)
 *   - H is the height of the BST due to recursion.
 *
 * Concepts Used:
 * - Binary Search Tree
 * - Recursion
 * - BST Property
 * - Lowest Common Ancestor
 *
 * Key Learning:
 * Unlike a normal Binary Tree, a BST provides an ordering property.
 * By comparing p.val and q.val with root.val, we can directly
 * decide whether to move left or right without searching both
 * subtrees.
 */



class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return root;

        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }

        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        else return root;
       
    }

    
}
