class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        boolean [] marked = new boolean[nums.length];
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else 
                return a[1] - b[1];
            
        });
        for(int i = 0;i<nums.length;i++){
            pq.offer(new int [] {nums[i], i});
        }
        while(!pq.isEmpty()){
            int [] current = pq.poll();
            if(!marked[current[1]]){
                score+=current[0];
                if(current[1]>0)
                    marked[current[1]-1] = true;
                if(current[1]<nums.length-1)
                    marked[current[1]+1] = true;
            }
        }
        return score;
    }
}