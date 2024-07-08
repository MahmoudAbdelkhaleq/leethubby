class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            queue.offer(i);
        }
        int count = 1;
        while(queue.size()>1){
            if(count == k){
                queue.poll();
                count = 1;
            }
            else{
                queue.offer(queue.poll());
                count++;
            }
        }
        return queue.poll();
    }
}