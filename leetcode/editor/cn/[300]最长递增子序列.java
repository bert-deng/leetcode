//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 1899 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n + 1];
        d[1] = nums[0];
        int len = 1;
        for(int i = 1; i < n; ++i)
        {
            if(nums[i] > d[len])
            {
                d[++len] = nums[i];
            }
            else {
                int l = 1, r = len, pos = 0;
                while(l <= r)
                {
                    int m = (l + r) >> 1;
                    if(d[m] < nums[i])
                    {
                        l = m + 1;
                        pos = m;
                    }
                    else r = m - 1;
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
