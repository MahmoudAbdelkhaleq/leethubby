class Solution {
    public String largestNumber(int[] nums) {
        String [] numWords = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            numWords[i] = nums[i]+"";
        }
        Arrays.sort(numWords, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int i = 0;
                for(;i<s1.length() && i<s2.length();i++){
                    int res = s2.charAt(i) - s1.charAt(i);
                    if(res != 0) return res;
                }
                if(s1.length()>s2.length()){
                    return compare(s1.substring(i),s2);
                }
                if(s2.length()>s1.length()){
                    return compare(s1,s2.substring(i));
                }
                return 0;
            }
        });
        StringBuilder res = new StringBuilder();
        int i = 0;
        for(;i<numWords.length-1 && numWords[i].equals("0");i++){}
        for(;i<numWords.length;i++){
            res.append(numWords[i]);
        }
        return res.toString();
    }
}