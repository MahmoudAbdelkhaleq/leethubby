class Solution {
    int yDiff(int[] a, int[] b) {
        return a[1] - b[1];
    }
    
    // Returns the delta X.
    int xDiff(int[] a, int[] b) {
        return a[0] - b[0];
    }
    public boolean checkStraightLine(int[][] coordinates) {
        int dX = xDiff(coordinates[1], coordinates[0]);
        int dY = yDiff(coordinates[1], coordinates[0]);
        
        for (int i = 2; i < coordinates.length; i++) {
            if (dY * xDiff(coordinates[i], coordinates[0]) != dX * yDiff(coordinates[i], coordinates[0])) {
                return false;
            }
        }
        return true;
    }
}