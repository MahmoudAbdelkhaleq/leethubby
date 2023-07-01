class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(int i =0;i<words.length;i++){
            set.add(convert(words[i]));
        }
        return set.size();
    }
    public static String convert(String word){
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        word = word.toLowerCase();
        String res = "";
        for(int i =0;i<word.length();i++){
            res = res+code[word.charAt(i)-97];
        }
        return res;
    }
}