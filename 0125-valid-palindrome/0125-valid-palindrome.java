class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        String clean = "";
        for(int i =0;i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') ||(s.charAt(i)>='0' && s.charAt(i)<='9')){
                clean+=s.charAt(i);
            }
        }
        System.out.println(clean);
        int i =0;
        int j = clean.length()-1;
        while(i<j){
            if(clean.charAt(i)!=clean.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}