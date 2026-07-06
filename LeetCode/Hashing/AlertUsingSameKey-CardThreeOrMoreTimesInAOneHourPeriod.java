// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/description/


class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> nameToTimes = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String timeStr = keyTime[i];
            int timeInMinutes = convertToMinutes(timeStr);

            if(nameToTimes.containsKey(name)) {
                nameToTimes.get(name).add(timeInMinutes);
            } else {
                List<Integer> timesList = new ArrayList<>();
                timesList.add(timeInMinutes);
                nameToTimes.put(name, timesList);
            }
        }

        List<String> alertNames = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : nameToTimes.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            Collections.sort(times);

            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    alertNames.add(name);
                    break;
                }
            }
        }

        Collections.sort(alertNames);
        return alertNames;
    }
    public int convertToMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}