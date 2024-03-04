class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int start = 0;
        int maxScore = score;
        int end = tokens.length-1;
        while(start<=end){
            if(power>=tokens[start]){
                power-=tokens[start++];
                score++;
            }
            else 
                if(score>0){
                    power+=tokens[end--];
                    score--;
                }
                else break;
            if(score>maxScore)
                maxScore = score;
        }
        return maxScore;
    }
}