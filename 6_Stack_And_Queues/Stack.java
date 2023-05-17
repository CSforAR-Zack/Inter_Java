import java.util.ArrayList;
// import java.util.LinkedList;

public class Stack {
    // LinkedList<Integer> stack = new LinkedList<Integer>();
    private ArrayList<Integer> stack = new ArrayList<Integer>();

    public void push(int n) {
        // stack.push(n);
        stack.add(n);
    }

    public int pop() {
        // return stack.pop();
        return stack.remove(stack.size() - 1);
    }

    public int peek() {
        // return stack.peek();
        return stack.get(stack.size() - 1);
    }

    public ArrayList<Integer> getStack() {
        return stack;
    }
}
