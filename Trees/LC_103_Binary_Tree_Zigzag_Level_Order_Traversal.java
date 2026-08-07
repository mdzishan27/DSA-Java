/*
 * Platform      : LeetCode
 * Problem No.   : 103
 * Problem Name  : Binary Tree Zigzag Level Order Traversal
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Perform Level Order Traversal (BFS) using a Queue.
 * 2. Process one level at a time.
 * 3. Maintain a boolean flag (leftToRight) to track traversal direction.
 * 4. If leftToRight is true, add nodes normally.
 * 5. Otherwise, insert each node at index 0 to reverse the level order.
 * 6. After processing each level, toggle the direction using:
 *      leftToRight = !leftToRight;
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * Concepts Used:
 * - Binary Tree
 * - Breadth First Search (BFS)
 * - Queue
 * - Zigzag Level Order Traversal
 *
 * Key Learning:
 * The queue order should always remain left-to-right.
 * Zigzag traversal is achieved by changing how values are
 * stored in the current level, not by changing the queue order.
 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while(q.size() > 0){
            int size = q.size();

            List<Integer> levels = new ArrayList<>();

            for(int i=0; i<size; i++){

                TreeNode front = q.remove();

                if(leftToRight){
                    levels.add(front.val);
                } else {
                    levels.add(0,front.val);
                }

              if(front.left != null) q.add(front.left);
              if(front.right != null) q.add(front.right);

               
            }

            ans.add(levels);

            leftToRight = !leftToRight;
            
        }

               
        return ans;

    }
}
