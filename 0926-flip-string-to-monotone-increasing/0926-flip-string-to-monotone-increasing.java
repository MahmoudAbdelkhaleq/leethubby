class Solution {
    public int minFlipsMonoIncr(String s) {
        int flips = 0;
        int ones = 0;
        for (int i =0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                flips = Math.min(ones,flips+1);
            }
            else ones++;
        }
        return flips;
    }
    //     for(int i =0;i<s.length()+1;i++){
    //         String current = getString(s.length(),i);
    //         int flips = getFlips(s,current);
    //         if(min>flips) min = flips;
    //     }
    //     return min;
    // }
    // public static String getString(int length, int zeros){
    //     String result = "";
    //     for (int i=0;i<length;i++){
    //         if(i<zeros) result+="0";
    //         else result+="1";
    //     }
    //     return result;
    // }
    // public static int getFlips(String s1,String s2){
    //     int flips = 0;
    //     for(int i=0;i<s1.length();i++){
    //         if(s1.charAt(i) != s2.charAt(i))flips++;
    //     }
    //     return flips;
    // }
}