// class Solution {
//     public int maxSubArray(int[] nums) {
//         int curr=nums[0];
//         int max=nums[0];
//         for(int i=1;i<nums.length;i++){
//             int now=nums[i];
//             curr=Math.max(now,curr+now);
//             max=Math.max(max,curr);
//         }
//         return max;
//     }
// }
