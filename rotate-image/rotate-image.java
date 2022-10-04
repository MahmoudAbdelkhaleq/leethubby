import java.io.*;
import java.util.*;
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int [][] rotated = new int[n][n];
        for (int i =0;i<matrix.length;i++){
            for (int j =0;j<matrix[i].length;j++){
                rotated[j][n-1-i]=matrix[i][j];
            }
        }
        for (int i =0;i<matrix.length;i++){
            for (int j =0;j<matrix[i].length;j++){
                matrix[i][j]=rotated[i][j];
            }
        }
    }
}