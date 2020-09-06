package solutions;

import utility.ListNode;
import utility.NumEnglish;

import java.math.BigDecimal;
import java.util.*;

public class Exam2 {

    public String Encrypt(String str){
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            switch (c){
                case 'z':
                    c = 'A';break;
                case 'Z':
                    c = 'a';break;
                case '9':
                    c = '0';break;
                default:
                    c = (char) (Character.isUpperCase(c) ? Character.toLowerCase(c)+1 : Character.toUpperCase(c)+1);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public String unEncrypt(String str){
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            switch (c){
                case 'a':
                    c = 'Z';break;
                case 'A':
                    c = 'z';break;
                case '0':
                    c = '9';break;
                default:
                    c = (char) (Character.isUpperCase(c) ? Character.toLowerCase(c)-1 : Character.toUpperCase(c)-1);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public String Encrypt1(String str){
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            switch (c){
                case 'z':
                    c = 'A';break;
                case 'Z':
                    c = 'a';break;
                case '9':
                    c = '0';
            }
            if (Character.isLetter(c)){
                c = (char) (Character.isUpperCase(c) ? Character.toLowerCase(c)+1 : Character.toUpperCase(c)+1);
            }else {
                c = (char)(c+1);
            }

            sb.append(c);
        }
        return sb.toString();
    }

    public String unEncrypt1(String str){
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            switch (c){
                case 'a':
                    c = 'Z';break;
                case 'A':
                    c = 'z';break;
                case '0':
                    c = '9';
            }
            if (Character.isLetter(c)){
                c = (char) (Character.isUpperCase(c) ? Character.toLowerCase(c)-1 : Character.toUpperCase(c)-1);
            }else {
                c = (char)(c+1);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public void rate1(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long A = in.nextLong(), B = in.nextLong();
            long a = in.nextLong(), b = in.nextLong();
            long max = 0, x = 0, y = 0;
            for (int i = 1; i <= A; i++) {
                for (int j = 1; j <= B; j++) {
                    if (i * b == j * a){
                        if (max <= i * j){
                            max = i*j;
                            x = i; y = j;
                        }
                    }
                }
            }
            if (max != 0){
                System.out.println(x + " " + y);
            }else {
                System.out.println("0 0");
            }
        }
    }

//    public void rate(){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            BigDecimal A = (new BigDecimal(in.nextLong())), B = (new BigDecimal(in.nextLong()));
//            BigDecimal a = (new BigDecimal(in.nextLong())), b = (new BigDecimal(in.nextLong()));
//            double max = 0;
//            long x = 0, y = 0;
//            for (long i = 1, j = 1, AT = A; i <= AT;) {
//                BigDecimal tmp = (i + (AT-i)/2);
//                j = tmp * b / a;
//                if (j <= B){
//                    if (tmp * b == j * a && max < tmp * j){
//                        max = tmp*j;
//                        x = tmp; y = j;
//                    }
//                    i = tmp+1;
//                }else{
//                    AT = tmp-1;
//                }
//            }
//            for (long i = 1, j = 1; i <= B;) {
//                long tmp = (i + (B-i)/2);
//                j = tmp * a / b;
//                if (j <= A){
//                    if (tmp * a == j * b && max < tmp * j){
//                        max = tmp*j;
//                        y = tmp; a = j;
//                    }
//                    i = tmp+1;
//                }else{
//                    B = tmp-1;
//                }
//            }
//            if (max != 0){
//                System.out.println(x + " " + y);
//            }else {
//                System.out.println("0 0");
//            }
//        }
//    }

    public void rate2(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            double A = in.nextLong(), B = in.nextLong();
            double a = in.nextLong(), b = in.nextLong();
            double max = 0, x = 0, y = 0;
            for (double i = 1, j = 1; i <= A;) {
                double tmp = (i + (A-i)/2);
                j = tmp * b / a;
                if (j <= B){
                    if (tmp * b == j * a && max <= tmp * j){
                        max = tmp*j;
                        x = tmp; y = j;
                    }
                    i = tmp+1;
                }else{
                    A = tmp-1;
                }
            }
            if (max != 0){
                System.out.println(x + " " + y);
            }else {
                System.out.println("0 0");
            }
        }
    }

    public ListNode sum(ListNode l1, ListNode l2){
        ListNode head = l1, pre = l1;
        int carry = 0;
        for (; l1 != null && l2 != null ;l1 = l1.next, l2 = l2.next) {
            int tmp = l1.val + l2.val + carry;
            carry = tmp /10;
            tmp = tmp % 10;
            l1.val = tmp;
            if (l1.next == null){
                pre = l1;
            }
        }
        if (l1 == null){
            pre.next = l2.next;
        }
        while (l1 != null && carry != 0){
            l1.val = l1.val + 1;
            if (l1.val < 10) {
                break;
            }
            l1.val = 0;
            l1 = l1.next;
        }
        return head;
    }

    public ListNode test(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int left = (val1 + val2 + carry)  & 10;
            carry = (val1 + val2 + carry) < 10 ? 0 : 1;

            ListNode tempNode = new ListNode(left);

            while (result.next != null) {
                result = result.next;
            }
            result.next = tempNode;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            while (result.next != null) {
                result = result.next;
            }
            result.next = new ListNode(carry);
        }
        return result.next;
    }

    public ListNode testM(ListNode head, int m){
        int len = 0;
        for (ListNode cur=  head; cur != null ; cur = cur.next) {
            len++;
        }
        for (int i = 0; i < len - m; i++) {
            head = head.next;
        }
        return head;
    }

    public int splitPassword(String pw){
        int res = 0;
        char[] arr = pw.toCharArray();
        for (int i = 0, len = pw.length(); i < len; i++) {
            for (int j = i, k = len - 1 , l = k; j < l;) {
                if (arr[j] != arr[l]){
                    j = i;
                    l = --k;
                }else {
                    j++;
                    l--;
                }
                if (j == l || j > l) res = Math.max(res, k - i + 1);
            }
        }
        return res;
    }


    public static int manacher_copy(String s) {
        int count =0;//记录最大回文
        StringBuffer sb = new StringBuffer();
        char[] c =s.toCharArray();
        sb.append("#");
        //对字符串进行封装
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
            sb.append("#");
        }
        int[] rad = new int[sb.length()];//记录新字符串以每个字符为中心的最大回文半径
        char[] cl = sb.toString().toCharArray();
        int max=0;//记录已经搜寻到的回文半径能到达右端的最达大值
        int id=0;//记录回文半径能到达最右端的回文字符串的中心
        for (int i = 1; i < cl.length; i++) {
            if (max>i) {
                rad[i]=Math.min(rad[2*id-i], max-i);
            }else {
                rad[i]=1;
            }
            while (i-rad[i]>=0 && i+rad[i]<cl.length && cl[(i-rad[i])]==cl[(i+rad[i])]) {
                rad[i]++;
            }
            if (i+rad[i]>max) {
                max=i+rad[i];
                id=i;
            }
            count=Math.max(count, rad[i]-1);
        }
        return count;
    }

    public int manacher(String str) {
        if (str == null || "".equals(str))return 0;
        int res = 0;
        StringBuilder sb = new StringBuilder();
        sb.append('@').append('#');
        for (int i = 0, len = str.length(); i < len; i++) {
            sb.append(str.charAt(i)).append('#');
        }
        sb.append('$');
        int id = 0;     //中心点
        int max = 0;    //最远端
        int[] rad = new int[sb.length()];
        for (int i = 1, len = sb.length(); i < len-1; i++) {
            if(i < max){
                rad[i]=Math.min(rad[2*id-i], max-i);    //i在max范围内的话，根据rad更新
            }
            while(sb.charAt(i + rad[i]) == sb.charAt(i - rad[i])){  //i+半径自增 判断回文串
                rad[i]++;
            }
            if (i + rad[i] > max){  //更新max到最远处
                max = i + rad[i];
                id = i;
            }
            res = Math.max(res, rad[i]-1);
        }
        return res;
    }

    public long ip2Num1(String ip){
        long res = 0;
        String[] str = ip.split("\\.");
        if (str.length != 4)return res;
        long n1, n2, n3, n4;
        try{
            n1 = Integer.parseInt(str[0]);
            n2 = Integer.parseInt(str[1]);
            n3 = Integer.parseInt(str[2]);
            n4 = Integer.parseInt(str[3]);
        }catch (Exception e){
            return res;
        }
        if((n1 < 0 || n1 > 255) && (n2 < 0 || n2 > 255) && (n3<0 || n3 > 255) && (n4 < 0 || n4 > 255)) return res;
        res = n1 * (long) Math.pow(2, 24) + n2 * (long) Math.pow(2, 16) + n3 * (long) Math.pow(2, 8) + n4;
        return res;
    }

    public long ip2Num(String ip){
        long res = 0;
        String[] str = ip.split("\\.");
        if (str.length != 4)return res;
        for (int i = 0 ; i < str.length ; ++i) {
            int num;
            try{
                num = Integer.parseInt(str[i]);
            }catch (Exception e){
                return res;
            }
            if (num < 0 || num > 255) return 0;
            res += num;
            if (i != str.length -1)res <<= 8;
        }
        return res;
    }

    public String num2Ip1(long ipnum){
        String res = "";
        long div = (long) Math.pow(2, 24);
        res += ipnum/div;
        ipnum %= div;
        div = (long) Math.pow(2, 16);
        res += "." + ipnum/div;
        ipnum %= div;
        div = (long) Math.pow(2, 8);
        res += "." + ipnum/div;
        ipnum %= div;
        res += "." + ipnum;
        return res;
    }

    public String num2Ip(long ipnum){
        String res = "";

        res += ipnum >> 24;
        long div = 1 << 24;
        ipnum &= div-1;
        div >>= 8;

        res += "." + (ipnum >> 16);
        ipnum &= div-1;
        div >>= 8;

        res += "." + (ipnum >> 8);
        ipnum &= div-1;

        res += "." + ipnum;
        return res;
    }

    public int checkNetSegment(String mask, String ip1, String ip2) {
        int[] masks = new int[4];
        int[] ip1s = new int[4];
        int[] ip2s = new int[4];
        String[] tmp;
        try{
            tmp = mask.split("\\.");
            if (tmp.length != 4)return 1;
            for (int i = 0; i < tmp.length; i++) {
                masks[i] = Integer.parseInt(tmp[i]);
                if (masks[i] < 0 || masks[i] > 255)return 1;
            }
            tmp = ip1.split("\\.");
            if (tmp.length != 4)return 1;
            for (int i = 0; i < tmp.length; i++) {
                ip1s[i] = Integer.parseInt(tmp[i]);
                if (ip1s[i] < 0 || ip1s[i] > 255)return 1;
            }
            tmp = ip2.split("\\.");
            if (tmp.length != 4)return 1;
            for (int i = 0; i < tmp.length; i++) {
                ip2s[i] = Integer.parseInt(tmp[i]);
                if (ip2s[i] < 0 || ip2s[i] > 255)return 1;
            }
        }catch (Exception e){
            return 1;
        }
        for (int i = 0; i < tmp.length; i++) {
            ip1s[i] &= masks[i];
            ip2s[i] &= masks[i];
            if (ip1s[i] != ip2s[i])return 2;
        }
        return 0;
    }

    public int fama1(int[][] items){
        Arrays.sort(items, (o1, o2) -> o1[0] - o2[0]);
        Set<Integer> set = new LinkedHashSet<>();
        set.add(0);
        for (int[] item : items) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= item[1]; j++) {
                list.add(item[0] * j);
            }
            Integer[] arr = new Integer[set.size()];
            arr = set.toArray(arr);
            for (int n : arr) {
                for (int l : list) {
                    set.add(n + l);
                }
            }
        }
        return set.size();
    }


    public int fama(int[][] items){
        //Arrays.sort(items, (o1, o2) -> o1[0] - o2[0]);
        Set<Integer> set = new LinkedHashSet<>();
        set.add(0);
        for (int[] item : items) {
            List<Integer> list = new ArrayList<>(set);
            for (int j = 0; j <= item[1]; j++) {
                for (int n : list) {
                    set.add(n + item[0] * j);
                }
            }
        }
        return set.size();
    }

    public String parse(long num){
        if (num == 0)return "";
        StringBuilder sb = new StringBuilder();
        long div = (long) Math.pow(10, 9);
        String str;

        long tmp = num / div;
        str = parse(tmp);
        if (!"".equals(str)){
            sb.append(str).append(" billion");
        }
        num %= div;
        div /= 1000;

        tmp = num / div;
        str = parse(tmp);
        if (!"".equals(str)){
            if (sb.length() != 0)sb.append(" ");
            sb.append(str).append(" million");
        }
        num %= div;
        div /= 1000;

        tmp = num / div;
        str = parse(tmp);
        if (!"".equals(str)){
            if (sb.length() != 0)sb.append(" ");
            sb.append(str).append(" thousand");
        }
        num %= div;
        div /= 10;

        tmp = num / div;
        str = parse(tmp);
        if (!"".equals(str)){
            if (sb.length() != 0)sb.append(" ");
            sb.append(str).append(" hundred");
        }
        num %= div;
        div /= 10;

        if (num != 0)sb.append(" and");

        if (num >= 10 && num <= 20){
            if (sb.length() != 0)sb.append(" ");
            sb.append(NumEnglish.getEnglish((int) (num)));
            return sb.toString();
        }else {
            if (sb.length() != 0)sb.append(" ");
            tmp = num / div;
            num %= div;
            sb.append(NumEnglish.getEnglish((int) (tmp * 10)));
        }

        if (num > 0 && num < 10){
            if (sb.length() != 0)sb.append(" ");
            sb.append(NumEnglish.getEnglish((int) num));
        }
        return sb.toString();
    }

    public int findKthToTail(ListNode head, int k){
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next){
            len++;
        }
        for (int i = 0; i < len - k; i++) {
            head = head.next;
        }
        return head.val;
    }

    public void getMinK1(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = in.nextInt(), k = in.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = in.nextInt();
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < len; i++) {
                if (queue.isEmpty() || queue.size() < k){
                    queue.add(arr[i]);
                }else if (queue.peek() > arr[i]){
                    queue.add(arr[i]);
                    queue.poll();
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int n : queue) {
                sb.append(n).append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.reverse().toString());
        }
    }

    public void getMinK(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = in.nextInt(), k = in.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }

    private int[] trainIn;
    public void trainEnter(int[] array){
        trainIn = array;
        permutation(Arrays.copyOf(array, array.length), 0);
    }
    public boolean isTrainOut(int[] permutation, int[] in){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0,j = 0; i < in.length || !stack.isEmpty();) {
            if (i != in.length && !stack.contains(permutation[j])){
                stack.push(in[i++]);
            }else if (stack.peek() == permutation[j]){
                stack.pop();j++;
            }else {
                return false;
            }
        }
        return true;
    }

    public void permutation(int[] array,int start) {
        if(start== array.length-1) {
            if(isTrainOut(array, trainIn)){
                for (int value : array) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = start; i < array.length; i++) {
                //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                swap(array,start,i);
                permutation(array,start+1);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                swap(array,start,i);
            }
        }
    }
    public void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }













}
