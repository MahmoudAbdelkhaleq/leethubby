class Solution {
    public String intToRoman(int num) {
        String s = "";
            if(num>=1000){
                for(int i =0;i<num/1000;i++){
                    s=s+"M";
                }
                num = num%1000;
            }
            if(num>=900){
                s=s+"CM";
                num = num-900;
            }
            else{
                if(num>=500){
                    s =s +"D";
                    num = num-500;
                }
                else{
                    if(num>=400){
                        s = s +"CD";
                        num=num-400;
                    }
                }
            }
            if(num>=100){
                for(int i =0;i<num/100;i++){
                    s=s+"C";
                }
                num = num%100;
            }
            ////////////////////////////
            if(num>=90){
                s=s+"XC";
                num = num-90;
            }
            else{
                if(num>=50){
                    s =s +"L";
                    num = num-50;
                }
                else{
                    if(num>=40){
                        s = s +"XL";
                        num=num-40;
                    }
                }
            }
            /////////////////
             if(num>=10){
                for(int i =0;i<num/10;i++){
                    s=s+"X";
                }
                num = num%10;
            }
            ////////////////
            if(num>=9){
                s=s+"IX";
                num = num-9;
            }
            else{
                if(num>=5){
                    s =s +"V";
                    num = num-5;
                }
                else{
                    if(num>=4){
                        s = s +"IV";
                        num=num-4;
                    }
                }
            }
            if(num>0){
                for(int i =0;i<num;i++){
                    s=s+"I";
                }
            }
        return s;
    }
}