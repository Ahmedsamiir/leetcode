class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
         int waterLeft = capacity;
         int steps = 0;
         int len = plants.length;

        for(int i = 0; i < len; ++i) {

        if(waterLeft < plants[i]) {
         waterLeft = capacity;
            steps += (i << 1) + 1; // (i << 1) is equivalent to (i * 2);
        } else {
         ++steps;
        }

         waterLeft -= plants[i];
        }

     return steps;
        
    }
}