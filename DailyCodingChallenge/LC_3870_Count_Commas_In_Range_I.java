/*
Intuition:

- A comma first appears in a number when it reaches 1000.
- Every number from 1000 onwards has at least one comma.
- Therefore, we only need to count how many numbers exist from
  1000 to n.

Approach:

1. If n < 1000:
   - No number contains a comma.
   - Return 0.

2. Start counting from 1000 because this is the first number
   that contains a comma.

3. Traverse from 1000 to n:
      for(int num = 1000; num <= n; num++)

   - Each number contributes one comma.
   - So increase count by 1 for every number.

4. Return count.

Key Idea:
All numbers between 1000 and n contain exactly one comma, so
we simply count the numbers in that range.

Example:
n = 1005

1000 → 1 comma
1001 → 1 comma
1002 → 1 comma
1003 → 1 comma
1004 → 1 comma
1005 → 1 comma

Total = 6

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public int countCommas(int n) {
        if(n < 1000) return 0;

        int count = 0;

        for(int num = 1000; num<=n; num++){
            count += 1;
        }

        return count;
    }
}



/*
Intuition:

- A comma first appears at 1000.
- Every number from 1000 to n contains at least one comma.
- So, instead of checking every number, directly calculate how many
  numbers are present from 1000 to n.

Approach:

1. If n < 1000:
   - No number contains a comma.
   - Return 0.

2. Otherwise:
   - Numbers containing a comma are from 1000 to n.
   - Count of numbers = n - 1000 + 1
                       = n - 999

3. Use the ternary operator:
      n < 1000 ? 0 : n - 999

   - If n < 1000 → return 0.
   - Otherwise → return n - 999.

Key Idea:
Instead of using a loop, directly calculate the number of values
from 1000 to n.

Example:
n = 1005

Count = 1005 - 999
      = 6

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int countCommas(int n) {
        return n < 1000 ? 0 : n-999;
    }
}
