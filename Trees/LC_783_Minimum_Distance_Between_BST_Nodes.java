// Approach : Inorder Traversal
// Inorder traversal of a BST gives nodes in sorted order.
// the minimum distance will always be between two consecutive nodes.
// Compare each node with the previous node to find the minimum difference.
// prev stores the previously visited node.
// We use Integer prev so that null can represent "no previous node" initially.
// min stores the smallest difference found so far.

// Time: O(n)
// Space: O(h), where h is the height of the BST.


class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(prev != null){
            min = Math.min(min,root.val-prev);
        }

        prev = root.val;

        inorder(root.right);
    }
}
