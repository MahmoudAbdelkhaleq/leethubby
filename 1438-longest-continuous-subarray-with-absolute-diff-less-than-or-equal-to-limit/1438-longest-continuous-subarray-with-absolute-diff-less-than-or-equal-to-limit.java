class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         int maxLength = 1;
//         int currLength = 1;
//         int start = 0;
//         int minNum = nums[0];
//         int maxNum = nums[0];
        
//         for(int i = 1;i<nums.length;i++){
//             if(nums[i]<minNum){
//                 minNum = nums[i];
//             }
//             if(nums[i]>maxNum){
//                 maxNum = nums[i];
//             }
//             if(maxNum-minNum<=limit){
//                 currLength++;
//             }
//             else{
//                 if(maxLength<currLength){
//                     maxLength = currLength;
//                 }
//                 while(maxNum-minNum>limit){
//                     if(nums[start] == minNum){
//                         minNum = maxNum;
//                         int tmp = start;
//                         start = i;
//                         for(int j = tmp+1;j<=i;j++){
//                             if(minNum>nums[j]){
//                                 minNum = nums[j];
//                                 start = j;
//                             }
//                         }
//                         break;
//                     }
//                     else {
//                         if(nums[start] == maxNum){
//                             maxNum = minNum;
//                             int tmp = start;
//                             start = i;
//                             for(int j = tmp+1;j<=i;j++){
//                                 if(maxNum<nums[j]){
//                                     maxNum = nums[j];
//                                     start = j;
//                                 }
//                             }
//                             break;
//                         }
//                     }
//                     start++;
//                 }
//                 currLength = i-start+1;
//             }
//         }
        
//         return Math.max(currLength, maxLength);
//     }
    public int longestSubarray(int [] nums, int limit){
        PriorityQueue<int []> minPQ = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]);
        PriorityQueue<int []> maxPQ = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]);
        int start = 0;
        int maxLength = 1;
        for(int i = 0;i<nums.length;i++){
            minPQ.offer(new int[]{nums[i], i});
            maxPQ.offer(new int[]{nums[i], i});
            while(maxPQ.peek()[0]-minPQ.peek()[0]>limit){
                // find min index to start with between min and max pq
                start = Math.min(maxPQ.peek()[1], minPQ.peek()[1])+1;
                while(maxPQ.peek()[1]<start){
                    maxPQ.poll();
                }
                while(minPQ.peek()[1]<start){
                    minPQ.poll();
                }
            }
            maxLength = Math.max(maxLength, i-start+1);
        }
        return maxLength;
    }
}