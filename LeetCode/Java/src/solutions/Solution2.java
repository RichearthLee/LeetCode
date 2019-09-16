package solutions;

import utility.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: LeetCode
 * @description: 51-100
 * @author: Yukun Lee
 * @create: 2019-08-19 11:20
 */

public class Solution2 {
    
    /** 
     * @description: 100. Same Tree
     * @param: [p, q] 
     * @return: boolean 
     * @author: Yukun Lee 
     * @date: 2019-08-19 
     */ 
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }else if(p != null && q != null){
            if (p.val != q.val)
            return false;
        }else {
            return false;
        }

        Queue<TreeNode> list_p = new LinkedList<>();
        Queue<TreeNode> list_q = new LinkedList<>();
        list_p.add(p);
        list_q.add(q);
        while(!list_p.isEmpty() && !list_q.isEmpty()){
            TreeNode node_p = list_p.poll();
            TreeNode node_q = list_q.poll();
            if(node_p.left != null && node_q.left != null){
                if (node_p.left.val != node_q.left.val){
                    return false;
                }
                list_p.offer(node_p.left);
                list_q.offer(node_q.left);
            }else if((node_p.left == null && node_q.left != null) || (node_q.left == null && node_p.left != null)) {
                return false;
            }

            if(node_p.right != null && node_q.right != null){
                if (node_p.right.val != node_q.right.val){
                    return false;
                }
                list_p.offer(node_p.right);
                list_q.offer(node_q.right);
            }else if((node_p.right == null && node_q.right != null)||(node_q.right == null && node_p.right != null)){
                return false;
            }

        }
        return true;
    }

    public int maxSubArray_v1(int[] nums) {
        int max = nums[0];
        for(int i = 1 ; i < nums.length ; ++i){
            if(nums[i] > 0){
                max = max + nums[i];
            }
            if(nums[i] < 0){
                if(max + nums[i]< 0){
                    continue;
                }else if(max + nums[i]> 0){

                }
            }
        }
        return 0;
    }

    public int maxSubArray_2(int[] nums){
        int maxRes = nums[0], maxMid = nums[0];
        for(int i = 1 ; i < nums.length ; ++i){
            maxMid = Math.max(maxMid + nums[i], nums[i]);
            maxRes = Math.max(maxRes, maxMid);
        }
        return maxRes;
    }

    public int maxSubArray(int[] nums){
        int[] dp = nums;
        int max = nums[0];
        for(int i = 1 ; i < nums.length ; ++i){
            dp[i] = dp[i] + dp[i-1]<0?0:dp[i-1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public List<Integer> spiralOrder_v1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int curm = 0 , curn = 0;
        int dir = 0;
        while(m != 0 && n != 0){
            res.add(matrix[curm][curn]);
            switch (dir){
                case 0:
                    if(curn + 1 < n){
                        curn = curn + 1;
                    }else {
                        curm--;
                        n--;
                        dir = 1;
                    }
                    break;
                case 1:
                    if(curm + 1 < m){
                        curm = curm + 1;
                    }else {
                        curn--;
                        m--;
                        dir = 2;
                    }
                    break;
                case 2:
                    if(curn - 1 >= matrix[0].length - n -2){
                        curn = curn - 1;
                    }else {
                        curm++;
                        n--;
                        dir = 3;
                    }
                    break;
                case 3:
                    if(curm - 1 >= matrix.length - m - 2){
                        curm = curm - 1;
                    }else {
                        curn++;
                        m--;
                        dir = 0;
                    }
                    break;
            }
        }
        return res;
    }

    public List<Integer> spiralOrder_v2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int[][] flag= new int[matrix.length][matrix[0].length];
        int curm = 0 , curn = 0;
        int dir = 0;
        while(flag[curm][curn]==0){
            res.add(matrix[curm][curn]);
            flag[curm][curn] = 1;
            switch (dir){
                case 0:
                    if(curn+1 < matrix[0].length && flag[curm][curn+1]==0){
                        curn++;
                    }else {
                        if(curm<matrix.length-1){
                            curm++;
                        }
                        dir = 1;
                    }
                    break;
                case 1:
                    if(curm+1 < matrix.length && flag[curm+1][curn]==0){
                        curm++;
                    }else {
                        if(curn>0){
                            curn--;
                        }
                        dir = 2;
                    }
                    break;
                case 2:
                    if(curn-1 >= 0 && flag[curm][curn-1]==0){
                        curn--;
                    }else {
                        if(curm>0){
                            curm--;
                        }
                        dir = 3;
                    }
                    break;
                case 3:
                    if(curm-1 >= 0 && flag[curm-1][curn]==0){
                        curm--;
                    }else {
                        if(curn<matrix[0].length-1)
                        curn++;
                        dir = 0;
                    }
                    break;
            }
        }
        return res;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0){
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <= colEnd ; ++i){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd ; ++i){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowBegin <= rowEnd){
                for(int i = colEnd; i >= colBegin; --i){
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(colBegin <= colEnd){
                for(int i = rowEnd ; i >= rowBegin; --i){
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }

    public boolean canJump_v1(int[] nums) {
        if(nums.length == 0){
            return true;
        }
        int[] path = new int[nums.length];
        path[0] = 1;
        int cur = 0;
        for(int i = 0; i < nums.length ; ++i){
            if(path[i] == 0){
                return false;
            }
            int maxStep = nums[i];
            for(int j = 1 ; j <= maxStep ; ++j){
                if(i+j >= path.length){
                    return true;
                }
                path[i+j] = 1;
            }
        }
        return true;
    }

    /**
     * 45. Jump Game
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0 ; i < nums.length && max < nums.length; ++i){
            if(i > max){
                return false;
            }
            max = Math.max(i + nums[i], max);
        }
        return true;
    }

    /**
     * 45. Jump Game II
     * @param nums
     * @return
     */
    public int jump_v1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] res = new int[nums.length];
        res[0] = 0;
        int cur = 0;
        for(int i = 0; i < nums.length ; ++i) {
            for (int j = 1; j <= nums[i]; ++j) {
                if(i + j >= nums.length){
                    return res[nums.length-1];
                }
                if (res[i + j] == 0) {
                    res[i + j] = res[i] + 1;
                }
            }
        }
        return res[nums.length-1];
    }

    /**
     * 56. Merge Intervals
     * @param intervals
     * @return
     */
    public int[][] merge_v1(int[][] intervals) {
        if(intervals.length < 1){
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(i1, i2) -> Integer.compare(i1[0], i2[0]));

        for(int i = 0 ; i < intervals.length; ++i){
            if(i == intervals.length-1 || intervals[i][1] < intervals[i+1][0]){
                res.add(intervals[i]);
            }else {
                int[] node = new int[2];
                node[0] = intervals[i][0];
                node[1] = Math.max(intervals[i][1], intervals[i+1][1]);
                res.add(node);
                ++i;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length < 1){
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] node = intervals[0];
        for(int i = 1; i < intervals.length; ++i){
            if(node[1] < intervals[i][0]){
                res.add(node);
                node = intervals[i];
            }else {
                node[1] = Math.max(node[1], intervals[i][1]);
            }
        }
        res.add(node);
        return res.toArray(new int[res.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> res = new ArrayList<>();
        if(intervals.length < 1){
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }
        int[] node = new int[2];
        boolean flag = false;
        node[0] = Integer.MAX_VALUE;
        node[1] = Integer.MIN_VALUE;
        for(int i = 0 ; i < intervals.length ; ++i){
            if(intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            }else if(intervals[i][0] > newInterval[1]){
                if(flag){
                    res.add(node);
                    flag = false;
                }
                res.add(intervals[i]);
            }else {
//                if(intervals[i][0] > newInterval[0]) {
////                    node[0] = newInterval[0];
////                }else if(intervals[i][0] < newInterval[0]){
////                    node[0] = intervals[i][0];
////                }else if(intervals[i][1] > newInterval[1]){
////                    node[1] = intervals[i][1];
////                }else if(intervals[i][1] < newInterval[1]){
////                    node[1] = newInterval[1];
////                }
                node[0] = Math.min(newInterval[0], intervals[i][0]) < node[0]
                        ? Math.min(newInterval[0], intervals[i][0]) : node[0];
                node[1] = Math.max(newInterval[1], intervals[i][1]) > node[1]
                        ? Math.max(newInterval[1], intervals[i][1]) : node[1];
                flag = true;
            }
        }
        if(flag){
            res.add(node);
        }
        if(node[0] == Integer.MAX_VALUE){
            for(int i = 0; i <= intervals.length ; ++i){
                if(i == intervals.length || newInterval[0] < intervals[i][1]){
                    res.add(i,newInterval);
                    break;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }


}
