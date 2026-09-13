/*
Intuition:

- We need to find the maximum value of:
      (nums[i] - 1) * (nums[j] - 1)

- We don't know which two elements will give the maximum product,
  so try every possible pair of elements.

Approach:Brueforce

1. Use two nested loops:
      i → selects the first element.
      j → selects the second element.

2. Start j from i + 1:
      for(int j = i + 1; j < n; j++)

   - This ensures that we choose two different elements.
   - It also avoids checking the same pair twice.
     For example, after checking (3, 4), we don't need to check (4, 3).

3. Calculate the product for every pair:
      product = (nums[i] - 1) * (nums[j] - 1);

4. Maintain maxProduct:
      maxProduct = Math.max(maxProduct, product);

   - maxProduct stores the largest product found so far.

5. After checking every possible pair, return maxProduct.

Key Idea:
Try every possible pair, calculate its product, and keep track
of the maximum product found.

Example:
nums = [3, 4, 5, 2]

(3,4) → 6
(3,5) → 8
(3,2) → 2
(4,5) → 12  ← maximum
(4,2) → 3
(5,2) → 4

Answer = 12

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int maxProduct = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {

                int product = (nums[i] - 1) * (nums[j] - 1);

                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }
}




/*
Intuition:

- We need to maximize:
      (nums[i] - 1) * (nums[j] - 1)

- Since all values are non-negative, the product will be maximum
  when we choose the two largest elements.
- Therefore, instead of checking every pair, we only need to find
  the largest and second-largest elements.

Approach:optimal

1. Maintain two variables:
      max1 → largest element found so far.
      max2 → second-largest element found so far.

2. Traverse the array once.

3. If the current number is greater than max1:
      max2 = max1;
      max1 = num;

   - The old largest becomes the second largest.
   - The current number becomes the new largest.

4. Otherwise, if the current number is greater than max2:
      max2 = num;

   - Update the second-largest element.

5. After the traversal, max1 and max2 are the two largest
   elements in the array.

6. Calculate:
      (max1 - 1) * (max2 - 1)

Key Idea:
We don't need to try every pair. We only need the two largest
elements because they produce the maximum product.

Example:
nums = [3, 4, 5, 2]

max1 = 5
max2 = 4

Answer:
(5 - 1) * (4 - 1)
= 4 * 3
= 12

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for(int num : nums){
            if(num > max1){
                max2 = max1;
                max1 = num;
            }

            else if(num > max2){
                  max2 = num;
                
            }
        }

        return (max1 - 1) * (max2 -1);
    }
}
