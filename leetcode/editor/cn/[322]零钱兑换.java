/**
<p>给你一个整数数组 <code>coins</code> ，表示不同面额的硬币；以及一个整数 <code>amount</code> ，表示总金额。</p>

<p>计算并返回可以凑成总金额所需的 <strong>最少的硬币个数</strong> 。如果没有任何一种硬币组合能组成总金额，返回 <code>-1</code> 。</p>

<p>你可以认为每种硬币的数量是无限的。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>coins = <code>[1, 2, 5]</code>, amount = <code>11</code>
<strong>输出：</strong><code>3</code> 
<strong>解释：</strong>11 = 5 + 5 + 1</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>coins = <code>[2]</code>, amount = <code>3</code>
<strong>输出：</strong>-1</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>coins = [1], amount = 0
<strong>输出：</strong>0
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>coins = [1], amount = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>coins = [1], amount = 2
<strong>输出：</strong>2
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= coins.length <= 12</code></li>
	<li><code>1 <= coins[i] <= 2<sup>31</sup> - 1</code></li>
	<li><code>0 <= amount <= 10<sup>4</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>广度优先搜索</li><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 1572</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
		if(amount < 1) return 0;
		return coinChange(coins, amount, new int[amount]);
		/*int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount+ 1);
		dp[0] = 0;
		for(int i = 0; i <= amount;i++)
		{
			for(int coin: coins)
			{
				if(i - coin < 0) continue;
				dp[i] = Math.min(dp[i - coin]+ 1,dp[i]);
			}
		}
		return dp[amount] == amount + 1? -1 : dp[amount];*/
    }
	public int coinChange(int[] coins, int amount, int[] dp)
	{
		if(amount == 0) return 0;
		if(amount < 0) return -1;
		if(dp[amount - 1] != 0)
			return dp[amount - 1];
		int min = Integer.MAX_VALUE;
		for(int coin : coins)
		{
			int res = coinChange(coins, amount - coin, dp);
			if(res >= 0 && res < min)
				min = res + 1;
		}
		dp[amount - 1]  = min == Integer.MAX_VALUE? -1:min;
		return dp[amount - 1];
	}
}
//leetcode submit region end(Prohibit modification and deletion)
