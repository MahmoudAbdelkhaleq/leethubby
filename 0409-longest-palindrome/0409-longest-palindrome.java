class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> data = new HashMap<Character,Integer>();
        for(int i =0;i<s.length();i++){
            if(data.containsKey(s.charAt(i)))
                data.put(s.charAt(i),data.get(s.charAt(i))+1);
            else
                data.put(s.charAt(i),1);
        }
        int max = 0;
        boolean oneLetter = false;
        for (int count : data.values()){
            if(count%2==0) max +=count;
            else{
                max+=count-1;
                oneLetter = true;
            }
        }
        if(oneLetter) max++;
        return max;
    }
}