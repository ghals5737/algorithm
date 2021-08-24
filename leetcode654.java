class Solution {
    public boolean solve(TreeNode n,int k,HashSet<Integer>set){
        if(n==null)return false;
        if(solve(n.left,k,set))return true;
        if(set.contains(k-n.val))return true;
        set.add(n.val);
        return solve(n.right,k,set);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer>set=new HashSet<>();
        return solve(root,k,set);
    }
