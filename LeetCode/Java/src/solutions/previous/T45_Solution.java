package solutions.previous;

public class T45_Solution {
    /**
     * @author yukunlee
     * @Description construct-binary-tree-from-preorder-and-inorder-traversal
     * @date 2018年11月3日
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length == 0) {
    		return null;
    	}
    	return recursion(preorder, inorder, 0,preorder.length-1, 0);
    }
    private TreeNode recursion(int[] preorder, int[] inorder, int head,int tail, int first) {
    	TreeNode root = new TreeNode(preorder[first]);
    	int mid = -1;
    	for(int i = head ; i<= tail; ++i) {  
    		if(inorder[i] == preorder[first]) {
    			mid = i;
    			break;
    		}
    	}
    	if(mid != head) root.left = recursion(preorder, inorder, head,mid-1, first+1);
    	first = first + mid - head;
    	if(mid != tail) root.right = recursion(preorder, inorder, mid+1,tail, first+1);  	
    	return root;
    }
    
    /**
     * @author yukunlee
     * @Description construct-binary-tree-from-inorder-and-postorder-traversal
     * @date 2018年11月3日
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree_1(int[] inorder, int[] postorder) {
    	if(postorder.length == 0) {
    		return null;
    	}
    	return recursion_1(postorder, inorder, 0, inorder.length-1, inorder.length-1);
    }
    
    private TreeNode recursion_1(int[] postorder, int[] inorder, int head,int tail, int last) {
    	TreeNode root = new TreeNode(postorder[last]);
    	int mid = -1;
    	for(int i = tail ; i >= head; --i) {  
    		if(inorder[i] == postorder[last]) {
    			mid = i;
    			break;
    		}
    	}
    	if(mid != tail) root.right = recursion_1(postorder, inorder, mid+1,tail, last-1);  	
    	last = last -tail + mid;
    	if(mid != head) root.left = recursion_1(postorder, inorder, head,mid-1, last-1);
    	return root;
    }
    

}
