public class MyHashSet {
    class SetNode {
        int key;
        SetNode next;
        public SetNode(int key){
            this.key = key;
        }
        public SetNode(){

        }
    }
    SetNode[] headSetNodes = new SetNode[1000];
    public MyHashSet() {

    }

    public void add(int key) {
        int hashedInd = key%1000;
        SetNode tempSetNode = headSetNodes[hashedInd];

        if (tempSetNode == null)
            headSetNodes[hashedInd] = new SetNode(key);
        else{ // O(n)
            while (true){
                if(tempSetNode.key == key)
                    break;
                if(tempSetNode.next == null) {
                    tempSetNode.next = new SetNode(key);
                    break;
                }
                tempSetNode = tempSetNode.next;
            }
        }
    }

    public void remove(int key) {
        int hashedInd = key%1000;
        SetNode tempSetNode = headSetNodes[hashedInd];
        SetNode prevSetNode = null;

        if (tempSetNode != null){
            if (tempSetNode.key == key)
                headSetNodes[hashedInd] = headSetNodes[hashedInd].next;
            else{
                while(tempSetNode != null){
                    if (tempSetNode.key == key) {
                        prevSetNode.next = tempSetNode.next;
                        break;
                    }
                    prevSetNode = tempSetNode;
                    tempSetNode = tempSetNode.next;
                }
            }
        }
    }

    public boolean contains(int key) {
        int hashedInd = key%1000;
        SetNode tempSetNode = headSetNodes[hashedInd];

        while(tempSetNode != null){
            if (tempSetNode.key == key)
                return true;
            tempSetNode = tempSetNode.next;
        }

        return false;
    }
}
