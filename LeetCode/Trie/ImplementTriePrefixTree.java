// https://leetcode.com/problems/implement-trie-prefix-tree/description

class Trie {
    class Node {
        Map<Character, Trie> map;
        boolean isWord;

        public Node(){
            map = new HashMap<>();
            isWord = false;
        }
    }
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Trie temp = this;

        for (char ch: word.toCharArray()){

            if (!temp.root.map.containsKey(ch))
                temp.root.map.put(ch, new Trie());

            temp = temp.root.map.get(ch);
        }
        temp.root.isWord = true;
    }
    
    public boolean search(String word) {
        Trie temp = this;

        for (char ch: word.toCharArray()){

            if (!temp.root.map.containsKey(ch))
                return false;
            
            temp = temp.root.map.get(ch);
        }

        return temp.root.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie temp = this;

        for (char ch: prefix.toCharArray()){
            if (!temp.root.map.containsKey(ch))
                return false;
            
            temp = temp.root.map.get(ch);
        }
        return true;
    }
}
