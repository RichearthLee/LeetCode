package solutions;

import utility.ListNode;

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

        return null;
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
     * @description: 33. Search in Rotated Sorted Array
     * @param: [nums, target] 
     * @return: int 
     * @author: Yukun Lee 
     * @date: 2019-07-30 
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
     * @description: 34. Find First and Last Position of Element in Sorted Array
     * @param: [nums, target] 
     * @return: int[] 
     * @author: Yukun Lee 
     * @date: 2019-08-01 
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
        boolean res = false;
        
        return res;
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




}//class
