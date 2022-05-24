class Solution {
    public int mySqrt(int x) {
        if(x <= 1)
            return x;
        return (int)Math.floor(Math.sqrt(x));
        
    }
}