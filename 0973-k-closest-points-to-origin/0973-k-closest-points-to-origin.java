class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] frst, int[] scnd) {
                double dist1 = Math.sqrt(frst[0]*frst[0]+frst[1]*frst[1]);
                double dist2 = Math.sqrt(scnd[0]*scnd[0]+scnd[1]*scnd[1]);
                  if(dist1 >= dist2) {
                         return 1;
                   }
                   else return -1;
            }
        });
        return Arrays.copyOfRange(points, 0, k);
    }
}