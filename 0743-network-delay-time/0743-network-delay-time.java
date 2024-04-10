class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] time: times){
            adj.computeIfAbsent(time[0], key-> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k, 0});
        dist[k] = 0;
        
        HashSet<Integer> visited= new HashSet<>();
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            
            int u = edge[0];
            int cost = edge[1];
            
            if (cost > dist[u]) {
                continue;
            }
            if(!adj.containsKey(u)){
                continue;
            }
            
            for(int[] neighbour : adj.get(u)){
                int v = neighbour[0];          
                int wt = neighbour[1];
                
                if(cost + wt < dist[v]){
                    dist[v] = cost + wt;
                    pq.offer(new int[]{v, dist[v]});
                }
                
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dist[i]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}