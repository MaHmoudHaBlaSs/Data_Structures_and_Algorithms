// https://leetcode.com/problems/design-add-and-search-words-data-structure/


class WordDictionary {
    class Node {
        Node[] childs;
        boolean isWord;

        public Node(){
            childs = new Node[26];
            isWord = false;
        }
    }
    Node root;

    public WordDictionary() {
        root = new Node();  
    }
    
    public void addWord(String word) {
        Node temp = root;

        for (char ch: word.toCharArray()){
            if (temp.childs[ch - 'a'] == null)
                temp.childs[ch - 'a'] = new Node();
            
            temp = temp.childs[ch - 'a'];
        }
        temp.isWord = true;
    }
    
    public boolean search(String word) {
        return helperSearch(word, 0,root);
    }

    // Mixed Logic between Recursive and Itterative 
    public boolean helperSearch (String word, int step, Node trie){
        Node temp = trie;

        for (int i = step; i < word.length(); i++){
            char ch = word.charAt(i);
            if ( ch == '.'){
                for(Node branch : temp.childs){
                    if (branch != null && helperSearch(word, i+1, branch))
                        return true;
                }
                return false;
            }
            else{
                if (temp.childs[ch - 'a'] == null)
                    return false;
                temp = temp.childs[ch - 'a'];
            }
        }
        return temp.isWord;
    }
}