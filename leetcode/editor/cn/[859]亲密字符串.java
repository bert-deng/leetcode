/**
<p>给你两个字符串 <code>s</code> 和 <code>goal</code> ，只要我们可以通过交换 <code>s</code> 中的两个字母得到与 <code>goal</code> 相等的结果，就返回&nbsp;<code>true</code>&nbsp;；否则返回 <code>false</code> 。</p>

<p>交换字母的定义是：取两个下标 <code>i</code> 和 <code>j</code> （下标从 <code>0</code> 开始）且满足 <code>i != j</code> ，接着交换 <code>s[i]</code> 和 <code>s[j]</code> 处的字符。</p>

<ul>
	<li>例如，在 <code>"abcd"</code> 中交换下标 <code>0</code> 和下标 <code>2</code> 的元素可以生成 <code>"cbad"</code> 。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ab", goal = "ba"
<strong>输出：</strong>true
<strong>解释：</strong>你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "ab", goal = "ab"
<strong>输出：</strong>false
<strong>解释：</strong>你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "aa", goal = "aa"
<strong>输出：</strong>true
<strong>解释：</strong>你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = "aaaaaaabc", goal = "aaaaaaacb"
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length, goal.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>s</code> 和 <code>goal</code> 由小写英文字母组成</li>
</ul>
<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 223</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String s, String goal) {
		if(s.length() != goal.length()) return false;
		if(s.equals(goal))
		{
			HashSet<Character> set= new HashSet<>();
			for(char ch: s.toCharArray())
			{
				if(set.contains(ch)) return true;
				set.add(ch);
			}
			return false;
		}else {
			int count = 0;
			int[] res = new int[2];
			for(int i = 0;i < s.length();i++)
			{
				if(s.charAt(i) != goal.charAt(i))
				{
					if(count == 2) return false;
					res[count++] = i;
				}
			}
			return s.charAt(res[0]) == goal.charAt(res[1])
					&& s.charAt(res[1]) == goal.charAt(res[0]);
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)
