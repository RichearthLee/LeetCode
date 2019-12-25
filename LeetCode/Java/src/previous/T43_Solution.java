package previous;

public class T43_Solution {
    /**
     * @author yukunlee
     * @Description balanced-binary-tree
     * @date 2018年11月1日
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(treeHight(root.left) - treeHight(root.right)) > 1) return false;
    	return isBalanced(root.left)&&isBalanced(root.right);
    }
    private int treeHight(TreeNode root) {
    	return root == null? 1:Math.max(treeHight(root.left), treeHight(root.right))+1;
    }
    
    /**
     * @author yukunlee
     * @Description convert-sorted-list-to-binary-search-tree
     * @date 2018年11月1日
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
    	return toBST(head, null);
    
    }
    private TreeNode toBST(ListNode head, ListNode tail) {
    	if(head == tail) {
    		return null;
    	}
    	ListNode  fast = head, slow = head;
    	for(;fast!= tail && fast.next != tail;) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	TreeNode root = new TreeNode(slow.val);
    	root.left = toBST(head , slow);
    	root.right = toBST(slow.next , tail);  	
        return root;
    }
    
    /**
     * @author yukunlee
     * @Description convert-sorted-array-to-binary-search-tree
     * @date 2018年11月1日
     * @param num
     * @return
     */
    public TreeNode sortedArrayToBST(int[] num) {
    	if(num.length ==0) {
    		return null;
    	}
    	return BST(num, 0, num.length-1);
    }
    private TreeNode BST(int[] num, int start, int end) {
    	if(start > end) {
    		return null;
    	}
    	int mid = (end + start +1)>>1;
    	TreeNode root = new TreeNode(num[mid]);
    	root.left = BST(num, start, mid-1);
    	root.right = BST(num, mid+1, end);
    	
    	return root;
    }

}
