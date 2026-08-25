// Approach:
// Start checking from the first positive multiple of k.
// For each multiple, search the entire array to see if it exists.
// If the multiple is found, move to the next multiple by adding k.
// If it is not found, return it because it is the smallest missing multiple.
//
// Time Complexity: O(n²) in the worst case
// Space Complexity: O(1)


class Solution {
    public int missingMultiple(int[] nums, int k) {
       int  multiple = k;

       while(true){
          boolean found = false;
          for(int i=0; i<nums.length; i++){

               if(nums[i] == multiple){
                    found = true;
                    break;
               } 
            
            }

            if(found == false)  return multiple;
            multiple += k;
        }

    }
}
