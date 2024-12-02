class MyHashMap {
    static class Node{
        int key, val;
        Node next;
        public Node(){

        }
    }
    Node[] headNodes = new Node[1000]; // Array of 1000 head nodes

    public void put(int key, int value) {
        int calcInd = key%1000;
        Node tempHead = headNodes[calcInd];

        if(tempHead == null){ // if index is empty
            // Creating new head node
            headNodes[calcInd] = new Node();
            headNodes[calcInd].key = key;
            headNodes[calcInd].val = value;
        }else{ // index already has a head node
            // searching for the key to modify its value or putting a new key with its value in the last
            while(tempHead.key == key || tempHead.next != null){
                if(tempHead.key == key){
                    tempHead.val = value;
                    return;
                }
                tempHead = tempHead.next;
            }
            // tempHead.next is equal to null
            tempHead.next = new Node();
            tempHead.next.key = key; tempHead.next.val = value;
        }
    }
    public void remove(int key) {
        int calcInd = key%1000;
        Node tempHead = headNodes[calcInd];
        Node prevNode = null;

        if(tempHead == null) // Empty index. [nothing to remove]
            return;
        if(tempHead.key == key) // headNode contains the key we are searching for
            headNodes[calcInd] = headNodes[calcInd].next; // putting headNode to next Node [null or another valid node]
        else{
            // Searching for the key in Linked Nodes
            while(tempHead != null){ // It's guaranteed that the loop will pass for at least 1 time.
                if(tempHead.key == key){ // Deletion
                    prevNode.next = tempHead.next;
                    return;
                }
                prevNode = tempHead;
                tempHead = tempHead.next;
            }
        }
    }

    public int get(int key) {
        int calcInd = key%1000;
        Node tempHead = headNodes[calcInd];

        while(tempHead != null){ // Index contains Node(s)
            if(tempHead.key == key) // Searching
                return tempHead.val;
            tempHead = tempHead.next;
        }

        // If index is empty or if key not found
        return -1;
    }
}
