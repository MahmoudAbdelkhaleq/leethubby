class Solution {
    public int minBitFlips(int start, int goal) {
        return flips(start, goal);
    }
    int flips(int num1, int num2){
        int count = 0;
        while(num1>0 && num2>0){
            if(num1%2!=num2%2){
                count++;
            }
            num1/=2;
            num2/=2;
        }
        while(num1>0){
            if(num1%2==1){
                count++;
            }
            num1/=2;
        }
        while(num2>0){
            if(num2%2==1){
                count++;
            }
            num2/=2;
        }
        return count;
    }
}