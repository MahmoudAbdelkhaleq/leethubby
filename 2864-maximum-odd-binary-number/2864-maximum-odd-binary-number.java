class Solution {
    public String maximumOddBinaryNumber(String s) {
        int countOnes = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '1')countOnes++;
            else res.append('0');
        }
        res.append('1');
        StringBuilder ones = new StringBuilder();
        for(int i = 0;i<countOnes-1;i++){
            ones.append('1');
        }
        ones.append(res.toString());
        return ones.toString();
    }
}