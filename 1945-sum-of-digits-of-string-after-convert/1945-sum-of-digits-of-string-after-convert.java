class Solution {
    public int getLucky(String s, int k) {
        String numString = "";
        for(char c: s.toCharArray()){
            numString+=(c-'a'+1);
        }
        int num = 0;
        for(char c:numString.toCharArray()){
            num+=c-'0';
        }
        while(k>1){
            num = sumDigit(num);
            k--;
        }
        return num;
    }
    public int sumDigit(int num){
        int sum = 0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}