class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int start = 0;
        int end = a.length;
        while(start<=end){
            int mid = (start + end)/2;
            if(a[mid]>a[mid-1] && a[mid]>a[mid+1]){
                return mid;
            }
            if(a[mid]>a[mid-1] && a[mid]<a[mid+1]){
                start = mid;
                continue;
            }
            if(a[mid]<a[mid-1] && a[mid] > a[mid+1]){
                end = mid;
            }
        }
        return -1;
    }
}