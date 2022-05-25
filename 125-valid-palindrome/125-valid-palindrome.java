class Solution {
    public boolean isPalindrome(String s) {
        
       StringBuffer buf= new StringBuffer();
        
       for(char c: s.toCharArray())
       {
           if(isAlphaNum(c))
               buf.append(lowerCase(c));
       }
        
        String input,reversed;
        input= buf.toString();
        reversed= buf.reverse().toString();
        
        if(input.equals(reversed))
            return true;
        else 
            return false;
    }
    
     static boolean isAlphaNum(char c)
    {
        if( (48<=c && c<=57) || (65<=c && c<=90) || (97<=c && c<=122)) 
            return true;
        else
            return false;
    }
    
    static char lowerCase(char c)
    {
        if(65<=c && c<=90)
            return (char)(c+32);
        else 
            return c;
    }
}