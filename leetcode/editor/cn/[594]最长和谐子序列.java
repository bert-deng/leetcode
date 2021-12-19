/**
<p>和谐数组是指一个数组里元素的最大值和最小值之间的差别 <strong>正好是 <code>1</code></strong> 。</p>

<p>现在，给你一个整数数组 <code>nums</code> ，请你在所有可能的子序列中找到最长的和谐子序列的长度。</p>

<p>数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,3,2,2,5,2,3,7]
<strong>输出：</strong>5
<strong>解释：</strong>最长的和谐子序列是 [3,2,2,2,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4]
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,1]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 2 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>排序</li></div></div><br><div><li>👍 274</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
       Arrays.sort(nums);
       int begin = 0;
       int end = 0;
       int ans = 0;
       for(;end < nums.length;end++)
       {
           while(nums[end] - nums[begin] > 1)
               begin++;
           if(nums[end] - nums[begin] == 1)
               ans = Math.max(ans, end - begin + 1);
       }
       return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
