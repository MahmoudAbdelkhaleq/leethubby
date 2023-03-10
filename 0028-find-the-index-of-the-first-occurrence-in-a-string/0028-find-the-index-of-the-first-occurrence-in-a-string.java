class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        ArrayList<Integer> starts = new ArrayList<Integer>();
        for(int i =0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)) starts.add(i);
        }
        // for(int i=1;i<needle.length();i++){
        //     if(starts.isEmpty())
        //         return -1;
        //     for(int j =0;j<starts.size();j++){
        //         if(i+starts.get(j) >=haystack.length() || needle.charAt(i) != haystack.charAt(i+starts.get(j))){
        //             starts.remove(j--);
        //         }
        //     }
        // }
        // if(starts.isEmpty()) return -1;
        // return starts.get(0);
        int pointer = 0;
        for(int j=0;j<starts.size();j++){
            for(int i =starts.get(j);i<haystack.length();i++){
                if(haystack.charAt(i)==needle.charAt(pointer)) pointer++;
                else{ 
                    pointer = 0;
                    starts.remove(j);
                    j--;
                    break;
                }
                if(pointer == needle.length())return starts.get(j);
            }
        }
        return -1;
    }
}