class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        Arrays.sort(happiness);
        int length = happiness.length;
        int j = 0;
        for(int i = length-1;i>length-k-1;i--){
            int happy = happiness[i]-j>0?happiness[i]-j:0;
            if(happy == 0) 
                break;
            res+=happy;
            j++;
        }
        return res;
    }
}