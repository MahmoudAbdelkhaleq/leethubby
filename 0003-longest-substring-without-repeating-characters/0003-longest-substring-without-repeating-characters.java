class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> indeces = new HashMap<Character,Integer>();
        int max = 0;
        int start = 0;
        int length = 0;
        for(int i = 0;i<s.length();i++){
            if(indeces.containsKey(s.charAt(i)) && indeces.get(s.charAt(i))>=start){
                start = indeces.get(s.charAt(i))+1;
                length = i-start+1;
                indeces.put(s.charAt(i),i);
            }
            else{
                indeces.put(s.charAt(i),i);
                length++;
            }
            if(length>max) max = length;
        }
        return max;
    }
}