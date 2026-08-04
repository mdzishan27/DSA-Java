/*
 * Platform      : LeetCode
 * Problem No.   : 257
 * Problem Name  : Binary Tree Paths
 * Difficulty    : Easy
 *
 * Approach:
 * 1. Use Depth First Search (DFS) with Backtracking.
 * 2. Maintain the current path from the root to the current node.
 * 3. Add the current node to the path while traversing.
 * 4. When a leaf node is reached:
 *      - Convert the current path into the required string format
 *        (e.g., "1->2->5").
 *      - Store the string in the answer list.
 * 5. Recursively explore the left and right subtrees.
 * 6. Backtrack by removing the last node from the path before returning.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(H)
 *   - H is the height of the tree.
 *
 * Concepts Used:
 * - Binary Tree
 * - Depth First Search (DFS)
 * - Recursion
 * - Backtracking
 * - Root to Leaf Traversal
 *
 * Key Learning:
 * The traversal logic is the same as Root to Leaf Paths.
 * The only difference is the output format:
 * Instead of storing a list of integers,
 * convert the path into a string before storing it.
 */



class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

       List<String> ans = new ArrayList<>();
       List<Integer> path = new ArrayList<>();

       dfs(root,path,ans);

       return ans;



    }

    public static void dfs(TreeNode root,List<Integer> path,List<String> ans){
        if(root == null) return;
        path.add(root.val);

        if(root.left == null && root.right == null){

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<path.size(); i++){
                sb.append(path.get(i));

                if(i != path.size() - 1){
                  sb.append("->");

                }

             
            }
           

            ans.add(sb.toString());
            

        }

        dfs(root.left,path,ans);
        dfs(root.right,path,ans);

        path.remove(path.size() - 1);
    }
}
