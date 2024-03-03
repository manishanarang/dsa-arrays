class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1) return new int[]{nums[0]};

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            maxHeap.add(new int[]{entry.getValue(), entry.getKey()});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[] result = new int[k];
        int j = 0;
        while(!maxHeap.isEmpty()){
            result[j++] = maxHeap.poll()[1];
        }

        return result;
    }
}