class Solution {
    // public int longestSubsequence(int[] arr, int difference) {
    //     int max = 1;
    //     for(int i =0;i<arr.length;i++){
    //         int length = 1;
    //         if(max<arr.length-i){
    //             for(int j =i+1;j<arr.length;j++){
    //                 if(arr[j]-arr[i]==difference*length)length++;
    //             }
    //             if(length>max) max = length;
    //         }
    //     }
    //     return max;
    // }
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 1;
        for(int i =0;i<arr.length;i++){
            if(map.get(arr[i]-difference)!=null){
                map.put(arr[i], map.get(arr[i]-difference)+1);
                ans = Math.max(ans, map.get(arr[i]));
            }
            else{
                map.put(arr[i], 1);
            }
        }
        return ans;
    }
}