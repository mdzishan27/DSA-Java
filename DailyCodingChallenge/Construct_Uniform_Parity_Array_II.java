/*
Approach:
1. First, find the minimum element.
2. If the minimum element is odd:
   - We can use it to convert all even elements into odd.
   - So, return true.
3. Otherwise, the minimum is even:
   - Now check if all elements are even.
   - If any element is odd, we cannot make all elements even.
   - So, return false.
   - If all are even, return true.

Key Idea:
- If there is an odd minimum → we can make all elements odd.
- If the minimum is even → all elements must already be even
  to make the array uniform.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean uniformArray(int[] nums1) {

        int n = nums1.length;

        int minElement = nums1[0];

        for(int i=0; i<n; i++){
            minElement = Math.min(minElement,nums1[i]);
        }

        if(minElement % 2 == 1){
            return true;
        }

        for(int num : nums1){
            if(num % 2 == 1){
                return false;
            }
        }

        return true;
    }
}
