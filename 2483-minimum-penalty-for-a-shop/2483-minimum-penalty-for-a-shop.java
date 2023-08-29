class Solution {
    public int bestClosingTime(String customers) {
        int index = 0;
        int min = 0;
        // for(int i =0;i<customers.length();i++){
        //     if(customers.charAt(i)=='Y')min++;
        // }
        int currentPenalty = min;
        for(int i =0;i<customers.length();i++){
            if(customers.charAt(i)=='Y')currentPenalty--;
            else currentPenalty++;
            if(currentPenalty<min){
                min = currentPenalty;
                index = i+1;
            }
        }
        return index;
    }
}