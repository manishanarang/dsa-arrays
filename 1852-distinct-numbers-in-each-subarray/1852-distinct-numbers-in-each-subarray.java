class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<k;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int t=0;
        result[t++] = map.size();
        
        for(int i = k; i<n;i++){
            if(map.containsKey(nums[i-k])){
                map.put(nums[i-k], map.get(nums[i-k])-1);  
                if(map.get(nums[i-k]) <=0){
                    map.remove(nums[i-k]);
                }
            }
            queue.poll();
            
            queue.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            result[t++] = map.size();
        }
        return result;
    }
}