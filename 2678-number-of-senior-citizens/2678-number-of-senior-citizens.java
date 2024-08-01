class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String passenger: details){
            char d1 = passenger.charAt(11);
            char d2 = passenger.charAt(12);
            if(d1>'6' || d1 == '6' && d2>'0'){
                count++;
            }
        }
        return count;
    }
}