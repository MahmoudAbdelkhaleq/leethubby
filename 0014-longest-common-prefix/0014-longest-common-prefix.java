class Solution {
    public String longestCommonPrefix(String[] strs) {
        String min = strs[0];
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<min.length())min = strs[i];
        }
        String result = "";
        for(int i=0;i<min.length();i++){
            boolean out = false;
            for(int j =0;j<strs.length;j++){
                if(min.charAt(i) != strs[j].charAt(i)){
                    out = true;
                    break;
                }
                if(j==strs.length-1) result+=min.charAt(i);
            }
            if(out)break;
        }
        return result;
    }
}