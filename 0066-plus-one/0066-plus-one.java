class Solution {
    public int[] plusOne(int[] digits) {
        int [] res;
        boolean d = true;
        for(int i = digits.length-1;i>=0;i--){
            if(digits[i]==9 && d){
                digits[i] = 0;
            }
            else{
                if(d){
                digits[i]++;
                d= false;
                }
            }
        }
        if(digits[0] == 0){
            res = new int [digits.length+1];
            res[0] = 1;
            for(int i = 1;i<res.length;i++){
                res[i] = digits[i-1];
            }
        }
        else{
            res = new int [digits.length];
            for(int i = 0;i<res.length;i++){
                res[i] = digits[i];
            }
        }
        return res;
    }
}