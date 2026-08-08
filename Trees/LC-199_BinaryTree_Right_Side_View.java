/*
DFS + Level:
- One answer for each level.
- First node at a level -> add().
- Every next node at same level -> set() to replace it.
- Traverse Left -> Right, so the last node at each level is the rightmost node.
- Hence, ans gives the Right Side View.

TC: O(N)
SC: O(H)
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        view(root,0,ans);
        return ans;
    }

    public void view(TreeNode root, int level, List<Integer> ans){
        if(root == null) return;

        if(level >= ans.size())   ans.add(root.val);
        else ans.set(level,root.val);

        view(root.left,level+1,ans);
        view(root.right,level+1,ans);


    }

    
}
