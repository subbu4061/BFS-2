// Solution-1

// Time Complexity: O(n), where n is the number of nodes.
// Space Complexity: O(w), where w is the maximum width of the tree
// Explanation: I perform a level-order traversal using a queue. For each level, I iterate through all nodes currently in the queue, 
// and when I reach the last node of that level, I record its value in the result. By always taking the rightmost node at each depth, I obtain the tree’s right-side view.


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                if(i==size-1) {
                    result.add(curr.val);
                }
                if(curr!=null){
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
                }
                
            }
        }
        return result;

    }
}


// Solution-2

// Time Complexity: O(n), where n is the number of nodes.
// Space Complexity: O(h), where h is the height of the tree
// Explanation: I traverse the tree using DFS, always visiting the right child before the left child. I track the current depth and whenever 
// I reach a level for the first time (level == result.size()), I add that node’s value to the result. This guarantees that the
// first node seen at each depth is the rightmost one.




class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
        
    }

    private void helper(TreeNode root, int level, List<Integer> result) {
        // base
        if(root == null) return;

        // logic
        if(level == result.size()) {
            result.add(root.val);
        }


        helper(root.right, level+1, result);
        helper(root.left, level +1, result);

    }
}
