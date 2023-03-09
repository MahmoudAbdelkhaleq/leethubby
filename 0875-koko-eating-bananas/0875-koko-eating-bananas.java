class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i =0;i<piles.length;i++){
            if(piles[i]>max)max = piles[i];
        }
        int min =1;
        while(min<max){
            int mid = min+(max-min)/2;
            if(verify(mid,piles,h)){
                max=mid;
            }
            else{
                min = mid+1;
            }
        }
        return min;
    }
    public static boolean verify(int num, int [] piles, int h){
        int hours = 0;
        for(int i =0;i<piles.length;i++){
            hours = hours+(int)Math.ceil((piles[i]+0.0)/num);
        }
        if(hours<=h) return true;
        return false;
    }
}