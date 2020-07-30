package solutions;

import utility.ListNode;
import utility.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Important {
    /**
     * alibaba
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     */
    public boolean isValid(String str) {
        if(str == "" || str == null)return true;
        Stack<Character> st = new Stack<>();
        int len = str.length();
        for(int i = 0 ; i < len ; i++){
            char c = str.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }else if(st.isEmpty() || Math.abs(st.pop() - c) > 2){
                return false;
            }
        }
        return st.isEmpty();
    }

    /**
     * bytedance  quicksort
     */
    public int[] quickSort(int[] nums, int start, int end){
        //if(nums == null || nums.length <= 0) return nums;
        if(start >= end) return nums;
        int key = nums[start], left = start, right = end;
        while(left < right){
            while(key <= nums[right] && left < right){    //递增
                right--;
            }
            while(key >= nums[left] && left < right){
                left++;
            }
//            while(key >= nums[right] && left < right){      //递减
//                right--;
//            }
//            while(key <= nums[left] && left < right){
//                left++;
//            }
            if(left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        nums[start] = nums[left];
        nums[left] = key;
        quickSort(nums,start,left-1);
        quickSort(nums,left+1, end);
        return nums;
    }


    public int[] quickSort_v1(int[] nums, int start, int end){
        //if(nums == null || nums.length <= 0) return nums;
        if(start >= end) return nums;
        int left = start, right = end;
        boolean f = true;
        while(left < right){
            if(f){
                if(nums[left]>nums[right]){
                    int mid = nums[right];
                    nums[right] = nums[left];
                    nums[left] = mid;
                    //left++;
                    f = false;
                    continue;
                }
                right--;
            }else {
                if(nums[right]<nums[left]){
                    int mid = nums[left];
                    nums[left] = nums[right];
                    nums[right] = mid;
                    //right--;
                    f = true;
                    continue;
                }
                left++;
            }
        }
        quickSort_v1(nums,start,left - 1);
        quickSort_v1(nums,left + 1, end);
        return nums;
    }



    /**
     * Preorder, Inorder, Postorder 二叉树非递归
     */
    public TreeNode Preorde_Inorderr(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                //System.out.println(p.val);  //preorder
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            //System.out.println(p.val);  //inorder
            p = p.right;
        }
        return root;
    }

    public TreeNode Postorder(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p, pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            p = stack.peek();
            if(p.left == null && p.right == null || (pre != null && (p.right == pre || p.left == pre))){
                pre = stack.pop();
                //System.out.println(pre.val);  //postorder
            }else {
                if(p.right != null){
                    stack.push(p.right);
                }
                if(p.left != null){
                    stack.push(p.left);
                }
            }
        }
        return root;
    }

    /**
     * Preorder, Inorder, Postorder 二叉树递归
     */
    public TreeNode Preorder_Inorder_Postorder(TreeNode root) {
        if(root==null) return null;
        //System.out.println(p.val);  //preorder
        Preorder_Inorder_Postorder(root.left);
        //System.out.println(p.val);  //inorder
        Preorder_Inorder_Postorder(root.right);
        //System.out.println(pre.val);  //postorder
        return root;
    }


    /**
     * 顺时针打印矩阵
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = -1;
        while(row > 0 && col >0){
            for(int k = 0 ; k < col ; k++){
                ++j;
                res.add(matrix[i][j]);
            }
            if(--row == 0) break;
            for(int k = 0 ; k < row ; k++){
                i++;
                res.add(matrix[i][j]);
            }
            if(--col == 0) break;
            for(int k = 0 ; k < col ; k++){
                j--;
                res.add(matrix[i][j]);
            }
            --row;
            for(int k = 0 ; k < row ; k++){
                i--;
                res.add(matrix[i][j]);
            }
            --col;
        }
        return res;
    }

    /**
     * 单链表排序  并归排序
     */
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode fast = head.next, slow = head, pre= null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        fast = sortList(head);
        slow = sortList(slow);
        return mergeList(fast, slow);
    }

    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 == null){
            pre.next = l2;
        }else {
            pre.next = l1;
        }
        return dummy.next;
    }

    public ListNode sortList_v1(ListNode head){
        ListNode cur = head, dummy = new ListNode(0), prev;
        dummy.next = head;
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        for(int step = 1; step < len ; step <<= 1){
            prev = dummy;
            cur = dummy.next;
            while(cur != null){
                ListNode left = cur;
                ListNode right = split(cur, step);
                cur = split(right, step);
                prev = mergeList(left, right, prev);
            }
        }
        return dummy.next;
    }

    /**
     *链表拆分
     */
    private ListNode split(ListNode cur, int step){
        if(cur == null)return null;
        ListNode pre = cur;
        while(cur != null && step > 0){
            pre = cur;
            cur = cur.next;
            step--;
        }
        pre.next = null;
        return cur;
    }

    /**
     *链表合并
     */
    private ListNode mergeList(ListNode l1, ListNode l2, ListNode prev){
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 != null){
            prev.next = l1;
        }else {
            prev.next = l2;
        }
        while(prev.next != null)prev = prev.next;
        return prev;
    }

    /**
     *  KMP算法
     * @param haystack  被匹配字符串
     * @param needle    匹配字符串
     * @return  index
     */
    public int strStr(String haystack, String needle) {
        int j = 0;
        for (int i = 0, N = haystack.length(), M = needle.length(); i < N; i++) {
            // 当前是状态 j，遇到字符 txt[i]，
            // pat 应该转移到哪个状态？
            j = dp[j][haystack.charAt(i)];
            // 如果达到终止态，返回匹配开头的索引
            if (j == M) return i - M + 1;
        }
        // 没到达终止态，匹配失败
        return -1;
    }

    private int[][] dp;

    public void KMP(String pat) {
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 当前状态 j 从 1 开始
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c)
                    dp[j][c] = j + 1;
                else
                    dp[j][c] = dp[X][c];
            }
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
    }







}
