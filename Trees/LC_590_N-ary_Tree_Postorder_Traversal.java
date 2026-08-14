// Approach: Recursive DFS
// In postorder traversal, we first visit all the children
// from left to right and then visit the current node.
// Since an N-ary node can have multiple children, we use
// root.children to traverse all of them.
//
// Time: O(n), where n is the number of nodes.
// Space: O(h), where h is the height of the tree.


class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    private void dfs(Node root,List<Integer> ans){
        if(root == null) return;

        for(Node child : root.children){
            dfs(child,ans);
        }

        ans.add(root.val);
    }
}
