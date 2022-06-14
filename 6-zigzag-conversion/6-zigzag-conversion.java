class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        String [] zigzag = new String [numRows];
        for(int i=0;i<zigzag.length;i++){
            zigzag[i]="";
        }
        int index = 0;
        boolean zig = false;
        for(int i =0;i<s.length();i++){
            if(!zig){
                zigzag[index]=zigzag[index]+s.charAt(i);
                index++;
            }
            else{
                zigzag[index]=zigzag[index]+s.charAt(i);
                index--;
            }
            if(!zig && index==numRows){
                zig=true;index-=2;
            }
            if(zig && index==-1){
                zig = false;index+=2;
            }
        }
        String result = "";
        for(int i=0;i<zigzag.length;i++){
            result= result + zigzag[i];
        }
        return result;
    }
}