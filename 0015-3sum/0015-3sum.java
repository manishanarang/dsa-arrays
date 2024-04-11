class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);
        if(nums.length < 3) return new ArrayList<>(result);
        int n = nums.length;
        for(int i = 0; i < n-2; i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            int j = i+1;
            int k = n-1;

            while(j<k){
                if(nums[i]+nums[j] + nums[k] == 0){
                    result.add(List.of(nums[i], nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if((nums[i] + nums[j] + nums[k]) < 0)
                {
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}