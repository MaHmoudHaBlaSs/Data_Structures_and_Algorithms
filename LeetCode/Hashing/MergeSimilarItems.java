// https://leetcode.com/problems/merge-similar-items/description/?envType=problem-list-v2&envId=sorting


class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0] , items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            if (map.containsKey(items2[i][0])) {
                map.put(items2[i][0] , map.get(items2[i][0]) + items2[i][1]);
            }else{
                map.put(items2[i][0] , items2[i][1]);
            }
        }
        for(Integer key : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(key);
            list.add(map.get(key));
            result.add(list);
        }
        return result;
        

    }
}