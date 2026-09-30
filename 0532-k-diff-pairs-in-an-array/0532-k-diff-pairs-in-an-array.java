/*
    Intuition:
    We need to count unique pairs (a, b) such that:
        |a - b| = k

    Approach:
    There are two cases:

    1. k == 0:
       We need two equal numbers, so a number must occur
       at least twice.
       Use a HashMap to store the frequency of each number.
       Every number with frequency >= 2 forms one unique pair (x, x).

    2. k > 0:
       First store all numbers in a HashSet so that duplicate
       values are removed.
       For every unique number x, check whether (x - k) exists.
       If it exists, then (x - k, x) is one valid unique pair.

    Why HashMap for k == 0?
    A HashSet only stores unique values, so it cannot tell
    whether a number appeared once or multiple times.
    HashMap stores the frequency.

    Why HashSet for k > 0?
    We only need unique values and don't want duplicate
    occurrences to count the same pair multiple times.

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

class Solution {
    public int findPairs(int[] nums, int k) {
        
       int count=0;

       if(k == 0){
           //for k=0 case1
            Map<Integer, Integer> freq = new HashMap<>();

            for(int x : nums){
             freq.put(x, freq.getOrDefault(x, 0) + 1);
            }
        

            for(int x : freq.keySet()){
                if(freq.get(x) >= 2) count++;
            }

            return count;
       
        }
       //case2 k>0
       Set<Integer> set = new HashSet<>();

       for(int ele : nums){
          set.add(ele);
        }
       
       for(int x : set){
          int diff = x - k;

          if(set.contains(diff)) count++;

          
        }
         
        
        return count;
    }

  
}
