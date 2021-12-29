/**
<p>给你一个下标从 <strong>0</strong> 开始、由 <code>n</code> 个整数组成的数组 <code>arr</code> 。</p>

<p><code>arr</code> 中两个元素的 <strong>间隔</strong> 定义为它们下标之间的 <strong>绝对差</strong> 。更正式地，<code>arr[i]</code> 和 <code>arr[j]</code> 之间的间隔是 <code>|i - j|</code> 。</p>

<p>返回一个长度为 <code>n</code> 的数组&nbsp;<code>intervals</code> ，其中 <code>intervals[i]</code> 是<em> </em><code>arr[i]</code><em> </em>和<em> </em><code>arr</code><em> </em>中每个相同元素（与 <code>arr[i]</code> 的值相同）的 <strong>间隔之和</strong> <em>。</em></p>

<p><strong>注意：</strong><code>|x|</code> 是 <code>x</code> 的绝对值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [2,1,3,1,2,3,3]
<strong>输出：</strong>[4,2,7,2,4,4,5]
<strong>解释：</strong>
- 下标 0 ：另一个 2 在下标 4 ，|0 - 4| = 4
- 下标 1 ：另一个 1 在下标 3 ，|1 - 3| = 2
- 下标 2 ：另两个 3 在下标 5 和 6 ，|2 - 5| + |2 - 6| = 7
- 下标 3 ：另一个 1 在下标 1 ，|3 - 1| = 2
- 下标 4 ：另一个 2 在下标 0 ，|4 - 0| = 4
- 下标 5 ：另两个 3 在下标 2 和 6 ，|5 - 2| + |5 - 6| = 4
- 下标 6 ：另两个 3 在下标 2 和 5 ，|6 - 2| + |6 - 5| = 5
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [10,5,10,10]
<strong>输出：</strong>[5,0,3,4]
<strong>解释：</strong>
- 下标 0 ：另两个 10 在下标 2 和 3 ，|0 - 2| + |0 - 3| = 5
- 下标 1 ：只有这一个 5 在数组中，所以到相同元素的间隔之和是 0
- 下标 2 ：另两个 10 在下标 0 和 3 ，|2 - 0| + |2 - 3| = 3
- 下标 3 ：另两个 10 在下标 0 和 2 ，|3 - 0| + |3 - 2| = 4
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == arr.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10<sup>5</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><br><div><li>👍 22</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long[] getDistances(int[] arr) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0; i < arr.length;i++)
		{
			map.computeIfAbsent(arr[i], (t) -> new ArrayList<Integer>()).add(i);
		}
		long ans[] = new long[arr.length];
		for (ArrayList<Integer> list : map.values()) {
			long[] pre = new long[list.size()];
			long[] suffix = new long[list.size()];
			for(int i = 1; i < list.size();i++)
			{
				pre[i] = pre[i - 1] + i * (list.get(i) - list.get(i - 1));
			}
			for(int i = list.size() - 2; i >= 0; i--)
				suffix[i] = suffix[i + 1] + (list.size() - 1 - i) * (list.get(i + 1) - list.get(i));
			for(int i = 0; i < list.size();i++)
				ans[list.get(i)] = pre[i] + suffix[i];
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
