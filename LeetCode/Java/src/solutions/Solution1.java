package solutions;

import com.sun.javafx.binding.StringFormatter;
import sun.plugin.javascript.navig.AnchorArray;
import utility.ListNode;
import utility.TreeNode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: LeetCode
 * @description: 1-50
 * @author: Yukun Lee
 * @create: 2019-08-19 11:20
 */
public class Solution1 {
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
        int mid1 = (s1 + e1) / 2, mid2 = (s2 + e2) / 2;
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

    public double findMedianSortedArrays_v1(int[] nums1, int[] nums2) {
        int index = 0 ,n1 = 0, n2 = 0;
        int[] res = new int[nums1.length + nums2.length];
        while (index < nums1.length + nums2.length){
            if(n1 == nums1.length){
                while(n2 != nums2.length){
                    res[index++] = nums2[n2++];
                }
                break;
            }
            if(n2 == nums2.length){
                while (n1 != nums1.length){
                    res[index++] = nums1[n1++];
                }
                break;
            }
            if (nums1[n1] <= nums2[n2]){
                res[index++] = nums1[n1++];
            }else {
                res[index++] = nums2[n2++];
            }
        }
        return res.length%2==0?(double)(res[res.length/2-1]+res[res.length/2])/2:(double)res[res.length/2];
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
    
    /** 
     * @description: 16. 3Sum Closest
     * @param: [nums, target] 
     * @return: int 
     * @author: Yukun Lee 
     * @date: 2019-07-23 
     */ 
    public int threeSumClosest(int[] nums, int target) {
        int a , b = 1, c = 2;
        int  len = Integer.MAX_VALUE;
        int  res = 0;
        for(a = 0 ; a < b ; ++a){
            for(b = a + 1 ; b < c ; ++b){
                for(c = b + 1 ; c < nums.length ; ++c){
                    if(Math.abs(nums[a] + nums[b] + nums[c] - target) < len){
                        len = Math.abs(nums[a] + nums[b] + nums[c] - target);
                        res = nums[a] + nums[b] + nums[c];
                    }
                }
            }
        }
        return res;
    }
    
    /** 
     * @description: 17. Letter Combinations of a Phone Number
     * @param: [digits] 
     * @return: java.util.List<java.lang.String> 
     * @author: Yukun Lee 
     * @date: 2019-07-23 
     */ 
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.length() == 0)return res;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();
        res.add("");
        for(int i = 0 ; i < len ; ++i){
            int index = Character.getNumericValue(digits.charAt(i));
            char[] arr = mapping[index].toCharArray();
            while (res.peek().length() == i){
                String mid = res.remove();
                for (char n : arr){
                    res.add(mid+n);
                }
            }
        }
        return res;
    }

    
    /** 
     * @description: 18. 4Sum
     * @param: [nums, target] 
     * @return: java.util.List<java.util.List<java.lang.Integer>> 
     * @author: Yukun Lee 
     * @date: 2019-07-25 
     */ 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        fourSum_Recursion(res, new ArrayList<>(),4, 0,target,nums);
        return res;
    }

    private void fourSum_Recursion(List<List<Integer>> res, List<Integer> temp, int count, int start, int target, int[] nums){
        if (target == 0 && count == 0){
            res.add(new ArrayList<>(temp));
        }else if (count > 0){
            for(int i = start ; i < nums.length ; i ++){
                if(i > 0 && nums[i-1] == nums[i] && i != start) continue;
                temp.add(nums[i]);
                fourSum_Recursion(res, temp, count-1, i+1, target-nums[i], nums);
                temp.remove(temp.size()-1);
            }
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode block = new ListNode(0);
        block.next = head;
        ListNode fast = block;
        ListNode slow = block;
        for(int i = 0 ; i <= n ; ++i){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return block.next;
    }
    
    /** 
     * @description: 22. Generate Parentheses
     * @param: [n] 
     * @return: java.util.List<java.lang.String> 
     * @author: Yukun Lee 
     * @date: 2019-07-25 
     */ 
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"", 0,0,n);
        return res;
    }

    public void backtrack(List<String> list,String str, int open, int close, int n){
        if(str.length() == n*2){
            list.add(str);
            return;
        }
        if(open < n ){
            backtrack(list, str+"(", open+1, close, n);
        }
        if(close < open){
            backtrack(list, str+")", open, close+1, n);
        }
    }

    
    /** 
     * @description: 24. Swap Nodes in Pairs
     * @param: [head] 
     * @return: utility.ListNode 
     * @author: Yukun Lee 
     * @date: 2019-07-26 
     */ 
    public ListNode swapPairs_v1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode block;
        ListNode pre = head.next;
        ListNode post = head;
        while (pre != null && post != null){
            post.next = pre.next;
            pre.next = post;

            block = pre;
            pre = post;
            post = block;

            if(pre.next != null){
                post = pre.next;
                pre = post.next;
            }else {
                break;
            }
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode block = new ListNode(0);
        block.next = head;
        ListNode cur = block;
        ListNode post;
        ListNode pre;
        while (cur.next != null && cur.next.next != null){
           post = cur.next;
           pre = cur.next.next;
           post.next = pre.next;
           pre.next = post;
           cur.next = pre;
           cur = cur.next.next;
        }
        return block.next;
    }

    /** 
     * @description: 23. Merge k Sorted Lists
     * @param: [lists] 
     * @return: utility.ListNode 
     * @author: Yukun Lee 
     * @date: 2019-07-29 
     */ 
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (true){
            ListNode node = minNode(lists);
            if(node == null){
                break;
            }
            cur.next = node;
            cur = node;
        }
        return res.next;
    }

    public ListNode minNode(ListNode[] lists){
        int index = -1;
        ListNode cur = null;
        for(int i = 0 ; i < lists.length ; ++i){
            if(cur == null){
                if (lists[i] == null){
                    continue;
                }else {
                    cur = lists[i];
                    index = i;
                }
            }else {
                if(lists[i] == null){
                    continue;
                }else {
                    if(lists[i].val < cur.val){
                        cur = lists[i];
                        index = i;
                    }else {
                        continue;
                    }
                }
            }
        }
        if(index>=0){
            lists[index] = lists[index].next;
        }
        return cur;
    }
    
    /**
     *  33. Search in Rotated Sorted Array
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length-1;
        int mid;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid]>nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        int rotate = left;
        int realmid;
        left = 0; right = nums.length-1;
        while(left <= right){
            mid = (left + right)/2;
            realmid = (mid + rotate)%nums.length;
            if(nums[realmid]<target){
                left = mid + 1;
            }else if(nums[realmid]> target){
                right = mid - 1;
            }else {
                return realmid;
            }
        }
        return -1;
    }
    
    /** 
     *  34. Find First and Last Position of Element in Sorted Array
     */
    public int[] searchRange_v1(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        int head = 0, tail = nums.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] < target) {
                head = mid + 1;
            } else if (nums[mid] > target) {
                tail = mid - 1;
            } else {
                res[0] = mid;
                break;
            }
        }
        if (res[0] == -1) {
            res[1] = -1;
            return res;
        }
        res[1] = res[0];
        while (res[0] > 0) {
            if (nums[res[0] - 1] == nums[res[0]]) {
                res[0]--;
            } else {
                break;
            }
        }
        while (res[1] < nums.length - 1) {
            if (nums[res[1] + 1] == nums[res[1]]) {
                res[1]++;
            } else {
                break;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums.length == 0) return res;
        int head = 0, tail = nums.length-1;
        while(head < tail){
            int mid = (head + tail)/2;
            if(nums[mid] < target){
                head = mid + 1;
            }else {
                tail = mid;
            }
        }
        if(nums[head] != target){
            return res;
        }
        res[0] = head;
        tail = nums.length-1;
        while(head < tail){
            int mid = (head + tail)/2+1;
            if(nums[mid] > target){
                tail = mid - 1;
            }else {
                head = mid;
            }
        }
        res[1] = tail;
        return res;
    }
    
    /** 
     * @description: 35. Search Insert Position
     * @param: [nums, target] 
     * @return: int 
     * @author: Yukun Lee 
     * @date: 2019-08-01 
     */ 
    public int searchInsert(int[] nums, int target) {
        int head = 0, tail = nums.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] < target) {
                head = mid + 1;
            } else if (nums[mid] > target) {
                tail = mid - 1;
            } else {
                return mid;
            }
        }
        return head;
    }
    
    /** 
     * @description: 30. Substring with Concatenation of All Words
     * @param: [s, words] 
     * @return: java.util.List<java.lang.Integer> 
     * @author: Yukun Lee 
     * @date: 2019-08-07 
     */ 
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0 || s.length() == 0 || words[0].length()*words.length>s.length()){
            return res;
        }
        int wordlen = words[0].length();
        int sumlen = words[0].length()*words.length;
        final Map<String, Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str,map.containsKey(str)?map.get(str)+1:1);
        }
        for (int i = 0 ; i <= s.length() - sumlen ; ++i){
            if(isSuitable(s.substring(i,i+sumlen), wordlen, new HashMap<>(map))){
                res.add(i);
            }

        }
        return res;
    }

    public boolean isSuitable(String str, int wordlen ,Map<String, Integer> map){
        for(int j = 0 ; j < str.length() ; ){
            String s = str.substring(j, j+wordlen);
            if(map.containsKey(s) && map.get(s)>0){
                map.put(s,map.get(s)-1);
            }else {
                return false;
            }
            j = j + wordlen;
        }
        return true;
    }

    /**
     * @description:  36. Valid Sudoku
     * @param: [board]
     * @return: boolean
     * @author: Yukun Lee
     * @create: 2019-08-02
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudoku = new HashSet<>(90);
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                char num = board[i][j];
                if(num != '.'){
                    if (!sudoku.add(num + " in row " + i)
                            || !sudoku.add(num + " in col " + j)
                            || !sudoku.add(num + " in cube " + i/3 + "-" + j/3)){
                        return false;
                    }
                }

            }
        }
        return true;
    }

    /**
     * 49. Group Anagrams
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        for (String raw : strs){
            boolean f = true;
            for (int j = 0 ; j < res.size() ; ++j){
                String s = res.get(j).get(0);
                if (isEqual(s,raw)){
                    res.get(j).add(raw);
                    f = false;
                    break;
                }
            }
            if (f){
                List<String> mid = new ArrayList<>();
                mid.add(raw);
                res.add(mid);
            }
        }
        return res;
    }

    public Boolean isEqual(String s, String raw){
        if (s.length() == raw.length()){
            for(int k = 0 ; k < s.length() ; k++){
                int index = raw.indexOf(s.charAt(k));
                if (index == -1){
                    return false;
                }else {
                    raw = raw.substring(0,index)
                            + (index == raw.length()-1? "" : raw.substring(index+1));
                }
            }
        }else {
            return false;
        }
        return true;
    }

    /**
     * 48. Rotate Image
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int[][] mid = new int[matrix.length][matrix.length];
        for(int i = 0 ; i < matrix.length ; i++){
            for (int j = 0; j < matrix.length ; j++){
                mid[j][matrix.length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix.length ; j++){
                matrix[i][j] = mid[i][j];
            }
        }
    }

    public void rotate_v1(int[][] matrix) {
        for(int i = 0 ; i < matrix.length/2 ; i++){
            int[] mid = matrix[i];
            matrix[i] = matrix[matrix.length - i -1];
            matrix[matrix.length - i -1] = mid;
        }
        for (int i = 0 ; i < matrix.length ; i++){
            for(int j = i+1 ; j < matrix.length ; j++){
                int mid = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = mid;
            }
        }
    }

    /**
     * 46. Permutations
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> arr = new LinkedList<>();
        for(int n : nums){
            arr.add(n);
        }
        permute_Recursion(arr, res, new ArrayList<>());
        return res;
    }

    private void permute_Recursion(List<Integer> arr, List<List<Integer>> res, List<Integer> mid){
        if (arr.size() == 0){
            res.add(new ArrayList<>(mid));
            return;
        }
        for(int i = 0 ; i < arr.size() ; ++i){
            int n = arr.get(i);
            mid.add(n);
            arr.remove(i);
            permute_Recursion(arr, res, mid);
            arr.add(i, n);
            mid.remove(mid.size()-1);
        }
    }

    /**
     * 47. Permutations II
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        permuteUnique_Recursion(nums, new boolean[nums.length], res, new ArrayList<>());
        return res;
    }

    private void permuteUnique_Recursion(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> mid){
        if(mid.size() == nums.length){
            res.add(new ArrayList<>(mid));
        }else {
            for(int i = 0 ; i < nums.length ; ++i){
                if (used[i] ||( i != 0 && nums[i] == nums[i-1] && used[i-1])) continue;
                mid.add(nums[i]);
                used[i] = true;
                permuteUnique_Recursion(nums, used, res, mid);
                mid.remove(mid.size()-1);
                used[i] = false;
            }
        }
    }

    /**
     * 39. Combination Sum
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 )return null;
        combinationSum_Recursion(res, new ArrayList<>(),0 , candidates, target);
        return res;
    }
    private void combinationSum_Recursion(List<List<Integer>> res, List<Integer> mid, int start, int[] candidates, int target){
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(mid));
            return;
        }
        for (int i = start ; i < candidates.length ; i++){
            mid.add(candidates[i]);
            combinationSum_Recursion(res, mid, i, candidates, target - candidates[i]);
            mid.remove(mid.size()-1);
        }
    }

    /**
     * 40. Combination Sum II
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 )return null;
        Arrays.sort(candidates);
        combinationSum2_Recursion(res, new ArrayList<>(),0 , candidates, target);
        return res;
    }
    private void combinationSum2_Recursion(List<List<Integer>> res, List<Integer> mid, int start, int[] candidates, int target){
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(mid));
            return;
        }
        for (int i = start ; i < candidates.length ; i++){
            if (i > start && candidates[i] == candidates[i-1]) continue;
            mid.add(candidates[i]);
            combinationSum_Recursion(res, mid, i+1, candidates, target - candidates[i]);
            mid.remove(mid.size()-1);
        }
    }

    /**
     * 43. Multiply Strings
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1 + n2];
        for(int i = n1-1 ; i >= 0 ; i--){
            for(int j = n2-1 ; j >= 0; j--){
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                num = res[i + j + 1] + num;
                res[i + j + 1] = num % 10;
                res[i + j] += num / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int n : res){
            if(sb.length() != 0 || n != 0)
            sb.append(n);
        }
        return sb.length() == 0 ? "0":sb.toString();
    }

    /**
     * 38. Count and Say
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder pre;
        for(int i = 1 ; i < n ; ++i ){
            int count = 1;
            pre = cur;
            cur = new StringBuilder();
            for(int j = 0, len = pre.length(); j < len ; j++){
                if(j < len - 1 && pre.charAt(j) == pre.charAt(j+1)){
                    count++;
                }else {
                    cur.append(count);
                    cur.append(pre.charAt(j));
                    count = 1;
                }
            }
        }

        return cur.toString();
    }

    /**
     * 31. Next Permutation
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums.length < 1) return;
        int index = nums.length - 2;
        while(index >= 0){
            if(nums[index] < nums[index+1]){
                for(int j = nums.length - 1 ; j >= 0 ; j--){
                    if(nums[j] > nums[index]){
                        int tmp = nums[index];
                        nums[index] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
                break;
            }
            index++;
        }
        for(int i = index + 1, j = nums.length - 1 ; i < j ; i++, j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public double Power(double base, int exponent) {
        if(base == 0 || base == 1)return base;
        if(exponent == 0) return 1;
        int res = 1;
        boolean flag = true;
        while(exponent != 0){
            res *= base;
            if(exponent > 0){
                exponent--;
            }else{
                exponent++;
                flag = false;
            }
        }
        return flag? res : 1/res;
    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        Arrays.sort(nums);
        while(left < right){
            if (nums[left] + nums[right] < target){
                left++;
            }else if (nums[left] + nums[right] > target){
                right--;
            }else {
                return new int[]{left, right};
            }
        }
        return new int[]{left, right};
    }

    public int[] twoSum_v1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int f = 0;
        while(l1 != null || l2 != null){
            int val = (l1== null?0:l1.val) + (l2==null?0:l2.val) + f;
            ListNode node = new ListNode(val % 10);
            f = val / 10;
            cur.next = node;
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (f != 0) cur.next = new ListNode(1);
        return dummy.next;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[26];
        int res = 0, cur = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            int c = s.charAt(i) - 'a';
            if (map[c] > 0){
                res = Math.max(res, cur);
                cur = 1;
                Arrays.fill(map, 0);
                map[c]++;
            }else {
                map[c]++;
                cur++;
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring_v1(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0, cur = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            int c = s.charAt(i);
            if (map.getOrDefault(c, 0) > 0){
                res = Math.max(res, cur);
                cur = 1;
                map.clear();
                map.put(c, 1);
            }else {
                map.put(c, 1);
                cur++;
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring_v2(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0, cur = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            int c = s.charAt(i);
            if (map.containsKey(c)){
                cur = Math.max(map.get(c), cur);
            }
            map.put(c, i);
            res = Math.max(res, i-cur);
        }
        return res;
    }


    public double findMedianSortedArrays_v2(int[] nums1, int[] nums2) {
        int mid = (nums1.length + nums2.length);
        int f = mid % 2;
        mid >>= 1;
        if(f == 1)mid++;
        double res = 0;
        for (int i = 0, j = 0;;) {
            int num;
            if (j == nums2.length || i < nums1.length && nums1[i] < nums2[j]){
                num = nums1[i++];
            }else {
                num = nums2[j++];
            }
            if(i + j == mid){
                if (f == 0){
                    res += num; f++; mid++;
                } else {
                    res = res > 0? (res + num)/2: num;
                    break;
                }
            }
        }
        return res;
    }


    public String longestPalindrome_v1(String s) {
        int len = s.length();
        if (len <= 0)return s;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i < len; i++) {
            int n = dp[i-1];
            if (i-n-1 >=0 && s.charAt(i-n-1) == s.charAt(i)){
                dp[i] = dp[i-1]+2;
            } else if ( s.charAt(i-1) == s.charAt(i) && (dp[i-1]==1 || dp[i-1] == dp[i-2]+1)){
                dp[i] = dp[i-1]+1;
            } else {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == res){
                return s.substring(i - dp[i]+1, i+1);
            }
        }
        return s;
    }

    public String longestPalindrome_v2(String s) {    //最长公共子串
        int len = s.length();
        if (len == 0)return s;
        String reverse = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[len][len];
        int max = 0, index = 0;
        for (int i = 0; i < len ; i++){
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == reverse.charAt(j)){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                }
                if (dp[i][j] > max){
                    int pre = len - i - 1;
                    if (pre + dp[i][j] -1 == j){
                        max = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        return s.substring(index - max + 1, index+1);
    }

    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            int val = x % 10;
            x /= 10;
            res = res * 10 + val;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }
        return (int) res;
    }

    public int myAtoi(String str) {
        HashMap<String, String[]> map = new HashMap<>();
        map.put("start", new String[]{"start", "signed", "in_number", "end"});
        map.put("signed", new String[]{"end", "end", "in_number", "end"});
        map.put("in_number", new String[]{"end", "end", "in_number", "end"});
        map.put("end", new String[]{"end", "end", "end", "end"});

        String state = "start";
        long res = 0, sign = 1;
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            state = map.get(state)[get_col(c)];
            if (state.equals("signed") && c == '-'){
                sign = -1;
            }
            if (state.equals("in_number")){
                res = res * 10 + c - '0';
                if (res * sign > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if (res * sign < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int)(res * sign);
    }

    private int get_col(char c) {
        if (c == ' ') return 0;
        if (c == '+' || c == '-') return 1;
        if (c >= '0' && c <= '9') return 2;
        return 3;
    }

    public boolean isPalindrome_v1(int x) {
        if (x < 0)return false;
        ArrayList<Integer> list = new ArrayList<>();
        while(x != 0){
            int n = x % 10;
            x = x /10;
            list.add(n);
        }
        for (int i = 0 ,j = list.size()-1; i < j ; i++, j--) {
            if (!list.get(i).equals(list.get(j))){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_v2(int x) {
        if (x < 0)return false;
        long val = 0, pre = x;
        while(x != 0){
            int n = x % 10;
            x = x /10;
            val = val*10 + n;
        }
        return val == pre;
    }

    public boolean isPalindrome_v3(int x) {
        if (x < 0)return false;
        int val = 0;
        while(x > val){
            val = val*10 + x % 10;
            x = x /10;
        }
        return x == val || x == val / 10;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)return res;
        ArrayList<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 0, pre = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp.add(node.val);
            pre--;
            if (node.left != null){
                queue.offer(node.left); cur++;
            }
            if (node.right != null){
                queue.offer(node.right); cur++;
            }
            if (pre == 0){
                res.add(new ArrayList<>(temp));
                temp.clear();
                pre = cur;
                cur = 0;
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder_v1(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)return res;
        ArrayList<Integer> temp;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 0, pre = 1;
        while(!queue.isEmpty()){
            temp = new ArrayList<>();
            while(pre > 0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                pre--;
                if (node.left != null){
                    queue.offer(node.left); cur++;
                }
                if (node.right != null){
                    queue.offer(node.right); cur++;
                }
            }
            pre = cur; cur = 0;
            res.add(temp);
        }
        return res;
    }

    public List<List<Integer>> levelOrder_v2(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            levelOrder_hepler(res, root, 0);
        }
        return res;
    }
    private void levelOrder_hepler(ArrayList<List<Integer>> res, TreeNode root, int deepth){
        if (root == null)return;
        if (res.size() <= deepth){
            res.add(new ArrayList<>());
        }
        res.get(deepth).add(root.val);
        levelOrder_hepler(res, root.left, deepth+1);
        levelOrder_hepler(res, root.right, deepth+1);
    }

    public int threeSumClosest_v1(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0, len = nums.length; i < len - 2 ; ++i){
            int head = i + 1, tail = len - 1;
            while (head < tail){
                int tmp = nums[head] + nums[tail] + nums[i];
                if (Math.abs(target - res) > Math.abs(target - tmp)){ res = tmp; }
                if(tmp == target){
                    return target;
                }else if(tmp < target){
                    head++;
                }else {
                    tail--;
                }
            }
        }
        return res;
    }

    public List<String> letterCombinations_v1(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");map.put('3', "def");
        map.put('4', "ghi");map.put('5', "jkl");map.put('6', "mno");
        map.put('7', "pqrs");map.put('8', "tuv");map.put('9', "wxyz");
//        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<>();
        res.add("");
        for (int i = 0, len = digits.length(); i < len; i++) {
            String str = map.get(digits.charAt(i));
//            String str = mapping[digits.charAt(i) - '0'];
            int cur = 0, res_len = res.size();
            for (Iterator<String> iterator = res.listIterator(); iterator.hasNext() && cur < res_len; cur++) {
                String temp = iterator.next();
                for (int k = 0, str_len = str.length(); k < str_len; k++) {
                    res.add(temp + str.charAt(k));
                }
                iterator.remove();
            }

        }
        return res;
    }

    public List<String> letterCombinations_v2(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.length() == 0)return res;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0, len = digits.length(); i < len; i++) {
            String str = mapping[digits.charAt(i) - '0'];
            for (int j = 0, res_len = res.size(); j < res_len; j++) {
                String tmp = res.pollFirst();
                for (int k = 0, str_len = str.length(); k < str_len; k++) {
                    res.add(tmp + str.charAt(k));
                }
            }
        }
        return res;
    }

    public ListNode removeNthFromEnd_v1(ListNode head, int n) {
        if (head == null)return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public boolean isValid_v1(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (st.isEmpty() || c == '(' || c == '[' || c == '{'){
                st.push(c);
            }else {
                if (Math.abs(c - st.pop()) > 2){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }


    public ListNode mergeTwoLists_v1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while(l1 != null && l2!= null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }else {
            cur.next = l2;
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists_v2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists_v2(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists_v2(l1, l2.next);
            return l2;
        }
    }

    public List<String> generateParenthesis_1(int n) {
        LinkedList<String> res = new LinkedList<>();
        if (n < 1)return res;
        generateParenthesis_hepler(res, new StringBuilder("("), n-1, n);
        return res;
    }
    private void generateParenthesis_hepler(LinkedList<String> res, StringBuilder tmp, int left, int right){
        if (left>right) return;
        if (left == 0 && right == 0) {
            res.offer(tmp.toString());
            return;
        }
        if (left != 0){
            generateParenthesis_hepler(res, tmp.append('('), left-1, right);
            tmp.deleteCharAt(tmp.length()-1);
        }
        if (right != 0){
            generateParenthesis_hepler(res, tmp.append(')'), left, right-1);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }

    private boolean parenthesisValidate(String str){
        Stack<Character> st = new Stack<>();
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            if (st.isEmpty() || c == '('){
                st.push(c);
            }else {
                if (st.pop() != '('){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public ListNode mergeKLists_v1(ListNode[] lists) {
        if (lists.length == 0 )return null;
        return mergeKLists_v1_helper(lists, 0, lists.length-1);
    }

    private ListNode mergeKLists_v1_helper(ListNode[] lists, int left , int right){
        if (left >= right){
            return lists[left];
        }
        ListNode l1 = mergeKLists_v1_helper(lists, (left + right)/2+1 , right);
        ListNode l2 = mergeKLists_v1_helper(lists, left, (left+ right)/2);
        return mergeTwoLists(l1,l2);
    }

//    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null){
//            return l2;
//        }
//        if (l2 == null){
//            return l1;
//        }
//        if (l1.val < l2.val){
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }

    public ListNode swapPairs_v2(ListNode head) {
        if (head == null)return null;
        ListNode dummy = new ListNode(0),
                cur = dummy, fast = head.next, slow = head;
        while(fast != null){
            cur.next = fast;
            slow.next = fast.next;
            fast.next = slow;
            cur = cur.next.next;

        }
        return dummy.next;
    }

    public ListNode swapPairs_v3(ListNode head) {
        if (head == null)return null;
        ListNode dummy = new ListNode(0),
                cur = head, pre = dummy;
        dummy.next = head;
        head = head.next;
        boolean f = true;
        while(head != null){
            if (f){
                cur.next = head.next;
                pre.next = head;
                head.next = cur;
                head = cur.next;
                pre = pre.next;
            }else {
                cur = cur.next;
                pre = pre.next;
                head = head.next;
            }
            f = !f;
        }
        return dummy.next;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0),
                cur = dummy, pre = head, post = head;
        while(post != null){
            for (int i = 1; i < k && post != null; i++) {
                post = post.next;
            }
            if (post == null) {
                cur.next = pre;
                break;
            }
            ListNode tmp = post.next;
            post.next = null;
            printLinkedList(pre);
            cur.next = reverseList(pre);
            printLinkedList(pre);
            printLinkedList(cur);
            cur = pre;
            pre = tmp;
            post = tmp;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode left = null, right = head;
        while(right != null){
            ListNode tmp = right.next;
            right.next = left;
            left = right;
            right =tmp;
        }
        return left;
    }

    private void printLinkedList(ListNode head){
        ListNode tmp = head;
        while(tmp != null){
            System.out.print(tmp.val + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public int removeDuplicates_v1(int[] nums) {
        int count = 0;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] == nums[i-1]){
                int tmp = 0;
                while (i > 0 && nums[i] == nums[i-1]){
                    count++;
                    i--;
                    tmp++;
                }
                System.arraycopy(nums, i + tmp, nums, i, nums.length - count - i);
            }
        }
        return nums.length - count;
    }

    public int removeDuplicates_v2(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; i++, j++) {
            while(j < nums.length-1 && nums[j] == nums[j+1]){
                j++;
            }
            nums[i] = nums[j];
        }
        return i;
    }

    public int removeDuplicates_v3(int[] nums) {
        if (nums.length == 0)return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) i++;
            nums[i] = nums[j];
        }
        return i+1;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0, len = haystack.length(),len_nd = needle.length(); i < len - len_nd; i++) {
            int  j = 0;
            for (j = i; j < len_nd; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))break;
            }
            if (j == len_nd)return i;
        }
        return -1;
    }

    public void nextPermutation_v1(int[] nums) {
        for (int i = nums.length-1; i >= 0 ; i--) {
            if (i == 0 || nums[i-1] < nums[i]){
                if (i == 0){
                    Arrays.sort(nums);
                    return;
                }
                for (int j = nums.length-1; j >= i ; j--) {
                    if (nums[j] > nums[i-1]){
                        int tmp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = tmp;
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
    }

    public int divide(int dividend, int divisor) {
        int sign = 1;
        int res = 0;
        if (dividend < 0){
            dividend = -dividend;
            sign = -sign;
        }
        if (divisor < 0){
            divisor = -divisor;
            sign = -sign;
        }
        while(dividend >= divisor){
            dividend -= divisor;
            res ++;
        }
        if (res == Integer.MIN_VALUE && sign < 0){
            return Integer.MAX_VALUE;
        }
        return sign > 0 ? res : -res;
    }

    public int divide_v1(int dividend, int divisor) {
        int sign = 1;
        long dividend_tmp = dividend, divisor_tmp = divisor, res = 0;
        if (dividend_tmp < 0){
            dividend_tmp = -dividend_tmp;
            sign = -sign;
        }
        if (divisor_tmp < 0){
            divisor_tmp = -divisor_tmp;
            sign = -sign;
        }
        if (dividend_tmp < divisor_tmp)return 0;

        while(dividend_tmp >= divisor_tmp){
            if (res == 0) {
                res++;
            } else {
                res <<= 1;
            }
            divisor_tmp <<= 1;
        }
        divisor_tmp >>= 1;
        dividend_tmp = dividend_tmp - divisor_tmp;
        dividend_tmp = dividend < 0 ?-dividend_tmp : dividend_tmp;
        res = (sign > 0? res:-res)
                + divide_v1((int) dividend_tmp, divisor);
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            res = Integer.MAX_VALUE;
        }
        return (int) res;
    }

    public int longestValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int res = 0;
        for (int i = 0, count = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (st.isEmpty() || c == '('){
                st.push(c);
            }else {
                if (st.peek() == '('){
                    count += 2;
                    res = Math.max(res, count);
                    st.pop();
                }else{
                    st.push(c);
                    count = 0;
                }
            }
        }
        return res;
    }

    public int longestValidParentheses_v1(String s) {
        Stack<Integer> st = new Stack<>();
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0, count = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '('){
                st.push(i);
            }else {
                if(st.isEmpty())continue;
                int index = st.pop();
                dp[i] = 2 + (index > 0 ? dp[index-1] : 0);
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }

    public int longestValidParentheses_v2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }


    public int search_v1(int[] nums, int target) {
        if(nums.length == 0)return -1;
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)>>2;
            if (target == nums[mid])return mid;
            if (nums[mid] > nums[left]){
                if (target < nums[mid] && target >= nums[left]){
                    right = mid -1;
                }else  {
                    left = mid + 1;
                }
            }else {
                if ( target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }


    public int[] searchRange_V1(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0 , right = nums.length-1;
        double tar = target - 0.5;
        while(left <= right){
            int mid = (left + right)>>1;
            double cur = nums[mid];
            if (cur > tar){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        res[0] = left;
        left = 0;  right = nums.length-1;
        tar = target + 0.5;
        while(left <= right){
            int mid = (left + right)>>1;
            double cur = nums[mid];
            if (cur > tar){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        res[1] = right;
        if (res[0] > res[1]){
            res[0] = -1; res[1] = -1;
        }
        return res;
    }

    public int[] searchRange_V2(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0 , right = nums.length-1;
        while(left <= right){    //左边界
            int mid = (left + right)>>1;
            if (target <= nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target){
            return res;
        }
        res[0] = left;
        left = 0; right = nums.length-1;
        while(left <= right){  //右边界
            int mid = (left + right)>>1;
            if (target >=  nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }

    public int searchInsert_v1(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if (target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return left;
    }

    public boolean isValidSudoku_v1(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                char c= board[i][j];
                if (set.contains(c)){
                    return false;
                }
                if(c != '.')set.add(c);
            }
        }
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                char c= board[j][i];
                if (set.contains(c)){
                    return false;
                }
                if(c != '.')set.add(c);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.clear();
                for (int k = i * 3; k < (i+1) * 3; k++) {
                    for (int l = j * 3; l < (j+1) * 3; l++) {
                        char c= board[k][l];
                        if (set.contains(c)){
                            return false;
                        }
                        if(c != '.')set.add(c);
                    }
                }
            }
        }
        return true;
    }


    public String countAndSay_v1(int n) {
        if (n <= 0) return "";
        StringBuilder res = new StringBuilder();
        res.append(1);
        for (int i = 1; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0, len = res.length(); j < len; j++) {
                int count = 1;
                while(j < len -1 && res.charAt(j) == res.charAt(j+1)) {
                    count++; j++;
                };
                tmp.append(count);
                tmp.append(res.charAt(j));
            }
            res = tmp;
        }
        return res.toString();
    }

    public List<List<Integer>> combinationSum_v1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum_v1_helper(res, new ArrayList<>(), 0, candidates, target, 0);
        return res;
    }
    
    private void combinationSum_v1_helper(List<List<Integer>> list, List<Integer> tmp, int index, int[] candidates, int target, int count){
        if (count > target)return;
        if (count == target){
            list.add(new ArrayList<>(tmp));
        }
        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            combinationSum_v1_helper(list, tmp, i, candidates, target, count+candidates[i]);
            tmp.remove(tmp.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2_v1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2_v1_helper(res, new ArrayList<>(), 0, candidates, target);
        return res;
    }
    private void combinationSum2_v1_helper(List<List<Integer>> list, List<Integer> tmp, int index, int[] candidates, int target){
        if (target < 0)return;
        if (target == 0){
            list.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i-1])continue;
            tmp.add(candidates[i]);
            combinationSum2_v1_helper(list, tmp, i+1, candidates, target-candidates[i]);
            tmp.remove(tmp.size()-1);
        }
    }

    public void solveSudoku(char[][] board) {
        solveSudoku_helper(board, 0, 0);
    }
    private boolean solveSudoku_helper(char[][] board, int row, int col){
        if (row > 8 || col > 8)return true;
        for (int i = row; i < 9; i++) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.')continue;
                Set<Character> set = getCandidates(board, i, j);
                if (set.size() == 0)return false;
                for (char c : set) {
                    board[i][j] = c;
                    if (solveSudoku_helper(board, j == 8? i+1 : i, j==8?0:j+1))return true;
                }
                board[i][j] = '.';
                return false;
            }
        }
        return false;
    }
    private Set<Character> getCandidates(char[][] board, int row, int col){
        Set<Character> set = new HashSet<>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.'){
                if (set.size() == 0)return set;
                set.remove(board[row][i]);
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.'){
                if (set.size() == 0)return set;
                set.remove(board[i][col]);
            }
        }
        for (int i = (row/3)*3; i < (row/3+1)*3; i++) {
            for (int j = (col/3)*3; j <(col/3+1)*3 ; j++) {
                if (board[i][j] != '.'){
                    if (set.size() == 0)return set;
                    set.remove(board[i][j]);
                }
            }
        }
        return set;
    }


    public int firstMissingPositive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 1;
        for (int n: set){
            if (n <= 0)continue;
            if (n >= res)res = n+1;
            else break;
        }
        return res;
    }

    public int firstMissingPositive_v1(int[] nums) {
        int res = 1;
        for (int n : nums) {
            if (n <= 0)continue;
            if (n == res)res++;
        }
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] <= 0)continue;
            if (nums[i] == res)res++;
        }
        return res;
    }

    public int firstMissingPositive_v2(int[] nums) {
        int[] map = new int[nums.length];
        for (int n : nums) {
            if (n <= 0 || n > nums.length)continue;
            map[n-1]++;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0)return i+1;
        }
        return nums.length+1;
    }

    public int firstMissingPositive_v3(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)res = 1;
            if (nums[i] < 1 || nums[i] > nums.length)nums[i] = 1;
        }
        if (res == 0)return 1;
        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0 && nums[nums[i]-1] > 0){
//                nums[nums[i]-1] = -nums[nums[i]-1];
//            }else if (nums[i] < 0 && nums[-nums[i]-1] > 0){
//                nums[-nums[i]-1] = -nums[-nums[i]-1];
//            }
            int tmp = Math.abs(nums[i])-1;
            nums[tmp] = -Math.abs(nums[tmp]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)return i+1;
        }
        return nums.length+1;
    }


    private int len = 0;
    public int diameterOfBinaryTree_v1(TreeNode root) {
        if (root == null)return 0;
        diameterOfBinaryTree_hepler(root);
        return len;
    }
    private int diameterOfBinaryTree_hepler(TreeNode root){
        if (root == null)return 0;
        int left = diameterOfBinaryTree_hepler(root.left);
        int right = diameterOfBinaryTree_hepler(root.right);
        len = Math.max(len, right + right);
        return Math.max(left, right)+1;
    }

    public int trap(int[] height) {
        int res = 0;
        int tmp = 0;
        while(true){
            for (int i = 0, j = -1; i < height.length; i++) {
                if (height[i] != 0){
                    if (j >= 0){
                        tmp += i-j-1;
                    }
                    j = i;
                }
            }
            res += tmp;
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > 0){
                    height[i]--;
                    max = 1;
                }
            }
            if (max == 0)break;
            tmp = 0;
        }
        return res;
    }

    public int trap_V1(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int left = -1, right = -1;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }
            for (int j = i+1; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            left = Math.min(left, right);
            if (left < height[i])continue;
            res += left - height[i];
        }
        return res;
    }

    public int trap_V2(int[] height) {
        int res = 0;
        int[] dp_left = new int[height.length], dp_right = new int[height.length];
        for (int j = 0; j < height.length; j++) {
            dp_left[j] = Math.max(height[j], j > 0 ? dp_left[j-1]:0);
        }
        for (int j = height.length-1; j >= 0; j--) {
            dp_right[j] = Math.max(height[j], j < height.length-1? dp_right[j+1]:0);
        }
        for (int i = 0; i < height.length; i++) {
            int tmp = Math.min(i > 0?dp_left[i-1]:0, i<height.length-1?dp_right[i+1]:0);
            if (tmp < height[i])continue;
            res += tmp - height[i];
        }
        return res;
    }

    public int trap_V3(int[] height) {
        int left = height.length > 0?height[0]:0, right = height.length > 0?height[height.length-1]:0, res = 0;
        for (int i = 0, j = height.length-1; i < j;) {
            if (left <= right){
                left = Math.max(left, height[i]);
                res += left - height[i++];
            }else {
                right = Math.max(right, height[j]);
                res += right - height[j--];
            }
        }
        return res;
    }


    public String multiply_v1(String num1, String num2) {
        int len = num1.length()+ num2.length();
        StringBuilder sb = new StringBuilder(len);
        int carry = 0;
        for (int i = 0; i < len-1; i++) {
            int tmp = 0;
            for (int j = 0; j < i && j < num1.length()-1; j++) {
                for (int k = 0; k < i && k < num2.length()-1; k++) {
                    if (j + k == i-1){
                        int n1 = num1.charAt(num1.length()-j-1) ,n2 = num2.charAt(num2.length()-k-1);
                        n1 = n1 - '0'; n2 = n2 - '0';
                        tmp  += n1 * n2;
                    }
                }
            }
            tmp += carry;
            carry = tmp / 10;
            sb.append(tmp % 10);
        }
        if (carry != 0){
            sb.append(carry);
        }
        int index = sb.length() - 1;
        while(sb.charAt(index) == '0')index--;
        sb.delete(index+1,sb.length());
        return sb.reverse().toString();
    }

    public String multiply_v2(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                res[i+j] += (num1.charAt(len1 - i - 1)-'0') * (num2.charAt(len2 - j -1)-'0');
                res[i+j+1] += res[i+j] / 10;
                res[i+j] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len1 + len2 - 1, f = 0; i >= 0 ; i--) {
            if (f != 0 || res[i] != 0) {
                f = 1;
                sb.append(res[i]);
            }
        }
        if (sb.length() == 0)sb.append(0);
        return sb.toString();
    }

    public int jump(int[] nums) {
        int res = 0, next = 0, cur = 0;
        for (int i = 0, len = nums.length; i < len -1 ; i++) {
            if (i == cur){
                cur = next;
                res++;
            }
            next = Math.max(next, i + nums[i]);
        }
        return res;
    }

    public List<List<Integer>> permute_v1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute_v1_helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    private void permute_v1_helper(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums, boolean[] flag){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]){
                tmp.add(nums[i]);
                flag[i] = true;
                permute_v1_helper(res, tmp, nums, flag);
                tmp.remove(tmp.size()-1);
                flag[i] = false;
            }
        }
    }


    public List<List<Integer>> permuteUnique_v1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permuteUnique_v1_helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    private void permuteUnique_v1_helper(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums, boolean[] flag){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] || i != 0 && nums[i] == nums[i-1] && !flag[i-1])continue;
            tmp.add(nums[i]);
            flag[i] = true;
            permuteUnique_v1_helper(res, tmp, nums, flag);
            tmp.remove(tmp.size()-1);
            flag[i] = false;
        }
    }


    public void rotate_v2(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int j = 0; j < len/2; j++) {
            for (int i = 0; i < len; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = tmp;
            }
        }
    }


    public List<List<String>> groupAnagrams_v1(String[] strs) {
        if (strs.length == 0)return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder(s.length()*2);
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            map.get(key);
            if (!map.containsKey(key))map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

















}//class
