class Solution {
    public int findKthPositive(int[] arr, int k) {
        int begin = 0;
        for(int i =0;i<arr.length;i++){
            int diff = arr[i]-begin;
            if(diff>1){
                if(k<diff){
                    return begin+k;
                }
                k = k-(diff-1);
            }
            begin = arr[i];
        }
        return begin+k;
    }
}