class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int leftPointer = 0;
        int rightPointer = costs.length-1;
        while(leftPointer<candidates){
            if(leftPointer>rightPointer){
                break;
            }
            if(leftPointer==rightPointer){
                left.offer(costs[leftPointer++]);
                break;
            }
            left.offer(costs[leftPointer++]);
            right.offer(costs[rightPointer--]);
        }
        while(k>0){
            if(!right.isEmpty() && !left.isEmpty()){
                if(right.peek()<left.peek()){
                    res+=right.poll();
                    if(rightPointer>=leftPointer)
                        right.offer(costs[rightPointer--]);
                }
                else{
                    res+=left.poll();
                    if(leftPointer<=rightPointer)
                        left.offer(costs[leftPointer++]);
                }
            }
            else{
                if(right.isEmpty()){
                    res+=left.poll();
                }
                else{
                    res+=right.poll();
                }
            }
            k--;
        }
        return res;
    }
}