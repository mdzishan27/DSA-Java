// Approach: Recursive DFS
// In preorder traversal, we first visit the current node,
// then recursively visit all its children from left to right.
// Since an N-ary node can have multiple children, we use
// root.children to traverse all of them.
//
// Time: O(n), where n is the number of nodes.
// Space: O(h), where h is the height of the tree.

class Solution {
    public List<Integer> preorder(Node root) {
        
        List<Integer> ans = new ArrayList<>();

        dfs(root,ans);

        return ans;

    }

    private void dfs(Node root, List<Integer> ans ){
        if(root == null) return;

        ans.add(root.val);

        for(Node child : root.children){
            dfs(child,ans);
        }
    }
}
