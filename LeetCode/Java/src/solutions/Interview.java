package solutions;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Interview {
    /**
     * alibaba
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * @param str
     * @return
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
     * @param nums
     * @param start
     * @param end
     * @return
     */
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


    public int[] quickSort(int[] nums, int start, int end){
        //if(nums == null || nums.length <= 0) return nums;
        if(start >= end) return nums;
        int key = nums[start], left = start, right = end;
        while(left < right){
            while(key <= nums[right] && left < right){
                right--;
            }
            while(key >= nums[left] && left < right){
                left++;
            }
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


    /**
     * Preorder, Inorder, Postorder 二叉树非递归
     * @param root
     * @return
     */
    public TreeNode Inorder_Preorder(TreeNode root) {
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
     * @param root
     * @return
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
     * @param matrix
     * @return
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




}
