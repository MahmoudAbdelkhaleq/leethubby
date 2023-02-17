class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        ArrayList<Character> x = new ArrayList<Character>();
        for(int i =0;i<s.length();i++){
            x.add(s.charAt(i));
        }
        for(int i =0;i<t.length();i++){
            if(!x.contains(t.charAt(i))) return false;
            x.remove((Character)t.charAt(i));
        }
        return x.isEmpty();
    }
}