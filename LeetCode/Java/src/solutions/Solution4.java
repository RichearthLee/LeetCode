package solutions;

import utility.ListNode;
import utility.TreeNode;

import javax.swing.*;
import java.util.*;

public class Solution4 {

    public boolean wordBreak(String s, List<String> wordDict){
        if (s.length() == 0)return true;
        for (int i = 0, len = s.length(); i < len; i++) {
            String str = s.substring(0, i);
            if (wordDict.contains(str) && wordBreak(s.substring(i), wordDict)){
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak_v1(String s, List<String> wordDict) {
        return word_Break_v1(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break_v1(String s, Set<String> wordDict, int start, Boolean[] f) {
        if (start == s.length()) {
            return true;
        }
        if(f[start] != null){
            return f[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break_v1(s, wordDict, end, f)) {
                return f[start] = true;
            }
        }
        return f[start] = false;
    }

    //dp
    public boolean wordBreak_v2(String s, List<String> wordDict) {
        HashSet<String> wordDictSet=new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak_v3(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] array = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            array[prerequisite[0]] = 1;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 1){
                    for (int[] prerequisite : prerequisites) {
                        if (prerequisite[0] == j && array[prerequisite[1]] == 0) {
                            array[j] = 0;
                            break;
                        }
                    }
                }
            }
        }
        for (int n :
                array) {
            if (n == 1)return false;
        }
        return true;
    }

    HashSet<Integer> saved = new HashSet<>();
    public boolean canFinish_v1(int numCourses, int[][] prerequisites) {
        Arrays.sort(prerequisites, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < prerequisites.length; i++) {
            if (!saved.contains(prerequisites[i][0])){
                int index = prerequisites[i][1];
                HashSet<Integer> tmp = new HashSet<>(prerequisites.length);
                tmp.add(prerequisites[i][0]);
                while(true){
                    index = binarySearch_2d(prerequisites, index);
                    if (index < 0 ){
                        saved.addAll(tmp);
                        break;
                    }
                    if (tmp.contains(index)){
                        return false;
                    }
                    tmp.add(prerequisites[index][0]);
                    index = prerequisites[index][1];
                }
            }
        }
        return true;
    }

    private int binarySearch_2d(int[][] array, int key){
        int left = 0, right = array.length-1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if (array[mid][0] < key){
                left = mid+1;
            }else if (array[mid][0] > key){
                right = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public boolean canFinish_v2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacent = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjacent.add(new ArrayList<>());
        int[] flag = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacent.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++) {
            if(canFinish_v2_dfs(adjacent, flag, i)) return false;
        }
        return true;
    }
    private boolean canFinish_v2_dfs(List<List<Integer>> adjacent, int[] flags, int i) {
        if(flags[i] == 1) return true;
        if(flags[i] == -1) return false;
        flags[i] = 1;
        for(Integer j : adjacent.get(i))
            if(canFinish_v2_dfs(adjacent, flags, j)) return true;
        flags[i] = -1;
        return false;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)return null;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode fast = head, slow = head;
        int index = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            index++;
        }
        if (fast == null)index--;
        while(slow != null){
            list.add(0, slow);
            slow = slow.next;
        }
        fast = head;
        for (int i = 0; i <= index; i++) {
            if (fast.val != list.get(i).val)return false;
            fast = fast.next;
        }
        return true;
    }

    public boolean isPalindrome_v1(ListNode head) {
        ListNode fast = head, slow = head;
        int index = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            index++;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = null;
        while(slow != null){
            dummy.next = slow;
            fast = slow.next;
            slow.next = cur;
            cur = slow;
            slow = fast;
        }
        cur = dummy.next;
        slow = head;
        for (int i = 0; i < index; i++) {
            if (cur.val != slow.val)return false;
            slow = slow.next;
            cur = cur.next;
        }
        return true;
    }

