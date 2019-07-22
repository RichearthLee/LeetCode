package solutions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import utility.ListNode;

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

    public void testForeach() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }

//        for(Integer i : list){
//            System.out.println(i);
//            list.remove(i);
//        }
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
            list.remove(i);
            --i;
        }
    }

    public void testArrayList() {
        ArrayList arr1;
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        if (1 < 2) {
            arr1 = arr2;
        }
        System.out.println(arr1.get(0));
    }

    /**
     * @description: leetcode 11
     * @param: [height]
     * @return: int
     * @author: Yukun Lee
     * @date: 2019-06-13
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            for (int j = i; j < height.length; ++j) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    /**
     * @description: leetcode 12 Integer to Roman
     * @param: [num]
     * @return: java.lang.String
     * @author: Yukun Lee
     * @date: 2019-06-13
     */
    public String intToRoman(int num) {
        int lastnode;
        String c1;
        String c2 = "";
        String c3 = "";
        String res = "";
        for (int i = 0; num != 0; ++i) {
            lastnode = num % 10;
            num = num / 10;
            if (i == 0) {
                c1 = "I";
                c2 = "V";
                c3 = "X";
            } else if (i == 1) {
                c1 = "X";
                c2 = "L";
                c3 = "C";
            } else if (i == 2) {
                c1 = "C";
                c2 = "D";
                c3 = "M";
            } else {
                c1 = "M";
            }
            switch (lastnode) {
                case 0:
                    continue;
                case 1:
                    res = c1 + res;
                    continue;
                case 2:
                    res = c1 + c1 + res;
                    continue;
                case 3:
                    res = c1 + c1 + c1 + res;
                    continue;
                case 4:
                    res = c1 + c2 + res;
                    continue;
                case 5:
                    res = c2 + res;
                    continue;
                case 6:
                    res = c2 + c1 + res;
                    continue;
                case 7:
                    res = c2 + c1 + c1 + res;
                    continue;
                case 8:
                    res = c2 + c1 + c1 + c1 + res;
                    continue;
                case 9:
                    res = c1 + c3 + res;
                    continue;
            }
        }
        return res;
    }

    public void testHashMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("M", 1000);
