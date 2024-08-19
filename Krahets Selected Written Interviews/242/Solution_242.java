import java.util.Map;
import java.util.HashMap;

public class Solution_242 {
    public static void main(String[] args) {
        solution solution = new solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
        String s = "你好";
        String t = "好你";
        System.out.println(solution.isAnagramUpdate(s, t));
    }
}

class solution{
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int count = 0; count < counter.length; count++){
            if(counter[count] != 0){
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramUpdate(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();

        for(char c : s.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()){
            if(!charCountMap.containsKey(c)){
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if(charCountMap.get(c) == 0){
                charCountMap.remove(c);
            }
        }

        return charCountMap.isEmpty();
    }

}
