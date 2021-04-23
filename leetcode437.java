class Solution {
    int cnt=0;    
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,new ArrayList<>(),targetSum);
        return cnt;
    }
    public void dfs(TreeNode root,List<Integer>list,int sum){        
        if(root==null)return;
        list.add(root.val);
        dfs(root.left,list,sum);
        dfs(root.right,list,sum);
        int total=0;
        for(int i=list.size()-1;i>=0;i--){total+=list.get(i);if(total==sum)cnt++;}
        list.remove(list.size()-1);
    }
}
