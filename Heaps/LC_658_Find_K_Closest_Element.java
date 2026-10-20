/*
Problem: Find K Closest Elements (LeetCode 658)
Difficulty: Medium

Intuition:
- We need to find the k elements closest to x.
- A max-heap allows us to efficiently remove the least suitable element whenever the heap size exceeds k.

Approach:
1. Create a Pair class to store each element and its absolute difference from x.
2. Use a max-heap ordered by difference, with larger elements having lower priority when differences are equal.
3. Traverse the array and calculate the absolute difference using Math.abs(x - ele).
4. Add each Pair to the max-heap.
5. If the heap size exceeds k, remove the element with the largest difference. If differences are equal, remove the larger element.
6. Extract the remaining k elements into a list.
7. Sort the list in ascending order and return it.

Why Max-Heap?
- It keeps the least suitable element at the top.
- Removing that element whenever the heap exceeds k ensures that only the k closest elements remain.

Key Idea:
- Prioritize smaller differences.
- When differences are equal, prioritize smaller element values.
- Sort the final result because heap extraction does not guarantee ascending order.

Time Complexity: O(n log k + k log k)
- Processing n elements takes O(n log k).
- Sorting the k selected elements takes O(k log k).

Space Complexity: O(k)
- The heap and result list store at most k elements each.
*/


class Solution {

    public class Pair implements Comparable<Pair>{
        int ele;
        int diff;

        Pair(int ele,int diff){
            this.ele = ele;
            this.diff = diff;
        }

        public int compareTo(Pair p){

            if(this.diff == p.diff)  return this.ele - p.ele;

            return this.diff - p.diff;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int ele : arr){

            int diff = Math.abs(x-ele);

            pq.add(new Pair(ele,diff));

            if(pq.size() > k) pq.remove();
        }

        List<Integer> ans = new ArrayList<>();

        while(pq.size() > 0){
            Pair p = pq.remove();

            ans.add(p.ele);
        }

        Collections.sort(ans);

        return ans;
    }
}
