class Solution {
    static List<List<Integer>>ans;
    public void solve(List<Integer> list,int[] c,int idx,int sum,int t){
        if(sum>t)return;
        if(sum==t){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<c.length;i++){
            if(sum+c[i]>t)continue;
            list.add(c[i]);
            solve(list,c,i,sum+c[i],t);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        solve(new ArrayList<>(),candidates,0,0,target);
        return ans;
    }
}
