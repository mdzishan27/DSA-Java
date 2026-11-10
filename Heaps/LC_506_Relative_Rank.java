class Solution {
    class Pair implements Comparable<Pair> {
        int score;
        int idx;

        Pair(int score, int idx){
            this.score = score;
            this.idx = idx;
        }

        public int compareTo(Pair p){
            return p.score - this.score;
        }
    }


    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(new Pair(score[i],i));
        }

        int rank = 1;
        while(pq.size() > 0){
            Pair p = pq.remove();

            if(rank == 1){
                ans[p.idx] = "Gold Medal";
            }

            else if(rank == 2){
                ans[p.idx] = "Silver Medal";
            }

            else if(rank == 3){
                ans[p.idx] = "Bronze Medal";
            }


            else ans[p.idx] = Integer.toString(rank);


            rank++;            
            
        }
        return ans;
    }
}





/*
Problem: Relative Ranks (LeetCode 506)
Difficulty: Easy

Intuition:
- We need to assign ranks based on athletes' scores while keeping the results in their original array positions.
- A Max-Heap helps us retrieve the highest score first, and storing the original index helps us place the rank correctly.

Approach:
1. Create a Pair class containing score and idx because we need to store each athlete's score along with its original index.
2. Implement Comparable<Pair> and override compareTo() to arrange pairs in descending order of scores because the highest score should have the highest priority.
3. Create a PriorityQueue of Pair objects and insert every score along with its index because we need to process athletes in descending order of their scores.
4. Initialize rank = 1 because the athlete with the highest score gets the first rank.
5. Remove the top Pair from the heap because it contains the index of the athlete with the highest remaining score.
6. Assign "Gold Medal" for rank 1, "Silver Medal" for rank 2, and "Bronze Medal" for rank 3 because these positions have special medal labels.
7. For all remaining positions, convert the rank into a String using Integer.toString() because the answer array stores Strings.
8. Store the result at ans[p.idx] because we need to maintain the original positions of the athletes.
9. Increment rank after assigning each position and repeat until the heap becomes empty.
10. Return the answer array containing the relative ranks in the original order.

Why Max-Heap?
- It always keeps the highest score at the top, allowing us to process athletes in descending order without sorting the original array.
- The Pair class stores the original index so that we can assign ranks at the correct positions.

Key Idea:
- Prioritize athletes based on their scores using a Max-Heap.
- Store their original indices to preserve the input order.
- Assign medal names to the top three positions and numeric ranks to the remaining athletes.

Time Complexity: O(n log n)
- Inserting n pairs into the PriorityQueue takes O(n log n).
- Removing all n pairs takes O(n log n).
- Assigning ranks takes O(n).

Space Complexity: O(n)
- The PriorityQueue stores n Pair objects.
- The answer array stores n rank strings.
*/
