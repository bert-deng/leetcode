//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3749 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int f = 0; f < n; f++)
        {
            if(f > 0 && nums[f] == nums[f - 1]) continue;
            int t = n - 1;
            int target = -nums[f];
            for (int s = f + 1; s < n; s++)
            {
                if(s > f + 1 && nums[s] == nums[s - 1]) continue;
                while(s < t && nums[s] + nums[t] > target)
                    t--;
                if(s == t) break;
                if(nums[s] + nums[t] == target)
                {
                    ArrayList<Integer> subList = new ArrayList<>();
                    subList.add(nums[f]);
                    subList.add(nums[s]);
                    subList.add(nums[t]);
                    list.add(subList);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
