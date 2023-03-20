class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int start = 0;
        int end = 0;
        
        for(int i =0;i<flowerbed.length;i++){
            if(i ==0 && flowerbed.length>1 && flowerbed[1]==0 && flowerbed[0]==0){
                flowerbed[0]=1;count++;
            }
            if(i>0 && i<flowerbed.length-1 && flowerbed[i] == 0){
                if(flowerbed[i-1]==0 && flowerbed[i+1]== 0) {
                    flowerbed[i]=1;count++;
                }
            }
            if(i == flowerbed.length-1 && flowerbed.length>1 && flowerbed[i-1] == 0 && flowerbed[i]==0)
                count++;
            if(flowerbed.length == 1 && flowerbed[0]==0)count = 1;
            // if(flowerbed[i]==1){
            //     if(start == 0)
            //         count = count + (end-start+1)/2;
            //     else
            //         count = count + (end-start)/2;
            // }
            // else{
            //     if(i-1>=0 && flowerbed[i-1]==1){
            //         start = i;
            //     }
            //     end=i;
            // }
        }
        return count>=n;
    }
}