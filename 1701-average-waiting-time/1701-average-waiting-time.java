class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total = 0;
        int currentTime = 1;
        for(int [] customer: customers){
            currentTime = Math.max(currentTime, customer[0]);
            currentTime+= customer[1];
            total+=currentTime-customer[0];
        }
        return total/(customers.length+0.0);
    }
}