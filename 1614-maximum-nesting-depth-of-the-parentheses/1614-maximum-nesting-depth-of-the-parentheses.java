class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        int maxDepth = 0;
        int depth = 0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            

            if(ch == '(') {

                depth ++;
                maxDepth = Math.max(depth,maxDepth);

            }
            else if(ch == ')') depth --;

            
        }

        return maxDepth;
    }
}