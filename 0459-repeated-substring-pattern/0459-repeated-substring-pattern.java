class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int size = 1;
        int plus = 1;
        if(s.length()%2==1) plus = 2;
        while(size<=s.length()/2){
            int index = size;
            String sample = s.substring(0,size);
            while(index+size<=s.length()){
                if(!sample.equals(s.substring(index, index+size))) break;
                index+=size;
            }
            if(index==s.length()) return true;
            size+=plus;
        }
        return false;
    }
}