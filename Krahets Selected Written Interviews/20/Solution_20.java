import java.util.Stack;

public class Solution_20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isVaild("()"));
        System.out.println(solution.isVaild("()[]{}"));
        System.out.println(solution.isVaild("(]"));
        System.out.println(solution.isVaild("([)]"));
        System.out.println(solution.isVaild("{[]}"));
    }
}

class Solution{
    public boolean isVaild(String s){
        if(s.isEmpty()){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }

        if(stack.isEmpty()){
            return true;
        }

        return false;
    }
}
