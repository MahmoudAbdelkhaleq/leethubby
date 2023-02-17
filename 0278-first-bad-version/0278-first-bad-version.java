/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        
        while(start<=end){
            int i = start + (end-start)/2;
            if(isBadVersion(i) && !isBadVersion(i-1))   return i;
            else if(!isBadVersion(i)) start = i+1;
            else end= i-1;
        }
        return 0;
    }
}