    public void moveZeroes(int[] nums) {
        if (nums.length < 1)return;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public void moveZeroes_v1(int[] nums) {
        if (nums.length < 1)return;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[cur++] = nums[i];
            }
        }
        for (int i = cur; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes_v2(int[] nums) {
        if (nums.length < 1)return;
        for (int i = 0, cur = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int tmp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = tmp;
                cur++;
            }
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)return 0;
        return pathSum_helper(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSum_helper(TreeNode root, int sum, int count){
        if (root == null)return 0;
        count += root.val;
        int res = 0;
        if (count == sum){
            res++;
        }
        res += pathSum_helper(root.left, sum , count);
        res += pathSum_helper(root.right, sum, count);
        return res;
    }


    public int pathSum_v1(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSum_v1_helper(root, sum, 0, map);
    }

    private int pathSum_v1_helper(TreeNode root, int sum, int count, Map<Integer, Integer> map){
        if (root == null)return 0;
        count += root.val;
        int res = map.getOrDefault(count - sum, 0);
        map.put(count, map.getOrDefault(count, 0) + 1);
        res += pathSum_v1_helper(root.left, sum , count, map);
        res += pathSum_v1_helper(root.right, sum, count, map);
        map.put(count, map.get(count)-1);
        return res;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int n : nums) {
            tmp[n-1]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (tmp[i] == 0){
                res.add(i+1);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers_v1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1){
                int tmp = nums[i];
                if (nums[tmp-1] == tmp){
                    nums[i] = 0;
                    continue;
                }
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                res.add(i+1);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers_v2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            res.add(n);
        }
        Arrays.fill(nums, 0);
        for (int n : res) {
            nums[n-1] = n;
        }
        res.clear();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                res.add(i+1);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers_v3(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            nums[index] = nums[index] > 0 ? -nums[index] : nums[index];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        while (z != 0) {
//            if ((z & 1) == 1){
//                res++;
//            }
            res++;
            //z >>>= 1;
            z &= z - 1;
        }
        //Integer.bitCount(x ^ y);
        return res;
    }

    public TreeNode convertBST(TreeNode root) {
        convertBST_helper(root, 0);
        return root;
    }

    private int convertBST_helper(TreeNode root, int val){
        if (root == null)return 0;
        root.val += val;
        root.val += convertBST_helper(root.right, val);
        return root.val - val + convertBST_helper(root.left, root.val);
    }

    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)return 0;
        res = Math.max(res, diameterOfBinaryTree_helper(root.left) + diameterOfBinaryTree_helper(root.right));
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return res;
    }

    private int diameterOfBinaryTree_helper(TreeNode root){
        if (root == null)return 0;
        return Math.max(diameterOfBinaryTree_helper(root.left), diameterOfBinaryTree_helper(root.right))+1;
    }


    public int diameterOfBinaryTree_V1(TreeNode root) {
        if (root == null)return 0;
        diameterOfBinaryTree_V1_helper(root);
        return res;
    }

    private int diameterOfBinaryTree_V1_helper(TreeNode root){
        if (root == null)return 0;
        int left = diameterOfBinaryTree_V1_helper(root.left);
        int right = diameterOfBinaryTree_V1_helper(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right)+1;
    }

    /**
     * 581. 最短无序连续子数组
     * @param nums int[]
     * @return nums
     */
    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            if (nums[left] <= nums[left+1]){
                left++;
            }else {
                break;
            }
        }
        while(left < right){
            if (nums[right] >= nums[right-1]){
                right--;
            }else {
                break;
            }
        }
        if (left == right)return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < left; i++) {
            if (nums[i] > min){
                left = i;
                break;
            }
        }
        for (int i = nums.length-1; i >= right; i--) {
            if (nums[i] < max){
                right = i;
                break;
            }
        }
        return (right - left)+ 1;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)return null;
        if (t1 != null && t2 != null){
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right  = mergeTrees(t1.right, t2.right);
            t1.val += t2.val;
        }else if (t1 == null){
            t2.left = mergeTrees(null, t2.left);
            t2.right = mergeTrees(null, t2.right);
            return t2;
        }else {
            t1.left = mergeTrees(t1.left, null);
            t1.right = mergeTrees(t1.right, null);
        }
        return t1;
    }

    public TreeNode mergeTrees_v1(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return t1;
        }
        if (t1 == null){
            return t2;
        }
        t1.left = mergeTrees_v1(t1.left, t2.left);
        t1.right  = mergeTrees_v1(t1.right, t2.right);
        t1.val += t2.val;
        return t1;
    }


    public TreeNode mergeTrees_v2(TreeNode t1, TreeNode t2) {
        if (t1 == null)return t2;
        if (t2 == null) return t1;
        LinkedList<TreeNode[]> queue = new LinkedList<>();
        queue.push(new TreeNode[]{t1, t2});
        while(!queue.isEmpty()){
            TreeNode[] nodes = queue.poll();
            nodes[0].val += nodes[1].val;
            if (nodes[0].left == null){
                nodes[0].left = nodes[1].left;
            }else if (nodes[1].left != null){
                queue.push(new TreeNode[]{nodes[0].left, nodes[1].left});
            }
            if (nodes[0].right == null){
                nodes[0].right = nodes[1].right;
            }else if (nodes[1].right != null){
                queue.push(new TreeNode[]{nodes[0].right, nodes[1].right});
            }
        }
        return t1;
    }


    class MinStack {

        /** initialize your data structure here. */
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
            if (s2.isEmpty() || s2.peek() >= x){
                s2.push(x);
            }
        }

        public void pop() {
            int x = s1.pop();
            if (x == s2.peek()){
                s2.pop();
            }
        }

        public int top() {
            return s1.peek();
        }

        public int getMin() {
            return s2.peek();
        }

    }

    public int minStep(int[] nums){
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boolean f = true;
            for (int j = i+1; j < i+nums[i] && j < nums.length; j++) {
                if (dp[j] == 0){
                    if (f){
                        dp[j] = dp[j-1]+1;
                        f = false;
                    }else {
                        dp[j] = dp[j-1];
                    }
                }
            }
        }
        return dp[nums.length-1];
    }

    public int jump_v1(int[] nums) {
        if(nums.length == 0) return 0;
        int[] res = new int[nums.length];
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

    public int jump_v2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public boolean validate(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> nums(int n){
        ArrayList<Integer> res = new ArrayList<>(n);
        for (int i = 2; i <= n; i++) {
            boolean f = true;
            for (int j = 2, len = (int) Math.sqrt(n); j <= len; j++) {
                if (n % j == 0) {
                    f = false; break;
                }
            }
            if (f)res.add(i);
        }
        return res;
    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }


    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, area = 0;
        while (left < right){
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }
        return area;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)return "";
        String res = strs[0];
        for (int i = 1, len = strs.length; i < len; i++) {
            for (int j = 0, len1 = res.length(), len2 = strs[i].length(); j < len1 && j <= len2; j++) {
                if (j == len2|| res.charAt(j) != strs[i].charAt(j)){
                    res = res.substring(0,j);break;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)return res;
        Arrays.sort(nums);
        if (nums[0] * nums[nums.length-1] > 0){
            return res;
        }
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) break;
            int left = i+1, right = nums.length-1;
            while (left < right){
                //if (nums[i] * nums[right] > 0) break;
                int count = nums[i] + nums[left] + nums[right];
                if (count == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
                if (count < 0){
                    while(left < right && nums[left] == nums[++left]);
                }else{
                    while(left < right && nums[right] == nums[--right]);
                }
            }
            while(i < nums.length-3 && nums[i] == nums[i+1])i++;
        }
        return res;
    }

    public List<List<Integer>> threeSum_v1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)return res;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (j > i || nums[j] == nums[j-1])continue;
                int n = -nums[i]-nums[j];
                if (map.containsKey(n) && (map.get(n) == i-1 || nums[i] != nums[i-1])){
                    res.add(new ArrayList<>(Arrays.asList(n, nums[i], nums[j])));
                }
            }
            map.put(nums[i], Math.min(i, map.getOrDefault(nums[i], Integer.MAX_VALUE)));
        }
        return res;
    }

    public List<List<Integer>> threeSum_v2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)return res;
        Arrays.sort(nums);
        res = threeSum_v2_helper(nums,0, res, new ArrayList<>());
        return res;
    }

    public List<List<Integer>> threeSum_v2_helper(int[] nums, int index,List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == 3){
            if (tmp.get(0) + tmp.get(1)  == -tmp.get(2)){
                res.add(new ArrayList<>(tmp));
            }
            return res;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1])continue;
            tmp.add(nums[i]);
            threeSum_v2_helper(nums,i+1, res, tmp);
            tmp.remove(tmp.size()-1);
        }
        return res;
    }

    public List<List<Integer>> threeSum_3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)return res;
        if (nums[0] * nums[nums.length-1] > 0){
            return res;
        }
        for(int i = 0 ; i < nums.length - 2 ; ++i){
            if(i == 0 || nums[i] != nums[i-1]){
                int head = i + 1, tail = nums.length - 1, val = -nums[i];
                while (head < tail){
                    if (nums[i] * nums[tail] > 0)break;
                    if(nums[head] + nums[tail] == val){
                        res.add(Arrays.asList(nums[i],nums[head],nums[tail]));
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

    private enum  PhoneNum {
        NUM1(1,""), NUM2(2, "abc"), NUM3(3, "def"),
        NUM4(4, "ghi"), NUM5(5, "jkl"), NUM6(6, "mno"),
        NUM7(7, "pqrs"), NUM8(8, "tuv"), NUM9(9, "wxyz");

        private int num;
        private String chars;

        PhoneNum(int num, String chars){
            this.num = num;
            this.chars = chars;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getChars() {
            return chars;
        }

        public void setChars(String chars) {
            this.chars = chars;
        }
    }












}
