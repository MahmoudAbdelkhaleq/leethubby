class Solution {
    public int firstUniqChar(String s) {
        int [] index = new int [26];
        int big = 100001;
        Arrays.fill(index,-1);
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(index[c-'a'] == -1) index[c-'a'] = i;
            else index[c-'a'] = big;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(min>index[i] && index[i]!=big && index[i]>-1) min = index[i];
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}