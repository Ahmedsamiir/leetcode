class Solution {
    public String intToRoman(int num) {
        
         Map<Integer,String> map = getMapping();
        StringBuilder sb = new StringBuilder();
        int[] order = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i=0;
        while(num!=0){
            if(num/order[i]>0){
                sb.append(map.get(order[i]));
                num-=order[i];
            } else{
                i++;
            }
        }
        return sb.toString();
        
    }
    
     public Map<Integer,String> getMapping(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        return map;
    }
    
    
}