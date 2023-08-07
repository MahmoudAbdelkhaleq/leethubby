class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startI = 0;
        int startJ = 0;
        int endI = matrix.length-1;
        int endJ = matrix[0].length-1;
        int row = -1;
        while(startI<=endI){
            int mid = (startI+endI)/2;
            if(matrix[mid][0]<=target && matrix[mid][endJ]>=target){
                row = mid;
                break;
            }
            else{
                if(matrix[mid][0]>target){
                    endI=mid-1;
                }
                if(matrix[mid][endJ]<target){
                    startI=mid+1;
                }
            }
        }
        if(row==-1)return false;
        while(startJ<=endJ){
            int mid = (startJ+endJ)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            else{
                if(matrix[row][mid]>target){
                    endJ=mid-1;
                }
                if(matrix[row][mid]<target){
                    startJ=mid+1;
                }
            }
        }
        return false;
    }
}