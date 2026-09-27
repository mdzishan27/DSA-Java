/*
    Intuition:
    Whenever we find '(' , we start a new section whose characters
    need to be reversed when we find the matching ')'.

    Approach:
    Use a Stack<Integer> to store the starting index of the current
    section inside the StringBuilder.

    - '(' → store sb.length(), because the characters inside the
      parentheses will start from this index.
    - normal character → simply add it to StringBuilder.
    - ')' → pop the starting index and reverse the characters from
      that index to the end of StringBuilder.

    Why and How:
    We don't add parentheses to StringBuilder.
    Therefore, sb.length() tells us exactly where the content inside
    the current '(' begins.

    Example:
        s = "a(bc)d"

        Before ')':
        sb = "abc"
        stack = [1]

        left = 1, right = 2

        Reverse "bc" → "cb"

        sb becomes "acb"

    The two-pointer technique is used for reversing:
        left  → moves forward
        right → moves backward

    We stop when left >= right.

    Time Complexity: O(n²) in the worst case because reversing
                     sections can take O(n) for multiple parentheses.
    Space Complexity: O(n) for the StringBuilder and Stack.
*/

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
