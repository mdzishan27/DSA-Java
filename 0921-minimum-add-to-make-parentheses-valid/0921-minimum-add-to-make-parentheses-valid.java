/*
    Problem: Minimum Add to Make Parentheses Valid
    Difficulty: Medium

    Intuition:
    Every '(' needs a matching ')' and every ')' needs a
    matching '('.

    Approach:Stack
    1. Use a Stack to store unmatched '('.
    2. When we see '(':
       - Push it into the stack because it may match a future ')'.
    3. When we see ')':
       - If the stack is not empty, match it with one '(' by popping.
       - If the stack is empty, there is no '(' to match it,
         so we need to add one '(' → open++.
    4. After processing the complete string, any '(' remaining
       in the stack needs one ')' for each of them.
    5. Therefore, the total additions are:
           open + st.size()

    Example:
    s = "())"

    '(' → push
    ')' → pop and match
    ')' → no '(' available → open++

    Answer = open + remaining '('
           = 1 + 0
           = 1

    Key Idea:
    Match every ')' with an available '('.
    Unmatched ')' are counted in open, while remaining '('
    in the stack need closing ')'.

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        int open = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(') st.push(ch);

            else {
                if(!st.isEmpty()){
                    st.pop();
                }

                else open++;
            }

        }

        return open + st.size();
    }
}





/*
    Problem: Minimum Add to Make Parentheses Valid
    Difficulty: Medium

    Intuition:
    We don't actually need a Stack because we only need to know
    how many unmatched '(' are currently available.

    Approach:optimised
    1. Use 'size' to keep track of unmatched '('.
    2. When we see '(':
       - Increase size because we have one more opening
         parenthesis that needs to be matched.
    3. When we see ')':
       - If size > 0, match it with one '(' and decrease size.
       - Otherwise, there is no '(' available to match it,
         so we need to add one '(' → open++.
    4. After traversing the string:
       - 'open' = number of '(' needed for unmatched ')'.
       - 'size' = number of ')' needed for unmatched '('.
    5. Total additions = open + size.

    Key Idea:
    Match ')' with an available '('.
    If no '(' is available, add one.
    Remaining '(' need closing ')'.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/










class Solution {
    public int minAddToMakeValid(String s) {       

        int open = 0;
        int size=0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(') size++;

            else if(size > 0){
                size--;

            }

            else open++;            

        }

        return open + size;
    }
}
