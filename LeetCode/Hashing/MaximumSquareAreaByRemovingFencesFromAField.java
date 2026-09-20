///  https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/description/

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hList = new ArrayList<>(Arrays.stream(hFences).boxed().toList());
        List<Integer> vList = new ArrayList<>(Arrays.stream(vFences).boxed().toList());

        hList.add(1); hList.add(m);
        vList.add(1); vList.add(n);
                
        Collections.sort(hList);
        Collections.sort(vList);
        
        HashSet<Integer> hDiffs = new HashSet<>();
        for (int i = 0; i < hList.size(); i++) {
            for (int j = i+1; j < hList.size(); j++) {
                hDiffs.add(hList.get(j) - hList.get(i));
            }
        }

        long ans = -1;
        for (int i = 0; i < vList.size(); i++) {
            for (int j = i+1; j < vList.size(); j++) {
                int diff = vList.get(j) - vList.get(i);
                if (hDiffs.contains(diff)) {
                    ans = Math.max(ans, (long) diff * diff);
                }
            }
        }

        return ans == -1 ? -1 : (int)(ans % 1_000_000_007L);
    }
}