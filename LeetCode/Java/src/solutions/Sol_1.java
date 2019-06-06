package solutions;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Sol_1 {
    /**
     * @Description: problem 4, Find the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     * @Param: [nums1, nums2]
     * @return: double
     * @Author: Yukun Lee
     * @Date: 2019-05-23
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 1 && nums2.length == 1) {
            return (double) Math.round((nums1[0] + nums2[0]) * 10 / 2) / 10;
        }
        int s1 = 0, s2 = 0, e1 = nums1.length - 1, e2 = nums2.length - 1;
        int mid1 = (s1 + e2) / 2, mid2 = (s2 + e2) / 2;
        while (mid1 == s1 && mid2 == s2) {
            if (nums1[mid1] > nums2[mid2]) {
                s2 = mid2 + 1;
            } else {
                s1 = mid1 + 1;
            }
            if (nums1[mid1 + 1] > nums2[mid2 + 1]) {

            }

            mid1 = (s1 + e1) / 2;
            mid2 = (s2 + e2) / 2;
        }
        return (double) Math.round((nums1[mid1] + nums2[mid2]) * 10 / 2) / 10;
    }

    /**
     * @description: problem 5, Given a string s, find the longest palindromic substring in s.
     * @param: s
     * @return: java.lang.String
     * @author: Yukun Lee
     * @date: 2019-05-23
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) return s;
        int[][] dp = new int[len][len];
        String res = "";
        for (int i = 0; i < len; ++i) {
            for(int j = 0; j<= i; ++j){
                dp[i][j] = (s.charAt(i) == s.charAt(j) && ((i - j < 2) || dp[i-1][j+1]==1))?1:0;
                if (dp[i][j]==1&&(res.length()==0||i-j+1>res.length())){
                    res = s.substring(j,i+1);
                }
            }
        }

        printMatrix(dp);
        return res;
    }

    public void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public void printMatrix(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public void printMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    /**
     * SimpleDateFormat：
     * G 年代标志符
     * y 年
     * M 月
     * d 日
     * h 时 在上午或下午 (1~12)
     * H 时 在一天中 (0~23)
     * m 分
     * s 秒
     * S 毫秒
     * E 星期
     * D 一年中的第几天
     * F 一月中第几个星期几
     * w 一年中第几个星期
     * W 一月中第几个星期
     * a 上午 / 下午 标记符
     * k 时 在一天中 (1~24)
     * K 时 在上午或下午 (0~11)
     * z 时区
     */
    public void getTime() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.ENGLISH);
        String year = df.format(new java.util.Date());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }

    /**
     * @description: leetcode 9
     * @param: [x]
     * @return: boolean
     * @author: Yukun Lee
     * @date: 2019-06-05
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        ArrayList<Integer> li = new ArrayList<>();
        while (x != 0) {
            int n = x % 10;
            x = x / 10;
            li.add(n);
            System.out.println(n);
        }
        int length = li.size();
        for (int i = 0; i < length / 2; ++i) {
            if (li.get(i) != li.get(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    /** 
     * @description: leetcode 10
     * @param: [s, p] 
     * @return: boolean 
     * @author: Yukun Lee 
     * @date: 2019-06-06 
     */ 
    public boolean isMatch( String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        int[][] dp = new int[s_len + 1][p_len + 1];
        dp[0][0] = 1;
        s = " " + s;
        p = " " + p;
        for (int i = 0; i <= s_len; ++i) {
            for (int j = 0; j <= p_len; ++j) {
                if ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                    if ((i == 0 && j == 0)) dp[i][j] = 1;
                    if ((i > 0 && j > 0) && dp[i - 1][j - 1] == 1) dp[i][j] = 1;
                }
                if (j > 0 && p.charAt(j) == '*') {
                    if ((j >= 2 && dp[i][j - 2] == 1) || (dp[i][j - 1] == 1) ||
                            (i > 0 && dp[i - 1][j] == 1 &&
                                    (((s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == p.charAt(j - 1))
                                            || p.charAt(j - 1) == '.')))) {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        printMatrix(dp);
        return dp[s_len][p_len] == 1;
    }


}//class
