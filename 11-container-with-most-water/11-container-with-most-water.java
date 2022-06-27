class Solution {
    public int maxArea(int[] height) {
        
//         int Area = 0;
//         int length = height.length;
     
//     for(int i = 0; i < length; i++)
//     {
//         for(int j = i + 1; j < length; j++)
//         {
//             Area = Math.max(Area, Math.min(height[i], height[j]) *(j - i));
            
//         }
//     }
//     return Area;
        
        int ans = 0, i = 0, j = height.length-1, res = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                res = height[i] * (j - i);
                i++;
            } else {
                res = height[j] * (j - i);
                j--;
            }
            if (res > ans) ans = res;
        }
        return ans;
        
    }
}