class Solution {
    public String minWindow(String s, String t) {
        int end = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        int [] countT = new int [52];
        int [] countS = new int [52];
        String res ="";
        for(char c: t.toCharArray()){
            if(c>='A' && c<='Z')
                countT[c-'A'+26]++;
            else
                countT[c-'a']++;
        }
        while(end<s.length()){
            while(window(countS, countT)){
                if(end-start<min){
                    min =end-start;
                    res = s.substring(start, end);
                }
                char c = s.charAt(start);
                if(c>='A' && c<='Z')

                    countS[c-'A'+26]--;
                else
                    countS[c-'a']--;
                start++;
            }

                char c = s.charAt(end);

                if(c>='A' && c<='Z')
                    countS[c-'A'+26]++;
                else
                    countS[c-'a']++;
                end++;

            }
        while(window(countS, countT)){
            if(end-start<min){
                min =end-start;
                res = s.substring(start, end);
            }
            char c = s.charAt(start);
            if(c>='A' && c<='Z')

                countS[c-'A'+26]--;
            else
                countS[c-'a']--;
            start++;
        }
        return res;
    }
    private boolean window(int [] countS, int [] countT){
        for(int i =0;i<countS.length;i++){
            if(countT[i]>countS[i]) return false;
        }
        return true;
    }
}