class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int i=0;  
        while(i<word1.length() && i<word2.length()) res+= word1.charAt(i)+""+word2.charAt(i++);
        for(int j =i;j<word1.length();j++) res+= word1.charAt(j);
        for(int j =i;j<word2.length();j++) res+= word2.charAt(j);
        return res;
    }
}