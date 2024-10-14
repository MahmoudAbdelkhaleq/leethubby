class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long score = 0;
        for(int n:nums){
            pq.offer(n);
        }
        while(k>0){
            int n = pq.poll();
            score+=n;
            pq.offer((int)Math.ceil(n/3.0));
            k--;
        }
        return score;
    }
}