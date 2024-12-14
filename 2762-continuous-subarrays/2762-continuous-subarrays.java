class Solution {
    public long continuousSubarrays(int[] nums) {
        long subarrays = 1;
        int start = 0;
        PriorityQueue<int []> minPQ = new PriorityQueue<>((a,b) -> {
            if(b[0]!=a[0]){
                return a[0] - b[0];
            }
            return a[1]-b[1];
        });
        PriorityQueue<int []> maxPQ = new PriorityQueue<>((a,b) -> {
            if(b[0]!=a[0]){
                return b[0] - a[0];
            }
            return a[1]-b[1];
        });
        minPQ.offer(new int [] {nums[start], start});
        maxPQ.offer(new int [] {nums[start], start});
        for(int i = 1;i<nums.length;i++){
            minPQ.offer(new int [] {nums[i], i});
            maxPQ.offer(new int [] {nums[i], i});
            while(maxPQ.peek()[0]-minPQ.peek()[0]>2){
                if(maxPQ.peek()[1]>minPQ.peek()[1]){
                    start = minPQ.peek()[1]+1;
                    minPQ.poll();
                }
                else{
                    start = maxPQ.peek()[1]+1;
                    maxPQ.poll();
                }
            }
            subarrays+=i-start+1;
        }
        return subarrays;
    }
}