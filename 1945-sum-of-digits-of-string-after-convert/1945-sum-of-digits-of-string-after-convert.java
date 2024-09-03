class Solution {
    public int getLucky(String s, int k) {
        int num = 0;
        for(char c:s.toCharArray()){
            num+=sumDigit(c-'a'+1);
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