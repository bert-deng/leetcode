# 算法

## 数位Dp


对于「数位 DP」题，都存在「询问 [a, b][a,b]（aa 和 bb 均为正整数，且 a < ba<b）区间内符合条件的数值个数为多少」的一般形式，通常我们需要实现一个查询 [0, x][0,x] 有多少合法数值的函数 int dp(int x)，然后应用「容斥原理」求解出 [a, b][a,b] 的个数：dp(b) - dp(a - 1)

具体的，对于「数位 DP」问题通常是「从高位到低位」的分情况讨论。

# 序列自动机
[通过删除字母匹配字典里最长单词](https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/)



# 状态压缩
[两个回文子序列的最大乘积](https://leetcode-cn.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/)


# 动态规划
* 650. 只有两个键的键盘 (分解质因数)
* [322零钱兑换](https://leetcode-cn.com/problems/coin-change/)