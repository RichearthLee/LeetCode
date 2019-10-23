package solutions;

import utility.ListNode;
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

    /**
     * 58. Length of Last Word
     * @param s
     * @return
     */
    public int lengthOfLastWord_v1(String s) {


        String[] res = s.split(" ");
        if (res.length == 0){
            return 0;
        }
        String word = res[res.length-1];
        int len = word.length();
        //return s.split(" ")[s.split(" ").length == 0 ? 0 : s.split(" ").length-1].length();
        return len;
    }

    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }

    /**
     * 59. Spiral Matrix II
     * @param n
     * @return int[][]
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cur = 1;
        int i = 0;
        int j = 0;
        int f = 0;
        while (cur <= n*n){
            res[i][j] = cur;
            cur++;
            switch (f){
                case 0:
                    if(j < n -1 && res[i][j+1] == 0){
                        j++;
                    }else {
                        f = 1;
                        i++;
                    }
                    break;
                case 1:
                    if(i < n-1 && res[i+1][j] == 0){
                        i++;
                    }else {
                        f = 2;
                        j--;
                    }
                    break;
                case 2:
                    if(j > 0 && res[i][j-1] == 0){
                        j--;
                    }else {
                        f = 3;
                        i--;
                    }
                    break;
                case 3:
                    if(i > 0 && res[i-1][j] == 0){
                        i--;
                    }else {
                        f = 0;
                        j++;
                    }
                    break;
            }
        }
        return res;
    }

    /**
     * 60. Permutation Sequence
     * @param n
     * @param k
     * @return
     */
    public String getPermutation_v1(int n, int k) {
        ArrayList<String> res = new ArrayList<>();
        LinkedList<Integer> num = new LinkedList<>();
        for (int i = 1 ; i <= n ; i++){
            num.add(i);
        }
        recursionPermute(res, num , "");
        return res.get(k-1);
    }

    private void recursionPermute(ArrayList<String> res, LinkedList<Integer> num, String s){
        if (num.size() == 0){
            res.add(s);
            return;
        }
        for(int i = 0 ; i < num.size() ; ++i){
            int n  = num.remove(i);
            recursionPermute(res, num, s+""+n);
            num.add(i, n);
        }

    }

    public String getPermutation(int n, int k) {
        String res = "";
        LinkedList<Integer> num = new LinkedList<>();
        for (int i = 1 ; i <= n ; i++){
            num.add(i);
        }
        //k--;
        for(int i = 1 ; i <= n ; ++i){
            int fa = factorial(n-i);
//            int fa = new Integer()->{
//                int r = 1;
//                for (int j = 1 ; j <= n ; ++j){
//                    r = r * j;
//                }
//                return r;
//            };
            int m = k / fa;
            if(k % fa == 0){
                k = fa;
                m = m - 1;
            }else {
                k = k % fa;
            }
            res += num.remove(m);
        }
        return res;
    }

    private int factorial(int n){
        int res = 1;
        for (int i = 1 ; i <= n ; ++i){
            res = res * i;
        }
        return res;
    }

    /**
     *
     */
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        while (cur.next != null){
            
        }
        return null;
    }
    
    /** 
     * @description: Unique Paths II
     * @param: [obstacleGrid] 
     * @return: int 
     * @author: Yukun Lee 
     * @date: 2019-10-15 
     */ 
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length==0){
            return 0;
        }
        int[] res = new int[obstacleGrid[0].length];
        res[0]=1;
        for(int i = 0 ; i < obstacleGrid.length ; i++){
            for(int j = 0 ; j < obstacleGrid[0].length ; ++j){
                if(obstacleGrid[i][j] != 1){
                    res[j] = (j > 0 ? res[j-1]:0) + res[j];
                }else {
                    res[j] = 0;
                }
            }
        }
        return res[obstacleGrid[0].length-1];
    }

    /**
     * 64. Minimum Path Sum
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for(int i = 0 ; i < grid.length ; ++i){
            for(int j = 0 ; j < grid[0].length ; ++j){
                if(i==0 && j ==0) continue;
                grid[i][j] =
                        Math.min(j>0?grid[i][j-1]:Integer.MAX_VALUE, i>0?grid[i-1][j]:Integer.MAX_VALUE)
                                + grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    /**
     * 66. Plus One
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if(digits == null||digits.length <= 0){
            return digits;
        }
        for(int i = digits.length-1 ; i >= 0 ; --i){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            else {
                digits[i]=0;
            }
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }

    public String addBinary(String a, String b) {
        if(a == null||a.length() <= 0){
            return b;
        }
        if(b == null||b.length() <= 0){
            return a;
        }

        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int n1 = 0;
        int n2 = 0;
        for (int i = 0 ; i < c1.length ; ++i){
            n1 += Math.pow(2,c1.length-i-1) * (c1[i]-'0');
        }
        for (int i = 0 ; i < c2.length ; ++i){
            n2 += Math.pow(2,c2.length-i-1) * (c2[i]-'0');
        }
        return Integer.toBinaryString(n1+n2);
    }

    public String addBinary_1(String a, String b){
        if(a == null||a.length() <= 0){
            return b;
        }
        if(b == null||b.length() <= 0){
            return a;
        }
        char[] n1;
        char[] n2;
        boolean f = false;
        if(a.length() >= b.length()){
            n1 = a.toCharArray();
            n2 = b.toCharArray();
        }else {
            n2 = a.toCharArray();
            n1 = b.toCharArray();
        }
        for(int i = n2.length-1 ; i >= 0; --i){
            if(n2[i] == '1'){
                for(int j = n1.length - (n2.length-i); j >= 0 ; --j){
                    if(n1[j] == '0'){
                        n1[j] = '1';
                        break;
                    }else {
                        n1[j] = '0';
                        if(j == 0){
                            f = true;
                        }
                    }
                }
            }
        }
        return f ? "1"+new String(n1) : new String(n1);
    }

    /**
     * 69. Sqrt(x)
     * Y = f(x0) + f'(x0)(x-x0)
     * Y = f(x0)-f'(x0)x0 +f'(x0)x
     * x = (f(x0)-f'(x0)x0) /f'(x0)
     * X = (x0^2 - 2*x0*x0)/2x0
     * x = -x0 / 2
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int res = 0;
        double mid = x;
        while(res != (int) mid){
            res = (int)mid;
            mid = mid -(mid*mid - x)/(2*mid);
            System.out.println(mid);
        }
        return res;
    }




}
