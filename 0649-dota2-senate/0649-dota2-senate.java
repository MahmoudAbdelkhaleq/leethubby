class Solution {
    static String winner = "";
    public String predictPartyVictory(String senate) {
        boolean [] hasRight = new boolean[senate.length()];
        Arrays.fill(hasRight, true);
        // int turn = 0;
        Queue<Character> queue = new LinkedList<>();
        while(true){
            for(int i =0;i<senate.length();i++){
                if(queue.isEmpty()){
                    if(hasRight[i]) queue.offer(senate.charAt(i));
                }
                else{
                    if(queue.peek()!=senate.charAt(i) && hasRight[i]){
                        queue.poll();
                        hasRight[i]=false;
                    }
                    else{
                        if(hasRight[i])queue.offer(senate.charAt(i));
                    }
                }
            }
            if(winner(senate, hasRight))break;
        }
        return winner;
    }
    private boolean winner(String senate, boolean[]hasRight){
        int i =0;
        while(i<hasRight.length){
            if(hasRight[i] && senate.charAt(i)=='D') break;
            i++;
        }
        if(i == hasRight.length){
            winner = "Radiant";
            return true;
        }
        i =0;
        while(i<hasRight.length){
            if(hasRight[i] && senate.charAt(i)=='R') break;
            i++;
        }
        if(i == hasRight.length){
            winner = "Dire";
            return true;
        }
        return false;
    }
}