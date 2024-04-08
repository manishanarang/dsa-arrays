class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        List<Integer> val = new ArrayList<>(map.values());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int v : val){
            pq.add(v);
        }
        int t = 0;
        Queue<int[]> queue = new LinkedList<>();

        while(!pq.isEmpty() || !queue.isEmpty()){
            t++;
            if(!pq.isEmpty()){
                int pop = pq.poll();
                if(pop > 1){
                    queue.add(new int[]{pop-1, t+n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == t){
                int[] entry = queue.poll();
                pq.add(entry[0]);
            } 
        }
        return t;
    }
}