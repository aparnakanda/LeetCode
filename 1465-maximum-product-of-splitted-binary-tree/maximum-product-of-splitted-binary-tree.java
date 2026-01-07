/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long totalSum=0;
    long maxProduct=0;
    static final int MOD=1000000007;
    public int maxProduct(TreeNode root) {
        totalSum=getSum(root);
        dfs(root);
        return (int)(maxProduct%MOD);
    }
    private long getSum(TreeNode node){
        if(node==null) return 0;
        return node.val+getSum(node.left)+getSum(node.right);
    }
    private long dfs(TreeNode node){
        if(node==null) return 0;
        long left=dfs(node.left);
        long right=dfs(node.right);
        long subTreeSum=node.val+left+right;
        long product=subTreeSum*(totalSum-subTreeSum);
        maxProduct=Math.max(maxProduct,product);

        return subTreeSum;
    }
}