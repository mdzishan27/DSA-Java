/*
    Problem: Kids With the Greatest Number of Candies
    Difficulty: Easy

    Intuition:
    For each child, we need to check if giving them all the
    extraCandies makes their candies greater than or equal to
    the maximum candies of any child.

    Approach:
    1. Find the maximum number of candies any child currently has.
    2. Traverse the candies array again.
    3. Add extraCandies to the current child's candies.
    4. If the new total is greater than or equal to max,
       add true to the result.
    5. Otherwise, add false.
    6. Return the result list.

    Key Idea:
    We only need the maximum current value to decide whether
    each child can have the greatest number of candies.

    Time: O(n)
    Space: O(n)  // Result list
*/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int n = candies.length;
 
       List<Boolean> result = new ArrayList<>();

       int max = candies[0];

        for(int i=1; i<n; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }

        for(int i=0; i<n; i++){

            int maxCandies = candies[i] +  extraCandies;

            if(maxCandies >= max){
                result.add(true);
            }

            else {
                result.add(false);
            }


        }

           return result;

    }
}
