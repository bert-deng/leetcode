/**
<p>给你一个由 <code>'1'</code>（陆地）和 <code>'0'</code>（水）组成的的二维网格，请你计算网格中岛屿的数量。</p>

<p>岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。</p>

<p>此外，你可以假设该网格的四条边均被水包围。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
<strong>输出：</strong>3
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 <= m, n <= 300</code></li>
	<li><code>grid[i][j]</code> 的值为 <code>'0'</code> 或 <code>'1'</code></li>
</ul>
<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>并查集</li><li>数组</li><li>矩阵</li></div></div><br><div><li>👍 1435</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
		int num = 0;
		int m = grid.length, n = grid[0].length;
		for(int i = 0;i < m;i++)
		{
			for(int j = 0;j < n;j++)
			{
				if(grid[i][j] == '1') {
					num++;
					dfs(grid, i, j);
				}
			}
		}
		return num;
    }
	private void dfs(char[][] grid, int i, int j)
	{
		int m = grid.length, n= grid[0].length;
		if(i < 0 || i >= m || j < 0 || j >= n) return;
		if(grid[i][j] == '0') return;
		grid[i][j] = '0';
		for(int[] dir : dirs)
		{
			int x = i + dir[0];
			int y = j + dir[1];
			dfs(grid, x, y);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
