class Solution {
    public String countAndSay(int n) {
        return helper(n);
    }
    public String helper(int n){
        if(n==1) return "1";
        String output = helper(n-1);
        int start = 0;
        List<String> strings = new ArrayList<>();
        for(int i =1;i<output.length();i++){
            if(output.charAt(i)!=output.charAt(start)){
                strings.add(output.substring(start,i));
                start = i;
            }
        }
        strings.add(output.substring(start,output.length()));
        String res = "";
        for(int i =0;i<strings.size();i++){
            res = res + strings.get(i).length() + strings.get(i).charAt(0);
        }
        return res;
    }
}