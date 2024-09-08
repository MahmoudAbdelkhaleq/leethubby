class Solution {
    public String convertDateToBinary(String date) {
        String [] dates = date.split("-");
        String res = "";
        for(String s: dates){
            res+=intToBinary(Integer.parseInt(s))+"-";
        }
        return res.substring(0,res.length()-1);
    }
    public String intToBinary(int num){
        StringBuilder binary = new StringBuilder();
        while(num>0){
            binary.insert(0,num%2);
            num/=2;
        }
        return binary.toString();
    }
}