class Solution {
    public int minSteps(String s, String t) {
        int [] sf = new int [26];
        int [] tf = new int [26];
        int res = 0;
        for(int i = 0;i<s.length();i++)
            sf[s.charAt(i)-'a']++;
        for(int i = 0;i<t.length();i++)
            tf[t.charAt(i)-'a']++;
        for(int i = 0;i<26;i++)
            if(tf[i]<sf[i])
                res+=(sf[i]-tf[i]);
        return res;
    }
}