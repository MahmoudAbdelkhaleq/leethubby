class Solution {
    public String getHint(String secret, String guess) {
        int [] secChar = new int [10];
        int [] gusChar = new int [10];
        int bulls = 0;
        for(int i = 0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                secChar[secret.charAt(i)-'0']++;
                gusChar[guess.charAt(i)-'0']++;
            }
        }
        int cows = 0;
        for(int i = 0;i<10;i++){
            cows+=Math.min(secChar[i],gusChar[i]);
        }
        return bulls+"A"+cows+"B";
    }
}