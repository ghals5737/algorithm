
// class Solution {
//     HashMap<String,Integer>map;
//     public int findTargetSumWays(int[] nums, int target) {
//         map=new HashMap<>(); 
//         return solve(nums,0,target);
//     }
//     public int solve(int[] nums,int index,int target){
//         if(index==nums.length){
//             if(target==0)return 1;
//             else return 0;
//         }
//         String key=index+"-"+target;
//         if(map.containsKey(key))return map.get(key);
//         int plus=solve(nums,index+1,target+nums[index]);
//         int minus=solve(nums,index+1,target-nums[index]);
//         map.put(key,plus+minus);
//         return map.get(key);
//     }
// }
