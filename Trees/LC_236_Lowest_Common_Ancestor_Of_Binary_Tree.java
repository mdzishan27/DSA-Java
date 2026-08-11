/*
 * Platform      : LeetCode
 * Problem No.   : 236
 * Problem Name  : Lowest Common Ancestor of a Binary Tree
 * Difficulty    : Medium
 *
 * Approach 1:Using Subtree search
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





/*
 * ============================================================
 * Approach 2: Optimized DFS
 * ============================================================
 *
 * Approach:
 * 1. Use Depth First Search (DFS) to search for p and q.
 * 2. If the current node is null, return null.
 * 3. If the current node is p or q, return the current node.
 * 4. Recursively search the left and right subtrees.
 * 5. If both left and right return a non-null node, it means
 *    p and q are found on different sides of the current node.
 *    Therefore, the current node is their Lowest Common Ancestor.
 * 6. If only one side returns a non-null node, return that node.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(H)
 *   - H is the height of the tree due to recursion.
 *
 * Key Learning:
 * The return value of each recursive call tells us whether
 * p or q was found in that subtree.
 *
 * - left != null && right != null → current node is LCA
 * - left == null → return right
 * - right == null → return left
 *
 * This approach visits each node only once and avoids the
 * repeated subtree searches used in Approach 1.
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return root;

        if(root == p || root == q) return root;

        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);

        if(l != null  && r != null) {

            return root;
        }

        if(l == null) return r;
        else return l;
        

    }

    
}

