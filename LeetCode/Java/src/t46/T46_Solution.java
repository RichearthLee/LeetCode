package t46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import t14.TreeNode;

public class T46_Solution {
	/**
	 * @author yukunlee
	 * @Description maximum-depth-of-binary-tree
	 * @date 2018年11月3日
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	/**
	 * @author yukunlee
	 * @Description binary-tree-zigzag-level-order-traversal
	 * @date 2018年11月3日
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		ArrayList<Integer> arr;
		TreeNode node;
		queue.offer(root);
		int size = 0;
		int layer = 0;
		while (!queue.isEmpty()) {
			size = queue.size();
			arr = new ArrayList<>();
			++layer;
			if (layer % 2 == 1) {
				while (size > 0) {
					node = queue.poll();
					arr.add(node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
					--size;
				}
			} else {
				while (size > 0) {
					node = queue.poll();
					arr.add(0, node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
					--size;
				}
			}
			res.add(arr);
		}
		return res;
	}

	/**
	 * @author yukunlee
	 * @Description symmetric-tree traversal
	 * @date 2018年11月4日
	 * @param root
	 * @return
	 */
	public boolean isSymmetric_traversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return true;
		ArrayList<Integer> arr = new ArrayList<>();
		TreeNode node;
		queue.offer(root);
		int size = 0;
		while (!queue.isEmpty()) {
			size = queue.size();
			arr.clear();
			while (size > 0) {
				node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
					arr.add(node.left.val);
				} else {
					arr.add(0);
				}
				if (node.right != null) {
					queue.add(node.right);
					arr.add(node.right.val);
				} else {
					arr.add(0);
				}
				--size;
			}
			if (!isHalfEqual(arr))
				return false;
		}
		return true;
	}

	private boolean isHalfEqual(ArrayList<Integer> arr) {
		int len = arr.size() - 1;
		if (len <= 0) {
			return true;
		}
		for (int i = 0; i <= len / 2; ++i) {
			if (arr.get(i) != arr.get(len - i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @author yukunlee
	 * @Description symmetric-tree recursion
	 * @date 2018年11月4日
	 * @param root
	 * @return
	 */
	public boolean isSymmetric_recursion(TreeNode root) {
		return isEqual(root, root);
	}

	private boolean isEqual(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if ((left == null && right != null) || left != null && right == null)
			return false;
		return left.val == right.val && isEqual(left.left, right.right) && isEqual(left.right, right.left);
	}

	/**
	 * @author yukunlee
	 * @Description isSameTree
	 * @date 2018年11月9日
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	/**
	 * @author yukunlee
	 * @Description recover-binary-search-tree
	 * @date 2018年11月9日
	 * @param root
	 */
	public void recoverTree(TreeNode root) {
		TreeNode cur = root, pre = null;
		while (cur != null) {
			if (cur.left == null) {
				detect(pre, cur);
				pre = cur;
				cur = cur.right;
			} else {
				TreeNode node = cur.left;
				while (node.right != null && node.right != cur) {
					node = node.right;
				}
				if (node.right == null) {
					node.right = cur;
					cur = cur.left;
				} else {
					detect(pre, cur);
					node.right = null;
					pre = cur;
					cur = cur.right;
				}
			}
		}
	}

	private void detect(TreeNode pre, TreeNode cur) {
		if (pre != null && cur != null) {
			if (pre.val > cur.val) {
				int n = pre.val;
				pre.val = cur.val;
				cur.val = n;
			}
		}
	}

	/**
	 * @author yukunlee
	 * @Description recover-binary-search-tree
	 * @date 2018年11月9日
	 * @param root
	 */
	TreeNode firstElem = null, secondElem = null;
	TreeNode preElem = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree_recursion(TreeNode root) {
		// 中序遍历
		inOrderTraverse(root);
		int tmp = firstElem.val;
		firstElem.val = secondElem.val;
		secondElem.val = tmp;
	}

	private void inOrderTraverse(TreeNode root) {
		if (root == null)
			return;
		inOrderTraverse(root.left);
		if (firstElem == null && preElem.val >= root.val) {
			firstElem = preElem;
		}
		if (firstElem != null && preElem.val >= root.val) {
			secondElem = root;
		}
		preElem = root;
		inOrderTraverse(root.right);
	}

	/**
	 * @author yukunlee
	 * @Description validate-binary-search-tree
	 * @date 2018年11月11日
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		return isValidBST_recursion(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private boolean isValidBST_recursion(TreeNode root, int max, int min) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val >= max) {
			return false;
		}
		return isValidBST_recursion(root.left, root.val, min) && isValidBST_recursion(root.right, max, root.val);
	}

	/**
	 * @author yukunlee
	 * @Description validate-binary-search-tree 中序遍历
	 * @date 2018年11月11日
	 * @param root
	 * @return
	 */
	public boolean isValidBST_travsal(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode pre = null;
		while (!stack.isEmpty() || cur != null) {
			if (cur == null) {
				cur = stack.pop();
				if (pre != null && pre.val >= cur.val)
					return false;
				pre = cur;
				cur = cur.right;
			} else {

				stack.push(cur);
				cur = cur.left;
			}
		}
		return true;
	}
	
	
    /**
     * @author yukunlee
     * @Description nique-binary-search-trees-ii
     * @date 2018年11月13日
     * @param n
     * @return
     */
    public ArrayList<TreeNode> generateTrees2(int n) {  
    	return recursion1(1, n);
    }
    private ArrayList<TreeNode> recursion1(int low , int high) {
    	ArrayList<TreeNode> result = new ArrayList<>();
    	if(low > high) {
    		result.add(null);
    		return result;
    	}
    	for(int i = low ; i <= high; ++i) {
    		ArrayList<TreeNode> left = recursion1(low, i-1);
    		ArrayList<TreeNode> right = recursion1(i+1, high);
    		for( int j = 0 ; j < left.size(); ++j) {
    			for( int k = 0 ; k <right.size() ; ++k) {
    				TreeNode node = new TreeNode(i);
    				node.left = left.get(j);
    				node.right = right.get(k);
    				result.add(node);
    			}
    		}       	
    	}
    	return result;
    }
    
    /**
     * @author yukunlee
     * @Description unique-binary-search-trees
     * @date 2018年11月13日
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return recursion(1, n);
    }
    
    private int recursion(int low , int high) {
    	if(low > high) {
    		return 0;
    	}
    	int sum = 0;
    	for(int i = low ; i <= high ; ++i) {
    		int left = recursion(low, i-1);
    		int right = recursion(i +1, high);
    		sum += left + right;
    	}
    	return sum;
    }
   
    public int numTrees_v1(int n) {
    	if(n<=0) return 0;
        int[] arr = new int[n+1];
        arr[0] =1;
        arr[1] =1;
        for(int i = 2 ; i <= n ; ++i) {
        	for(int j = 1; j <= i ; ++j) {
        		arr[i] = arr[j-1] * arr[i-j]; 
        	}
        }
        return arr[n];
    }
    
    /**
     * @author yukunlee
     * @Description binary-tree-inorder-traversal
     * @date 2018年11月14日
     * @param root
     * @return
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
    	return inorderTraversal_helper(list, root);
    }
    private ArrayList<Integer> inorderTraversal_helper(ArrayList<Integer> list , TreeNode root) {
    	if(root == null) {
    		return list;
    	}
    	inorderTraversal_helper(list, root.left);
    	list.add(root.val);
    	inorderTraversal_helper(list, root.right);
    	return list;
    }
    
    
    /**
     * @author yukunlee
     * @Description binary-tree-inorder-traversal
     * @date 2018年11月14日
     * @param root
     * @return
     */
    public ArrayList<Integer> inorderTraversal_v1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(!st.isEmpty() || cur != null) {
        	if(cur == null) {
        		cur = st.pop();
        		list.add(cur.val);
        		cur = cur.right;
        	}else {
        		st.push(cur);
        		cur = cur.left;
        	}
        }
    	return list;
    }

}
