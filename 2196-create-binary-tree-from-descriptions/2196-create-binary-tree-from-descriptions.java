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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> notRoot = Arrays.stream(descriptions)
                                        .map(des -> des[1])
                                        .collect(Collectors.toSet());
        Map<Integer, TreeNode> map = new HashMap<>();
        Integer root = -1;
        for(int[] des : descriptions) {
            if(!notRoot.contains(des[0])) root = des[0];
            TreeNode par = map.getOrDefault(des[0], new TreeNode(des[0]));
            TreeNode child = map.getOrDefault(des[1], new TreeNode(des[1]));
            if(des[2]==0) par.right = child;
            else par.left = child;
            map.put(des[0], par);
            map.put(des[1], child);
        }
        return map.get(root);
    }
}