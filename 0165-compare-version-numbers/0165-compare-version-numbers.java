class Solution {
    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        int n = v1.length<v2.length ? v1.length : v2.length;
        for(int i = 0;i<n;i++){
            if(Integer.parseInt(v1[i])>Integer.parseInt(v2[i]))
                return 1;
            if(Integer.parseInt(v1[i])<Integer.parseInt(v2[i]))
                return -1;
        }
        int n2 = v1.length<v2.length ? v2.length : v1.length;
        String [] v3 = v1.length<v2.length ? v2 : v1;
        for(int i = n;i<n2;i++){
            if(Integer.parseInt(v3[i])>0){
                if(v1.length>v2.length) return 1;
                return -1;
            }
        }
        return 0;
    }
}