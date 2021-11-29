/**
<p>冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。</p>

<p>在加热器的加热半径范围内的每个房屋都可以获得供暖。</p>

<p>现在，给出位于一条水平线上的房屋 <code>houses</code> 和供暖器 <code>heaters</code> 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。</p>

<p><strong>说明</strong>：所有供暖器都遵循你的半径标准，加热的半径也一样。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> houses = [1,2,3], heaters = [2]
<strong>输出:</strong> 1
<strong>解释:</strong> 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> houses = [1,2,3,4], heaters = [1,4]
<strong>输出:</strong> 1
<strong>解释:</strong> 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>houses = [1,5], heaters = [2]
<strong>输出：</strong>3
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= houses.length, heaters.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>1 <= houses[i], heaters[i] <= 10<sup>9</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 231</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int h : heaters)
            set.add(h);
        int result = 0;
        for(int x : houses)
        {
            Integer high = set.ceiling(x);
            Integer low = set.floor(x);
            if(high == null) result  = Math.max(result, x - low);
            else if(low == null) result = Math.max(result, high - x);
            else result = Math.max(result, Math.min(high - x, x - low));
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
