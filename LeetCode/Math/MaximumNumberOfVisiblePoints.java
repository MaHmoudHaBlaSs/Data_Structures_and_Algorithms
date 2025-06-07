///  https://leetcode.com/problems/maximum-number-of-visible-points/description/

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int sameLocationCount = 0;

        for (List<Integer> point : points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);
            if (dx == 0 && dy == 0) {
                sameLocationCount++;
            } else {
                angles.add(Math.atan2(dy, dx));
            }
        }

        Collections.sort(angles);

        //to handle circular window
        List<Double> allAngles = new ArrayList<>(angles);
        for (double ang : angles) {
            allAngles.add(ang + 2 * Math.PI);
        }

        double viewAngle = Math.toRadians(angle);
        int maxVisible = 0, right = 0;

        for (int left = 0; left < angles.size(); left++) {
            while (right < allAngles.size() && allAngles.get(right) - angles.get(left) <= viewAngle) {
                right++;
            }
            maxVisible = Math.max(maxVisible, right - left);
        }

        return maxVisible + sameLocationCount;
    }
}
