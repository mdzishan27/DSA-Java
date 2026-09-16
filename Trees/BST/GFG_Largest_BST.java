/*
    Problem: Largest BST in a Binary Tree
    Difficulty: Medium

    Intuition:
    For every node, check whether the subtree rooted at that node
    is a BST and keep track of the largest BST found.

    Approach:
    1. Use postorder traversal so we get information from the
       left and right subtrees before checking the current node.
    2. Quad stores:
       - max → maximum value in the subtree
       - min → minimum value in the subtree
       - size → number of nodes in the subtree
       - isBST → whether the subtree is a BST
    3. The current subtree is a BST if:
       - left subtree is BST
       - right subtree is BST
       - left max < root.data
       - right min > root.data
    4. If it is a BST, update maxSize using the current size.
    5. Return the current subtree information to its parent.

    Why max and min?
    They help the parent check the complete left and right
    subtrees, not just the direct children.

    How does Quad help?
    Instead of calculating the same information again,
    helper() returns everything the parent needs in one object:

        Quad
        ├── max
        ├── min
        ├── size
        └── isBST

    LeetCode Connection:
    The same pattern is used in "Maximum Sum BST in Binary Tree".
    The logic is almost the same; here we calculate size,
    while there we calculate sum.

    Key Idea:
    Get information from left + right → check BST → update answer.

    Time: O(n)
    Space: O(h)  // Recursion stack
*/


class Quad{
    int max;
    int min;
    int size;
    boolean isBST;
    
    Quad(int max, int min, int size, boolean isBST){
        this.max = max;
        this.min = min;
        this.size = size;
        this.isBST = isBST;
    }
}

class Solution {
    static int maxSize;
    public Quad helper(Node root){
        
        if(root == null) return new Quad(Integer.MIN_VALUE, Integer.MAX_VALUE,0,true);
        
        Quad lst = helper(root.left);
        Quad rst = helper(root.right);
        
        int max = Math.max(root.data,Math.max(lst.max,rst.max));
        int min = Math.min(root.data,Math.min(lst.min,rst.min));
        
        int size = 1 + lst.size + rst.size;
        
        boolean isBST = lst.isBST && rst.isBST && (lst.max < root.data) && (rst.min > root.data);
        
        if(isBST) maxSize = Math.max(size,maxSize);
        
        return new Quad(max,min,size,isBST);
        
    }
    
    
    public int largestBst(Node root) {
       
       maxSize = 0;
       helper(root);
       
       return maxSize;
    }
    
    
}