//        map.put("D", 500);
//        map.put("C", 100);
//        String[] match = {"M", "D", "C", "L", "X" ,"V" ,"I"};
//        StringBuffer sb= new StringBuffer(s);

    }

    /**
     * @description: leetcode 13
     * @param: [s]
     * @return: int
     * @author: Yukun Lee
     * @date: 2019-06-13
     */
    public int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; --i) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i < len - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        res--;
                    } else {
                        res++;
                    }
                    continue;
                case 'V':
                    res = res + 5;
                    continue;
                case 'X':
                    if (i < len - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        res = res - 10;
                    } else {
                        res = res + 10;
                    }
                    continue;
                case 'L':
                    res = res + 50;
                    continue;
                case 'C':
                    if (i < len - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        res = res - 100;
                    } else {
                        res = res + 100;
                    }
                    continue;
                case 'D':
                    res = res + 500;
                    continue;
                case 'M':
                    res = res + 1000;
                    continue;

            }
        }
        return res;
    }

    /**
     * @description:
     * @param: [strs]
     * @return: java.lang.String
     * @author: Yukun Lee
     * @date: 2019-06-13
     */
    public String longestCommonSubstr(String[] strs) {
        if (strs.length < 1) return "";
        int len = strs[0].length();
        String sub = "";
        boolean f = true;
        String res = "";
        for (int i = 0; i < len; ++i) {
            if (res.length() + i >= len) break;
            for (int j = i + 1; j <= len; ++j) {
                sub = strs[0].substring(i, j);
                f = true;
                for (String v : strs) {
                    if (v.contains(sub) == false) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    res = res.length() < sub.length() ? sub : res;
                }
            }
        }
        return res;
    }

    /**
     * @description: leetcode 14
     * @param: [strs]
     * @return: java.lang.String
     * @author: Yukun Lee
     * @date: 2019-06-13
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        int len = strs[0].length();
        String sub;
        String res = "";
        for (int i = 1; i <= len; ++i) {
            if (res.length() + i > len) break;
            sub = strs[0].substring(0, i);
            for (String v : strs) {
                if (i>v.length() || !v.substring(0,i).equals(sub)) {
                    return res;
                }
            }
            res = res.length() < sub.length() ? sub : res;
        }
        return res;
    }

    /**
     * @description: leetcode 15
     * @param: [nums]
     * @return: List<List<Integer>>
     * @author: Yukun Lee
     * @date: 2019-06-14
     */
    public List<List<Integer>> threeSum_v1(int[] nums) {
        if(nums.length < 3) return null;
        int a , b = 1, c = 2;
        List<List<Integer>> res = new ArrayList<>();
        for(a = 0 ; a < b ; ++a){
            for(b = a + 1 ; b < c ; ++b){
                for(c = b + 1 ; c < nums.length ; ++c){
                    if(nums[a] + nums[b] + nums[c] == 0){
                        res.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c])));
                    }
                }
            }
        }
        return res;
    }

    /**
     * @description: leetcode 15
     * @param: [nums]
     * @return: List<List<Integer>>
     * @author: Yukun Lee
     * @date: 2019-06-14
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length - 2 ; ++i){
            if(i == 0 || nums[i] != nums[i-1]){
                int head = i + 1, tail = nums.length - 1, val =0 -nums[i];
                while (head < tail){
                    if(nums[head] + nums[tail] == val){
                        res.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                        while (head < tail && nums[head] == nums[head+1]) head++;
                        while (head < tail && nums[tail] == nums[tail-1]) tail--;
                        head++;
                        tail--;
                    }else if(nums[head] + nums[tail] < val){
                        head++;
                    }else {
                        tail--;
                    }
                }
            }
        }
        return res;
    }

    public void testFilePath(){
    }

    public void testDate(){
        System.out.println(new Date());
    }

    /**
     * @description: leetcode 20
     * @param: [s]
     * @return: boolean
     * @author: Yukun Lee
     * @date: 2019-06-26
     */
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i< s.length() ; ++i){
            if(s.charAt(i)== '{' || s.charAt(i)== '[' || s.charAt(i)=='(' || st.empty()){
                st.push(s.charAt(i));
            }else {
                if(s.charAt(i)== ')' && st.peek()== '('||
                        s.charAt(i)== ']' && st.peek()== '['||
                        s.charAt(i)== '}' && st.peek()== '{'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.empty() ? true : false;
    }

    public  void testInsertArray(){
        System.out.println("------");
        ArrayList<Integer> ts = new ArrayList<>();
        for(int i = 0 ; i < 10 ; ++i){
            ts.add(i);
        }
        for(int i = 0 ; i < ts.size() ; ++i){
            if(i == 5){
                ts.add(i,100);
            }
        }
        for(int i = 0 ; i < ts.size() ; ++i){
            System.out.println(ts.get(i));
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode current = res;
        while (c1 != null && c2 != null){
            if (c1.val < c2.val){
                current.next = c1;
                current = c1;
                c1 = c1.next;
            }else {
                current.next = c2;
                current = c2;
                c2 = c2.next;
            }
        }
        if(c1 != null){
            current.next = c1;
        }else {
            current.next = c2;
        }
        return res.next;
    }

    /** 
     * @description: 26. Remove Duplicates from Sorted Array
     * @param: [nums] 
     * @return: int 
     * @author: Yukun Lee 
     * @date: 2019-07-22 
     */ 
    public int removeDuplicates(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < nums.length ; ++i){
            if(i == nums.length - 1 || nums[i] != nums[i+1]){
                nums[res++] = nums[i];
            }
        }
        return res;
    }



}//class
