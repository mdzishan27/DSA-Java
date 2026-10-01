/*  Leecode: 3731. Find Missing Elements

    Intuition:
    After sorting the array, any missing elements will appear
    between two consecutive numbers whose difference is greater than 1.

    Approach:Sorting
    1. Sort the array so that all numbers are in increasing order.
    2. Compare every current element with the next element.
    3. If next - current > 1, then there are missing numbers
       between them.
    4. Use another loop to add all those missing numbers to the
       answer list.

    Example:
    nums = [1, 4, 2, 6]

    After sorting:
    [1, 2, 4, 6]

    Between 2 and 4:
        3 is missing → add 3

    Between 4 and 6:
        5 is missing → add 5

    Answer = [3, 5]

    Time Complexity:
    O(n log n) for sorting + O(n + m) for traversal,
    where m is the number of missing elements.

    Space Complexity:
    O(m) for the output list (excluding sorting space).
*/



class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            int curr = nums[i];
            int next = nums[i+1];

            if((next-curr) > 1){
               for(int j=curr+1; j<next; j++){
                  ans.add(j);
                }
                
                
            }

            

        }

        return ans;

         
    }
}



/*  
    Intuition:
    The numbers in nums are unique, and the smallest and largest
    values are present. Therefore, all numbers between min and max
    should exist in the complete range.

    Approach:HashSet
    1. Find the minimum and maximum values in nums.
    2. Store all existing numbers in a HashSet for O(1) average
       lookup.
    3. Traverse every number from min to max.
    4. If a number is not present in the HashSet, it is missing,
       so add it to the answer list.

    Why HashSet?
    We need to quickly check whether each number in the expected
    range exists in nums.

    Example:
    nums = [1, 4, 2, 6]

    Complete range: 1, 2, 3, 4, 5, 6
    Missing elements: [3, 5]

    Time Complexity: O(n + range)
    where range = max - min + 1

    Space Complexity: O(n) auxiliary space
    excluding the output list.
*/

class Solution {
    public List<Integer> findMissingElements(int[] nums) {


        List<Integer> ans = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int x : nums){
            min = Math.min(x,min);
            max = Math.max(x,max);

            set.add(x);
        }

        for(int i=min; i<=max; i++){
            if(!set.contains(i))   ans.add(i);
           
        }

        return ans;
    }
}

