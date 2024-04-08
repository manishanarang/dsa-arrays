class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        for(int i = 0; i<stones.length;i++){
            pq.add(stones[i]);
        }

        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();

            if(first == second) continue;
            pq.add(Math.abs(first-second));
        }
        return pq.size() > 0 ? pq.peek() : 0; 
    }
}