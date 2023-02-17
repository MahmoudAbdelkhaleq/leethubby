class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        HashMap<String,String> indeces = new HashMap<String,String>();
        fill(image,sr,sc,color,indeces);
        return image;
    }
    public static void fill(int[][] image, int sr, int sc, int color, HashMap<String,String> indeces){
        if(indeces.containsKey(sr+" "+sc)) return;
        int n = image.length;
        int m = image[0].length;
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        indeces.put(sr+" "+sc,"");
        if(sr>0 && image[sr-1][sc] == oldColor) fill(image,sr-1,sc,color,indeces);
        if(sr<n-1 && image[sr+1][sc] == oldColor) fill(image,sr+1,sc,color,indeces);
        if(sc>0 && image[sr][sc-1] == oldColor) fill(image,sr,sc-1,color,indeces);
        if(sc<m-1 && image[sr][sc+1] == oldColor) fill(image,sr,sc+1,color,indeces);
    }
}