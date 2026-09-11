/*
Intuition:

- We need to form all possible 3-digit even numbers using the given
  digits.
- Since we don't know which digit should be in the hundreds, tens,
  or units position, try every possible combination using 3 loops.
- A valid number must:
    1. Use three different indices.
    2. Be a 3-digit number.
    3. End with an even digit.
- Duplicate numbers can be formed when the array contains duplicate
  digits, so use a HashSet to store only unique numbers.

Approach:

1. Use three nested loops:
      i → hundreds position
      j → tens position
      k → units position

2. Make sure the same index is not used more than once:
      if(i == j || i == k || j == k) continue;

3. Construct the 3-digit number:
      digits[i] * 100 + digits[j] * 10 + digits[k]

4. Check whether the number is valid:
      num >= 100
      - Ensures the number has 3 digits.

      num % 2 == 0
      - Ensures the number is even.

5. Add every valid number to the HashSet:
      set.add(num);

   - HashSet automatically removes duplicate numbers.

6. Instead of traversing the HashSet to count its elements,
   directly use:
      set.size()

   - size() gives the number of unique elements in the Set.

Key Idea:
Try every possible 3-digit combination, filter the valid even
numbers, and use a HashSet to keep only unique numbers.

Example:
digits = [1, 2, 4]

Possible valid numbers:
124, 142, 214, 412, ...

If the same number is generated again, HashSet stores it only once.

Time Complexity: O(n³)
Space Complexity: O(n³) in the worst case for storing unique numbers.
*/

class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
          
            for(int j=0; j<n; j++){

               for(int k=0; k<n; k++){

                    if(i == j || i == k || j == k)  continue;

                    else {
                      int num = (digits[i] * 100) + (digits[j] * 10) + (digits[k] * 1);

                       if(num >= 100 && num % 2 == 0){
                          set.add(num);
                        } 
                    }
                }

            }
        }
        
        
       
      return set.size();

    }
}
