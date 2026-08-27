/*
 * Platform      : LeetCode
 * Problem No.   : 938
 * Problem Name  : Range Sum of BST
 * Difficulty    : Easy
 *
 * Approach:
 * 1. Use recursion to traverse the Binary Search Tree.
 * 2. If the current node is null, return 0.
 * 3. If the current node's value lies within the range [low, high],
 *    add its value to the sum and recursively check both subtrees.
 * 4. If root.val is smaller than low, then all nodes in the left
 *    subtree will also be smaller than low because of the BST property.
 *    Therefore, skip the left subtree and move to the right.
 * 5. If root.val is greater than high, then all nodes in the right
 *    subtree will also be greater than high.
 *    Therefore, skip the right subtree and move to the left.
 *
 * Time Complexity : O(N) in the worst case
 * Space Complexity: O(H)
 *   - H is the height of the BST due to recursion.
 *
 * Concepts Used:
 * - Binary Search Tree
 * - Recursion
 * - DFS
 * - BST Property
 * - Range Query
 *
 * Key Learning:
 * The BST property allows us to skip entire subtrees that cannot
 * contain values within the given range, making the traversal more
 * efficient than blindly visiting every node.
 */


class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        if(root.val >= low && root.val <= high){
            return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
        }

        if(root.val < low){
            return rangeSumBST(root.right,low,high);
        }

        return rangeSumBST(root.left,low,high);

    }
 }
