/**
<p>字典 <code>wordList</code> 中从单词 <code>beginWord</code><em> </em>和 <code>endWord</code> 的 <strong>转换序列 </strong>是一个按下述规格形成的序列：</p>

<ul>
	<li>序列中第一个单词是 <code>beginWord</code> 。</li>
	<li>序列中最后一个单词是 <code>endWord</code> 。</li>
	<li>每次转换只能改变一个字母。</li>
	<li>转换过程中的中间单词必须是字典 <code>wordList</code> 中的单词。</li>
</ul>

<p>给你两个单词<em> </em><code>beginWord</code><em> </em>和 <code>endWord</code> 和一个字典 <code>wordList</code> ，找到从 <code>beginWord</code> 到 <code>endWord</code> 的 <strong>最短转换序列</strong> 中的 <strong>单词数目</strong> 。如果不存在这样的转换序列，返回 0。</p>
 

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
<strong>输出：</strong>5
<strong>解释：</strong>一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
<strong>输出：</strong>0
<strong>解释：</strong>endWord "cog" 不在字典中，所以无法进行转换。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= beginWord.length <= 10</code></li>
	<li><code>endWord.length == beginWord.length</code></li>
	<li><code>1 <= wordList.length <= 5000</code></li>
	<li><code>wordList[i].length == beginWord.length</code></li>
	<li><code>beginWord</code>、<code>endWord</code> 和 <code>wordList[i]</code> 由小写英文字母组成</li>
	<li><code>beginWord != endWord</code></li>
	<li><code>wordList</code> 中的所有字符串 <strong>互不相同</strong></li>
</ul>
<div><div>Related Topics</div><div><li>广度优先搜索</li><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 900</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord)) return 0;
		Set<String> set = new HashSet<>(wordList); //单词集  查找是否在单词集中比较快
		Set<String> visited = new HashSet<>();   //是否访问过
		int n = beginWord.length();				//单词长度
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		visited.add(beginWord);
		int step = 1;
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i < size;i++)
			{
				String s = q.poll();
				if(s.equals(endWord)) return step;
				for(int j = 0;j < n;j++) //长度
				{
					for(int k = 0;k < 26;k++) //26个字母都试一次
					{
						String newS = getString(s, j, k); //替换当前字符串的第j位为(a + k)看这单词是否在单词集中
						if(set.contains(newS) && !visited.contains(newS))
						{
							visited.add(newS);
							q.offer(newS);
						}
					}
				}
			}
			step++;
		}
		return 0;
	}
	public String getString(String s , int j, int k)
	{
		char[] ch = s.toCharArray();
		ch[j] = (char) ('a' + k);
		return new String(ch);
	}
}
//leetcode submit region end(Prohibit modification and deletion)
