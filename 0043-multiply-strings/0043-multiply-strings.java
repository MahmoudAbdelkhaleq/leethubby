class Solution {
    public String multiply(String num1, String num2) {
        String res = "0";
        if(num2.length()>num1.length()){
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        int carry = 0;
        for(int i = num2.length()-1;i>-1;i--){
            int d1 = num2.charAt(i)-'0';
            if(d1==0) continue;
            StringBuilder current = new StringBuilder();
            for(int j = num1.length()-1;j>-1;j--){
                int d2 = num1.charAt(j)-'0';
                int mul = d1*d2 + carry;
                current.insert(0, mul%10);
                if(mul>=10)carry = mul/10;
                else carry = 0;
            }
            if(carry!=0){
                current.insert(0,carry);
                carry = 0;
            }
            for(int j =num2.length()-1;j>i;j--) current.append("0");
            res = add(res, current.toString());
        }
        return res;
    }
    public String add(String num1, String num2){
        if(num2.length()<num1.length())while(num1.length()!=num2.length()) num2="0"+num2;
        else while(num1.length()!=num2.length()) num1="0"+num1;
        StringBuilder res= new StringBuilder();
        int carry = 0;
        for(int i=num1.length()-1;i>-1;i--){
            int digit = (num1.charAt(i)-'0') + (num2.charAt(i)-'0') + carry;
            res.insert(0, (digit%10)+"");
            if(digit>=10) carry = 1;
            else carry = 0;
        }
        if(carry!=0){
                res.insert(0,carry);
                carry = 0;
        }
        return res.toString();
    }
}