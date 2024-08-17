import java.util.LinkedList;
import java.util.Deque;

/**Given an encoded string, return its decoded string. 
 * The encoding rule is: k[encoded_string],
 * which means that the encoded_string inside the square brackets is repeated exactly k times. 
 * Note that k is guaranteed to be a positive integer. 
 * You can assume that the input string is always valid;
 * there are no extra spaces in the input string and the input square brackets are always formatted. 
 * In addition, you can assume that the original data contains no numbers, 
 * and that all numbers represent only the number of repetitions k
 * e.g., there will be no inputs like 3a or 2[4].
 */

public class Solution_394 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString_op("3[a]2[bc]"));
        System.out.println(solution.decodeString_op("3[a2[c]]"));
        System.out.println(solution.decodeString_op("2[abc]3[cd]ef"));
    }
}

// use queue
class Solution{
    public String decodeString(String s){
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stcak_res = new LinkedList<>();

        for(Character c : s.toCharArray()){
            if(c == '['){
                stack_multi.addLast(multi);
                stcak_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++){
                    tmp.append(res);
                }

                res = new StringBuilder(stcak_res.removeLast() + tmp);
            }else if(c >= '0' && c <= '9'){
                multi = multi * 10 + Integer.parseInt(c + "");
            }else{
                res.append(c);
            }
        }

        return res.toString();
    }

    public String decodeString_op(String s){
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Deque<Integer> stackMulti = new LinkedList<>();
        Deque<StringBuilder> stackRes = new LinkedList<>();

        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stackMulti.push(multi);
                stackRes.push(res);
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp= res;
                res = stackRes.pop();
                int repeatTimes= stackMulti.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    res.append(tmp);
                }
            } else if (Character.isDigit(c)) {
                multi = multi * 10 + (c - '0');
            } else {
                res.append(c);
            }
        }
        
        return res.toString();
    }
}