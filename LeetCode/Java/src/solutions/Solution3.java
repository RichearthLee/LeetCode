package solutions;


import utility.TreeLinkNode;
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

    public int StrToInt(String str) {
        int len = str.length();
        if(!(str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) >= '0' && str.charAt(0) <= '9')){
            return 0;
        }
        for(int i = 1 ; i < len ; i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                return 0;
            }
        }
        return Integer.valueOf(str);
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : numbers){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }else {
                map.put(n, 1);
            }
        }
//        int n = 0;
//        for(Map.Entry<Integer, Integer> ent : map.entrySet()){
//            if(ent.getValue() > 1){
//                duplication[n] = ent.getKey();
//                n++;
//                f = true;
//            }
//        }
        for(int n : numbers){
            if(map.get(n) > 1){
                duplication[0] = n;
                return true;
            }
        }
        return false;
    }


    public boolean duplicate_v1(int numbers[],int length,int [] duplication) {
        if(length <= 0)return false;
        int[] map = new int[length];
        for(int n : numbers){
             map[n]++;
        }
        for(int n : numbers){
            if(map[n] > 1){
                duplication[0] = n;
                return true;
            }
        }
        return false;
    }



    public void test(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (sc.hasNextInt()) {
            num = sc.nextInt();
        }
        String[] str = new String[num+1];
        for(int i = 0 ;i < num ; i++){
            str[i] = sc.nextLine();
        }
        if(num == 0){
            System.out.println(0);
        }
        if(num == 1){
            System.out.println(str[0]);
        }
        Arrays.sort(str);
        int len = 0;
        for(int i = 0 ; i < num ; i++){
            int length = str[i].length();
            String temp = str[i];
            for(int j = i+1 ; j < num ;j++){
                if(temp.charAt(temp.length()-1) <= str[j].charAt(0)){
                    len += + str[j].length();
                    temp = str[j];
                }
                len = Math.max(len, length);
            }
        }
        System.out.println(len);

    }

    private void testrecursion(String[] str, int index, int pre, int len){
        if(index >= str.length){
            return;
        }
        for(int i = index ; i < str.length ; i++){
            if(str[index].charAt(0) >= str[pre].charAt(str[pre].length()-1)){
                len += str[index].length();
                testrecursion(str, i+1, i,1);
                len -= str[index].length();
            }
        }
    }

    public int[] multiply(int[] A) {
        int[] b = new int[A.length];
        Arrays.fill(b,1);
        for(int i= 0 ; i < b.length ; i++){
            for(int j = 0 ; j < b.length ; j ++){
                if(j != i){
                    b[i] *= A[j];
                }
            }
        }
        return b;
    }

    public int[] multiply_v1(int[] A) {
        int[] B = new int[A.length];
        if(A.length == 0)return B;
        B[0] = 1;
        for(int i = 1, len = A.length ; i < len ; ++i){
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        for(int i = A.length - 2; i >= 0 ; --i){
            temp = temp * A[i+1];
            B[i] *= temp;
        }
        return B;
    }

    /**
     * 正则表达式匹配
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
            if(str.length == 0 && pattern.length == 0)return true;
            if(str.length != 0 && pattern.length == 0)return false;
        return match_recursion(str, pattern, 0 ,0);
    }
    private boolean match_recursion(char[] str, char[] pattern, int i, int j){
        if(i >= str.length && j >= pattern.length) return true;
        if(i < str.length && j >= pattern.length) return false;
        if(j < pattern.length-1 && pattern[j+1] == '*'){
            if(i > str.length || ((i < str.length && pattern[j] != str[i]) && pattern[j] != '.')){
                return match_recursion(str, pattern, i, j+2);
            }else {
                return match_recursion(str, pattern, i, j+2) || match_recursion(str, pattern, i+1, j);
            }
//            if((i < str.length && pattern[j] == '.') || (i < str.length && pattern[j] == str[i])){
//                return match_recursion(str, pattern, i, j+2) || match_recursion(str, pattern, i+1, j);
//            }else {
//                return match_recursion(str, pattern, i, j+2);
//            }
        }else {
            if((i < str.length && pattern[j] == '.') || (i < str.length && pattern[j] == str[i])){
                return match_recursion(str, pattern,i+1,j+1);
            }else {
                return false;
            }
        }
    }

    /**
     * 表示数值的字符串
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        int nume = 0, numd = 0;
        for(int i = 0; i < str.length ; i++){
            if(str[i] < '0' || str[i] > '9'){
                if((str[i] == '-' || str[i] == '+') && (i == 0 || str[i-1]== 'e' || str[i-1] == 'E')){
                    continue;
                }
                if((str[i] == 'e' || str[i] == 'E') && nume == 0 && i != str.length-1){
                    nume++;
                    continue;
                }
                if(str[i] == '.' && nume == 0 && i != 0 && i != str.length-1 && numd==0 ||
                        (str[i] == '.' && numd == 0&& (i < str.length-2 && (str[i+1] != 'E' || str[i+1] != 'e')))){
                    numd++;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    HashMap<Character, Integer> s3_map = new HashMap<>(32);
    LinkedList<Character>  s3_arr = new LinkedList<>();
    public void Insert(char ch) {
        if(s3_map.containsKey(ch)){
            s3_map.put(ch, s3_map.get(ch)+1);
        }else {
            s3_map.put(ch, 1);
        }
        s3_arr.offer(ch);
    }
    public char FirstAppearingOnce() {
//        for(Character ch : s3_arr){
//            if(s3_map.get(ch) == 1){
//                return ch;
//            }
//        }
        while(!s3_arr.isEmpty() && s3_map.get(s3_arr.get(0)) >1)s3_arr.poll();
        if(s3_arr.isEmpty())return '#';
        return s3_arr.get(0);
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        while(pHead != null){
            if(set.contains(pHead)){
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy;
        boolean f = false;
        while(pHead != null){
            while(pHead.next != null && pHead.next.val == pHead.val){
                pHead = pHead.next;
                f = true;
            }
            if(f){
                pre.next = pHead.next;
            }
            pre = pre.next;
            pHead = pHead.next;
            f = false;
        }
        return dummy.next;
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else {
            if(pNode.next == null){
                return null;
            } else if (pNode.next.left == pNode){
                return pNode.next;
            }else if(pNode.next.right == pNode){
                while(pNode.next != null && pNode.next.left != pNode){
                    pNode = pNode.next;
                }
                return pNode.next;
            }
        }
        return null;
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null)return true;
        return isSymmetrical_mirror(pRoot.left,pRoot.right);
    }
    private boolean isSymmetrical_mirror(TreeNode left, TreeNode right){
        if(left == null && right == null)return true;
        if(left == null || right ==null)return false;
        if(left.val == right.val)return isSymmetrical_mirror(left.left, right.right) &&
                isSymmetrical_mirror(left.right, right.left);
        return false;
    }

    public ArrayList<ArrayList<Integer>> PrintZ(TreeNode pRoot) {
        Queue<TreeNode> qe = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if (pRoot == null)return res;
        qe.offer(pRoot);
        int len = 1;
        int nextlen = 0;
        boolean f = false;
        while(!qe.isEmpty()){
            TreeNode temp = qe.poll();
            len--;
            if(temp.left != null){
                qe.offer(temp.left);nextlen++;
            }
            if(temp.right != null){
                qe.offer(temp.right);nextlen++;
            }
            if(f){
                arr.add(0,temp.val);
            }else {
                arr.add(temp.val);
            }
            if(len == 0){
                f = !f;
                len = nextlen;
                nextlen = 0;
                res.add(new ArrayList<>(arr));
                arr.clear();
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> PrintZ_v1(TreeNode pRoot) {
        Queue<TreeNode> qe = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)return res;
        qe.offer(pRoot);
        int len = 1;
        int nextlen = 0;
        boolean f = false;
        while(!qe.isEmpty()){
            ArrayList<Integer> arr = new ArrayList<>();
            for(; len > 0 ; len--){
                TreeNode temp = qe.poll();
                if(temp.left != null){
                    qe.offer(temp.left);nextlen++;
                }
                if(temp.right != null){
                    qe.offer(temp.right);nextlen++;
                }
                if(f){
                    arr.add(0,temp.val);
                }else {
                    arr.add(temp.val);
                }
            }
            f = !f;
            len = nextlen;
            nextlen = 0;
            res.add(arr);
        }
        return res;
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        if(pRoot == null) return res;
        qu.offer(pRoot);
        int len = 1, nextlen = 0;
        while (!qu.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(;len > 0 ; len--){
                TreeNode node = qu.poll();
                temp.add(node.val);
                if(node.left != null) {
                    qu.offer(node.left);nextlen++;
                }
                if(node.right != null){
                    qu.offer(node.right);nextlen++;
                }
            }
            len = nextlen;
            nextlen = 0;
            res.add(temp);
        }
        return res;
    }


    //private StringBuilder s3_sb;

    public String Serialize(TreeNode root) {
        //StringBuilder s3_sb = new StringBuilder();
        return Serialize_recursion(root, new StringBuilder()).toString();
    }
    private StringBuilder Serialize_recursion(TreeNode root, StringBuilder sb){
        if(root != null){
            sb.append(root.val); sb.append(',');
        }else {
            sb.append("#,"); return sb;
        }
        Serialize_recursion(root.left, sb);
        Serialize_recursion(root.right, sb);
        return sb;
    }

    public TreeNode Deserialize(String str) {
        return Deserialize_recursion(str, new int[1]);
    }
    private TreeNode Deserialize_recursion(String str, int[] index){
        if(str.charAt(index[0]) == '#'){
            index[0]+=2; return null;
        }
        int i = index[0];
        for(; str.charAt(i) != ',' ; ++i);
        TreeNode node = new TreeNode(Integer.valueOf(str.substring(index[0], i)));
        index[0]=i+1;
        node.left = Deserialize_recursion(str, index);
        node.right = Deserialize_recursion(str, index);
        return node;
    }

    public TreeNode KthNode(TreeNode pRoot, int k) {
//        LinkedList<TreeNode> res = new LinkedList<>();
//        KthNode_recursion(pRoot, k, res);
//        return res.size() == k ? res.peekLast() : null;
        if(k == 0)return null;
        int[] num = new int[1];
        num[0] = k;
        return KthNode_helper(pRoot, num);
    }

    private void KthNode_recursion(TreeNode pRoot, int k, LinkedList<TreeNode> res){
        if(pRoot == null)return;
        KthNode_recursion(pRoot.left, k, res);
        if(res.size() >= k){
            return;
        }else {
            res.offer(pRoot);
        }
        KthNode_recursion(pRoot.right , k , res);
    }

    private TreeNode KthNode_helper(TreeNode pRoot, int[] k){
        if(pRoot == null)return null;
        TreeNode node = KthNode_helper(pRoot.left, k);
        if(node != null)return node;
        k[0]--;
        if(k[0] == 0){
            return pRoot;
        }
        return KthNode_helper(pRoot.right , k);
    }

    private ArrayList<Integer> median = new ArrayList<>();
    public void Insert_v1(Integer num) {
        int left = 0, right = median.size()-1;
        while(left < right){
            int mid = (left + right)/2;
            if(median.get(mid) < num){
                left = mid+1;
            }else if(median.get(mid) > num){
                right = mid-1;
            }
        }
        median.add(left, num);
    }

    public Double GetMedian_v1() {
        int len = median.size();
        if(len % 2 ==1){
            return (double)median.get(len/2);
        }else {
            return (median.get(len/2-1) + median.get(len/2))/2.0;
        }
    }

    private PriorityQueue<Integer> asc = new PriorityQueue<>();
    private PriorityQueue<Integer> desc = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public void Insert(Integer num) {
        int len = asc.size() + desc.size();
        if(len % 2 == 1){
            if(num >= desc.peek()){
                asc.offer(num);
            }else {
                asc.offer(desc.poll());
                desc.offer(num);
            }

        }else {
            if(asc.isEmpty() || num <= asc.peek()){
                desc.offer(num);
            }else {
                desc.offer(asc.poll());
                asc.offer(num);
            }

        }
    }

    public Double GetMedian() {
        int len = asc.size() + desc.size();
        if(len == 0)return 0.0;
        if(len % 2 ==1){
            return (double)desc.peek();
        }else {
            return (desc.peek() + asc.peek())/2.0;
        }
    }



    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0)return res;
        for(int pre = 0,  post = size -1, len = num.length; post < len ; post++, pre++){
            int max = num[pre];
            for(int i = pre; i<= post ; i++){
                max = Math.max(max, num[i]);
            }
            res.add(max);
        }
        return res;
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(hasPath_recursion(matrix, rows, cols, i, j, str, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath_recursion(char[] matrix, int rows, int cols,int i, int j, char[] str, int index){
        int len = i*cols + j;
        if(j < 0 || j > cols -1 || i < 0|| i > rows -1 || str[index] != matrix[len]) return false;
        if(index == str.length - 1)return true;
        char c = matrix[len];
        matrix[len] = '#';
        boolean f = hasPath_recursion(matrix, rows, cols, i, j-1, str, index+1);
        f |= hasPath_recursion(matrix, rows, cols, i, j+1, str, index+1);
        f |= hasPath_recursion(matrix, rows, cols, i-1, j, str, index+1);
        f |= hasPath_recursion(matrix, rows, cols, i+1, j, str, index+1);
        matrix[len] = c;
        return f;
    }


    public int cutRope(int target) {
        int cur = 1, pre = 1;
        for(int i = 2; i <= target && cur >= pre; i++){
            pre = cur;
            cur = 1;
            int tmp = target/i;
            int rmd = target%i;
            cur = (int)(Math.pow(tmp,i-rmd)*Math.pow(tmp+1,rmd));
        }
        return pre;
    }

    public int movingCount(int threshold, int rows, int cols) {
        return movingCount_recrusion(threshold, rows, cols, 0, 0, new boolean[rows][cols]);
    }
    private int movingCount_recrusion(int threshold, int rows, int cols, int i, int j, boolean[][] f){
        if(i < 0 || i>= rows || j < 0 || j>= cols || f[i][j] )return 0;
        int count = 0;
        for(int num = i; num != 0 ;){
            count += num % 10;
            num /= 10;
        }
        for(int num = j; num != 0 ;){
            count += num % 10;
            num /= 10;
        }
        if(count > threshold) return 0;
        f[i][j] = true;
        return movingCount_recrusion(threshold, rows, cols, i, j-1, f)
        + movingCount_recrusion(threshold, rows, cols, i, j+1, f)
        + movingCount_recrusion(threshold, rows, cols, i-1, j, f)
        + movingCount_recrusion(threshold, rows, cols, i+1, j, f) + 1;
    }

    public int movingCount_v1(int threshold, int rows, int cols) {
        boolean[][] matrix = new boolean[rows][cols];
        if(threshold < 0)return 0;
        int res = 1; matrix[0][0] = true;
        for(int i = 0; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(!matrix[i][j] && movingCount_helper(i, j ,threshold) &&
                        (i>0 && matrix[i-1][j] ||
                        j> 0 && matrix[i][j-1] ||
                        i< rows-1 && matrix[i+1][j] ||
                        j< cols-1 &&matrix[i][j+1])){
                        res++;
                        matrix[i][j] = true;
                }
            }
        }
        return res;
    }

    private boolean movingCount_helper(int i, int j, int threshold){
        int count = 0;
        for(int num = i; num != 0 ;){
            count += num % 10;
            num /= 10;
        }
        for(int num = j; num != 0 ;){
            count += num % 10;
            num /= 10;
        }
        return count <= threshold;
    }

    private void print(boolean[][] matrix){
        for (boolean[] booleans : matrix) {
            for (boolean n : booleans) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    ArrayList<Integer> reverse = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null)return reverse;
        printListFromTailToHead(listNode.next);
        reverse.add(listNode.val);
        return reverse;
    }

    public ArrayList<Integer> printListFromTailToHead_v1(ListNode listNode) {
        ArrayList<Integer> reverse = new ArrayList<>();
        while(listNode != null){
            reverse.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(reverse);
        return reverse;
    }

    /**
     *
     * @param triangle
     * @return
     */
    public int minimumTotal_v1(List<List<Integer>> triangle) {
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        return minimumTotal_recursion(triangle, 0, 0,new int[1], res);
    }
    private int minimumTotal_recursion(List<List<Integer>> triangle, int col, int row, int[] tmp, int[] res){
        if(row == triangle.size() || col == triangle.get(row).size()){
            if(row == triangle.size()){
                res[0] = Math.min(res[0], tmp[0]);
            }
            return res[0];
        }
        tmp[0] += triangle.get(row).get(col);
        minimumTotal_recursion(triangle, col, row+1,tmp,res);
        minimumTotal_recursion(triangle, col+1, row+1,tmp,res);
        tmp[0] -= triangle.get(row).get(col);
        return res[0];
    }

    public int minimumTotal_v2(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle.get(0).size() == 0)return 0;
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1, row = triangle.size(); i < row ; i++){
            for(int j = 0; j <= i ; j++){
                int num = triangle.get(i).get(j);
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + num;
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + num;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + num, dp[i-1][j] + num);
                }
            }
        }
        int res = dp[dp.length-1][0];
        for(int n : dp[dp.length-1]){
            res = Math.min(res, n);
        }
        return res;
    }

    public int minimumTotal_v3(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle.get(0).size() == 0)return 0;
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1, row = triangle.size(); i < row ; i++){
            int prev = 0;
            for(int j = 0; j <= i ; j++){
                int num = triangle.get(i).get(j), cur;
                if(j == 0){
                    prev = dp[j];
                    dp[j] = dp[j] + num;
                }else if(j == i){
                    dp[j] = prev + num;
                }else {
                    cur = prev;
                    prev = dp[j];
                    dp[j] = Math.min(cur + num, dp[j] + num);
                }
            }
        }
        for(int n : dp){
            dp[0] = Math.min(dp[0], n);
        }
        return dp[0];
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        for(int i = triangle.size()-1 ; i >= 0 ; i--){
            for(int j = 0, col = triangle.get(i).size(); j < col ; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * 121. Best Time to Buy and Sell Stock
     * @param prices
     * @return
     */
    public int maxProfit_v1(int[] prices) {  //记录最大值和最小值的下标
        int min = 0,max = 0, res=0;
        for(int i = 1; i <prices.length ; i++){
            if(prices[i] > prices[max]){
                max = i;
                res = Math.max(res, prices[i] - prices[min]);
            }else if(prices[i] < prices[min]){
                min = i;
                max = i;
            }
        }
        return res;
    }

    public int maxProfit_V2(int[] prices) { //记录局部最大和全局最大
        int max = 0, res = 0;
        for(int i = 1; i < prices.length ; i++){
            max = Math.max(0, max += prices[i] - prices[i-1]);
            res = Math.max(max, res);
        }
        return res;
    }

    public int maxProfit_v3(int[] prices) {
        int max = 0, min = 0;
        for(int i = 0; i < prices.length ; i++){  //记录最小值和当前值做差
            min = prices[i] < prices[min] ? i : min;
            max = Math.max(max, prices[i] - prices[min]);
        }
        return max;
    }

    /**
     * 122. Best Time to Buy and Sell Stock II
     * @param prices a array
     * @return the max value
     */
    public int maxProfit_v4(int[] prices) {
        int res = 0, index =0;
        for(int i = 0 ; i < prices.length ; i++){
            while(i<prices.length-1 && prices[i] >= prices[index] && prices[i] < prices[i+1]){
                i++;
            }
            res += prices[i] - prices[index];
            index = i;
        }
        return res;
    }

    public int maxProfit_v5(int[] prices) {
        int res = 0, index =0;
        for(int i = 1 ; i < prices.length ; i++){
            while(i < prices.length &&prices[i] >= prices[i-1]){
                i++;
            }
            res += prices[i-1] - prices[index];
            index = i;
        }
        return res;
    }

    /**
     * 123. Best Time to Buy and Sell Stock III
     * @param prices a array
     * @return the max value
     */
    public int maxProfit_v6(int[] prices) {    //分开两段求最大值
        int res = 0;
        for(int i = 1 ; i < prices.length ; i++){
            int pre=0, post=0, maxPre = 0, maxPost = 0;
            for(int j = 1 ; j <= i ; j++){
                pre = Math.max(0, pre += prices[j] - prices[j-1]);
                maxPre = Math.max(maxPre, pre);
            }
            for(int j = i+2 ; j < prices.length ; j++){
                post = Math.max(0,post += prices[j] - prices[j-1]);
                maxPost = Math.max(post, maxPost);
            }
            res = Math.max(res, maxPost + maxPre);
        }
        return res;
    }

    public int maxProfit_v7(int[] prices) {  //不对
        int index =0; int[] res = new int[2];
        for(int i = 1 ; i < prices.length ; i++){
            while(i < prices.length &&prices[i] >= prices[i-1]){
                i++;
            }
            int num = prices[i-1] - prices[index];
            if(num > res[0]){
                res[1] = res[0];
                res[0] = num;
            }else if(num > res[1]){
                res[1] = num;
            }
            index = i;
        }
        return res[0]+res[1];
    }

    public int maxProfit_v8(int[] prices) {   //利用DP模拟两次交易
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    public int maxProfit(int[] prices) {   //利用DP
        if(prices.length == 0)return 0;
        int[][] dp = new int[3][prices.length];
        for(int k = 1 ; k <= 2 ; k++){
            int min = prices[0];
            for(int i = 1 ; i < prices.length ; i++){
                min = Math.min(min, prices[i] - dp[k-1][i-1]);
                dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
            }
        }
        return dp[2][prices.length-1];
    }

    /**
     * 215. Kth Largest Element in an Array
     * @param nums array
     * @param k kth
     * @return kth
     */
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest_helper(nums, k, 0, nums.length-1);
    }
    private int findKthLargest_helper(int[] nums, int k, int start, int end){
        if(start >= end) return nums[start];
        int left = start, right = end, key = nums[left];
        while(left < right){
            while(left < right && key > nums[right]){
                right--;
            }
            while (left < right && key < nums[left]){
                left++;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        nums[start] = nums[left];
        nums[left] = key;

        if(left+1 > k){
            return findKthLargest_helper(nums, k, start, left-1);
        }else if(left+1 < k){
            return findKthLargest_helper(nums, k, left + 1, end);
        }else {
            return nums[left];
        }
    }

    /**
     * 454. 4Sum II
     * @param A a
     * @param B b
     * @param C c
     * @param D d
     * @return n
     */
    public int fourSumCount_v1(int[] A, int[] B, int[] C, int[] D) {
//        Set<ArrayList<Integer>> res = new HashSet<>();
//        ArrayList<Integer> tmp;
        int res=0;
        //Arrays.sort(A);
        //Arrays.sort(B);
        //Arrays.sort(C);
        //Arrays.sort(D);
        for(int a = 0 ; a < A.length ; a++){
            //if(a > 0 && A[a] == A[a-1])continue;
            for(int b = 0 ; b < B.length ; b++){
                //if(b > 0 && B[b] == B[b-1])continue;
                for(int c = 0 ; c < C.length; c++){
                    //if(c > 0 && C[c] == C[c-1])continue;
                    for(int d = 0 ; d < D.length ;d++){
                        //if(d > 0 && D[d] == D[d-1])continue;
                        if(A[a] + B[b] + C[c] + D[d] == 0){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            for(int b : B){
                //int num = a + b;
                map.put(a + b, map.getOrDefault(a+b, 0)+1);
            }
        }
        int res=0;
        for(int c : C){
            for(int d : D){
                res += map.getOrDefault(-c-d,0);
            }
        }
        return res;
    }

    /**
     * 8. 字符串转换整数 (atoi)
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if(str.length() == 0)return 0;
        long res = 0, sign = 1;
        for(int i =0, len = str.length(); i < len ; ++i){
            if(str.charAt(i) == ' ' && (i == 0 || str.charAt(i-1) == ' ')){
                continue;
            }
            if(str.charAt(i) == '-' && (i == 0 || str.charAt(i-1) == ' ')){
                sign = -1;continue;
            }else if(str.charAt(i) == '+' && (i == 0 || str.charAt(i-1) == ' ')){
                continue;
            }
            if(str.charAt(i) >'9' || str.charAt(i) < '0'){
                break;
            }
            res = (res*10 + (str.charAt(i) - '0'));
            if(sign*res > Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(sign*res < Integer.MIN_VALUE)return Integer.MIN_VALUE;
        }
        return (int)(sign*res);
    }


    public ListNode addTwoNumbers_v1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy; int f = 0;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                cur.next = new ListNode((l1.val + l2.val  + f)%10);
                f = (l1.val + l2.val + f)/10;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
                cur.next = new ListNode((l1.val + f)%10);
                f = (l1.val + f)/10;
                l1 = l1.next;
            }else {
                cur.next = new ListNode((l2.val + f)%10);
                f = (l2.val + f)/10;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(f != 0){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy; int f = 0; cur.next = l1;
        while(l1 != null && l2 != null){
            int tmp = l1.val + l2.val + f;
            cur.next.val = tmp%10;
            f = tmp/10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while(l1 != null){
            int tmp = l1.val + f;
            cur.next.val = tmp %10;
            f = tmp/10;
            l1 = l1.next;
            cur = cur.next;
        }
        if(l2 != null){
            cur.next = l2;
        }
        while(l2 != null){
            int tmp = l2.val + f;
            cur.next.val = tmp %10;
            f = tmp/10;
            l2 = l2.next;
            cur = cur.next;
        }
        if(f != 0){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public boolean isPalindrome(String s) {
        for(int left = 0 , right = s.length()-1 ; left < right ;left++, right--){
            while(left < right && !valid(s.charAt(left))){
                left++;
            }
            while(left < right && !valid(s.charAt(right))){
                right--;
            }
            char a = s.charAt(left), b =  s.charAt(right);
            if(!(a-b == 0 || (a > 64 && b > 64 && Math.abs(a-b) == 32))){
                return false;
            }
        }
        return true;
    }
    private boolean valid(char c){
        return (c <='9' && c>='0' || c <= 'Z' && c >= 'A' || c <= 'z' && c >='a');
    }


    public boolean hasCycle_v1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head))return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)return true;
        }
        return false;
    }

    public int majorityElement(int[] nums) {
//        int count = 0, num = nums[0]-1;
//        for(int n : nums){
//            if(n == num){
//                count++;
//            }else {
//                count--;
//                if(count < 0){
//                    num = n;count=1;
//                }
//            }
//        }
//        return num;
        int num =nums[0];
        for(int count = 1, i = 1; i < nums.length ; i++){
            if(nums[i] == num){
                count++;
            }else {
                count--;
                if(count < 0){
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return num;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

    public boolean isPowerOfTwo_v1(int n) {
        if(n != 1 && (n & 1) == 1) return false;
        for(int num = 1; num <= n ;){
            if(num == n)return true;
            n *= 2;
        }
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        if(n<0)return false;
        while((n & 1) != 1) n >>= 1; n >>= 1;
        for(int i = 0 ;i < 31 ; i++, n >>= 1){
            if((n & 1) == 1)return false;
        }
        return true;
    }

    public TreeNode lowestCommonAncestor_v1(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(q.val > root.val && p.val > root.val){
                root = root.right;
            }else if(q.val < root.val && p.val < root.val){
                root = root.left;
            }else {
                return root;
            }
        }
        return null;
    }

    public void deleteNode(ListNode node) {
        while(node.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.next = null;
    }

    /**
     *  二叉搜索树中第K小的元素
     * @param root a
     * @param k k
     * @return a
     */
    public int kthSmallest_v1(TreeNode root, int k) {
        return kthSmallest_recursion(root, k, new int[1]);
    }

    private int kthSmallest_recursion(TreeNode root, int k, int[] res) {
        if(root == null)return 0;
        int val = kthSmallest_recursion(root.left, k, res);
        if(res[0] == k) return val;
        else if(++res[0] == k) return root.val;
        return kthSmallest_recursion(root.right, k, res);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null)return 0;
        Stack<TreeNode> st  = new Stack<>();
        int count = 0;
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(++count == k)return root.val;
            root = root.right;
        }
        return 0;
    }

    public TreeNode lowestCommonAncestor_v2(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestor_recursion(root, p, q, new int[1]);
    }

    private TreeNode lowestCommonAncestor_recursion(TreeNode root, TreeNode p, TreeNode q ,int[] n){
        if(root == null)return null;
        TreeNode left = lowestCommonAncestor_recursion(root.left,p ,q, n);
        if(n[0] == 2){
            return left;
        }
        TreeNode right = lowestCommonAncestor_recursion(root.right, p ,q, n);
        if(n[0] == 2){
            return right;
        }
        if(root.val == q.val || root.val == p.val){
            if(left != null || right != null){
                n[0] = 2;
                return root;
            }
            n[0] = 1;
            return root;
        }
        if(left != null && right != null){
            n[0] = 2;
            return root;
        }
        if(left != null){
            return left;
        }
        return right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null)return right;
        if(right == null)return left;
        return root;
    }


    public int[] productExceptSelf(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 0 ; i < nums.length ; i++){
            dp[i] = nums[i-1] * dp[i-1];
        }
        int tmp = 1;
        for(int i = nums.length-1 ; i >= 0 ;i--){
            dp[i] = tmp * dp[i];
            tmp *= nums[i];
        }
        return dp;
    }

    public String reverseWords_v1(String s) {
        StringBuilder sb = new StringBuilder();
        s += ' ';
        for(int i = 0, pre = 0, len = s.length(); i < len ;i++){
            if(s.charAt(i) == ' ' || i == len-1){
                sb.append(new StringBuilder(s.substring(pre, i+1)).reverse());
                pre = i+1;
            }
        }
        return sb.toString().trim();
    }

    public String reverseWords_v2(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for(String str : arr){
            sb.append(new StringBuilder(str).reverse());
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0, len = s.length(); i < len ;i++){
            StringBuilder tmp = new StringBuilder();
            while(s.charAt(i) != ' '){
                tmp.append(s.charAt(i));
                i++;
            }
            sb.append(tmp.reverse());
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public int maxProduct(int[] nums) {
        long res = nums[0];
        long temp = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            temp = Math.max(nums[i], temp * nums[i]);
            res = Math.max(res, temp);
        }
        return (int) res;
    }

    public int maxProduct_v1(int[] nums) {
        int res = nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < nums.length - i ; j++){
                int tmp = nums[j];
                for(int k = 0; k < i; k++){
                    tmp *= nums[j+k+1];
                }
                res = Math.max(res, tmp);
            }
        }
        return res;
    }

    public int maxProduct_v2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] >= 0) dp[i] = Math.max(dp[i-1] * nums[i], nums[i]);
            if(nums[i] < 0){
                for(int j = i; j > 0; j--){
                    if(dp[j] < 0){
                        dp[i] = dp[i-1] * dp[j] * nums[i];
                    }
                }
            }
        }
        return dp[nums.length-1];
    }

    public int maxProduct_v3(int[] nums) {
        int res = nums[0], tmp = nums[0], neg = 0;
        if(tmp < 0) {
            neg = tmp;
        }
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] < 0){
                if(neg == 0){
                    neg = nums[i] * tmp;
                }else {
                    tmp = nums[i-1] < 0 ? neg : tmp * neg;
                    neg = 0;
                }
            }else {
                if(nums[i] == 0)neg = 0;
            }
            tmp = Math.max(nums[i], nums[i] * tmp);
            res = Math.max(tmp, res);
        }
        return res;
    }

    public int maxProduct_v4(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public void sequenceSwap(){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int arr[] = new int[len];
        for(int i = 0 ; sc.hasNext() ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ;j < arr.length ; j++){
                for(int k = j ; k < arr.length ; k++){
                    if((arr[j] + arr[k])%2 == 1 && validate(arr[j], arr[k])){
                        int tmp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = tmp;
                    }
                }
            }
        }
        for(int n : arr){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private boolean validate(int n, int m){
        ArrayList<Integer> narr = new ArrayList<>();
        ArrayList<Integer> marr = new ArrayList<>();
        while(n != 0){
            narr.add(n%10);
            n = n /10;
        }
        while(m != 0){
            marr.add(m%10);
            m = m /10;
        }
        for(int i = narr.size()-1 , j = marr.size()-1; i > 0 && j >0; i--, j--) {
            if(narr.get(i).equals(marr.get(j)))continue;
            return narr.get(i) > marr.get(j);
        }
        return false;
    }


    public void score(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Integer arr[] = new Integer[num];
        for(int i = 0 ; sc.hasNext()&& i < num ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        double [] p = new double[num];
        for(int i = num-2, count = num-1 ; i >= 0 ; i--){
            if(!arr[i].equals(arr[i+1])) count = i+1;
            p[i] = (double) (num - count)/num;
        }

        int out = sc.nextInt();
        for(int n = out; n >=0 && sc.hasNext() ; n--){
            System.out.println(String.format("%.6f",p[sc.nextInt()-1]*100));
        }
    }

    public void sequence(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(),  count = sc.nextInt();
        int arr[] = new int[num];
        for(int i = 0 ; sc.hasNext()&& i < num ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int n = count; n >=0 && sc.hasNext() ; n--){
            int c = 0;
            for(int i = num-1 ; i >= 0 ; i--){
                if(arr[i] < n){
                    System.out.println(c);
                }
                c++;
                arr[i]--;
            }
            for(int i = 0 ; i < num-1; i++){
                if(arr[i] > arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
    }

    public int num(int[] arr){
        if(arr.length <=1 )return -1;
        int[] res = new int[arr.length-1];
        for(int i = 0 ; i < arr.length-1 ; i++){
            res[i] = arr[i+1] - arr[i];
        }
        int n = 1;
        boolean f = true;
        while(f){
            for(int m : res){
                if(m == 0) {
                    f = false;
                    return -1;
                }
                if(m % n != 0){
                    return n;
                }
            }
            n++;
        }
        return -1;
    }

    public static void attack(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt(), def = in.nextInt();
        int[] arr = new int[num];
        int[] dmg = new int[num];
        for(int i = 0 ; i < num && in.hasNext();i++){
            arr[i] = in.nextInt();
        }
        for(int i = 0 ; i < num && in.hasNext();i++){
            dmg[i] = in.nextInt();
        }
        int[] darr = arr.clone();
        Arrays.sort(darr);
        int res = 0;
        for(int m : darr){
            if(m > def){
                for(int i = 0 ; i < num ; i++){
                    if(m == arr[i]){
                        arr[i] = -1;
                        res += dmg[i];
                        break;
                    }
                }
            }else {
                def++;
            }
        }
        System.out.println(res);
    }

    public void aff(){
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int pep = in.nextInt(), num = in.nextInt();
        set.add(in.nextInt());
        for(int i = 0 ; i < num;i++){
            int count = in.nextInt();
            int[] arr = new int[count];
            for(int j = 0 ; j < count ; j++){
                arr[j] = in.nextInt();
            }
            for(int n : arr){
                if(set.contains(n)){
                    for(int m : arr){
                        set.add(m);
                    }
                    break;
                }
            }
        }
        System.out.println(set.size());
    }

    public void matrix(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] mt = new int[n][m];
        if(n == 0 || m == 0)return;
        for(int i = 0 ; i < n  && in.hasNext(); i++){
            int num = in.nextInt();
            for(int j = m-1 ; j >= 0 ; j--){
                mt[i][j] = num%10;
                num /= 10;
            }
        }
        int[][] res = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mt[i][j] == 1){
                    res[i][j] = matrix_helper(mt,i,j);
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(j == m-1){
                    System.out.print(res[i][j]);
                }else {
                    System.out.print(res[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public int matrix_helper(int[][] matrix, int i , int j){
        if(i< 0 || i >= matrix.length || j <0 || j >= matrix[0].length||matrix[i][j]==0){
            return 0;
        }
        int len = Integer.MAX_VALUE;
        len = Math.min(len , matrix_helper(matrix, i+1, j));
        len = Math.min(len , matrix_helper(matrix, i-1, j));
        len = Math.min(len , matrix_helper(matrix, i, j+1));
        len = Math.min(len , matrix_helper(matrix, i+1, j-1));
        return len +1;
    }


    /**
     * 198. 打家劫舍
     * @param nums a
     * @return a
     */
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;dp[1] = nums[0];
        for(int i = 2 ; i < dp.length ; i++){
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }
        return dp[nums.length];
    }

    public int rob_v1(int[] nums) {
        if(nums.length == 0)return 0;
        int prepre = 0, pre = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            int tmp = pre;
            pre = Math.max(prepre + nums[i], pre);
            prepre = tmp;
        }
        return pre;
    }

    public int rob_v2(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        return Math.max(rob_v1(Arrays.copyOfRange(nums,0,nums.length-1)),
                rob_v1(Arrays.copyOfRange(nums,1,nums.length)));
    }
















































}
