/*
 * Platform      : LeetCode
 * Problem No.   : 102
 * Problem Name  : Binary Tree Level Order Traversal
 * Difficulty    : Medium
 *
 * Approach:
 * 1. If the tree is empty, return an empty list.
 * 2. Use a Queue to perform Breadth First Search (BFS).
 * 3. Traverse the tree level by level.
 * 4. For each level:
 *      - Store the current queue size.
 *      - Process exactly 'size' nodes.
 *      - Add their values to a temporary list.
 *      - Push their left and right children into the queue.
 * 5. Add the completed level to the final answer.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * Concepts Used:
 * - Binary Tree
 * - Breadth First Search (BFS)
 * - Queue
 * - Level Order Traversal
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size() > 0){

            int size = q.size();

            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode node = q.remove();
                level.add(node.val);

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }

            result.add(level);
        }

        return result;
    }
}
