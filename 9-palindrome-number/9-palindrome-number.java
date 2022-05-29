class Solution {
    public boolean isPalindrome(int x) {
        String y = x + "";
        for(int i =0;i<y.length()/2;i++){
            if(y.charAt(i) != y.charAt(y.length()-1-i))
                return false;
        }
        return true;
    }
}