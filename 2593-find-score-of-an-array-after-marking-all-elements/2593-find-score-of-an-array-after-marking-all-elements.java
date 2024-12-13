class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        Set<Integer> markedIndeces = new HashSet<>();
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
            if(!markedIndeces.contains(current[1])){
                score+=current[0];
                markedIndeces.add(current[1]-1);
                markedIndeces.add(current[1]+1);
            }
        }
        return score;
    }
}