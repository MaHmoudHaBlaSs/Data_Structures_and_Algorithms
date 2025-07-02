// https://leetcode.com/problems/string-compression/description/

class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;

        int writeIndex = 0;
        char curr = chars[0];
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == curr) {
                count++;
            } else {
                chars[writeIndex++] = curr;
                if (count > 1) {
                    String counts = String.valueOf(count);
                    for (int j = 0; j < counts.length(); j++) {
                        chars[writeIndex++] = counts.charAt(j);
                    }
                }
                curr = chars[i];
                count = 1;
            }
        }

        chars[writeIndex++] = curr;
        if (count > 1) {
            String counts = String.valueOf(count);
            for (int j = 0; j < counts.length(); j++) {
                chars[writeIndex++] = counts.charAt(j);
            }
        }

        return writeIndex;
    }
}