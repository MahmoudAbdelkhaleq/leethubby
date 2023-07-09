class Solution {
    public int largestVariance(String s) {
        int [] counter = new int [26];
        for(char c : s.toCharArray()){
            counter[(int) (c-'a')]++;
        }
        int max = 0;
        for(int i =0;i<26;i++){
            if(counter[i]==0) continue;
            for(int j = 0;j<26; j++){
                if(i==j || counter[j] ==0)
                    continue;
                char major = (char)('a' + i);
                char minor = (char)('a' + j);
                int majorCount = 0;
                int minorCount = 0;
                int remMinors = counter[j];
                for(char c : s.toCharArray()){
                    if(c==major) majorCount++;
                    if(c==minor){ 
                        minorCount++;
                        remMinors--;
                    }
                    if(minorCount>0)
                        max= Math.max(max, majorCount-minorCount);
                    if(majorCount < minorCount && remMinors>0){
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }
        return max;
    }
}