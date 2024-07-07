class Solution {
    public String getEncryptedString(String s, int k) {
        int shift = k%s.length();
        StringBuilder res= new StringBuilder();
        res.append(s.substring(shift));
        res.append(s.substring(0,shift));
        return res.toString();
    }
}