class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) 
            return -1;
        int maxDays = Arrays.stream(bloomDay).max().getAsInt();
        int minDays = 0;
        int min = -1;
        while(maxDays>=minDays){
            int mid = (maxDays-minDays)/2 + minDays;
            if(!check(bloomDay, mid, m, k)){
                minDays = mid+1;
            }
            else{
                if(min>mid || min ==-1)
                    min = mid;
                maxDays = mid-1;
            }
        }
        return min;
    }
    public boolean check(int [] bloomDay, int days, int m, int k){
        int count = 0;
        for(int i = 0;i<bloomDay.length;i++){
            if(bloomDay[i]<=days){
                count++;
            }
            else{
                count = 0;
            }
            if(count == k){
                m--;
                count = 0;
            }
        }
        return m <= 0;
    }
}