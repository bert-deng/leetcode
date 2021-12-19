//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 650 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int len = s.length() - 1;
        boolean [][] dp = new boolean[len][len];
        for(int i = len - 1;i>=0;i--)
        {
            for(int j = 0;j<len;j++)
            {
                if(s.charAt(i) != s.charAt(j) || j > i) continue;
                if(i -j <=1) {
                    ans++;
                    dp[i][j] = true;
                }

                if(dp[i + 1][j - 1])
                {
                    ans++;
                    dp[i][j] = true;
                }

            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
