class Solution {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(),b.length());
        while(a.length()<length) a = "0" + a;
        while(b.length()<length) b = "0" + b;
        boolean carry = false;
        String result = "";
        for(int i =length-1;i>=0;i--){
            int x = Integer.parseInt(a.charAt(i)+"")+Integer.parseInt(b.charAt(i)+"");
            if(carry)x++;
            switch(x){
                case 0:result="0"+result;carry=false;break;
                case 1:result="1"+result;carry=false;break;
                case 2:result="0"+result;carry=true;break;
                default:result="1"+result;carry=true;
            }
        }
        if(carry) result = "1" + result;
        return result;
    }
}