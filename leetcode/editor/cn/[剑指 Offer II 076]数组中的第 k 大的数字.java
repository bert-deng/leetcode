/**
<p>给定整数数组 <code>nums</code> 和整数 <code>k</code>，请返回数组中第 <code><strong>k</strong></code> 个最大的元素。</p>

<p>请注意，你需要找的是数组排序后的第 <code>k</code> 个最大的元素，而不是第 <code>k</code> 个不同的元素。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <code>[3,2,1,5,6,4] 和</code> k = 2
<strong>输出:</strong> 5
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> <code>[3,2,3,1,2,4,5,5,6] 和</code> k = 4
<strong>输出:</strong> 4</pre>

<p>&nbsp;</p>

<p><strong>提示： </strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 215&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">https://leetcode-cn.com/problems/kth-largest-element-in-an-array/</a></p>
<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>快速选择</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 15</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        for(int i = nums.length - 1; i >= 0;i--)
        {
            heapify(nums, i,nums.length);
        }
        for(int i = nums.length - 1; i >= nums.length - k;i--)
        {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
        return nums[nums.length - k];
    }
    private void heapify(int[] res, int i, int n) //堆化 把i位置的值往下沉 n是heap的size 把小的值往下沉
    {
        int left = 2 * i + 1;
        if(left < n)
        {
            int largest = i;
            if(res[left] > res[largest]) largest = left;
            if(left + 1 < n && res[left + 1] > res[largest])
                largest  = left + 1;
            if(largest != i) //i 不是最大的就和孩子节点换
            {
                swap(res, i, largest);
                heapify(res, largest, n);
            }

        }
    }
    private void swap(int[] res, int i, int j)
    {
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
