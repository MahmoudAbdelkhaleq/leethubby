import java.lang.Math;
class Solution {
    boolean neg = false;
    public int reverse(int x) {
        // if(x<0){
        //     neg = true;
        //     long sum = -reverse(-x);
        //     if(sum < -2147483648) return 0;
        //         return (int)sum;
        // }
        String digits=""+x;
        if (x<0){
            neg = true;
            digits=digits.substring(1,digits.length());
        }
        long sum = 0;
        for(int i=0;i<digits.length();i++){
            String s = digits.charAt(i)+"";
            sum+=Integer.parseInt(s)*Math.pow(10,i);
            if (!neg && sum > 2147483647)
                return 0;
            
            if (neg && -sum < -2147483648)
                return 0;
        }
       if (neg) return (int)-sum;
    return (int)sum;
    }
}