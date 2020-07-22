/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // To store the result.
        List<List<Integer>> result = new ArrayList<>();
        
        // To store the value level by level.
        List<Integer> valsInLevel = new ArrayList<>();
        
        // Stack to store current and next level TreeNodes.
        Stack<TreeNode> curLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        
        boolean isLeftToRight = true;
        
        // If root is null.
        if (root == null){
            return result;
        }
        
        // push root node to current level.
        curLevel.push(root);
        
        while(!curLevel.isEmpty()){
            TreeNode node = curLevel.pop();
            valsInLevel.add(node.val);
            
            // push the next level nodes from left to right.
            if(isLeftToRight){
                if(node.left != null){
                    nextLevel.push(node.left);
                }
                if(node.right != null){
                    nextLevel.push(node.right);
                }
            }
            
            // push the next level nodes from right to left.
            else {
                if(node.right != null){
                    nextLevel.push(node.right);
                } 
               if(node.left != null){
                    nextLevel.push(node.left);
                }
            }
            
            // Interchange the values once the level is completed.
            if(curLevel.isEmpty()){
                curLevel = nextLevel;
                nextLevel = new Stack<>();
                isLeftToRight = !isLeftToRight;
                result.add(valsInLevel);
                valsInLevel = new ArrayList<>();
            }
        }
        return result;
    }
}
