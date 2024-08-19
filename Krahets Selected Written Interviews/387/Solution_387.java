import java.util.HashMap;

public class Solution_387 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }
}

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc){
            dic.put(c, !dic.containsKey(c));
        }

        for(int i = 0; i < sc.length; i++){
            if(dic.get(sc[i])){
                return i;
            }
        }
        return -1;
    }
}