class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            left[i] = left[i-1] * nums[i];
        }
        int n = nums.length;
        right[n-1] = nums[n-1];

        for(int i = n-2; i>=0; i--){
            right[i] = right[i+1] * nums[i];
        }

        int[] result = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(i == 0){
                result[i] = right[i+1];
            }
            else if(i == n-1){
                result[i] = left[i-1];
            }
            else{
                result[i] = left[i-1] * right[i+1];
            }
        }
        return result;
    }
}