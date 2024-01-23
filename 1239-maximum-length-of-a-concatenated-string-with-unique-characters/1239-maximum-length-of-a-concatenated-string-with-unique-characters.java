class Solution {
    public int maxLength(List<String> arr) {
        for(int i = 0;i<arr.size();i++){
            if(dupInString(arr.get(i))) arr.remove(i--);
        }
        return dfs(arr, 0, "");
    }
    public int dfs(List<String> arr, int index, String s){
        if(index == arr.size()) return s.length();
        boolean can = true;
        String add = arr.get(index);
        for (int i = 0;i<add.length();i++){
            if(s.contains(add.charAt(i)+"")) can = false;
        }
        if(!can) return dfs(arr, index+1, s);
        return Math.max(dfs(arr, index+1, s), dfs(arr, index+1, s+arr.get(index)));
    }
    public boolean dupInString(String s){
        boolean [] ch = new boolean[26];
        for(int i = 0;i<s.length();i++){
            if(ch[s.charAt(i)-'a']) return true;
            ch[s.charAt(i)-'a'] = true;
        }
        return false;
    }
}