package solutions;

import com.sun.scenario.animation.shared.ClipEnvelope;
import utility.ListNode;
import utility.TreeNode;

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

    /**
     * Problem A. 晴天小猪历险记之Hill
     * 这一天，他来到了一座深山的山脚下，因为只有这座深山中的一位隐者才知道这种药草的所在。
     * 但是上山的路错综复杂，由于小小猪的病情，晴天小猪想找一条需时最少的路到达山顶，
     * 但现在它一头雾水，所以向你求助。
     * 山用一个三角形表示，从山顶依次向下有1段、2段、3段等山路，
     * 每一段用一个数字T（1< =T< =100）表示，代表晴天小猪在这一段山路上需要爬的时间，
     * 每一次它都可以朝左、右、左上、右上四个方向走（注意：在任意一层的第一段也可以走到本层的最后一段或上一层的最后一段）。
     * 晴天小猪从山的左下角出发，目的地为山顶，即隐者的小屋。
     * 输入数据
     * 　　第一行有一个数 n
     * （ 2≤ n≤ 1000 ），表示山的高度。
     * 　　从第二行至第 n+1 行，第 i+1 行有 i
     * 个数，每个数表示晴天小猪在这一段山路上需要爬的时间。
     * 输出数据
     * 　　一个数，即晴天小猪所需要的最短时间。
     * @param
     * @return
     */
    public int hill_v1(int h, int[][] num) {
        int[][] dp = num;
        for(int i = num.length-1; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; ++j){
                int mindown = 0;
                int mineq;
                if(i == num.length-1){
                    mineq = dp[i][j] = dp[i][j] + j>0?dp[i][j-1]:0;
                }else {

                    int mineq_ri;
                    if(j+1>i){
                        mineq_ri = Math.min(dp[i+1][j+1],dp[i+1][j+2]);
                        mineq_ri = Math.min(mineq_ri, dp[i+1][i]);
                    }else if(j+1==i){
                        mineq_ri = Math.min(dp[i+1][j+1],dp[i+1][j+2]);
                        mineq_ri = Math.min(mineq_ri, dp[i+1][0]);
                    }else {
                        mineq_ri = Math.min(dp[i+1][j+1],dp[i+1][j+2]);
                    }
                    mineq = Math.min(j==0?dp[i][i]:dp[i][j-1],mineq_ri);
                    if(j==0){
                        mindown = Math.min(dp[i+1][j],dp[i+1][j+1]);
                        mindown = Math.min(mindown, dp[i+1][i]);
                    }else if(j==i){
                        mindown = Math.min(dp[i+1][j],dp[i+1][j+1]);
                        mindown = Math.min(mindown, dp[i+1][0]);
                    }else {
                        mindown = Math.min(dp[i+1][j],dp[i+1][j+1]);
                    }
                }
                dp[i][j] = Math.min(mindown,mineq)+ dp[i][j];
            }
        }
        return dp[0][0];
    }


    public int hill(int h, int[][] num) {
        int[][] dp = num.clone();
        for(int i = num.length-1; i >= 0 ; i--){
            //int left = Integer.MAX_VALUE;
            for(int j = 0 ; j <= i ; ++j){
                if(i < num.length-1){
                    if(j==0){
                        int n = Math.min(dp[i+1][i],dp[i+1][j+1]);
                        dp[i][j] = Math.min(n,dp[i+1][j])+dp[i][j];
                    }else if (j==i){
                        int n = Math.min(dp[i+1][0],dp[i+1][j]);
                        dp[i][j] = Math.min(dp[i+1][j+1],n)+dp[i][j];
                    }else {
                        dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + dp[i][j];
                    }
                }
            }
            int[] mid = new int[i+1];
            for(int j = 0 ; j <= i ; ++j){
                //dp[i][j] = num[i][j] + (j <= 0?0:num[i][j-1]);
                mid[j] = dp[i][j];
                if(j <= 0){
                    dp[i][j] = dp[i][j];
                }else {
                    dp[i][j] = dp[i][j] + dp[i][j-1];
                }
            }
            for(int j = i ; j > 0  ; --j){
                //dp[i][j] = ((num[i][j] + (j>=i?num[i][0]:num[i][j+1])) < dp[i][j] ? num[i][j] + j>i?num[i][0]: num[i][j+1] : dp[i][j]);
                //dp[i][j] = Math.min((num[i][j] + (j==i?num[i][0]:num[i][j+1])),dp[i][j]);
                if(j==i){
                    dp[i][j] = Math.min(mid[j] + mid[0],dp[i][j]);
                    System.out.println(Math.min(dp[i][j] + dp[i][0],dp[i][j]));
                }else{
                    dp[i][j] = Math.min((mid[j] + mid[j+1]),dp[i][j]);
                }

            }
        }

        for(int i = 0 ; i <= num.length-1;++i){
            System.out.println();
            for (int j = 0 ; j<= num.length-1 ; ++j){
                System.out.print(dp[i][j]+"\t");
            }
        }
        return dp[0][0];
    }

    /**
     * 北交考试题
     * @param n
     * @return
     */
    public long getScore(int n) {
        long res = 0;
        List<Integer> arr = new LinkedList<>();
        for(int i = 1; i <= n ; ++i){
            arr.add(i);
        }
        for(int i = 1 ; i <= n ; ++i){
            if(arr.isEmpty()){
                break;
            }else {
                res += arr.remove(0) % i;
            }
            if(arr.isEmpty()){
                break;
            }else {
                arr.add(arr.remove(0));
            }
        }
        return res;
    }

    public void equation(int a, int b, int c){
        List<Integer> res = new ArrayList<>();
        for(int x = c ; x < 99999999 ; x++){
            int num = 0;
            int m = x;
            while (m > 0){
                num += m % 10;
                m = m/10;
            }
//            if(x == (b*Math.pow(num,a)+c)){
//                res.add(x);
//            }
            m = x - c;
            if(m % b == 0){
                m = m / b;
                if(Math.pow(num,a) == m){
                    res.add(x);
                }
            }
        }
        System.out.println(res.size());
        for(int i = 0 ; i < res.size() ;++i){
            System.out.print(res.get(i)+" ");
        }
    }
    private int getSum(int x){
        int res = 0;
        while (x > 0){
            res += x % 10;
            x = x/10;
        }
        return res;
    }

    public int climbStairs(int n) {
        if(n <= 0)return 0;
        int n1 = 1, n2 = 2, n3;
        if(n == 1)return 1;
        for(int i = 2 ; i < n ; i++){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }

    public String simplifyPath_v1(String path) {
        String res = "";
        //Stack<String> st = new Stack<>();
        String[] arr = path.split("/");
        int f = 0;
        for(int i = arr.length-1 ; i >= 0 ; --i){
            if(arr[i].equals("..")){
                f += 1;
            }else if(!arr[i].equals(".") && !arr[i].equals("")){
                if(f == 0){
                    res = "/"+ arr[i] + res;
                }else {
                    f -= 1;
                }
            }
        }
        if(res.equals(""))return "/";
        return res;
    }

    /**
     * 73. Set Matrix Zeroes
     * @param matrix
     */
    public void setZeroes_v1(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i = 0 ; i < matrix.length ; ++i){
            for(int j = 0 ; j < matrix[0].length ; ++j){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; ++i){
            for(int j = 0 ; j < matrix[0].length ; ++j){
                if(row[i] == 1){
                    matrix[i][j] = 0;
                }
                if(col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean col0 = false;
        for(int i = 0 ; i < matrix.length ; ++i){
            if(matrix[i][0]==0) col0 = true;
            for(int j = 1 ; j < matrix[0].length ; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for(int i = matrix.length - 1 ; i >=0 ; --i){
            for(int j = matrix[0].length - 1 ; j > 0; --j){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col0) matrix[i][0] = 0;
        }

    }

    public boolean searchMatrix_v1(int[][] matrix, int target) {
        if(matrix.length <= 0 || matrix[0].length <= 0) return false;
        int start = 0,end = matrix.length -1;
        while (start <= end){
            int mid = (start + end)/2;
            if(matrix[mid][0] == target)return true;
            else if(matrix[mid][0] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        if(end < 0) return false;
        int i = end;
        start = 0; end = matrix[0].length -1;
        while (start <= end){
            int mid = (start + end)/2;
            if(matrix[i][mid] == target)return true;
            else if (matrix[i][mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length <= 0 || matrix[0].length <= 0) return false;
        int start = 0,end = matrix.length * matrix[0].length -1;
        while(start <= end){
            int mid = (start + end) >> 1;
            if(matrix[mid / matrix[0].length][mid % matrix[0].length] == target){
                return true;
            }else if(matrix[mid / matrix[0].length][mid % matrix[0].length] > target){
                    end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return false;
    }

    public void sortColors_v1(int[] nums) {
        int l = 0, r = nums.length-1,flag = 1;
        while(l < r){
            if(nums[l] == 0){
                l++;
            }else if(nums[r] == 2){
                r--;
            }else if(nums[l] > nums[r]){
                int mid = nums[l];
                nums[l] = nums[r];
                nums[r] = mid;
            }else if(nums[l] == 1 && nums[r] == 1){
                flag = 1;
                for(int i = l ; i < r ; ++i){
                    int mid = nums[i];
                    if(nums[i] == 0){
                        nums[i] = nums[l];
                        nums[l] = mid;
                        flag = 0;
                        break;
                    }else if(nums[i] == 2){
                        nums[i] = nums[r];
                        nums[r] = mid;
                        flag = 0;
                        break;
                    }
                }
                if(flag == 1){
                    return;
                }
            }
        }
    }


    public void sortColors(int[] nums) {
        int l = 0, r = nums.length-1;
        for(int i = 0 ; i <= r ; i++){

            if(nums[i] == 2){
                int mid = nums[i];
                if(nums[r] == 2) r--;
                nums[i] = nums[r];
                nums[r] = mid;
                r--;
            }
            if(nums[i] == 0){
                int mid = nums[i];
                if(nums[l] == 0) l++;
                nums[i] = nums[l];
                nums[l] = mid;
                l++;
            }
        }
    }

    public void sortColors(int A[], int n){
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0)
            {
                A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
            }
            else if (A[i] == 1)
            {
                A[++n2] = 2; A[++n1] = 1;
            }
            else if (A[i] == 2)
            {
                A[++n2] = 2;
            }
        }
    }

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        recursion(1, n ,k, new LinkedList<>(), result);
        return result;
    }

    public void recursion(int s, int n, int k, LinkedList<Integer> mid, List<List<Integer>> result){
        if(k == 0){
            result.add(new LinkedList<>(mid));
            return;
        }
        for(int i = s ; i <= n ; ++i){
            mid.add(i);
            recursion(i+1, n ,k-1, mid,result);
            mid.pollLast();
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i <= nums.length ; i++){
            subsets_insert(nums,0, i, new LinkedList<>(), result);
        }
        return result;
    }

    public void subsets_insert(int[] nums,int s, int k, LinkedList<Integer> mid, List<List<Integer>> result){
        if(k == 0){
            result.add(new ArrayList<>(mid));
            return;
        }
        for(int i = s ; i < nums.length ;++i){
            mid.add(nums[i]);
            subsets_insert(nums, i+1,k-1, mid, result);
            mid.pollLast();
        }

    }
    
    /** 
     * @description:  
     * @param: [board, word] 
     * @return: boolean
     * @author: Yukun Lee 
     * @date: 2019-12-17 
     */ 
    public boolean exist_v1(char[][] board, String word) {
        char[] arr = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: arr){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        for (int i = 0 ; i < board.length ; ++i){
            for(int j = 0 ; j < board[0].length ; ++j){
                if(map.containsKey(board[i][j])){
                    Map<Character, Integer> mid = new HashMap<>(map);
                    mid.put(board[i][j], mid.get(board[i][j])-1);
                    while(mid.containsKey(board[i+1][j])){
                        if (mid.containsKey(board[i+1][j])){
                        }else if (mid.containsKey(board[i][j+1])){

                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        List<Character> w = new LinkedList<>();
        for(int i = 0 ; i < word.length() ; ++i){
            w.add(word.charAt(i));
        }
        for(int i = 0 ; i < board.length ; ++i){
            for(int j = 0 ; j < board[0].length ; ++j){
                if(w.get(0) == board[i][j]){
                    char a = board[i][j];
                    w.remove(0);
                    board[i][j] = 0;
                    if(exist_recursion(board,w,i,j)) return true;
                    w.add(0,a);
                    board[i][j] = a;
                }
            }
        }

        return false;
    }
    private boolean exist_recursion(char[][] board, List<Character> w, int i, int j){
        if(w.size() == 0){
            return true;
        }
        if(j > 0 && w.get(0)==board[i][j-1]){
            char a = board[i][j-1];
            w.remove(0);
            board[i][j-1] = 0;
            if (exist_recursion(board,w,i,j-1)) return true;
            w.add(0,a);
            board[i][j-1] = a;
        }
        if(j < board[0].length-1 && w.get(0)==board[i][j+1]){
            char a = board[i][j+1];
            w.remove(0);
            board[i][j+1] = 0;
            if(exist_recursion(board,w,i,j+1)) return true;
            w.add(0,a);
            board[i][j+1] = a;
        }
        if(i < board.length -1 && w.get(0)==board[i+1][j]){
            char a = board[i+1][j];
            board[i+1][j] = 0;
            w.remove(0);
            if(exist_recursion(board,w,i+1,j)) return true;
            w.add(0,a);
            board[i+1][j] = a;
        }
        if(i > 0 && w.get(0) == board[i-1][j]){
            char a = board[i-1][j];
            board[i-1][j] = 0;
            w.remove(0);
            if (exist_recursion(board,w,i-1,j)) return true;
            w.add(0,a);
            board[i-1][j] = a;
        }
        return false;
    }

    public int removeDuplicates_v1(int[] nums) {
        int len = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i]) > 2) continue;
                map.put(nums[i],map.get(nums[i])+1);
                len++;
            }else {
                map.put(nums[i],1);
                len++;
            }
        }
        return len;
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n : nums){
            if(i < 2 || n > nums[i-2]){
                nums[i++] = n;
            }
        }
        return i;
    }
    
    /** 
     * @description:  
     * @param: [nums, target] 
     * @return: boolean 
     * @author: Yukun Lee 
     * @date: 2019-12-24 
     */ 
    public boolean search_v1(int[] nums, int target) {
        int left = 0 , right = nums.length-1;
        while(left < right){
            int mid = (right + left) >> 1;
            if(nums[mid] >= nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        int offset = left;
        left = 0 ;right = nums.length-1;
        while (left <= right){
            int mid = (left + right)>>1;
            int realmid = (mid + offset)%nums.length;
            if(nums[realmid] > target){
                right = mid - 1;
            }else if(nums[realmid] < target){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int left = 0 , right = nums.length-1;
        while(left <= right){
            int mid = (left + right)>>1;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[left] && nums[right] == nums[mid]){ left++; right--;}
            else if(nums[left] <= nums[mid]){
                if(target < nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }else {
                if(target > nums[mid] && nums[right] >= target) left = mid + 1;
                else right = mid -1;
            }
        }
        return false;
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode dump = new ListNode(Integer.MIN_VALUE);
        dump.next = head;
        ListNode cur = dump, post = head;
        while(post != null){
                while(post != null && cur.next.val == post.val) {
                    post = post.next;
                }
                if(cur.next == post){
                    cur = cur.next;
                }else {
                    cur.next = post;
                }
                if(post!=null)
                post = post.next;
            }
        return dump.next;
    }

    /**
     * 83. Remove Duplicates from Sorted List
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode pre =head, cur = head;
        while(cur != null) {
            while (cur != null && cur.val == pre.val) {
                cur = cur.next;
            }
            if (cur != pre.next) {
                pre.next = cur;
            }
            pre = pre.next;
            if(cur!= null )cur = cur.next;
        }
        return head;
    }
    /*
     * @description: 86
     * @param: [head, x]
     * @return: utility.ListNode
     * @author: Yukun Lee
     * @date: 2019-12-26
     */
    public ListNode partition_v1(ListNode head, int x) {
        ListNode dumb = new ListNode(0);
        ListNode predumb = new ListNode(0);
        predumb.next = head;
        ListNode pre = predumb, res = dumb;
        while (head != null) {
            if (head.val < x) {
                res.next = head;
                res = res.next;
                pre.next = head;
            } else {
                pre = pre.next;
                head = head.next;
            }
            head = head.next;
        }
        res.next = predumb.next;
        return dumb.next;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dumbres = new ListNode(0);
        ListNode dumb = new ListNode(0);
        ListNode pre = dumb, cur = head, res = dumbres;
        while (cur != null) {
            while (cur != null && cur.val < x) {
                cur = cur.next;
            }
            if (cur != pre) {
                pre.next = cur;
            }
        }
        res.next = head;
        return dumbres.next;
    }

    /**
     * @description: 88. Merge Sorted Array
     * @param: [nums1, m, nums2, n]
     * @return: void
     * @author: Yukun Lee
     * @date: 2019-12-26
     */
    public void merge_v1(int[] nums1, int m, int[] nums2, int n) {
        int[] mid = nums1.clone();
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (j == n) {
                nums1[i + j] = mid[i++];
            } else if (i == m) {
                nums1[i + j] = nums2[j++];
            } else if (mid[i] < nums2[j]) {
                nums1[i + j] = mid[i++];
            } else {
                nums1[i + j] = nums2[j++];
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        while (i >=0 && j >= 0) {
            if(nums1[i] > nums2[j]){
                nums1[i+j+1] = nums1[i--];
            }else {
                nums1[i+j+1] = nums2[j--];
            }
        }
        while (j >= 0){
            nums1[i+j+1] = nums2[j--];
        }
    }

    public List<Integer> grayCode_v1(int n) {
        List<Integer> res= new ArrayList<>();
        res.add(0);
        if(n == 0) return res;
        res.add(1);
        if(n == 1) return res;
        int m =(int)Math.pow(2,n-2);
        res.add(3);
        res.add(2);
        int a = 0,b=1,c=3,d=4;
        for(int i = 1 ; i < m ; ++i){
            res.add(a+=4);
            res.add(b+=4);
            res.add(c+=4);
            res.add(d+=4);
        }
        return res;
    }
    public List<Integer> grayCode(int n) {
        List<Integer> res= new ArrayList<>();
        res.add(0);
        for(int i = 1 ; i <= n ; ++i){
            int m = res.size();
            for(int j = m-1; j >= 0 ; j--){
                res.add(res.get(j)+m);
            }
        }
        return res;
    }
    
    
    /** 
     * @description: 90. Subsets II
     * @param: [nums] 
     * @return: java.util.List<java.util.List<java.lang.Integer>> 
     * @author: Yukun Lee 
     * @date: 2019-12-27 
     */ 
    public List<List<Integer>> subsetsWithDup_v1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        for(int i = 0 ; i <= nums.length ; ++i){
            subsetsWithDup(res, new ArrayList<>(), nums, 0, i);
        }
        return res;
    }

    private void subsetsWithDup(List<List<Integer>> res, List<Integer> mid, int[] nums, int s, int k){
        if(k == 0){
            if(res.contains(mid)) return;
            res.add(new ArrayList<>(mid));
        }
        for(int i = s ; i < nums.length ; ++i){
            mid.add(nums[i]);
            subsetsWithDup(res, mid, nums, i+1,k-1);
            mid.remove(mid.size()-1);
        }
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        int s, size = 0;
        for(int i = 0 ; i <= nums.length ; ++i){
            s = (i >= 1 && nums[i] == nums[i - 1]) ? size : 0;
            size = res.size();
            for(int j = s ; j < size ; ++j){
                List<Integer> mid = new ArrayList<>(res.get(j));
                mid.add(nums[i]);
                res.add(mid);
            }
        }
        return res;
    }
    
    /** 
     * @description: 91. Decode Ways
     * @param: [s] 
     * @return: int 
     * @author: Yukun Lee 
     * @date: 2019-12-27 
     */ 
    public int numDecodings_v1(String s) {
        char[] arr = s.toCharArray();
        int res= 0;
        for(int i = 0 ; i < arr.length ; i++){
            if((arr[i]=='1'|| arr[i] == '2') && i< arr.length-1){
                res++;
            }
            if(arr[i]=='0'){
                res--;
            }
        }
        return res >0 ? res :0;
    }

    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2 ; i < dp.length ; i++){
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[dp.length-1];
    }

    /**
     * 92. Reverse Linked List II
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode letf = dumb, right = dumb;
        while(m > 1){
            letf = letf.next;
            m--;
        }
        while( n > 0){
            right = right.next;
            n--;
        }
        head = letf;
        letf = letf.next;
        while(head.next != right){
            head.next = letf.next;
            letf.next = right.next;
            right.next = letf;
            letf = head.next;
        }
        return dumb.next;
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode letf = null, right = head;
        while(right != null){
            ListNode tmp = right.next;
            right.next = letf;
            letf = right;
            right =tmp;
        }
        return letf;
    }

    /**
     * quickSort
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int[] quickSort(int[] nums, int start, int end){
        //if(nums == null || nums.length <= 0) return nums;
        if(start >= end) return nums;
        int cur = start, left = start, right = end;
        boolean f = true;
        while(left < right){
            if(f){
                if(nums[cur]>nums[right]){
                    int mid = nums[right];
                    nums[right] = nums[cur];
                    nums[cur] = mid;
                    cur = right;
                    f = false;
                }
                    right--;
            }else {
                if(nums[cur]<nums[left]){
                    int mid = nums[left];
                    nums[left] = nums[cur];
                    nums[cur] = mid;
                    cur = left;
                    f = true;
                }
                    left++;
            }
        }
        quickSort(nums,start,cur-1);
        quickSort(nums,cur+1, end);
        return nums;
    }

    /**
     * 98. Validate Binary Search Tree
     * @param root
     * @return
     */
    public boolean isValidBST_v1(TreeNode root) {
        Queue<TreeNode> arr = new LinkedList<>();
        if(root == null)return true;
        arr.add(root);
        while(!arr.isEmpty()){
            TreeNode node = arr.remove();
            if(node.left != null){
                if(node.left.val >= node.val){
                    return false;
                }
                arr.add(node.left);
            }
            if(node.right != null){
                if(node.right.val <= node.val){
                    return false;
                }
                arr.add(node.right);
            }
        }
        return true;
    }

    public boolean isValidBST_v2(TreeNode root) {
        if(root == null)return true;
        boolean r1 = true, r2 = true;
        if(root.left != null){
            if(root.left.val >= root.val){
                return false;
            }
            r1 = isValidBST_Recursion_v2(root.left, root.val, -Double.MAX_VALUE);
        }
        if(root.right != null){
            if(root.right.val <= root.val){
                return false;
            }
            r2 = isValidBST_Recursion_v2(root.right,  Double.MAX_VALUE, root.val);
        }
        return r1 && r2;
    }

    private boolean isValidBST_Recursion_v2(TreeNode root, double max, double min){
        boolean r1 = true, r2 = true;
        if(root.left != null){
            if(root.left.val >= root.val || root.left.val <= min){
                return false;
            }
            r1 = isValidBST_Recursion_v2(root.left, root.val, min);
        }
        if(root.right != null){
            if(root.right.val <= root.val || root.right.val >= max){
                return false;
            }
            r2 = isValidBST_Recursion_v2(root.right, max , root.val);
        }

        return r1 && r2;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        return isValidBST_Recursion(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValidBST_Recursion(TreeNode root, long max, long min){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isValidBST_Recursion(root.left, root.val, min)
                && isValidBST_Recursion(root.right, max , root.val);
    }

    /**
     *输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
     * 只能调整树中结点指针的指向。
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        return Convert_recursion(pRootOfTree, null);
    }

    private TreeNode Convert_recursion(TreeNode root, TreeNode pre) {
        if(root == null)return null;
        TreeNode l = Convert_recursion(root.left, root);
        if(pre != null && pre.right == root){

        }
        TreeNode r = Convert_recursion(root.right, root);
        if(pre != null && pre.left == root){
            if(r != null){
                //root.right = r;
                r.right = pre;
                pre.left = r;
            }else {
                root.right = pre;
            }
        }
        return root;
    }


    public TreeNode Convert_v1(TreeNode pRootOfTree) {
        if(pRootOfTree == null)return null;
        TreeNode l = Convert_v1(pRootOfTree.left);
        if(l != null){
            while(l.right != null)l = l.right;
            pRootOfTree.left = l;
            l.right = pRootOfTree;
        }
        TreeNode r = Convert_v1(pRootOfTree.right);
        if(r != null){
            while(r.left != null)r = r.left;
            pRootOfTree.right = r;
            r.left = pRootOfTree;
        }
        return pRootOfTree;
    }

    /**
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.equals(""))return res;
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        recursion(res, new StringBuilder(), arr, new boolean[arr.length]);
        return res;
    }

    private void recursion(ArrayList<String> res, StringBuilder sb, char[] arr, boolean[] used){
        if(sb.length() == arr.length){
            res.add(sb.toString());
        }else{
            int len = arr.length;
            for(int i = 0 ; i < len ; i++){
                if(i != 0 && arr[i-1] == arr[i] || used[i]) continue;
                used[i] = true;
                sb.append(arr[i]);
                recursion(res, sb, arr, used);
                sb.deleteCharAt(sb.length()-1);
                used[i] = false;
            }
        }
    }

    /**
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : array){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else {
                map.put(n, 1);
            }
            if(map.get(n) > array.length/2){
                return n;
            }
        }
        return 0;
    }

    /**
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k == 0 || k > input.length) return new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());
        for(int n : input){
            if(pq.size() < k){
                pq.offer(n);
            }else if(n < pq.peek()){
                pq.poll();
                pq.offer(n);
            }
        }
        return new ArrayList<>(pq);
    }


    public String PrintMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();
        if(numbers.length == 0) return sb.toString();
        ArrayList<String> lt = new ArrayList<>();
        for(int n : numbers){
            lt.add(String.valueOf(n));
        }
        lt.sort((String s1, String s2) -> ((s1+s2).compareTo(s2+s1)));
        for(String str : lt){
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     *丑数
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if(index < 7) return index;
        int p2 = 0, p3 = 0, p5 = 0, num = 1;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(num);
        while(res.size() < index){
            num = Math.min(res.get(p2) * 2, Math.min(res.get(p3) * 3, res.get(p5) * 5));
            if(res.get(p2) * 2 == num) p2++;
            if(res.get(p3) * 3 == num) p3++;
            if(res.get(p5) * 5 == num) p5++;
            res.add(num);
        }
        return res.get(index-1);
    }

    /**
     * 第一个只出现一次的字符
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = str.length();
        char c;
        for(int i = 0 ; i < len ; i++){
            c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }
//        int res = len;
//        for(Map.Entry<Character, Integer> e : map.entrySet()){
//            if(e.getValue() == 1){
//                res = Math.min(str.indexOf(e.getKey()), res);
//            }
//        }
//        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry<Character, Integer> en = it.next();
//        }
        for(int i = 0 ; i < len ; i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public double myPow(double x, int n) {
        if (n == 0)return 1;
        if (x == 0)return 0;
        if (x == 1)return 1;
        if (x == -1){
            if (n % 2 == 0)return 1;
            return -1;
        }
        if (n == Integer.MIN_VALUE)return 0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1.0;
        while(n > 0){
            if ((n & 1) == 1){
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }

    public int lengthOfLastWord_v2(String s) {
        s = s.trim();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                return s.length() - i - 1;
            }
        }
        return s.length();
    }

    public int[][] generateMatrix_v1(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1, top = 0, bottom = n-1;
        for (int i = 0, j = 0, num = 1;  ; ) {
            while(j <= right) matrix[i][j++] = num++;
            if (++top > bottom)break;
            j--; i++;
            while(i <= bottom) matrix[i++][j] = num++;
            if (left > --right)break;
            i--;j--;
            while(j >= left) matrix[i][j--] = num++;
            if (top > --bottom)break;
            j++;i--;
            while(i >= top) matrix[i--][j] = num++;
            if (++left > right)break;
            i++;j++;
        }
        return matrix;
    }

    public int[][] generateMatrix_v2(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1, top = 0, bottom = n-1, num = 1;
        while(num <= n*n){
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }

    public String getPermutation_v2(int n, int k) {
        List<String> res = new ArrayList<>();
        getAllPermutation(n, new int[n], res, new StringBuilder());
        return res.get(k-1);
    }

    private void getAllPermutation(int n, int[] used, List<String> res, StringBuilder sb){
        if (sb.length() == n){
            res.add(sb.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i-1] != 1){
                sb.append(i);
                used[i-1] = 1;
                getAllPermutation(n, used, res, sb);
                used[i-1] = 0;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public String getPermutation_v3(int n, int k) {
        ArrayList<Integer> st = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st.add(i);
        }
        StringBuilder sb = new StringBuilder();
        setNumber(n, k, sb, st);
        return sb.toString();
    }

    private void setNumber(int n, int k, StringBuilder sb, ArrayList<Integer> arrayList){
        if (n == 0)return;
        int count = 1;
        for (int i = 1; i < n ; i++) {
            count *= i;
        }
        int index = k/count;
        int remainder = k%count;
        if (remainder > 0){
            index++;
        }
        sb.append(arrayList.get(index));
        arrayList.remove(index);
        setNumber(n-1, remainder == 0 ? count : remainder, sb, arrayList);
    }

    public ListNode rotateRight_v1(ListNode head, int k) {
        if (head == null)return head;
        ListNode tail = head, cur = head;
        int len = 1;
        for (; tail.next != null ; tail = tail.next) {
            len++;
        }
        k = k % len;
        if(k == 0)return head;
        for (int i = 0;i < len - k ; i++) {
            head = head.next;
            tail.next = cur;
            cur.next = null;
            tail = tail.next;
            cur = head;
        }
        return head;
    }

    public ListNode rotateRight_v2(ListNode head, int k) {
        if (head == null)return head;
        ListNode tail = head, cur = head;
        int len = 1;
        for (; tail.next != null ; tail = tail.next) {
            len++;
        }
        k = k % len;
        if(k == 0)return head;
        for (int i = 0; i < len-k-1; i++) {
            cur = cur.next;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)return 0;
        int[][] res = new int[m+1][n+1];
        res[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                res[i][j] += res[i-1][j] + res[i][j-1];
            }
        }
        return res[m][n];
    }

    public int uniquePaths_v1(int m, int n) {
        if (m <= 0 || n <= 0)return 0;
        int[] cur = new int[n+1], pre = new int[n+1];
        Arrays.fill(pre, 1);
        pre[0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                cur[j] = cur[j-1] + pre[j];
            }
            int[] tmp = cur;
            cur = pre;
            pre = tmp;
        }
        return cur[n];
    }

    public int uniquePaths_v2(int m, int n) {
        if (m <= 0 || n <= 0)return 0;
        int[] cur = new int[n+1];
        Arrays.fill(cur, 1);
        cur[0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                cur[j] += cur[j-1];
            }
        }
        return cur[n];
    }

    public int uniquePaths_v3(int m, int n) {
        if (m <= 0 || n <= 0)return 0;
        double divisor = 1, dividend = 1;
        for (int i = 1; i <= n-1; i++) {
            divisor *= i;
        }
        for (int i = m-1; i <= m+n-2; i++) {
            dividend *= i;
        }
        return (int) (dividend/divisor);
    }

    public int uniquePathsWithObstacles_v1(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0
                || obstacleGrid[0].length == 0
                || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)return 0;
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] res = new int[row][col];
        if (obstacleGrid[0][0] != 1)res[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1)continue;
                int m = i-1 < 0 || obstacleGrid[i-1][j] == 1?0 : res[i-1][j];
                int n = j-1 < 0 || obstacleGrid[i][j-1] == 1?0 : res[i][j-1];
                res[i][j] += m+n;
            }
        }
        return res[row-1][col-1];
    }

    public int uniquePathsWithObstacles_v2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0
                || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)return 0;
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[] res = new int[col];
        res[0] = 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < col; j++) {
                res[j] = ints[j] == 1 ? 0 : ((j > 0 ? res[j - 1] : 0) + res[j]);
            }
        }
        return res[col-1];
    }

    public int minPathSum_v1(int[][] grid) {
        if (grid == null || grid.length == 0)return 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];
    }

    public int[] plusOne_v1(int[] digits) {
        if (digits == null || digits.length == 0)return digits;
        for (int i = digits.length-1, carry = 1; i >= 0; i--) {
            int tmp = digits[i] + carry;
            carry = tmp / 10;
            digits[i] = tmp % 10;
            if (carry == 0)return digits;
        }
        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        //System.arraycopy(digits, 0, arr, 1, digits.length);
        return arr;
    }

    public String addBinary_v1(String a, String b) {
        if (a == null || a.length() == 0)return b;
        if (b == null || b.length() == 0)return a;
        StringBuilder sb = new StringBuilder(a.length() + b.length());
        int carry = 0;
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j>= 0 ; i--, j--) {
            int n = (i < 0? 0 : a.charAt(i)-'0') + (j < 0 ? 0 :b.charAt(j)-'0') + carry;
            carry = n >> 1;
            sb.append(n & 1);
        }
        if (carry == 1)sb.append(1);
        for (int i = sb.length()-1; i >= 0; i--) {
            if (sb.charAt(i) == '1' || i == 0)break;
            sb.deleteCharAt(i);
        }
        return sb.reverse().toString();
    }

    public int mySqrt_v1(int x) {
        int l = 0, r = x, res = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if ((long)mid*mid <= x){
                res = mid;
                l = mid+1;
            }else {
                r = mid -1;
            }
        }
        return res;
    }

    public int mySqrt_v2(int x) {    //Xi+1 = (Xi + C/Xi)/2;
        double res = x, pre = x;
        while(res*res > x){
            res = (res + x/res)/2;
            if (Math.abs(pre - res) < 1e-7){
                break;
            }
            pre = res;
        }
        return (int)res;
    }

    public int climbStairs_v1(int n) {
        if (n <= 0)return 0;
        int res = 1, pre = 1;
        for (int i = 0; i < n; i++) {
            int tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }


    public String simplifyPath(String path) {
        if (path == null || path.equals(""))return path;
        String[] arr = path.split("/");
        StringBuilder sb = new StringBuilder(path.length());
        for (String s : arr) {
            if (!s.equals("")){
                if (s.equals("..")){
                     if (sb.length() > 0) sb.delete(sb.lastIndexOf("/"), sb.length());
                }else if (!s.equals(".")){
                    sb.append('/');
                    sb.append(s);
                }
            }
        }
        if (sb.length() == 0)sb.append('/');
        return sb.toString();
    }


    public String simplifyPath_v2(String path) {
        if (path == null || path.equals(""))return path;
        Stack<String> st = new Stack<>();
        String[] list = path.split("/");
        for (String s : list) {
            if ("..".equals(s)){
                if (!st.empty())st.pop();
            }else if (!"".equals(s) && !".".equals(s)){
                st.push(s);
            }
        }
        if (st.empty())return "/";
        StringBuilder sb = new StringBuilder(path.length());
        for (String s : st) {
            sb.append('/');
            sb.append(s);
        }
        return sb.toString();
    }

    public void setZeroes_v2(int[][] matrix) {
        if (matrix.length == 0)return;
        int []col = new int[matrix[0].length];
        int []row = new int[matrix.length];
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (matrix[i][j] == 0){
                    col[j] = 1;
                    row[i] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes_v3(int[][] matrix) {
        if (matrix.length == 0)return;
        boolean col = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) col = true;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0){
            Arrays.fill(matrix[0], 0);
        }
        if (col){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes_v4(int[][] matrix) {
        if (matrix.length == 0)return;
        boolean col = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    if (j == 0)col = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0){
            if (col){
                Arrays.fill(matrix[0], 0);
            }else {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

    public boolean searchMatrix_v2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)return false;
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right){
            int mid = (left + right)/2; //left + (right - left)/2
            int i = mid / col, j = mid % col;
            if (matrix[i][j] > target){
                right = mid-1;
            }else if (matrix[i][j] < target){
                left = mid+1;
            }else {
                return true;
            }
        }
        return false;
    }

    public void sortColors_v2(int[] nums) {
        if (nums == null || nums.length == 0)return;
        int _1 = 0, _2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                if (i >= _1){
                    nums[i] = nums[_1];
                    nums[_1] = 0;
                    _1++;
                }
                if (_2 < _1)_2 = _1;
            }
            if (nums[i] == 1 && i >= _2){
                nums[i] = nums[_2];
                nums[_2] = 1;
                _2++;
            }
        }
    }

    public void sortColors_v3(int[] nums) {
        if (nums == null || nums.length == 0)return;
        int l = 0, r = nums.length-1;
        for (int i = 0; i <= r;) {
            if (nums[i] == 2){
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
            }else if (nums[i] == 0){
                nums[i++] = nums[l];
                nums[l] = 0;
                l++;
            }else {
                i++;
            }
        }
    }


    public List<List<Integer>> combine_v1(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine_helper_v1(n, k, res, new ArrayList<>());
        return res;
    }
    public void combine_helper_v1(int n, int k, List<List<Integer>> res, List<Integer> tmp) {
        if (k == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = n; i > 0; i--) {
            tmp.add(i);
            combine_helper_v1(i-1, k-1, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public List<List<Integer>> subsets_v1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsets_v1_helper(nums, 0, i, res, new ArrayList<>());
        }
        return res;
    }
    public void subsets_v1_helper(int[] nums, int index, int k,List<List<Integer>> res, List<Integer> tmp) {
        if (k == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            subsets_v1_helper(nums, i+1, k-1, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public boolean exist_v2(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null|| word.length() == 0) {
            return false;
        }
        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == arr[0] && exist_v2_helper(board, arr, 1, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean exist_v2_helper(char[][] board, char[] word, int index, int i, int j){
        if (index == word.length){
            return true;
        }
        if (j < board[0].length-1 && board[i][j+1] == word[index]){
            char c = board[i][j];
            board[i][j] = 0;
            if (exist_v2_helper(board, word, index+1, i, j+1)){
                return true;
            }
            board[i][j] = c;
        }
        if (j > 0 && board[i][j-1] == word[index]){
            char c = board[i][j];
            board[i][j] = 0;
            if (exist_v2_helper(board, word, index+1, i, j-1)){
                return true;
            }
            board[i][j] = c;
        }
        if (i < board.length-1 && board[i+1][j] == word[index]){
            char c = board[i][j];
            board[i][j] = 0;
            if (exist_v2_helper(board, word, index+1, i+1, j)){
                return true;
            }
            board[i][j] = c;
        }
        if (i > 0 && board[i-1][j] == word[index]){
            char c = board[i][j];
            board[i][j] = 0;
            if (exist_v2_helper(board, word, index+1, i-1, j)){
                return true;
            }
            board[i][j] = c;
        }
        return false;
    }

    public int removeDuplicates_v2(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        int tail = nums.length;
        for (int i = 1, count = 1; i < tail; i++) {
            if (nums[i] == nums[i-1]){
                count++;
            }else {
                count = 1;
            }
            if (count > 2){
                for (int j = i+1; j < tail; j++) {
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
                tail--;
                i--;
            }
        }
        return tail;
    }

    public int removeDuplicates_v3(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        int tail = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 2 || nums[i] > nums[i-2]){
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }

    public boolean search_v2(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right)>>1;  // lefe + (right - left)/2
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left] && nums[mid] == nums[right]){
                left++;
                right--;
            } else if (nums[mid] >= nums[left]){
                if (target < nums[mid] && target >= nums[left]){
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }else{
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;;
                }
            }
        }
        return false;
    }

    public ListNode deleteDuplicates_v1(ListNode head) {
        for (ListNode cur = head; cur!= null && cur.next != null ;) {
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates_v2(ListNode head) {
        if (head == null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        boolean f = false;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                f = true;
            }
            cur = cur.next;
            if (f) {
                pre.next = cur;
            }else {
                pre = pre.next;
            }
            f = false;
        }
        return dummy.next;
    }

    public ListNode partition_v2(ListNode head, int x) {
        if (head == null)return null;
        ListNode dummy = new ListNode(0), part = dummy, cur;
        dummy.next = head;
        while(part.next != null && part.next.val < x){
            part = part.next;
        }
        cur = part;
        while (cur != null && cur.next != null){
            if (cur.next.val < x){
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = part.next;
                part.next = tmp;
                part = part.next;
                cur = cur.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public void merge_v2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)return;
        System.arraycopy(nums1, 0, nums1, n, m);
        for (int i = n, j = 0, cur = 0; i < m + n || j < n; cur++) {
            if (i < m + n && nums1[i] <= nums2[j]){
                nums1[cur] = nums1[i++];
            }else {
                nums1[cur] = nums2[j++];
            }
        }
    }

    public void merge_v3(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)return;
        int i = m-1, j = n-1;
        while (i >= 0 && j >= 0){
            if (nums1[i] <= nums2[j]){
                nums1[i+j+1] = nums1[i++];
            }else {
                nums1[i+j+1] = nums2[j++];
            }
        }
        while (j != 0){
            nums1[j] = nums2[j--];
        }
    }

    public List<Integer> grayCode_v2(int n) {
        List<Integer> res = new ArrayList<Integer>(){{add(0);}};
        for (int i = 0; i < n; i++) {
            for (int m = res.size(), j = m - 1 ; j >= 0 ; j--) {
                res.add(m + res.get(j));
            }
        }
        return res;
    }

    public int numDecodings_v2(String s) {
        if (s == null || s.length() == 0)return 0;
        int cur = 1, pre = 1;
        if (s.charAt(0) == '0')return 0;
        for (int i = 1, len = s.length(), prec = s.charAt(0), c; i < len; i++) {
            c = s.charAt(i);
            if (c == '0' && (prec > '2' || prec =='0')){
                return 0;
            }
            if ((prec == '1' || prec == '2' && c <= '6')
                    && c > '0' && (i == len-1 ||i < len -1 && s.charAt(i+1) != '0')){
                int tmp = cur;
                cur = cur + pre;
                pre = tmp;
            }else {
                pre = cur;
            }
            prec = c;
        }
        return cur;
    }

    public int numDecodings_v3(String s) {
        if (s == null || s.length() == 0)return 0;
        int cur = 1, pre = 1;
        if (s.charAt(0) == '0')return 0;
        for (int i = 1, len = s.length(), prechar = s.charAt(0), curchar; i < len; i++) {
            curchar = s.charAt(i);
            int tmp = 0;
            if (curchar == '0' && (prechar > '2' || prechar =='0')){
                return 0;
            }
            if (curchar >= '1' && curchar <= '9'){
                tmp += cur;
            }
            if (prechar == '1' || prechar == '2' && curchar <= '6'){
                tmp += pre;
            }
            pre = cur;
            cur = tmp;
            prechar = curchar;
        }
        return cur;
    }


    public ListNode reverseBetween_v1(ListNode head, int m, int n) {
        if (head == null)return null;
        ListNode dummy = new ListNode(0), dummy1 = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        cur = pre.next; head = cur;
        for (int i = m; i <= n; i++) {
            ListNode tmp = cur.next;
            cur.next = dummy1.next;
            dummy1.next = cur;
            cur = tmp;
        }
        pre.next = dummy1.next;
        head.next = cur;
        return dummy.next;
    }

    public ListNode reverseBetween_v2(ListNode head, int m, int n) {
        if (head == null)return null;
        ListNode dummy = new ListNode(0), tail;
        dummy.next = head;
        ListNode pre = dummy, cur;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        cur = pre.next; head = cur.next; tail = cur;
        for (int i = m; i < n; i++) {
            ListNode tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        pre.next = cur;
        tail.next = head;
        return dummy.next;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12)return res;
        int len = s.length();
        for (int i = 1; i <= 3 && i < len - 2; i++) {
            if (len - i > 9)continue;
            String s1 = s.substring(0, i);
            if (!restoreIpAddresses_isValid(s1)){
                continue;
            }
            for (int j = i+1; j <= i+3 && j < len - 1; j++) {
                if (len - j > 6)continue;
                String s2 = s.substring(i, j);
                if (!restoreIpAddresses_isValid(s2)){
                    continue;
                }
                for (int k = j+1; k <= j+3 && k < len; k++) {
                    if(len - k > 3)continue;
                    String s3 = s.substring(j, k), s4 =s.substring(k);
                    if (restoreIpAddresses_isValid(s3, s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    private boolean restoreIpAddresses_isValid(String ... arg){
        for (String s: arg) {
            if(s.length() <= 0 || s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1)|| Integer.parseInt(s) > 255){
                return false;
            }
        }
        return true;
    }


    public List<String> restoreIpAddresses_v1(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12 || s.length() < 4)return res;
        List<String> tmp = new ArrayList<>(0);

        return res;
    }
    private void restoreIpAddresses_v1_hepler(int index, String s, List<String> res, List<String> tmp){
        if (index == s.length() && tmp.size() == 4){
            res.add(String.join(".", tmp));
            return;
        }
        for (int i = index, len = s.length(); i < index + 4 && i < len ; i++) {
            if (i > len - 3 + tmp.size()){
                break;
            }
            if (len - i > (3 - tmp.size())*3){
                continue;
            }
            String s1 = s.substring(index, i);
            if (restoreIpAddresses_isValid(s1)){
                tmp.add(s1);
                restoreIpAddresses_v1_hepler(index+1, s, res, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal_hepler(root, res);
        return res;
    }
    private void inorderTraversal_hepler(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        inorderTraversal_hepler(root.left, res);
        res.add(root.val);
        inorderTraversal_hepler(root.right, res);
    }

    public List<Integer> inorderTraversal_v1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.empty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }

    public void quickSort_v1(int[] nums, int start, int end){
        if (start >= end)return;
        int left = start, right = end, key = nums[left];
        while(left < right){
            while(left < right && key <= nums[right]){
                right--;
            }
            while(left < right && key >= nums[left]){
                left++;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        nums[start] = nums[left];
        nums[left] = key;
        quickSort_v1(nums, start, left - 1);
        quickSort_v1(nums, left + 1, end);
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            TreeNode root = new TreeNode(i+1);
            nodes[i] = 1;
            generateTrees_helper(nodes, root, root, res, 1);
            nodes[i] = 0;
        }
        return res;
    }
    private void generateTrees_helper(int[] nodes, TreeNode node, TreeNode root, List<TreeNode> res, int len){
        if(len == nodes.length){
            TreeNode clone = cloneTree(root, new TreeNode(root.val));
            res.add(clone);
            return;
        }
        boolean f = true;
        for (int i = 0; i < node.val; i++) {
            if (nodes[i] == 0){
                f = false;
                nodes[i] = 1;
                TreeNode left = new TreeNode(i+1);
                node.left = left;
                generateTrees_helper(nodes, left, root, res, len+1);
                for (int j = node.val + 1; j < nodes.length; j++) {
                    nodes[j] = 1;
                    TreeNode right = new TreeNode(j+1);
                    node.right = right;
                    generateTrees_helper(nodes, right, root, res, len+1);
                    node.right = null;
                    nodes[j] = 0;
                }
                node.left = null;
                nodes[i] = 0;
            }
        }
        if (f){
            for (int j = node.val + 1; j < nodes.length; j++) {
                nodes[j] = 1;
                TreeNode right = new TreeNode(j+1);
                node.right = right;
                generateTrees_helper(nodes, right, root, res, len+1);
                node.right = null;
                nodes[j] = 0;
            }
        }
    }
    private TreeNode cloneTree(TreeNode root, TreeNode clone){
        if (root == null){
            return null;
        }
        if (root.left != null){
            clone.left = new TreeNode(root.left.val);
            cloneTree(root.left, clone.left);
        }
        if (root.right != null){
            clone.right = new TreeNode(root.right.val);
            cloneTree(root.right, clone.right);
        }
        return clone;
    }


    public List<TreeNode> generateTrees_v1(int n) {
        if (n == 0)return new ArrayList<>();
        return generateTrees_v1_helper(1, n);
    }

    private List<TreeNode> generateTrees_v1_helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees_v1_helper(start, i-1);
            List<TreeNode> right = generateTrees_v1_helper(i+1, end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }


    public int numTrees(int n) {
        return numTrees_helper(1, n);
    }
    private int numTrees_helper(int start, int end){
        if (start >= end){
            return 1;
        }
        int res = 0;
        for (int i = start; i <= end; i++) {
            res += numTrees_helper(start, i-1) *
            numTrees_helper(i+1, end);
        }
        return res;
    }

    public int numTrees_v1(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                nums[i] += nums[j-1] * nums[i-j];
            }
        }
        return nums[n];
    }


    public boolean isValidBST_v3(TreeNode root) {
        return isValidBST_v3_helper(root, (long) Integer.MAX_VALUE+1, (long) Integer.MIN_VALUE-1);
    }
    private boolean isValidBST_v3_helper(TreeNode root, long max, long min){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return isValidBST_v3_helper(root.left, root.val, min) && isValidBST_v3_helper(root.right, max, root.val);
    }













}