class Solution {
    public int[] shuffle(int[] nums, int n) {
        
         for(int i=n;i<2*n;i++){
            nums[i] = nums[i]<<10;
            nums[i] |= nums[i-n];
        }
        int z = n;
        for(int i=0;i<2*n;i+=2){
            nums[i] = nums[z] & 1023;
            nums[i+1] = nums[z++] >> 10;
        }
        return nums;
        
    }
}