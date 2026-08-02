/*
 * Platform      : LeetCode
 * Problem No.   : 107
 * Problem Name  : Binary Tree Level Order Traversal II
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Perform a normal Level Order Traversal using BFS and a Queue.
 * 2. Traverse the tree level by level.
 * 3. Store each level in the answer list.
 * 4. After the traversal is complete, reverse the outer list
 *    using Collections.reverse(ans) to obtain the bottom-up order.
 *
 * Alternative Approach:
 * - Insert each level at the beginning of the answer list
 *   using ans.add(0, level), which avoids reversing at the end.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * Concepts Used:
 * - Binary Tree
 * - Breadth First Search (BFS)
 * - Queue
 * - Level Order Traversal
 * - Collections.reverse()
 */

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size() > 0){

            int size = q.size();

            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode front = q.remove();
                level.add(front.val);

                if(front.left != null)
                    q.add(front.left);

                if(front.right != null)
                    q.add(front.right);
            }

            ans.add(level);
        }

        Collections.reverse(ans);

        return ans;
    }
}
