import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_205 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphicUpdate("egg", "add"));
        System.out.println(solution.isIsomorphicUpdate("foo", "bar"));
        System.out.println(solution.isIsomorphicUpdate("paper", "title"));
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i), y = t.charAt(i);
            if(s2t.containsKey(x) && s2t.get(x) != y || t2s.containsKey(y) && t2s.get(y) != x){
                return false;
            }

            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    public boolean isIsomorphicUpdate(String s, String t){
        int length = s.length();
        String[] pairs = new String[length];

        for(int i = 0; i < length; i++){
            pairs[i] = s.charAt(i) + "," + t.charAt(i);
        }

        Set<String> PairSet = new HashSet<>();
        for(String pair : pairs){
            PairSet.add(pair);
        }

        return PairSet.size() == s.chars().mapToObj(c -> (char)c).collect(Collectors.toSet()).size() &&
               PairSet.size() == t.chars().mapToObj(c -> (char)c).collect(Collectors.toSet()).size();
    }
}
