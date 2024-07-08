class Solution {
    public int findTheWinner(int n, int k) {
        return winnerHelper(n, k) + 1;
        // List<Integer> nums = new ArrayList<>();
        // for(int i = 1;i<=n;i++){
        //     nums.add(i);
        // }
        // int index = 0;
        // for(int i = 0;i<n-1;i++){
        //     index = (index + k - 1)%nums.size();
        //     nums.remove(index);
        // }
        // return nums.get(0);
        
        // Queue<Integer> queue = new LinkedList<>();
        // for(int i = 1;i<=n;i++){
        //     queue.offer(i);
        // }
        // int count = 1;
        // while(queue.size()>1){
        //     if(count == k){
        //         queue.poll();
        //         count = 1;
        //     }
        //     else{
        //         queue.offer(queue.poll());
        //         count++;
        //     }
        // }
        // return queue.poll();
    }
    private int winnerHelper(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (winnerHelper(n - 1, k) + k) % n;
    }
}