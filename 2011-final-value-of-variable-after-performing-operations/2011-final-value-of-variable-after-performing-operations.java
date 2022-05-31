class Solution {
    public int finalValueAfterOperations(String[] operations) {
        
        int value = 0;
        String a = "++X";
        String b = "X++";
           for(String s : operations)
            {
                if(s.equals(a) || s.equals(b))
                    value++;
                else
                    value--;
            }
         
        return value;
        
    }
}