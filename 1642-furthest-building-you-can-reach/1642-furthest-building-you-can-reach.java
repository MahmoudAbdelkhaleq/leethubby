class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderJumps = new PriorityQueue<>();
        for(int i = 0;i<heights.length-1;i++){
            int diff = heights[i+1]-heights[i];
            if(diff>0){
                if(ladderJumps.size() == ladders){
                    if(ladders == 0 || ladderJumps.peek()>=diff)bricks-=diff;
                    else{
                        bricks-=ladderJumps.poll();
                        ladderJumps.offer(diff);
                    }
                    if(bricks<0) return i;
                }
                else{
                    ladderJumps.offer(diff);
                }
            }
        }
        return heights.length-1;
    }
}