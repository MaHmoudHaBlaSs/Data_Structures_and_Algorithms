///  https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/description/


class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            map.putIfAbsent(keyName[i], new ArrayList<>());
            map.get(keyName[i]).add(toMinutes(keyTime[i]));
        }

        List<String> res = new ArrayList<>();

        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            Collections.sort(times);

            for (int i = 0; i + 2 < times.size(); i++) {
                if (times.get(i + 2) - times.get(i) <= 60) {
                    res.add(name);
                    break;
                }
            }
        }

        Collections.sort(res);
        return res;
    }

    private int toMinutes(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        return h * 60 + m;
    }
}
