--> https://leetcode.com/problems/daily-temperatures/description/

// brute force
    /*
    public static int[] dailyTemperatures(int[] temperatures) {
        //Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            for(int j = i+1; j < temperatures.length; j++){
                if(temperatures[j] > temperatures[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }

     */
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
