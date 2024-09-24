class TrieNode{
    // from 0 to 9
    TrieNode [] children = new TrieNode[10];
}
class Trie{
    TrieNode root = new TrieNode();
    public void insert(int num){
        TrieNode current = root;
        String numString = num+"";
        for(char c: numString.toCharArray()){
            int index = c-'0';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
    }
    public int getLongestPrefix(int num){
        TrieNode current = root;
        String numString = num+"";
        int length = 0;
        for(char c: numString.toCharArray()){
            int index = c-'0';
            if(current.children[index] == null){
                break;
            }
            length++;
            current = current.children[index];
        }
        return length;
    }
}
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for(int num:arr1){
            trie.insert(num);
        }
        int maxLength = 0;
        for(int num:arr2){
            int length = trie.getLongestPrefix(num);
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}