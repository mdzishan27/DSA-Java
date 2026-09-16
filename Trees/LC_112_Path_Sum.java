/*
    Problem: Path Sum
    Difficulty: Easy

    Intuition:
    We need to check if there is a root-to-leaf path whose
    values add up to targetSum.

    Approach:
    1. If root is null, there is no path, so return false.
    2. If the current node is a leaf, check whether its value
       is equal to targetSum.
    3. Subtract the current node's value from targetSum.
    4. Recursively check both left and right subtrees.
    5. If either subtree finds a valid path, return true.

    Why check leaf node?
    The path must end at a leaf, so reaching a node with no
    left and right children is where we check the remaining sum.

    How it works:
    targetSum = targetSum - root.val

    This keeps track of the sum still needed as we move down
    the tree.

    Key Idea:
    At every node, subtract its value from targetSum and
    continue searching until a leaf is reached.

    Time: O(n)
    Space: O(h)  // Recursion stack
*/


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)  return false;

        if(root.left == null && root.right == null){
            if(targetSum == root.val)  return true;
            else return false;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
