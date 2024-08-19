public class Solution392 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()){
            return true;
        }

        int i = 0;
        for(char c : t.toCharArray()){
            if(s.charAt(i) == c && ++i == s.length()){
                return true;
            }
        }

        return false;
    }
}