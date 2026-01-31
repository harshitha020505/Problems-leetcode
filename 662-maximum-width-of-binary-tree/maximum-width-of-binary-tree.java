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
 * }*/
 
class Pair { 
        TreeNode node; 
        long idx; 
        Pair(TreeNode node, long idx) 
        { this.node = node; this.idx = idx; } }
 
 
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // List<List<Integer>> llst=new ArrayList<>();
        Queue<Pair> qu=new LinkedList<>();
        if(root==null){
            return 0;
        }
        int maxWidth=0;
        qu.add(new Pair(root,0));
        while(!qu.isEmpty()){
            int size = qu.size();
            long min = qu.peek().idx; // normalize
            long first = Long.MAX_VALUE;
            long last = Long.MIN_VALUE;
            // List<Integer> lst=new ArrayList<>();
            for(int i=0;i<size;i++){
                Pair p=qu.poll();
                long idx=p.idx-min;
                // TreeNode node=qu.poll();
                // qu.pop();
                first=Math.min(first,idx);
                last=Math.max(last,idx);
                // lst.add(p.node.val);
                if(p.node.left!=null){
                    qu.add(new Pair(p.node.left,2*idx));
                    // left=2*left;
                }
                
                if(p.node.right!=null){
                    qu.add(new Pair(p.node.right,2*idx+1));
                    // right=2*right+1;
                }
            }
            maxWidth=Math.max(maxWidth,(int)(last-first+1));
           
            // llst.add(lst);

        }
        return maxWidth;
    }
}