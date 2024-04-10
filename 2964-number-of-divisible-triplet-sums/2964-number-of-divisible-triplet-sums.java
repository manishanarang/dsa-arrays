class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        int n = nums.length;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int res = 0;
        
        // Step 1: Populate auxiliary hashmap
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = (nums[i] + nums[j]) % d;
                map.computeIfAbsent(key, k-> new ArrayList<>()).add(List.of(i,j));
            }
        }
        
        // Step 2: Linear scan and filtering
        for (int k = 2; k < n; k++) {
            int cur = nums[k] % d;
            int require = (d - cur) % d;
            if (map.containsKey(require)) {
                List<List<Integer>> pairs = map.get(require);
                for (var pair : pairs) {
                    int i = pair.get(0);
                    int j = pair.get(1);
                    if (j<k) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}