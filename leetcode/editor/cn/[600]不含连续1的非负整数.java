//给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。 
//
// 示例 1: 
//
// 输入: 5
//输出: 5
//解释: 
//下面是带有相应二进制表示的非负整数<= 5：
//0 : 0
//1 : 1
//2 : 10
//3 : 11
//4 : 100
//5 : 101
//其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。 
//
// 说明: 1 <= n <= 10⁹ 
// Related Topics 动态规划 👍 217 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static int N = 50;
    static int[][] f = new int[N][2];
    static{
        f[1][0] = 1;
        f[1][1] = 1;
        for(int i = 2; i <=30; i++)
        {
            f[i][0] = f[i - 1][0] + f[i - 1][1];
            f[i][1] = f[i - 1][0];
        }
    }
    int getLen(int n)
    {
        for(int i = 30;i >= 0;i--)
            if(((1 << i) & n) != 0) return i;
        return 0;
    }
    public int findIntegers(int n) {
        int len = getLen(n);
        int ans = 0, pre = 0;
        for (int i = len;i >= 0; i--)
        {
            int cur = ((n >> i) & 1);
            if (cur == 1) ans += f[i + 1][0];
            if(per == 1 && cur == 1) break;
            pre = cur;
            if(i == 0) ans++;
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
