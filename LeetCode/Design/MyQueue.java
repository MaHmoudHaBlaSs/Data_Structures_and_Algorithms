import java.util.Stack;

// Implement Queue using Stacks
public class MyQueue {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> helperStack = new Stack<>();
    int peek;
    public MyQueue() {

    }

    public void push(int x) {
        if(mainStack.isEmpty())
            peek = x;
        mainStack.push(x);
    }

    public int pop() { // O(2n) >> O(n)
        int popped;
        if (mainStack.isEmpty())
            return 0;
        while (!mainStack.isEmpty()){
            helperStack.push(mainStack.pop());
        }
        popped = helperStack.pop();
        peek = (!helperStack.isEmpty())?helperStack.peek(): 0;

        while (!helperStack.isEmpty()){
            mainStack.push(helperStack.pop());
        }

        return popped;
    }

    public int peek() {
        return peek; // O(1)
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }
}
