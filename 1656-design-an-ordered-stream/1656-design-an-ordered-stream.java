class OrderedStream {
    
    String s[];
    int ptr;
    
    public OrderedStream(int n) {
        
        s=new String[n+1];
        ptr=1;
        
    }
    
    public List<String> insert(int idKey, String value) {
        
        List<String> list=new ArrayList<>();
        s[idKey]=value;
        if(idKey==ptr){

        while(ptr<s.length && s[ptr]!=null){

        list.add(s[ptr++]);
        }
    }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */