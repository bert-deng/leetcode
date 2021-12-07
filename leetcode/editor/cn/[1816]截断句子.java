/**
<p><strong>句子</strong> 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。</p>

<ul>
	<li>例如，<code>"Hello World"</code>、<code>"HELLO"</code> 和 <code>"hello world hello world"</code> 都是句子。</li>
</ul>

<p>给你一个句子 <code>s</code>​​​​​​ 和一个整数 <code>k</code>​​​​​​ ，请你将 <code>s</code>​​ <strong>截断</strong> ​，​​​使截断后的句子仅含 <strong>前</strong> <code>k</code>​​​​​​ 个单词。返回 <strong>截断</strong> <code>s</code>​​​​<em>​​ </em>后得到的句子<em>。</em></p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "Hello how are you Contestant", k = 4
<strong>输出：</strong>"Hello how are you"
<strong>解释：</strong>
s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
前 4 个单词为 ["Hello", "how", "are", "you"]
因此，应当返回 "Hello how are you"
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "What is the solution to this problem", k = 4
<strong>输出：</strong>"What is the solution"
<strong>解释：</strong>
s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
前 4 个单词为 ["What", "is", "the", "solution"]
因此，应当返回 "What is the solution"</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = "chopper is not a tanuki", k = 5
<strong>输出：</strong>"chopper is not a tanuki"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 500</code></li>
	<li><code>k</code> 的取值范围是 <code>[1,  s 中单词的数目]</code></li>
	<li><code>s</code> 仅由大小写英文字母和空格组成</li>
	<li><code>s</code> 中的单词之间由单个空格隔开</li>
	<li>不存在前导或尾随空格</li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>字符串</li></div></div><br><div><li>👍 50</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String truncateSentence(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int cnt = 0, n = s.length();
		for(int i = 0;i < n && cnt < k;i++)
		{
			if(s.charAt(i) == ' ') cnt++;
			if(cnt < k) sb.append(s.charAt(i));
		}
		return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
