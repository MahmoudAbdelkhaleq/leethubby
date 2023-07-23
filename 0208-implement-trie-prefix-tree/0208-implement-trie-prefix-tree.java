class Trie {

    HashSet<String> data;
    public Trie() {
        data = new HashSet<String>();
    }
    
    public void insert(String word) {
        data.add(word);
    }
    
    public boolean search(String word) {
        return data.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        for(String s: data){
            if(s.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
}