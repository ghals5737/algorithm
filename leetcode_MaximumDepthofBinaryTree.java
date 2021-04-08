public class leetcode_MaximumDepthofBinaryTree {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    class Solution {
        static int solve(TreeNode root,int d){
            if(root==null)return d;
            return Math.max(solve(root.left,d+1),solve(root.right,d+1));
        }
        public int maxDepth(TreeNode root) {
            return solve(root,0);
        }
    }    
}
