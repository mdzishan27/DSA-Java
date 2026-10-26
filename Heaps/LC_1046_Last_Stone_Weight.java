/*
Problem: Last Stone Weight (LeetCode 1046)
Difficulty: Easy

Intuition:
- We need to repeatedly smash the two heaviest stones until at most one stone remains.
- Sorting the list after every operation allows us to easily identify the two heaviest stones.

Approach:BruteForce
1. Store all stone weights in an ArrayList because we need to remove stones and add new stone weights dynamically.
2. Sort the list in ascending order after every operation because we need the two heaviest stones at the end of the list.
3. Select the last two elements as the heaviest stones because sorting places the largest elements at the end.
4. Remove both stones from the list because they are smashed together.
5. If both stones have different weights, calculate their absolute difference and add it to the list because the heavier stone remains with the difference in weight.
6. If both stones have equal weights, do not add anything because both stones are destroyed.
7. Repeat until at most one stone remains and return its weight, or 0 if no stones remain.

Why Sorting?
- Sorting makes it easy to access the two heaviest stones using the last two indices.
- However, sorting the list repeatedly is inefficient because the list must be sorted again after every operation.

Key Idea:
- Always smash the two heaviest stones.
- If their weights differ, add the difference back to the list; otherwise, both are destroyed.

Time Complexity: O(n^2 log n)
- In each iteration, sorting the list takes O(m log m), where m is the current list size.
- Since the list size decreases by one per iteration, the total time complexity is O(n^2 log n).

Space Complexity: O(n)
- The ArrayList stores at most n stone weights.
*/

class Solution {
    public int lastStoneWeight(int[] stones) {

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<stones.length; i++){
            arr.add(stones[i]);
        }


        while(arr.size() > 1){

            Collections.sort(arr);

            int n = arr.size();

            int a = arr.get(n-1);

            int b = arr.get(n-2);

            arr.remove(n-1);

            arr.remove(n-2);


            if(a != b){

                arr.add(Math.abs(a-b));
            }

        }

       if(arr.size() == 0) return 0;

       else return arr.get(0);
    }
}



/*
Problem: Last Stone Weight (LeetCode 1046)
Difficulty: Easy

Intuition:
- We need to repeatedly smash the two heaviest stones until at most one stone remains.
- A max-heap helps us efficiently retrieve the two heaviest stones without sorting the entire collection after every operation.

Approach:Using max-heap
1. Create a max-heap using PriorityQueue with Collections.reverseOrder() because we need the largest stone weight at the top.
2. Insert all stone weights into the heap so that the two heaviest stones are always available for removal.
3. While the heap contains more than one stone, remove the two largest elements because these are the stones that must be smashed.
4. If both stones have different weights, calculate their absolute difference and insert it back into the heap because the remaining stone has that weight.
5. If both stones have equal weights, do not insert anything because both stones are destroyed.
6. Repeat until at most one stone remains, then return its weight. If the heap is empty, return 0.

Why Max-Heap?
- It keeps the largest element at the top, allowing us to retrieve the heaviest stone efficiently.
- Each removal takes O(log n), avoiding repeated sorting of the entire collection.

Key Idea:
- Always remove the two heaviest stones.
- Insert their difference only when their weights are unequal.
- Continue until zero or one stone remains.

Time Complexity: O(n log n)
- Inserting n stones takes O(n log n).
- Each smash operation performs at most two removals and one insertion, each taking O(log n).
- At most n - 1 smash operations are performed.

Space Complexity: O(n)
- The max-heap stores at most n stone weights.
*/

class Solution {
    public int lastStoneWeight(int[] stones) {

       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

       for(int i=0; i<stones.length; i++){
         pq.add(stones[i]);
       }
        
       while(pq.size() > 1){
          int a = pq.remove();
          int b = pq.remove();

          if(a != b) pq.add(Math.abs(a-b));
        }

        return pq.size() == 0 ? 0 : pq.remove();
    }
}
