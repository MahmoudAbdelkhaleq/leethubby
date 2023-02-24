class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int []>(){
            public int compare(int [] x, int [] y){
                if(x[0]<y[0]) return -1;
                if(x[0] == y[0]){
                    if(x[1]<y[1]) return -1;
                    if(x[1] == y[1]) return 0;
                    else return 1;
                }
                else return 1;
            }
        });
        List<int []> list = new ArrayList<int[]>();
        for(int i =0;i<intervals.length;i++){
            list.add(intervals[i]);
        }
        for(int i =0;i<list.size()-1;i++){
            if(overlapping(list.get(i),list.get(i+1))){
                int [] x = list.get(i);
                x[1] = Math.max(x[1],list.get(i+1)[1]);
                x[0] = Math.min(x[0],list.get(i+1)[0]);
                list.remove(i+1);
                i--;
            }
        }
        int [][] result = new int[list.size()][2];
        for(int i =0;i<result.length;i++){
            result[i]=list.get(i);
        }
        return result;
    }
    public static boolean overlapping(int [] x, int [] y){
        if((y[0]<x[0] && y[1]<x[0]) || (y[0]>x[1] && y[1]>x[1])) return false;
        return true;
    }
}