/*请实现一个函数，把字符串 s 中的每个空格替换成"%20"
 * 示例：
 * 输入： s = "We are happy."
 * 输出： We%20are%20happy.
 */
class Solution {
    public String replaceSpace(String s) {
        String replaceStr = s.replace(" ","%20");
        return replaceStr;
    }
}