class Solution {
    public long minimumSteps(String s) {
        long steps = 0;
        int blackBallCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                steps += blackBallCount;
            } else {
                blackBallCount++;
            }
        }

        return steps;
        // for(char c:s.toCharArray()){
        //     if(c == '1')
        //         blackBalls++;
        // }
        // List<Integer> rightWhitePositions = new ArrayList<Integer>();
        // for(int i = s.length()-1;i>s.length()-1-blackBalls;i--){
        //     char c = s.charAt(i);
        //     if(c == '0')
        //         rightWhitePositions.add(i);
        // }
        // for(int i = 0;i<s.length()-blackBalls;i++){
        //     char c = s.charAt(i);
        //     if(c == '1'){
        //         steps+=rightWhitePositions.get(0)-i;
        //         rightWhitePositions.remove(0);
        //     }
        // }
        // return steps;
    }
}