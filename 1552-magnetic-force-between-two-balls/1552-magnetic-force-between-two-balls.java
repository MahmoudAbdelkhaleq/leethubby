class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int min = position[0];
        int max = position[n-1];
        int start = 1;
        int end = (int) Math.ceil((max-min) / (m-1));
        int maxForce = 0;
        while(start<=end){
            int mid = (end-start)/2 + start;
            if(check(position, m, mid)){
                maxForce = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return maxForce;
    }
    public boolean check(int [] position, int m, int force){
        int prevBallPos = 0;
        int ballsCount = 1;
        for(int i = 1;i<position.length && ballsCount < m ; i++){
            if(position[i]-position[prevBallPos] >=force){
                ballsCount++;
                prevBallPos = i;
            }
        }
        return ballsCount == m;
    }
}