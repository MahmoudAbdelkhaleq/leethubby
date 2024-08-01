class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String passenger: details){
            int age = Integer.parseInt(passenger.charAt(11)+""+passenger.charAt(12));
            if(age>60){
                count++;
            }
        }
        return count;
    }
}