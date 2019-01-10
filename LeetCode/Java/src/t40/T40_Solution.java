package t40;

import java.util.LinkedList;
import java.util.Queue;

public class T40_Solution {
	/**
	 * @author yukunlee
	 * @Description populating-next-right-pointers-in-each-node
	 * @date 2018年10月30日
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
		Queue<TreeLinkNode> queue = new LinkedList<>();
		TreeLinkNode n = new TreeLinkNode(0);
		int layer = 0;
		queue.offer(root);

		while (!queue.isEmpty()) {
			layer = queue.size();
			while (layer > 0) {
				n = queue.poll();
				n.next = layer > 1 ? queue.peek() : null;
				if (n.left != null) {
					queue.offer(n.left);
				}
				if (n.right != null) {
					queue.offer(n.right);
				}
				--layer;
			}
		}

	}
	
    /**
     * @author yukunlee
     * @Description populating-next-right-pointers-in-each-node-ii
     * @date 2018年10月31日
     * @param root
     */
    public void connect_1(TreeLinkNode root) {
    	TreeLinkNode firstOfLayer = new TreeLinkNode(0);
    	TreeLinkNode cur = firstOfLayer;
    	
    	while(root != null) {
    		firstOfLayer.next = null;
    		while(root != null) {
    			if(root.left != null) {
    				cur.next = root.left;
    				cur = cur.next;
    			}
    			if(root.right != null) {
    				cur.next = root.right;
    				cur = cur.next;
    			}
    			root = root.next;
    		}
    		root = firstOfLayer.next;
    		cur = firstOfLayer;
    	}
    }

}
