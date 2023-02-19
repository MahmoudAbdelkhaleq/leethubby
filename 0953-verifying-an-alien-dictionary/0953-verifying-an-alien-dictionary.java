class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0;i<words.length-1;i++){
            if(!check(words[i],words[i+1],order)) return false;
        }
        return true;
    }
    public static boolean check(String word1, String word2, String order){
        for(int i=0;i<Math.min(word1.length(),word2.length());i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                for(int j=0;j<order.length();j++){
                    if(word1.charAt(i)==order.charAt(j))return true;
                    if(word2.charAt(i)==order.charAt(j))return false;
                }
            }
        }
        return word1.length()<=word2.length();
    }
}