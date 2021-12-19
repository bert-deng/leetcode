//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 219 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int m = s.length();
        int[][] f= new int [m + 1][26];
        Arrays.fill(f[m], m);

        for (int i = m - 1; i >= 0; --i)
        {
            for (int j = 0; j < 26; j++)
            {
                if(s.charAt(i) == (char)('a' + j))
                    f[i][j] = i;
                else f[i][j] = f[i + 1][j];
            }
        }
        String ans = "";
        for (String t : dictionary)
        {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < t.length(); i++)
            {
                if(f[j][t.charAt(i) - 'a'] == m)
                {
                    match = false;
                    break;
                }
                j = f[j][t.charAt(i) - 'a'] + 1;
            }
            if (match)
            {
                if (t.length() > ans.length() || (t.length() == ans.length() && t.compareTo(ans) <0))
                {
                    ans = t;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
