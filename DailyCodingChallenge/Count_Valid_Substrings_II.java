class Solution {
    public long countValidSubstrings(String s) {

        

        int lastA = -1;
        int lastAB = -1;
        int left = 0;

        long count = 0;

        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);

            if(ch == 'a'){
                lastA = right;
            }

            else if(ch == 'b'){
                if(lastA != -1) lastAB = lastA;
            }

            else if(ch == 'c'){
                if(lastAB != -1)  left = Math.max(left,lastAB+1);
            }

            count += right - left + 1;
        }

        return count;
    }
}



/*
Problem: Count Valid Substrings I
Difficulty: Medium

Intuition:
- Generating every substring is unnecessary because we only need to identify whether "abc" appears consecutively.
- Sliding Window allows us to maintain the earliest valid starting position and count valid substrings ending at each index.

Approach:
1. Initialize left = 0 to represent the earliest valid starting position and count = 0 to store the total valid substrings.
2. Traverse the string using the right pointer because every position represents the ending index of the current substrings.
3. Check whether the last three characters form "abc" because this is the only pattern that makes a substring invalid.
4. If "abc" is found, move left to right - 1 because every substring starting at or before right - 2 contains the invalid pattern.
5. Calculate right - left + 1 because every possible starting position between left and right creates a valid substring ending at right.
6. Add this value to count because we need to count all valid substrings, not just the current window.
7. Return count after traversing the entire string.

Why Sliding Window?
- It avoids generating every possible substring and repeatedly checking it.
- The left pointer maintains the earliest valid starting position, while the right pointer processes each character once.

Key Idea:
- If "abc" appears at the current right position, move left just after its starting position.
- The number of valid substrings ending at right is right - left + 1.

Time Complexity: O(n)
- Each character is processed once using the right pointer.

Space Complexity: O(1)
- Only left, right, and count variables are used.
*/
