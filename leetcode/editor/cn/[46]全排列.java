/**
<p>给定一个不含重复数字的数组 <code>nums</code> ，返回其 <strong>所有可能的全排列</strong> 。你可以 <strong>按任意顺序</strong> 返回答案。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[[0,1],[1,0]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[[1]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 6</code></li>
	<li><code>-10 <= nums[i] <= 10</code></li>
	<li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 1644</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	ArrayList<List<Integer>> list = new ArrayList<>();
	boolean[] visited = new boolean[7];
    public List<List<Integer>> permute(int[] nums) {
		dfs(new LinkedList<Integer>(), nums);
		return list;
    }
	public void dfs(LinkedList<Integer> track, int[] nums)
	{
		if(track.size() == nums.length)
		{
			list.add(new LinkedList<Integer>(track));
			return;
		}
		for(int i = 0; i < nums.length; i++)
		{
			if(visited[i]) continue;
			else{
				track.add(nums[i]);
				visited[i] = true;
				dfs(track, nums);
				track.removeLast();
				visited[i] = false;
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
