///  https://leetcode.com/problems/snapshot-array/description/


class SnapshotArray {
    private class Node{
        int data, snap;
        public Node(int data,int snap){
            this.data = data;
            this.snap = snap; 
        }
    }

    private HashMap<Integer, List<Node>> mp = new HashMap<>(); 
    private int curr_snap  = 0;
    
    public SnapshotArray(int length) {
        for(int i=0; i<length; i++){
            var list = new ArrayList<Node>();
            list.add(new Node(0,0));
            mp.put(i, list);
        }
    }
    
    public void set(int index, int val) {
        var list = mp.get(index);
        var node = list.getLast();
        
        if(node.snap == curr_snap) 
            node.data = val; 
        else 
            list.add(new Node(val, curr_snap));  
    }
    
    public int snap() {
        return curr_snap++;
    }
    
    public int get(int index, int snap_id) {
        var list = mp.get(index);
        int left = 0, right = list.size() - 1;
        
        while (left <= right) {  
            int mid = left + (right - left) / 2;  
            if (list.get(mid).snap <= snap_id) 
                left = mid + 1;
            else 
                right = mid - 1;
        }

        return list.get(right).data; 
    }
}