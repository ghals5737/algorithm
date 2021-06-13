// class Solution {
//     public int perm(boolean[] v,int idx,int n){
//         if(n+1==idx){
//             return 1;
//         }
//         int res=0;
//         for(int i=1;i<=n;i++){
//             if(!v[i]&&(i%idx==0||idx%i==0)){
//                 v[i]=true;
//                 res+=perm(v,idx+1,n);
//                 v[i]=false;
//             }
//         }
//         return res;
//     }
//     public int countArrangement(int n) {
//         return perm(new boolean[n+1],1,n);
//     }
// }
