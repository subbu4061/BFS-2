
// Time Complexity: O(n), where n is the number of nodes.
// Space Complexity: O(w), where w is the maximum width of the tree
// Explanation: I perform a BFS traversal using a queue, storing each node along with its parent. At each level, I check whether nodes x and y exist and record their parents.
// If both are found at the same level and have different parents, they are cousins. If only one is found at a level, or both share the same parent, they are not cousins.
// The algorithm stops as soon as both nodes are found or when the tree is fully traversed.

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            boolean foundx = false;
            boolean foundy = false;
            TreeNode parentx = new TreeNode();
            TreeNode parenty = new TreeNode();
            for(int i=0; i<size; i=i+2){
                TreeNode child = q.poll();
                TreeNode parent = q.poll();
                if(child.val ==x) {
                    foundx = true;
                    parentx = parent;
                }
                if(child.val ==y) {
                    foundy = true;
                    parenty = parent;
                }
                if(child.left!=null){
                    q.add(child.left);
                    q.add(child);
                } 
                if(child.right!=null){
                    q.add(child.right);
                    q.add(child);

                } 
            }
            if(foundx && foundy) {
                if(parentx!=parenty) {
                    return true;
                }
                return false;
            }
            if(foundx || foundy) return false; 
            
        }
        return false;
        
    }
}
