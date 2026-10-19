/*
Problem: K Closest Points to Origin (LeetCode 973)
Difficulty: Medium

Intuition:
- We need to find the k points closest to the origin (0, 0).
- A max-heap helps us maintain the k closest points by removing the farthest point whenever the heap size exceeds k.

Approach:
1. Create a Triplet class storing the squared distance (d) and coordinates (x, y).
2. Use a max-heap of Triplet objects, ordered by squared distance.
3. Traverse each point and calculate its squared distance using d = x*x + y*y.
4. Add each point to the heap.
5. If the heap size exceeds k, remove the point with the largest distance.
6. After processing all points, extract the remaining k points and store their coordinates in the result array.

Why Max-Heap?
- The farthest point among the k closest points stays at the top.
- When a new point is added and the heap exceeds size k, removing the farthest point ensures that we retain the k closest points.

Key Idea:
- Maintain a max-heap of size at most k.
- Compare squared distances instead of calculating square roots, since square roots do not change the relative ordering of distances.

Time Complexity: O(n log k)
- Each point requires a heap insertion and, when necessary, a removal, each taking O(log k) time.

Space Complexity: O(k)
- The priority queue stores at most k points, excluding the output array.
*/

class Solution {
    public class Triplet implements Comparable<Triplet>{
        int d;
        int x;
        int y;

        Triplet(int d,int x, int y){
            this.d = d;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Triplet t){
            return this.d - t.d;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<points.length; i++){
            
            int x = points[i][0];  int y = points[i][1];

            int d = x*x + y*y;

            pq.add(new Triplet(d,x,y));
    

            if(pq.size() > k) pq.remove();
        }

        int[][] ans = new int[k][2];

        for(int i=0; i<k; i++){
            Triplet t = pq.remove();

            ans[i][0] = t.x;
            ans[i][1] = t.y;
        }

        return ans;
    }
}
