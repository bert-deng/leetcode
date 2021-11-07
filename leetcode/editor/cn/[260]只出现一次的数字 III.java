/**
<p>给定一个整数数组 <code>nums</code>，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 <strong>任意顺序</strong> 返回答案。</p>

<p> </p>

<p><strong>进阶：</strong>你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,1,3,2,5]
<strong>输出：</strong>[3,5]
<strong>解释：</strong>[5, 3] 也是有效的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,0]
<strong>输出：</strong>[-1,0]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[1,0]
</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= nums.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1</code></li>
	<li>除两个只出现一次的整数外，<code>nums</code> 中的其他数字都出现两次</li>
</ul>
<div><div>Related Topics</div><div><li>位运算</li><li>数组</li></div></div><br><div><li>👍 531</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
		int ans = 0;
		for(int x : nums) ans ^= x; //假设结果为a b 则一次异或后 结果ans = a ^ b
		int t = ans & (-ans);  // 找到 ans左右边的1,这一位为一，证明a b 这意味不相同，以这个为标准，将数组分为两类，在做运算，可以求出a,b的其中一个
		int a = 0;
		for(int x : nums)
		{
			if((x & t) != 0) a ^= x;
		}
		return new int[]{a, ans ^ a};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
