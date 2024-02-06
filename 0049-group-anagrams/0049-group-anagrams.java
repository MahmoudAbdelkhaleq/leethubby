class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0 ;i<strs.length;i++){
            int [] freq = new int [26];
            for(int j = 0;j<strs[i].length();j++){
                char c = strs[i].charAt(j);
                freq[c-'a']++;
            }
            String key = "";
            for(int j = 0;j<26;j++){
                if(freq[j]!=0) key = key + freq[j] + ((char)('a'+j) + "");
            }
            map.computeIfAbsent(key, v->new ArrayList<String>()).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> l: map.values()){
            res.add(l);
        }
        return res;
    }
}