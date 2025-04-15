// https://leetcode.com/problems/lru-cache/description/

// Optimal.
class LRUCache {
    int len;
    int size;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        len = capacity;
        size = 0;
        map = new HashMap<>(len);
    }
    
    public int get(int key) {
        // Update List
        if (map.containsKey(key)){
            Node temp = map.get(key);

            if (size != 1){
                temp.remove();
                insertLast(temp);
            }
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if (map.containsKey(key)) { // Already Exists
            Node temp = map.get(key);
            // Update Map
            temp.val = value; // Update Key Value

            // Update List
            if (size != 1){
                temp.remove();
                insertLast(temp);
            }
        } 
        else {
            Node newNode = new Node(key, value);

            if (size == len) { // No Available Slots   
                // Update Map
                map.remove(head.key);
                map.put(key, newNode);

                // Update List
                if (size != 1){
                    head.remove();
                    insertLast(newNode);
                }
                else{
                    head = newNode;
                    tail = newNode;
                }
            } 
            else { // Available Slots
                // Update Map
                map.put(key, newNode);

                // Update List
                if (head == null){ // First Node
                    head = newNode;
                    tail = head;
                }
                else
                    insertLast(newNode);

                size++;
            }
        }
    }
    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node (int key, int val){
            this.key = key;
            this.val = val;
        }

        public void remove(){
            if (pre == null){ // Head Node
                head = head.next;
                head.pre = null;
            }
            else if (next == null){ // Tail Node
                tail = tail.pre;
                tail.next = null;
            }
            else{ // Inner Node
                pre.next = next;
                next.pre = pre;
            }

            next = null;
            pre = null;
        }
    }
    public void insertLast(Node node){
        tail.next = node;
        node.pre = tail;
        tail = tail.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */