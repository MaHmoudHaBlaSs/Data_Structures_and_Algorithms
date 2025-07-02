// https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (stack.isEmpty() || sameSign(asteroids[i], stack.peek()) || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (Math.abs(asteroids[i]) > Math.abs(stack.peek())) {
                        stack.pop();
                    } else if (Math.abs(asteroids[i]) == Math.abs(stack.peek())) {
                        stack.pop();
                        asteroids[i] = 0;
                        break;
                    } else {
                        asteroids[i] = 0;
                        break;
                    }
                }
                if (asteroids[i] != 0) {
                    stack.push(asteroids[i]);
                }
            }
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
    public boolean sameSign (int x , int y) {
        return (x > 0 && y > 0) || ( x  < 0 && y < 0 );
    }
}