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
                while(i<s1.length() && i<s2.length()){
                    if(s1.charAt(i)>s2.charAt(i)){
                        return -1;
                    }
                    if(s2.charAt(i)>s1.charAt(i)){
                        return 1;
                    }
                    i++;
                }
                if(s1.length()>s2.length()){
                    int res = s2.charAt(0)-s1.charAt(i);
                    return res != 0 ? res : compare(s1.substring(i),s2);
                }
                if(s2.length()>s1.length()){
                    int res = s2.charAt(i)-s1.charAt(0);;
                    return res != 0 ? res : compare(s1,s2.substring(i));
                }
                return 0;
            }
        });
        StringBuilder res = new StringBuilder();
        int i = 0;
        for(;i<numWords.length-1;i++){
            if(!numWords[i].equals("0")){
                break;
            }
        }
        for(;i<numWords.length;i++){
            res.append(numWords[i]);
        }
        return res.toString();
    }
}