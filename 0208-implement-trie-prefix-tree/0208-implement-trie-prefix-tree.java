class TrieNode{
    boolean isWord;
    TrieNode[] childNodes;
    public TrieNode(){
        childNodes = new TrieNode[26];
        isWord = false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.childNodes[c-'a']!=null){
                current = current.childNodes[c-'a'];
            }
            else{
                TrieNode node = new TrieNode();
                current.childNodes[c-'a'] = node;
                current = node;
            }
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.childNodes[c-'a'] == null){
                return false;
            }
            current = current.childNodes[c-'a'];
        }
        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c: prefix.toCharArray()){
            if(current.childNodes[c-'a'] == null){
                return false;
            }
            current = current.childNodes[c-'a'];
        }
        return true;
    }
}