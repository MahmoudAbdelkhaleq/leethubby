class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        for(int i =0;i<ransomNote.length();i++){
            if(magazine.contains(ransomNote.charAt(i)+""))
                magazine = magazine.replaceFirst(ransomNote.charAt(i)+"","");
            else return false;
        }
        return true;
    }
}