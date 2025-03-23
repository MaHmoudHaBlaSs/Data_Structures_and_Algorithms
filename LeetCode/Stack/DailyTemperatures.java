// https://leetcode.com/problems/daily-temperatures/description/
// You need to solve NextGreatElementI Problem Before Solving This. [Will find it in the same folder]


// Optimal.
// T: O(n)          S: O(n)
public static int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[temperatures.length];

    for (int i = 0; i < temperatures.length; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int prevIndex = stack.pop();
            result[prevIndex] = i - prevIndex;
        }
        stack.push(i);
    }
    return result;
}
