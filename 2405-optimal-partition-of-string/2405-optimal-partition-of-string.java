class Solution {
    public int partitionString(String s) {
        String current = "";
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(current.contains(s.charAt(i)+"")){
                current = "";
                count++;
            }
            current+=s.charAt(i)+"";
        }
        if(!current.equals(""))count++;
        return count;
    }
}