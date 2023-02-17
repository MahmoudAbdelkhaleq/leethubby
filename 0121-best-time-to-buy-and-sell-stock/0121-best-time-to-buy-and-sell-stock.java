class Solution {
    public int maxProfit(int[] prices) {
        int minStock = Integer.MAX_VALUE;
        int max = 0;
        for(int i =0;i< prices.length;i++){
            if(prices[i]<minStock)
                minStock = prices[i];
            else{
                if(prices[i]-minStock > max){
                    max = prices[i]-minStock;
                }
            }
        }
        return max;
    }
}