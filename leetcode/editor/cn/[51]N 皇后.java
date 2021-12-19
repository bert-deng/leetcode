/**
<p><strong>n 皇后问题</strong> 研究的是如何将 <code>n</code> 个皇后放置在 <code>n×n</code> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>

<p>给你一个整数 <code>n</code> ，返回所有不同的 <strong>n<em> </em>皇后问题</strong> 的解决方案。</p>

<div class="original__bRMd">
<div>
<p>每一种解法包含一个不同的 <strong>n 皇后问题</strong> 的棋子放置方案，该方案中 <code>'Q'</code> 和 <code>'.'</code> 分别代表了皇后和空位。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
<pre>
<strong>输入：</strong>n = 4
<strong>输出：</strong>[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
<strong>解释：</strong>如上图所示，4 皇后问题存在两个不同的解法。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>[["Q"]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 9</code></li>
	<li>皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。</li>
</ul>
</div>
</div>
<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 1094</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
      char[][] chess = new char[n][n];
      for (int i = 0; i < n; i++)
          Arrays.fill(chess[i],'.');
      boolean[] usedCol= new boolean[n];
      boolean[] usedSlash = new boolean[2 * n - 1];
      boolean[] usedBackSlash = new boolean[2 * n - 1];
      backtrack(chess, 0, usedCol, usedSlash,usedBackSlash);
      return res;
    }
    private void backtrack(char[][] chess, int row, boolean[] usedCol, boolean[] usedSlash, boolean[] usedBackSlash)
    {
        if(row == chess[0].length)
        {
            addToRes(chess);
            return;
        }
        else
        {
            for(int i = 0;i < chess[0].length;i++)
            {
                if(usedCol[i] || usedSlash[i + row] || usedBackSlash[row - i + chess[0].length - 1] ) continue;
                else
                {
                    chess[row][i] = 'Q';
                    usedCol[i] = true;
                    usedSlash[i + row] = true;
                    usedBackSlash[row - i + chess[0].length - 1] = true;
                    backtrack(chess, row + 1, usedCol, usedSlash, usedBackSlash);
                    chess[row][i] = '.';
                    usedCol[i] = false;
                    usedSlash[i + row] = false;
                    usedBackSlash[row - i + chess[0].length - 1] = false;
                }
            }
        }
    }
    private void addToRes(char[][] chess)
    {
        ArrayList<String> list =new ArrayList<>();
        for(int i = 0; i < chess.length;i++)
            list.add(new String(chess[i]));
        res.add(list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
