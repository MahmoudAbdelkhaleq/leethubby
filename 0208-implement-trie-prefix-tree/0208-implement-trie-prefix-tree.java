class Trie {

boolean endWord;
    char character;
    Trie[] children;
    Trie root;
    public Trie() {
        root = new Trie('\0');
    }

    public Trie(char ch){
        character = ch;
        endWord = false;
        children = new Trie[26];
        Arrays.fill(children, null);
    }
    
    public void insert(String word) {
        Trie pointer = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(pointer.children[ch - 'a'] == null){
                pointer.children[ch - 'a'] = new Trie(ch);
            }
            pointer = pointer.children[ch - 'a'];
        }
        pointer.endWord = true;
    }
    
    public boolean search(String word) {
        Trie pointer = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(pointer.children[ch - 'a'] == null){
                return false;
            }
            pointer = pointer.children[ch - 'a'];
        }
        return pointer.endWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie pointer = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(pointer.children[ch - 'a'] == null){
                return false;
            }
            pointer = pointer.children[ch - 'a'];
        }
        return true;
    }
}