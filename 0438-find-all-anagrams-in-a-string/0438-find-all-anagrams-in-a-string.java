class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int [] countP = new int [26];
        for(int i =0;i<p.length();i++){
            countP[p.charAt(i)-'a']++;
        }
        int [] count = new int [26];
        List<Integer> res = new ArrayList<Integer>();
        int start = 0;
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            if(i+1-start >= p.length()){
                if(check(count, countP)){
                    res.add(start);
                }
                count[s.charAt(start)-'a']--;
                start++;
            }
        }
        return res;
    }
    private boolean check(int [] c1, int [] c2){
        for(int i =0;i<c1.length;i++){
            if(c1[i]!=c2[i]) return false;
        }
        return true;
    }
}