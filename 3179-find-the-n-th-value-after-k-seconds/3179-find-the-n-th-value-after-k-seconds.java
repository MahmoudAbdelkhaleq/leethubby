class Solution {
    private final long MOD = 1000000007;
    public int valueAfterKSeconds(int n, int k) {
        long [] arr = new long[n];
        Arrays.fill(arr,1);
        while(k>0){
            prefixSum(arr);
            k--;
        }
        return (int)arr[n-1];
    }
    void prefixSum(long [] arr){
        for(int i = 0;i<arr.length-1;i++){
            arr[i+1] = (arr[i+1]+arr[i])%MOD;
        }
    }
}