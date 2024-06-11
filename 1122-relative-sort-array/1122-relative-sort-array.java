class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int lastIndex = -1;
        for(int i = 0;i<arr2.length;i++){
            for(int j = lastIndex+1;j<arr1.length;j++){
                if(arr1[j] == arr2[i]){
                    int tmp = arr1[j];
                    arr1[j] = arr1[++lastIndex];
                    arr1[lastIndex] = tmp;
                }
            }
        }
        Arrays.sort(arr1, lastIndex+1, arr1.length);
        return arr1;
    }
}