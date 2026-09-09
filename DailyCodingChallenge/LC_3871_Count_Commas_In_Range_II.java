/*
Intuition:

- Commas appear based on the number of digits:
    1,000        → 1 comma
    1,000,000    → 2 commas
    1,000,000,000 → 3 commas

- Instead of checking every number individually, group numbers
  according to how many commas they contain.

Approach:

1. Start from:
      lower = 1000
      comma = 1

   - 1000 is the first number that contains a comma.
   - Numbers from 1000 to 999,999 contain exactly 1 comma.

2. For the current group, calculate the upper limit:
      upper = lower * 1000 - 1

   - This gives the largest number in the current comma group.
   - If upper is greater than n, use n as the upper limit.

3. Calculate how many numbers are in this range:
      countNo = upper - lower + 1

4. Each number in this range contains `comma` commas, so:
      result += countNo * comma

5. Move to the next comma group:
      lower = lower * 1000;
      comma += 1;

   Example:
      lower = 1000  → 1 comma
      lower = 1,000,000 → 2 commas
      lower = 1,000,000,000 → 3 commas

6. Continue until lower becomes greater than n.

7. Return result.

Key Idea:
Instead of counting commas number by number, divide the numbers
into ranges where every number has the same number of commas.

Example:
n = 1,005,000

1000 → 999,999
→ each number has 1 comma

1,000,000 → 1,005,000
→ each number has 2 commas

So we calculate the contribution of each range directly.

Time Complexity: O(log₁₀(n))
Space Complexity: O(1)
*/


class Solution {
    public long countCommas(long n) {
        long result = 0;

        long lower = 1000;
        long comma = 1;

        while(lower <= n){
            long upper = lower * 1000 - 1;

            if(upper > n) upper = n;

            long countNo = upper - lower + 1;

            result += countNo * comma;

            lower = lower * 1000;

            comma += 1;             

        }

        return result;
    }
}
