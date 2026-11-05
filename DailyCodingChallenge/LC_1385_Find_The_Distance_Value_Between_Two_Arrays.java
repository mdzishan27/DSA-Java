class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int count = 0;
        
        for(int i=0; i<arr1.length; i++){
              
            boolean allValid = true;


            for(int j=0; j<arr2.length; j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    allValid = false;
                }
            }


            if(allValid){
                count++;
            }


            
        }

        return count;
    }
}


/*
Problem: Find the Distance Value Between Two Arrays (LeetCode 1385)
Difficulty: Easy

Intuition:
- We need to count elements in arr1 that have an absolute difference greater than d from every element in arr2.
- A nested loop helps us compare each element of arr1 with all elements of arr2.

Approach:BruteForce
1. Initialize count = 0 to store the number of valid elements from arr1.
2. Traverse arr1 because we need to check every element individually.
3. Initialize allValid = true for each element because it is considered valid until a condition violates the requirement.
4. Traverse arr2 and calculate the absolute difference using Math.abs(arr1[i] - arr2[j]) because the distance should always be non-negative.
5. If the absolute difference is less than or equal to d, mark allValid = false because the current arr1 element does not satisfy the required distance condition.
6. After checking all elements of arr2, increment count only if allValid is still true because the element must be at a distance greater than d from every element in arr2.
7. Return count after checking all elements of arr1.

Why Nested Loops?
- Each element of arr1 must be compared with every element of arr2.
- The inner loop verifies whether the current element satisfies the distance condition against all elements of the second array.

Why Boolean Flag?
- allValid tracks whether the current arr1 element satisfies the condition.
- Once a violating element is found in arr2, we mark it false so it is not included in the final count.

Key Idea:
- An element from arr1 is valid only when its absolute difference from every element in arr2 is strictly greater than d.
- Count only those elements that satisfy this condition.

Time Complexity: O(m * n)
- Each element of arr1 is compared with every element of arr2.
- m and n represent the lengths of arr1 and arr2 respectively.

Space Complexity: O(1)
- Only a few variables are used without any additional data structure.
*/
