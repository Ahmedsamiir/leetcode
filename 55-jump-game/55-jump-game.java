class Solution {
    public boolean canJump(int[] nums) {
        
          int size = nums.length - 1;
        
        for (int i = size; i >= 0; --i) {
            if (nums[i] + i >= size) {
                size = i;
            }
        }
        return size == 0;
        
    }
}