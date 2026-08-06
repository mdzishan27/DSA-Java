/*
 * Platform      : LeetCode
 * Problem No.   : 958
 * Problem Name  : Check Completeness of a Binary Tree
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Perform Level Order Traversal (BFS) using a Queue.
 * 2. Traverse every node from left to right.
 * 3. Add both left and right children to the queue,
 *    even if they are null.
 * 4. Once the first null node is encountered, set a flag
 *    (foundNull = true).
 * 5. If any non-null node is found after foundNull becomes true,
 *    the tree is not complete, so return false.
 * 6. If the traversal finishes without violating this rule,
 *    return true.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * Concepts Used:
 * - Binary Tree
 * - Breadth First Search (BFS)
 * - Queue
 * - Complete Binary Tree
 *
 * Key Learning:
 * During level order traversal, once the first null node is
 * encountered, every remaining node must also be null.
 * If a non-null node appears after a null node, the tree
 * is not a Complete Binary Tree.
 */

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean foundNull = false;

        while(q.size() > 0){
           TreeNode front = q.remove();


           if(front == null) {
            foundNull = true;
            continue;
           } 

            if(foundNull)  return false;

            q.add(front.left);
            q.add(front.right);

           
        }

        return true;

        
    }
}
