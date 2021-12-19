/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        while(num >= 10)
        {
            int n = 0;
           while(num != 0)
           {
                n += num % 10;
                num /= 10;
           }
           num = n;
        }
        return num;
    }
}
// @lc code=end

