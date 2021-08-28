class Solution {
    int max=Integer.MIN_VALUE;
    public int getMax(TreeNode node){
        if(node==null)return 0;
        int left=Math.max(getMax(node.left),0);
        int right=Math.max(getMax(node.right),0);
        int now=node.val+left+right;
        max=Math.max(max,now);
        return node.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }
}
