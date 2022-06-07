class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max = 0;
        int size = candies.length;
        List<Boolean> result = new ArrayList<>();
        
        for(int i =0 ; i < size ; i++){
            
            if(candies[i] > max){
                
                max = candies[i]; 
            }
   
        }
        
        
        for(int i =0 ; i < size ; i++){
           
            
            result.add(candies[i] + extraCandies >= max);
            
        }
        
       
        return result;
    }
}