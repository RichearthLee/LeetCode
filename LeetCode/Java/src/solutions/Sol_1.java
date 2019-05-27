package solutions;

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
     * @param: [s]
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

}//class
