class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String parent = folder[0];
        result.add(parent);
        for(String s: folder){
            if(!s.startsWith(parent+"/") && !s.equals(parent)){
                parent = s;
                result.add(s);
            }
        }
        return result;
    }
}