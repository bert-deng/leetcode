/**
<p>给你一个下标从 <strong>0</strong>&nbsp;开始包含 <code>n</code>&nbsp;个正整数的数组&nbsp;<code>arr</code>&nbsp;，和一个正整数&nbsp;<code>k</code>&nbsp;。</p>

<p>如果对于每个满足&nbsp;<code>k &lt;= i &lt;= n-1</code>&nbsp;的下标&nbsp;<code>i</code>&nbsp;，都有&nbsp;<code>arr[i-k] &lt;= arr[i]</code>&nbsp;，那么我们称&nbsp;<code>arr</code>&nbsp;是 <strong>K</strong>&nbsp;<strong>递增</strong> 的。</p>

<ul>
	<li>比方说，<code>arr = [4, 1, 5, 2, 6, 2]</code>&nbsp;对于&nbsp;<code>k = 2</code>&nbsp;是 K 递增的，因为：

	<ul>
		<li><code>arr[0] &lt;= arr[2] (4 &lt;= 5)</code></li>
		<li><code>arr[1] &lt;= arr[3] (1 &lt;= 2)</code></li>
		<li><code>arr[2] &lt;= arr[4] (5 &lt;= 6)</code></li>
		<li><code>arr[3] &lt;= arr[5] (2 &lt;= 2)</code></li>
	</ul>
	</li>
	<li>但是，相同的数组&nbsp;<code>arr</code>&nbsp;对于&nbsp;<code>k = 1</code>&nbsp;不是 K 递增的（因为&nbsp;<code>arr[0] &gt; arr[1]</code>），对于&nbsp;<code>k = 3</code>&nbsp;也不是 K 递增的（因为&nbsp;<code>arr[0] &gt; arr[3]</code>&nbsp;）。</li>
</ul>

<p>每一次 <strong>操作</strong>&nbsp;中，你可以选择一个下标&nbsp;<code>i</code> 并将&nbsp;<code>arr[i]</code> <strong>改成任意&nbsp;</strong>正整数。</p>

<p>请你返回对于给定的 <code>k</code>&nbsp;，使数组变成 K 递增的 <strong>最少操作次数</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>arr = [5,4,3,2,1], k = 1
<b>输出：</b>4
<strong>解释：
</strong>对于 k = 1 ，数组最终必须变成非递减的。
可行的 K 递增结果数组为 [5,<em><strong>6</strong></em>,<em><strong>7</strong></em>,<em><strong>8</strong></em>,<em><strong>9</strong></em>]，[<em><strong>1</strong></em>,<em><strong>1</strong></em>,<em><strong>1</strong></em>,<em><strong>1</strong></em>,1]，[<em><strong>2</strong></em>,<em><strong>2</strong></em>,3,<em><strong>4</strong></em>,<em><strong>4</strong></em>] 。它们都需要 4 次操作。
次优解是将数组变成比方说 [<em><strong>6</strong></em>,<em><strong>7</strong></em>,<em><strong>8</strong></em>,<em><strong>9</strong></em>,<em><strong>10</strong></em>] ，因为需要 5 次操作。
显然我们无法使用少于 4 次操作将数组变成 K 递增的。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>arr = [4,1,5,2,6,2], k = 2
<b>输出：</b>0
<strong>解释：</strong>
这是题目描述中的例子。
对于每个满足 2 &lt;= i &lt;= 5 的下标 i ，有 arr[i-2] &lt;=<b> </b>arr[i] 。
由于给定数组已经是 K 递增的，我们不需要进行任何操作。</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>arr = [4,1,5,2,6,2], k = 3
<b>输出：</b>2
<strong>解释：</strong>
下标 3 和 5 是仅有的 3 &lt;= i &lt;= 5 且不满足 arr[i-3] &lt;= arr[i] 的下标。
将数组变成 K 递增的方法之一是将 arr[3] 变为 4 ，且将 arr[5] 变成 5 。
数组变为 [4,1,5,<em><strong>4</strong></em>,6,<em><strong>5</strong></em>] 。
可能有其他方法将数组变为 K 递增的，但没有任何一种方法需要的操作次数小于 2 次。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i], k &lt;= arr.length</code></li>
</ul>
<div><li>👍 17</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kIncreasing(int[] arr, int k) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0; i < k;i++)
		{
			list.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < arr.length;i++)
		{
			list.get(i % k).add(arr[i]);
		}
		int ans = 0;
		for(int i = 0; i < k;i++)
		{
			ans += list.get(i).size() - longestSubSequence(list.get(i));
		}
		return ans;
    }
	private int longestSubSequence(ArrayList<Integer> nums)
	{
		int[] res = new int[nums.size()];
		int size = 0;
		for(int i = 0; i < nums.size();i++)
		{
			int l = 0, r = size;
			while(l != r)
			{
				int m = (l + r) / 2;
				if(res[m] <= nums.get(i))
					l = m + 1;
				else r = m;
			}
			res[l] = nums.get(i);
			if(l == size) size++;
		}
		return size;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
