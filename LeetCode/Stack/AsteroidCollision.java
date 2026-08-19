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

// more readable solution
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        boolean[] alive = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int size = 0;

        for(int i=0; i<n; ++i){
            int ast = asteroids[i];

            if(ast > 0){
                stack.addLast(i);
            }else{
                ast *= -1;
                int removed = -1;

                while(!stack.isEmpty() && ast >= asteroids[stack.peekLast()]){
                    removed = asteroids[stack.removeLast()];
                    if(removed == ast) break;
                } 

                if(stack.isEmpty() && removed != ast){
                    alive[i] = true;
                    size++;
                }
            }
        }

        size += stack.size();
        for(int i : stack) alive[i] = true;

        int[] ans = new int[size];
        int j = 0;
        for(int i=0; i<n; ++i){
            if(alive[i]) 
                ans[j++] = asteroids[i];
        }

        return ans;
    }
}