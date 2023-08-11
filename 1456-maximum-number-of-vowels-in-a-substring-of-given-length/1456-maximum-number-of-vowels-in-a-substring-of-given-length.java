class Solution {
    public int maxVowels(String s, int k) {
        int start = 0;
        int vowels = 0;
        int max = 0;
        String v = "aeiou";
        for(int i = 0;i<s.length();i++){
            if(v.contains(s.charAt(i)+"")) vowels++;
            if(i-start==k-1){
                if(max<vowels) max = vowels;
                if(v.contains(s.charAt(start++)+"")) 
                    vowels--;
            }
        }
        return max;
    }
}