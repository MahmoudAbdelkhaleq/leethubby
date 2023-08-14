
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int num:nums){
        //     pq.add(num);
        //     if(pq.size()>k) pq.remove();
        // }
        // return pq.peek();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        
        for (int num: nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }
        int[] count = new int[maxValue - minValue + 1];
        for (int num: nums) {
            count[num - minValue]++;
        }
        for (int num = count.length - 1; num >= 0; num--) {
            k -= count[num];
            if (k <= 0) {
                return num + minValue;
            }
        }
        
        return -1;
    }
}