class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n-1;

        int maxLeft = height[left];
        int maxRight = height[right];
        int maxWater = 0;


        while(left<right){
            if(maxLeft < maxRight){
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                maxWater+=maxLeft-height[left];
            }
            else{
                right--;
                maxRight = Math.max(maxRight, height[right]);
                maxWater+=maxRight-height[right];
            }
        }
        return maxWater;
    }
}