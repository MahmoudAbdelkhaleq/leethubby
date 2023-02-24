class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String big = str2;
        String small = str1;
        if(str1.length() > str2.length()){
            big = str1;
            small = str2;
        }
        int max = small.length();
        int bigLength = big.length();
        int div = 1;
        while(div<=max){
            if(max%div == 0 && bigLength%(small.length()/div) == 0){
                String possible = small.substring(0,small.length()/div);
                if(divisible(big,possible) && divisible(small,possible)){
                    return possible;
                }
                else{
                    div++;
                }
            }
            else{
                div++;
            }
        }
        return "";
    }
    public static boolean divisible(String big, String possible){
        for(int i =0;i<big.length();i=i+possible.length()){
            if(!possible.equals(big.substring(i,i+possible.length()))) return false;
        }
        return true;
    }
}