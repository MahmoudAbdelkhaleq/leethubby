class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        for(int i = 0;i<matrix[0].length;i++){
            List<Integer> index = new ArrayList<Integer>();
            int max = matrix[0][i];
            for(int j = 0;j<matrix.length;j++){
                if(max<matrix[j][i]) max = matrix[j][i];
                if(matrix[j][i] == -1) index.add(j);
            }
            if(max == -1) continue;
            for(int j = 0;j<index.size();j++){
                matrix[index.get(j)][i] = max;
            }
        }
        return matrix;
    }
}