class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char c= s.charAt(i);
            if(c=='a' ||c=='e' || c=='i' || c=='o' || c == 'u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U') vowels.append(c);
        }
        int j = vowels.length()-1;
        StringBuilder res = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char c= s.charAt(i);
            if(c=='a' ||c=='e' || c=='i' || c=='o' || c == 'u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U') res.append(vowels.charAt(j--));
            else res.append(s.charAt(i));
        }
        return res.toString();
    }
}