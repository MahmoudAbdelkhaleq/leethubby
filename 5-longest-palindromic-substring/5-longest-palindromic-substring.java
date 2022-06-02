class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for(int i =0;s.length()-i>max.length();i++){
            for(int j =s.length();j-i>max.length();j--){
                if(isPalindrome(s.substring(i,j))){
                    max = s.substring(i,j);
                    break;
                }
            }
        }
        return max;
    }
    public boolean isPalindrome(String s){
        for(int i =0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}