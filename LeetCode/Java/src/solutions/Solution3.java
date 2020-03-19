package solutions;


import utility.ListNode;
import utility.Node;
import utility.TreeNode;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 101-150
 * @author: Yukun Lee
 * @create: 2019-08-19 11:20
 */
public class Solution3 {

    /**
     * 101. Symmetric Tree
     * @param root
     * @return
     */
    public boolean isSymmetric_v1(TreeNode root) {
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        if(root == null) return true;
        left.add(root.left); right.add(root.right);
        while(!left.isEmpty() && !right.isEmpty()){
            TreeNode l = left.remove();
            TreeNode r = right.remove();
            if(l != null && r != null){
                if(l.val != r.val) return false;
                left.add(l.left); left.add(l.right);
                right.add(r.right); right.add(r.left);
            }else if(!(l == null && r == null)){
                return false;
            }
        }
        return left.isEmpty() && right.isEmpty();
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric_Recursion(root.left, root.right);
    }

    private boolean isSymmetric_Recursion(TreeNode left, TreeNode right) {
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return  false;
        }
        return isSymmetric_Recursion(left.left, right.right) && isSymmetric_Recursion(left.right, right.left);
    }

    /**
     * 102. Binary Tree Level Order Traversal
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_v1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> arr = new LinkedList<>();
        if(root == null) return res;
        arr.add(root);
        int cur = 1, next = 0;
        List<Integer> mid = new ArrayList<>();
        while(!arr.isEmpty()){
            TreeNode node = arr.remove();
            if(node.left != null){
                arr.add(node.left);
                next++;
            }
            if(node.right != null ){
                arr.add(node.right);
                next++;
            }
            cur--;
            mid.add(node.val);
            if(cur == 0){
                res.add(new ArrayList<>(mid));
                cur = next;
                next = 0;
                mid.clear();
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder_v2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> arr = new LinkedList<>();
        if(root == null) return res;
        arr.add(root);
        while(!arr.isEmpty()){
            int num = arr.size();
            List<Integer> mid = new ArrayList<>();
            for(int i = 0 ; i < num ; ++i){
                TreeNode node = arr.remove();
                if(node.left != null){
                    arr.add(node.left);
                }
                if(node.right != null ){
                    arr.add(node.right);
                }
                mid.add(node.val);
            }
            res.add(mid);
        }
        return res;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder_Recursion(root, res, 0);
        return res;
    }
    private void levelOrder_Recursion(TreeNode root, List<List<Integer>> res, int height){
        if (root == null) return;
        if(res.size() <= height){
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        levelOrder_Recursion(root.left, res, height+1);
        levelOrder_Recursion(root.right, res, height+1);
    }

    /**
     * 104. Maximum Depth of Binary Tree
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
       return maxDepth_Recursion(root, 0);
    }
    private int maxDepth_Recursion(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        return Math.max(maxDepth_Recursion(root.left, depth+1)
                ,maxDepth_Recursion(root.right, depth+1));
    }

    /**
     * 103. Binary Tree Zigzag Level Order Traversal
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_v1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> arr = new LinkedList<>();
        if(root == null) return res;
        arr.add(root);
        while(!arr.isEmpty()){
            int num = arr.size();
            List<Integer> mid = new ArrayList<>();
            for(int i = 0 ; i < num ; ++i){
                TreeNode node = arr.remove(0);
                if(node.left != null){
                    arr.add(num-i-1, node.left);
                }
                if(node.right != null ){
                    arr.add(num-i-1, node.right);
                }
                mid.add(node.val);
            }
            res.add(mid);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrder_Recursion(root, res, 0);
        return res;
    }
    private void zigzagLevelOrder_Recursion(TreeNode root, List<List<Integer>> res, int height){
        if (root == null) return;
        if(res.size() <= height){
            res.add(new ArrayList<>());
        }
        if(height % 2 == 0){
            res.get(height).add(root.val);
        }else{
            res.get(height).add(0,root.val);
        }

        zigzagLevelOrder_Recursion(root.left, res, height+1);
        zigzagLevelOrder_Recursion(root.right, res, height+1);
    }

    /**
     * 105. Construct Binary Tree from Preorder and Inorder Traversal
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_v1(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1 ; i < inorder.length ; ++i){
            TreeNode left = new TreeNode(inorder[i]);
        }

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return buildTree_Recursion(preorder,0,inorder,0,inorder.length-1);
    }

    private TreeNode buildTree_Recursion(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd){
        if(preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i = inStart ; i <= inEnd ; i++){
            if(preorder[preStart] == inorder[i]){
                index = i;break;
            }
        }
        root.left = buildTree_Recursion(
                preorder,
                preStart + 1,
                inorder,
                inStart,
                index-1);
        root.right = buildTree_Recursion(
                preorder,
                preStart + index - inStart + 1,
                inorder,
                index+1,
                inEnd);
        return root;
    }

    /**
     * 106. Construct Binary Tree from Inorder and Postorder Traversal
     * @param postorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_v2(int[] postorder, int[] inorder) {
        if (postorder.length == 0 || inorder.length == 0) return null;
        return buildTree_Recursion_v2(postorder,postorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode buildTree_Recursion_v2(int[] postorder, int postStart, int[] inorder, int inStart, int inEnd){
        if(postStart < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int index = 0;
        for(int i = inStart ; i <= inEnd ; i++){
            if(postorder[postStart] == inorder[i]){
                index = i;break;
            }
        }
        root.left = buildTree_Recursion_v2(
                postorder,
                postStart -(inEnd - index) -1,
                inorder,
                inStart,
                index-1);
        root.right = buildTree_Recursion_v2(
                postorder,
                postStart - 1,
                inorder,
                index+1,
                inEnd);
        return root;
    }

    /**
     * 107. Binary Tree Level Order Traversal II
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> arr = new LinkedList<>();
        if(root == null) return res;
        arr.add(root);
        while(!arr.isEmpty()){
            int num = arr.size();
            List<Integer> mid = new ArrayList<>();
            for(int i = 0 ; i < num ; ++i){
                TreeNode node = arr.remove();
                if(node.left != null){
                    arr.add(node.left);
                }
                if(node.right != null ){
                    arr.add(node.right);
                }
                mid.add(node.val);
            }
            res.add(0,mid);
        }
        return res;
    }

    /**
     * 108. Convert Sorted Array to Binary Search Tree
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST_Recursion(nums,0, nums.length-1);
    }

    private TreeNode sortedArrayToBST_Recursion(int[] nums, int start, int end){
        if (start > end) return null;
        int index = (start+end)/2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = sortedArrayToBST_Recursion(nums, start, index-1);
        root.right = sortedArrayToBST_Recursion(nums,index+1, end);
        return root;
    }

    /**
     * 109. Convert Sorted List to Binary Search Tree
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode fast = head, slow = head, pre = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        root.left = pre == slow ? sortedListToBST(null):sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    /**
     * 110. Balanced Binary Tree
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(isBalanced(root.left, 2) - isBalanced(root.right, 2)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    private int isBalanced(TreeNode root, int height){
        if(root == null) return height-1;
        return Math.max(isBalanced(root.left,height+1),isBalanced(root.right,height+1));
    }

    /**
     * 111. Minimum Depth of Binary Tree
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    /**
     * 112. Path Sum
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 113. Path Sum II
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum_Recusion(root, sum, res, new ArrayList<>());
        return res;
    }

    private void pathSum_Recusion(TreeNode root, int sum,List<List<Integer>> res,List<Integer> mid) {
        if(root == null) return;
        mid.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            res.add(new ArrayList<>(mid));
        }
        pathSum_Recusion(root.left, sum - root.val, res, mid);
        pathSum_Recusion(root.right, sum - root.val, res, mid);
        mid.remove(mid.size()-1);
        return;
    }

    /**
     * 114. Flatten Binary Tree to Linked List
     * @param root
     */
    public void flatten_v1(TreeNode root) {
        if (root == null) return;
        PriorityQueue<TreeNode> sorted = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            TreeNode node = list.poll();
            if(node.left != null) list.add(node.left);
            if(node.right != null) list.add(node.right);
            sorted.add(node);
        }
        TreeNode cur = sorted.poll();
        while(!sorted.isEmpty()){
            cur.right = sorted.poll();
            cur.left = null;
            cur = cur.right;
        }
    }

    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = null;

        TreeNode cur = root;
        while(cur.right != null)cur = cur.right;
        cur.right = right;

    }

    /**
     * 115. Distinct Subsequences
     * @param s
     * @param t
     * @return
     */
    public int numDistinct_v1(String s, String t) {
        return numDistinct(s,t,0,0);
    }

    private int numDistinct(String s, String t, int sStart, int tStart){
        if(tStart == t.length()){
            return 1;
        }else if(sStart == s.length()){
            return 0;
        }
        int res = 0;
        for(int i = sStart ; i < s.length() ; ++i){
            if(s.charAt(i) == t.charAt(tStart)){
                res += numDistinct(s,t,i+1,tStart+1);
            }
        }
        return res;
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for(int i = 0 ; i <= s.length() ; i++){
            dp[0][i] = 1;
        }
        for(int i = 1 ; i<= t.length() ; ++i){
            for (int j = 1 ; j <= s.length() ; ++j){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    /**
     * 116. Populating Next Right Pointers in Each Node
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return root;
        if(root.left != null){
            root.left.next = root.right;
            if (root.next != null){
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node connect_v1(Node root) {
        Node cur = root, first = root;
        while(first != null){
            cur = first;
            if (cur.left != null){
                first = cur.left;
            }
            while(cur != null){
                if(cur.left != null){
                    cur.left.next = cur.right;
                    if (cur.next != null){
                        cur.right.next = cur.next.left;
                    }
                }
                cur = cur.next;
            }
        }
        return root;
    }

    /**
     * 117. Populating Next Right Pointers in Each Node II
     * @param root
     * @return
     */
    public Node connect_v3(Node root) {
        Node cur, head = root, child;
        while(head != null){
            cur = head;
            head = null;
            child = null;
            while(cur != null){
                if(cur.left != null){
                    if(child == null){
                        head = cur.left;
                    }else {
                        child.next = cur.left;
                    }
                    child = cur.left;
                }
                if (cur.right != null){
                    if (child == null){
                        head = cur.right;
                    }else {
                        child.next = cur.right;
                    }
                    child = cur.right;
                }
                cur = cur.next;
            }
        }
        return root;
    }

    public Node connect_v4(Node root) {
        if (root == null) return root;
        Node child = null;
        if(root.left != null && root.right != null){
            root.left.next = root.right;
            child = root.right;
        }else if (root.left != null){
            child = root.left;
        }else if (root.right != null){
            child = root.right;
        }
        Node pre = root.next;
        while (child != null && pre != null){
            if (pre.left != null){
                child.next = pre.left;
                break;
            }else if (pre.right != null){
                child.next = pre.right;
                break;
            }else {
                pre = pre.next;
            }
        }
        connect_v4(root.left);
        connect_v4(root.right);
        return root;
    }

    /**
     * 118. Pascal's Triangle
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        for (int i = 0 ; i < numRows ; i++){
            List<Integer> mid = new ArrayList<>();
            if (i == 0){ mid.add(1);}
            else {
                for (int j = 0; j <= i ; j++){
                    int pre = (j-1 >= 0 ? res.get(i-1).get(j-1) : 0);
                    int post = (j == i ? 0 : res.get(i-1).get(j));
                    mid.add(pre + post);
                }
            }
            res.add(mid);
        }
        return res;
    }

    /**
     * 119. Pascal's Triangle II
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for(int i = 0 ; i < rowIndex + 1 ; i++){
            res.add(1);
            for(int j = i-1 ;  j > 0 ; --j){
                res.set(j, res.get(j) + res.get(j-1));
            }
        }
        return res;
    }

    /**
     * 数组中的逆序对
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        int res = 0;
        for(int i = 0 ; i < array.length ; ++i){
            for(int j = i + 1 ; j < array.length ; ++j){
                if(array[i] > array[j]){
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 两个链表的第一个公共结点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        while(pHead1 != null){
            ListNode cur = pHead2;
            while(cur != null){
                if(pHead1 == cur){
                    return cur;
                }
                cur = cur.next;
            }
            pHead1 = pHead1.next;
        }
        return null;
    }

    public ListNode FindFirstCommonNode_v1(ListNode pHead1, ListNode pHead2) {
        int len1 = 0, len2 = 0;
        ListNode cur1 = pHead1;
        while(cur1 != null){
            cur1 = cur1.next;
            ++len1;
        }

        ListNode cur2 = pHead2;
        while(cur2 != null){
            cur2 = cur2.next;
            ++len2;
        }
        if(len1 > len2){
            len1 = len1 - len2;
            while(len1 > 0){
                pHead1 = pHead1.next;
                --len1;
            }
        }else {
            len2 = len2 - len1;
            while(len2 > 0){
                pHead2 = pHead2.next;
                --len2;
            }
        }
        while(pHead1 != null){
            if(pHead1 == pHead2)return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public ListNode FindFirstCommonNode_v2(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while(cur1 != cur2){
            cur1 = cur1 == null ? pHead1 : cur1.next;
            cur2 = cur2 == null ? pHead2 : cur2.next;
        }
        return cur1;
    }

    /**
     * 数字在排序数组中出现的次数
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if(array.length == 0)return 0;
        int res = 0, left =0, right = array.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(array[mid] > k){
                right = mid -1;
            }else if(array[mid] < k){
                left = mid + 1;
            }else {
                left = mid;
                break;
            }
        }
        for(int i = left+1 ; i < array.length && array[i] == k ; ++i){
            res++;
        }
        for(int i = left ;  i >= 0 && array[i] == k ; --i){
            res++;
        }
        return res;
    }

    /**
     * 二叉树的深度
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left)+1, TreeDepth(root.right)+1);
    }

    /**
     * 平衡二叉树
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        Boolean f = Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) < 2;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && f;
    }

    /**
     * 数组中只出现一次的数字
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> st = new HashSet<>();
        for(int i : array){
            if(!st.add(i)){
                st.remove(i);
            }
        }
        boolean f = true;
        for(int i : st){
            if(f){
                num1[0] = i;
                f = false;
            }else {
                num2[0] = i;
            }
        }
    }

    /**
     * 和为S的连续正数序列
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < sum ; ++i){
            int num = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = i ; j < sum ; ++j){
                num += j;
                temp.add(j);
                if(num > 100) break;
                if(num == 100) res.add(temp);
            }
        }
        return res;
    }

    public int[] maxNum(int[] arr, int k){
        int[] res = new int[k];
        res[0] = arr[0];
        if(arr.length < 2)return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : arr){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }
        k = k > arr.length ? arr.length : k;
        for(int i = 0 ; i < k ; ++i){
            int key = 0, value = 0;
            for(Map.Entry<Integer, Integer> n : map.entrySet()){
                if(value < n.getValue()){
                    value = n.getValue();
                    key = n.getKey();
                }
            }
            res[i] = key;
            map.remove(key);
        }
        return res;
    }

    public String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");
        if(arr.length == 0)return str;
        for(int i = arr.length-1 ; i >= 0 ; --i){
            sb.append(arr[i]+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        //sb.toString().trim();
        return sb.toString();
    }

    public boolean isContinuous(int [] numbers) {
        if(numbers.length <= 1)return false;
        Arrays.sort(numbers);
        for(int i = 0 ; i < numbers.length-1 ; i++){
            if(numbers[i] == 0)continue;
            if(numbers[i+1] - numbers[i] == 1) continue;
            if(numbers[i+1] - numbers[i] == 0) return false;
            int n = numbers[i+1] - numbers[i];
            for(int j = 0 ; numbers[j] <= 0 && n > 1; j++){
                if(numbers[j] > 0)return false;
                if(numbers[j] == 0){
                    numbers[j] = -1;
                    n--;
                }
            }
            if(n > 1)return false;
        }
        return true;
    }

    public int LastRemaining_Solution(int n, int m) {
        int[] arr = new int[n];
        int i = -1, temp = m;
        while(n > 0){
            i++;
            if(i == arr.length)i = 0;
            if(arr[i] == 1)continue;
            temp--;
            if(temp == 0){
                temp = m;
                n--;
                arr[i] = 1;
            }
        }
        return i;
    }










}
