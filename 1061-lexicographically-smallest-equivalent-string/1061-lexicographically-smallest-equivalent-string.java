import java.util.*;
class Solution {
    static Hashtable<Character, Character> finalEquiv = new Hashtable<Character, Character>();
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        finalEquiv.clear();
        String result = "";
        for (int i=0;i<baseStr.length();i++){
            if(!finalEquiv.containsKey(baseStr.charAt(i))){
                ArrayList<Character> letters = new ArrayList<Character>();
                letters.add(baseStr.charAt(i));
                result+=(get(letters,s1,s2)+"");
            }
            else result+=finalEquiv.get(baseStr.charAt(i));
        }
        return result;
    }
    public static char get(ArrayList<Character> letters, String s1, String s2){
        for(int i=0;i<letters.size();i++){
            int n = letters.size();
            char c = letters.get(i);
            for (int j =0;j<s1.length();j++){
                if(c == s1.charAt(j) && !letters.contains(s2.charAt(j))){
                    letters.add(s2.charAt(j));
                }
                if(c == s2.charAt(j) && !letters.contains(s1.charAt(j))){
                    letters.add(s1.charAt(j));
                }
            }
        }
        char min = letters.get(0);
        for(int i =1;i<letters.size();i++){
            if(min>letters.get(i)) min = letters.get(i);
        }
        finalEquiv.put(letters.get(0),min);
        return min;
    }
}