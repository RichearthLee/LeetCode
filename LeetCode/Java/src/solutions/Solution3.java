package solutions;


import utility.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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



}
