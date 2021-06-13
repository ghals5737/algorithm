// class Solution {
//     public boolean dfs(int n,int p){
//         if(n==0)return true;
//         int num=(int)Math.pow(3,p);
//         if(n>=num){
//             if(dfs(n-num,p+1))return true;
//             if(dfs(n,p+1))return true;
//         }
//         return false;
//     }
//     public boolean checkPowersOfThree(int n) {
//         return dfs(n,0);
//     }
// }
