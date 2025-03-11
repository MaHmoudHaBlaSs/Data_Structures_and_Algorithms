https://leetcode.com/problems/number-of-distinct-averages/description/?envType=problem-list-v2&envId=two-pointers

public static int distinctAverages(int[] nums) {
        Set<Float> set = new HashSet<>();
        int left = 0 , right = nums.length - 1;
        Arrays.sort(nums);
        while (left <= right) {
            float avg = (((float) nums[left]) + nums[right]) / 2 ;
            if (!set.contains(avg)) {
                set.add(avg);
            }
            left ++ ;
            right--;
        }
        return set.size();
    }
