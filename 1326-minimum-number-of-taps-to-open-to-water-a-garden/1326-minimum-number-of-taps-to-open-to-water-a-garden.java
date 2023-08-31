class Solution {
    public int minTaps(int n, int[] ranges) {
        int [][] intervals = new int [ranges.length][2];
        for(int i =0;i<=n;i++){
            intervals[i] = new int [] {i-ranges[i], i+ranges[i]};
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int [] a, int [] b){
                if(a[0]<b[0]) return -1;
                if(a[0]>b[0]) return 1;
                if(a[1]<=b[1])return -1;
                return 1;
            }
        });
        int covered = 0;
        int i =0;
        int taps = 0;
        while(covered<n){
            int max = 0;
            while(i<intervals.length){
                if(intervals[i][0]>covered) break;
                if(intervals[i][1]>max) max = intervals[i][1];
                i++;
            }
            if(max == 0) return -1;
            covered = max;
            taps++;
        }
        return taps;
    }
}