class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12 || s.length()<4) return new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        for(int i =1;i<s.length();i++){
            for(int j =i+1;j<s.length();j++){
                for(int k =j+1;k<s.length();k++){
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,s.length());
                    if(validNum(s1) && validNum(s2) && validNum(s3) && validNum(s4)){
                        String res = s1+"."+s2+"."+s3+"."+s4;
                        result.add(res);
                    }
                }
            }
        }
        return result;
    }
    public static boolean validNum(String s){
        if(s.length()!=1 && s.charAt(0) == '0') return false;
        int x = Integer.parseInt(s);
        if(x>=0 && x<=255) return true;
        return false;
    }
}