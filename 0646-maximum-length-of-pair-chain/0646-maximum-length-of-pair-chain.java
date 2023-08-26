class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int [] x1, int [] x2){
                if(x1[0]<x2[0])return -1;
                if(x1[0]==x2[0]){
                    if(x1[1]<x2[1])return -1;
                }
                return 1;
            }
        });
        int [] dp = new int[pairs.length];
        dp[0]=1;
        for(int i =1;i<dp.length;i++){
            int max = dp[i-1];
            for(int j =i-1;j>-1;j--){
                if(dp[j] == max){
                    if(pairs[i][0]>pairs[j][1]){
                        dp[i]=1+dp[j];
                        break;
                    }
                }
            }
            if(dp[i]==0)dp[i]=dp[i-1];
        }
        return dp[pairs.length-1];
    }
//     private int solve (int [][] pairs, int index, int [] dp){
        
//     }
}