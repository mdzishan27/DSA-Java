/*
Intuition:

- For every node, we need to check whether its value is equal to
  the average of all values in its subtree.
- So for each node, find:
    1. Sum of all nodes in its subtree.
    2. Number of nodes in its subtree.
- Then calculate:
      average = sum / count
- If root.val == average, increase the result by 1.

Approach:

1. Use a class-level `result` variable:
      int result = 0;

   - It is kept outside the recursive solve() method so it does not
     reset to 0 during every recursive call.
   - Whenever a node satisfies the condition, do:
      result += 1;

2. For every node, call findSum():
      int sum = findSum(root, count);

   - findSum() recursively traverses the complete subtree.
   - It adds every node's value to calculate the subtree sum.
   - At the same time, count[0] is increased for every node.

3. Use an array for count:
      int[] count = {0};

   - Java passes primitive int by value, so changing an int inside
     findSum() would not update the original count.
   - Using an array allows us to modify count[0] and see the updated
     value after recursion.

4. Calculate the average:
      sum / count[0]

5. Check:
      if(root.val == sum / count[0])

   - If true, the current node satisfies the condition.
   - Increase result by 1.

6. Recursively check the left and right subtrees:
      solve(root.left);
      solve(root.right);

   - This repeats the same process for every node in the tree.

7. In averageOfSubtree():
   - Reset result to 0.
   - Start the recursive process using solve(root).
   - Return the final result.

Key Idea:
For every node, independently calculate its entire subtree's
sum and count, then check whether the node's value equals the
subtree average.

This is a brute-force approach because the same nodes can be
traversed multiple times while calculating the subtree information.

Time Complexity: O(n²) in the worst case
Space Complexity: O(n) due to recursion stack
*/

class Solution {

    int result = 0;

    private int findSum(TreeNode root, int[] count){
        if(root == null) return 0;
        count[0]++;

        int lstSum = findSum(root.left,count);
        int rstSum = findSum(root.right,count);

        return lstSum + rstSum + root.val;
    }

    private void solve(TreeNode root){
        if(root == null) return;

        int[] count = {0};

        int sum = findSum(root,count);

        if(root.val == sum/count[0]){
            result += 1;

        }

        solve(root.left);
        solve(root.right);

    }

    

   
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }
}
