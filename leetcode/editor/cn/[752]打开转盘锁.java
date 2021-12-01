/**
<p>你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： <code>'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'</code> 。每个拨轮可以自由旋转：例如把 <code>'9'</code> 变为 <code>'0'</code>，<code>'0'</code> 变为 <code>'9'</code> 。每次旋转都只能旋转一个拨轮的一位数字。</p>

<p>锁的初始数字为 <code>'0000'</code> ，一个代表四个拨轮的数字的字符串。</p>

<p>列表 <code>deadends</code> 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。</p>

<p>字符串 <code>target</code> 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入：</strong>deadends = ["0201","0101","0102","1212","2002"], target = "0202"
<strong>输出：</strong>6
<strong>解释：</strong>
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> deadends = ["8888"], target = "0009"
<strong>输出：</strong>1
<strong>解释：</strong>
把最后一位反向旋转一次即可 "0000" -> "0009"。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
<strong>输出：</strong>-1
<strong>解释：
</strong>无法旋转到目标数字且不被锁定。
</pre>

<p><strong>示例 4:</strong></p>

<pre>
<strong>输入:</strong> deadends = ["0000"], target = "8888"
<strong>输出：</strong>-1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= deadends.length <= 500</code></li>
	<li><code><font face="monospace">deadends[i].length == 4</font></code></li>
	<li><code><font face="monospace">target.length == 4</font></code></li>
	<li><code>target</code> <strong>不在</strong> <code>deadends</code> 之中</li>
	<li><code>target</code> 和 <code>deadends[i]</code> 仅由若干位数字组成</li>
</ul>
<div><div>Related Topics</div><div><li>广度优先搜索</li><li>数组</li><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 415</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
		int step = 0;
		Set<String> dead = new HashSet<>();
		for(String s : deadends) dead.add(s);
		Set<String> s1 = new HashSet<>(); //一个从0000开始扩散
		Set<String> s2 = new HashSet<>();//一个从target开始扩散
		Set<String> visited = new HashSet<>();
		s1.add("0000");
		s2.add(target);
		while(!s1.isEmpty() && !s2.isEmpty())
		{
			if(s1.size() > s2.size())
			{
				Set<String> tmp = s1;
				s1 = s2;
				s2 = tmp;
			}
			Set<String> tmp = new HashSet<>();
			for(String s : s1)
			{
				if(dead.contains(s)) continue;
				if(s2.contains(s)) return step;
				visited.add(s);
				for(int i = 0;i< 4;i++)
				{
					String up = moveUp(s, i);
					if(!visited.contains(up))
						tmp.add(up);
					String down = moveDown(s, i);
					if(!visited.contains(down))
						tmp.add(down);
				}
			}
			step++;
			s1 = s2;
			s2 = tmp;
		}
		return -1;
		/* 单向BFS
		int step = 0;
		Queue<String> q = new LinkedList<>();
		Set<String> dead= new HashSet<>();
		for(String s : deadends)
			dead.add(s);
		Set<String> set = new HashSet<>();
		set.add("0000");
		q.offer("0000");
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0;i < size;i++)
			{
				String tmp = q.poll();
				if(tmp.equals(target)) return step;
				if(dead.contains(tmp)) continue;
				for(int j = 0;j < 4;j++)
				{
					String up = moveUp(tmp, j);
					if(!set.contains(up))
					{
						q.offer(up);
						set.add(up);
					}
					String down = moveDown(tmp, j);
					if(!set.contains(down)) {
						q.offer(down);
						set.add(down);
					}
				}
			}
			step++;
		}
		return -1;*/
    }
	public String moveUp(String tmp, int j)
	{
		char[] ch = tmp.toCharArray();
		if(ch[j] == '9')
			ch[j] = '0';
		else ch[j] += 1;
		return new String(ch);
	}
	public String moveDown(String tmp, int j)
	{
		 char[] ch = tmp.toCharArray();
		 if(ch[j] == '0')
			 ch[j] = '9';
		 else ch[j] -= 1;
		 return new String(ch);
	}
}
//leetcode submit region end(Prohibit modification and deletion)
