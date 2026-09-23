/*
    Problem: K-th Permutation
    LeetCode: 60
    Difficulty: Hard
    Approach: Factorial Number System

    Intuition:
    We do not generate all permutations because there can be n!
    permutations. Instead, we find the required permutation
    directly by using factorial groups.

    Approach:
    1. Store numbers from 1 to n in an ArrayList.
    2. Calculate (n - 1)! because after choosing the first number,
       the remaining n - 1 numbers can be arranged in (n - 1)!
       ways.
    3. Convert k to 0-based using k-- because our calculation
       uses indexes starting from 0.
    4. For every position:
       - index = k / fact gives the index of the number to choose.
       - Remove that number from the list and add it to the answer.
       - k %= fact moves k to the required position inside
         the selected group.
       - Update fact for the next position.
    5. Repeat until all numbers are selected.

    Why index = k / fact?
    If there are (n - 1)! permutations for each possible first
    number, division tells us which group contains the k-th
    permutation.

    Why k %= fact?
    After selecting a group, we only need to find the position
    of k inside that group.

    Why remove the selected number?
    Once a number is chosen for a position, it cannot be used again.
    Removing it keeps the remaining numbers available for the
    next positions.

    Key Idea:
    Factorial tells us the size of each permutation group.
    
    Count the group → choose the number → remove it → repeat.

    Time: O(n²)
    Space: O(n)
*/

class Solution {
    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();

        List<Integer> num = new ArrayList<>();

        int fact = 1;

        for(int i=1; i<=n; i++){
            fact *= i;
            num.add(i);
        }

        k--;

        for(int i=0; i<n; i++){
            fact /= (n-i);

            int idx = (k / fact);

            sb.append(num.remove(idx));

            k %= fact;
        }

        return sb.toString();


    }
}
