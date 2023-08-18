class Solution {
    public String countAndSay(int n) {
        return helper(n);
    }
    public String helper(int n){
        if(n==1) return "1";
        String output = helper(n-1);
        int start = 0;
        HashMap<String, Integer> counts = new LinkedHashMap<>();
        for(int i =1;i<output.length();i++){
            if(output.charAt(i)!=output.charAt(start)){
                counts.put(output.charAt(start)+""+start, i-start);
                start = i;
            }
        }
        counts.put(output.charAt(start)+""+start, output.length()-start);
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Integer> set :
             counts.entrySet()) {
            res.append(set.getValue());
            res.append(set.getKey().charAt(0));
        }
        return res.toString();
    }
}