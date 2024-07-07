class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = numBottles;
        int emptyBottles = numBottles;
        while(emptyBottles>=numExchange){
            int newBottles = emptyBottles/numExchange;
            emptyBottles = newBottles + emptyBottles%numExchange;
            drunk += newBottles;
        }
        return drunk;
    }
}