/*
 * Platform      : LeetCode
 * Problem No.   : 513
 * Problem Name  : Find Bottom Left Tree Value
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Use Breadth First Search (BFS) with a Queue.
 * 2. Traverse the tree level by level from left to right.
 * 3. For every level, the first node processed (i == 0)
 *    is the leftmost node of that level.
 * 4. Store its value in 'ans'.
 * 5. Since the levels are processed from top to bottom,
 *    the last updated value of 'ans' will be the leftmost
 *    value of the last level.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * Concepts Used:
 * - Binary Tree
 * - Breadth First Search (BFS)
 * - Queue
 * - Level Order Traversal
 *
 * Key Learning:
 * In BFS, nodes at each level are processed from left to right.
 * Therefore, the first node of every level is its leftmost node.
 * By updating the answer at i == 0, the final answer becomes
 * the leftmost node of the bottom-most level.
 */


class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int ans = root.val;

        while(q.size() > 0){
            int size = q.size();

            for(int i=0; i<size; i++){

                TreeNode front = q.remove();

                if(i == 0){
                    ans = front.val;
                }

                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);

            }

            
        }

        return ans;


    }
}
