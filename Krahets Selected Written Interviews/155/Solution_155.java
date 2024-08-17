import java.util.Stack;

public class Solution_155 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-9);
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.min());
    }
}

class MinStack {
    Stack<Integer> minstack;
    Stack<Integer> mainstack;
    /** initialize your data structure here. */
    public MinStack() {
        mainstack = new Stack<>();
        minstack = new Stack<>();
  
    }
  
    public void push(int x) {
        mainstack.push(x);
        if(minstack.isEmpty() || x <= minstack.peek()){
            minstack.push(x);
        }
    }
  
    public void pop() {
        if(mainstack.pop().equals(minstack.peek())){
            minstack.pop();
        }  
    }
  
    public int top() {
        return mainstack.peek();
    }
  
    public int min() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */