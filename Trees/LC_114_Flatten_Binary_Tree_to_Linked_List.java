/*
 * Platform      : LeetCode
 * Problem No.   : 114
 * Problem Name  : Flatten Binary Tree to Linked List
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Perform a Preorder Traversal (Root -> Left -> Right)
 *    using DFS and store all nodes in an ArrayList.
 * 2. The preorder traversal gives the required order of
 *    nodes in the flattened tree.
 * 3. Traverse the ArrayList and connect each node to the
 *    next node using the right pointer.
 * 4. Set the left pointer of every node to null.
 * 5. The final tree becomes a right-skewed linked list.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * Concepts Used:
 * - Binary Tree
 * - Depth First Search (DFS)
 * - Preorder Traversal
 * - ArrayList
 * - Tree Pointer Manipulation
 *
 * Key Learning:
 * Preorder traversal gives the exact order required for
 * the flattened tree:
 *
 * Root -> Left -> Right
 *
 * Each node's left pointer is set to null and its right
 * pointer is connected to the next node in preorder.
 */


class Solution {
    public void flatten(TreeNode root) {

        if(root == null) return;
        ArrayList<TreeNode> arr = new ArrayList<>();
        dfs(root,arr);

        for(int i=0; i<arr.size()-1; i++){
            TreeNode a = arr.get(i);
            TreeNode b = arr.get(i+1);

            a.right = b;
            a.left = null;
        }

        TreeNode last = arr.get(arr.size()-1);
        last.right = null;
        last.left = null;
        
    }

    private void dfs(TreeNode root,  ArrayList<TreeNode> arr){
        if(root == null) return;

        arr.add(root);
        dfs(root.left,arr);
        dfs(root.right,arr);

        
    }
}
