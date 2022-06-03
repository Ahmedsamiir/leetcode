class Solution {
    public String defangIPaddr(String address) {
        
        //replaces all occurrences of "." to "[.]"
        String replaceDotWithParentheses = address.replace(".","[.]");
        
        
        return replaceDotWithParentheses;
        
        
        
    }
}