public class Solution_409 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
        System.out.println(solution.longestPalindrome("a"));
    }
}

class Solution {
    public int longestPalindrome(String s) {

        int[] count = new int[128];
        for(char c : s.toCharArray()){
            count[c]++;
        }

        int ans = 0;
        for(int v : count){
            ans += v / 2 * 2;
            if(v % 2 == 1 && ans % 2 == 0){
                ans++;
            }
        }

        return ans;
    }
}