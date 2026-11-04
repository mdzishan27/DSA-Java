class Solution {
    public int minCost(int[] arr) {
      
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      for(int i=0; i<arr.length; i++){
          pq.add(arr[i]);
      }
      
      int cost = 0;
        
      while(pq.size()>1){
          int first = pq.remove();
          int second = pq.remove();
          
          cost += first+second;
          
          pq.add(first+second);
      }  
      
      return cost;
      
    }
}
