// Approach:
// Insert the given value into the BST using recursion.
// LeetCode guarantees that val does not already exist in the BST,
// so no duplicate-value check is required.
//
// If the tree is empty, create a new node and return it.
// Otherwise, compare val with the current node:
// - If val > root.val, move to the right subtree.
// - If val < root.val, move to the left subtree.
// When the required child is null, insert the new node there.
//
// Time Complexity: O(h), where h is the height of the BST.
// Space Complexity: O(h) due to recursion.


class Solution {
    private void attach(TreeNode root,int val){
        if(root == null) return ;
        if(root.val < val){
            if(root.right == null) root.right = new TreeNode(val);
            else attach(root.right,val);
        }

        else {
            if(root.left == null) root.left = new TreeNode(val);
            else attach(root.left,val);
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            return new TreeNode(val);
        }

        attach(root,val);

        return root;

    }
}
