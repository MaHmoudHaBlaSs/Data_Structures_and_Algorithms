///     https://leetcode.com/problems/distant-barcodes/description/

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] ans = new int[barcodes.length];
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int barcode : barcodes)
            mp.put(barcode, mp.getOrDefault(barcode,0) + 1);

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        pq.addAll(mp.entrySet());


        for(int i=0; i<ans.length; i++){
            int prev = (i == 0 ? -1 : ans[i-1]);

            Map.Entry<Integer,Integer> tmp = pq.peek().getKey() == prev ? pq.poll() : null;

            Map.Entry<Integer,Integer> top = pq.poll();
            top.setValue(top.getValue() - 1); 
            
            if(tmp != null) pq.add(tmp);
            if(top.getValue() > 0) pq.add(top);
            
            ans[i] = top.getKey();
        }

        return ans;
    }
}