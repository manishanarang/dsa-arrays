class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<nums.length;i++){
            set.add(nums[i]);
        }
        int sequence, maxLength = 0;
        for(int i = 0; i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                //start of a sequence
                sequence = 1;
                int curr = nums[i];
                while(set.contains(curr + 1)){
                    sequence++;
                    curr++;
                }
                maxLength = Math.max(maxLength, sequence);

            }
        }
        return maxLength;
    }
}