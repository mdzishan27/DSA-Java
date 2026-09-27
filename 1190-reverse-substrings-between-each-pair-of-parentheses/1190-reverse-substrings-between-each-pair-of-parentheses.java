class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();

        StringBuilder sb = new  StringBuilder(n);

        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch == '(')  st.push(sb.length());

            else if(ch == ')'){
                int left = st.pop();
                int right = sb.length()-1;

                while(left < right){
                    char temp = sb.charAt(left);
                    sb.setCharAt(left,sb.charAt(right));
                    sb.setCharAt(right,temp);
                    left++;
                    right--;
                }


            }

            else sb.append(ch);
        }

        return sb.toString();
    }
}