package solutions;

import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;
import utility.ListNode;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.function.DoubleToIntFunction;

public class Exam1 {

    public void buy() {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        if(len == 0){
            System.out.println(0);
            return;
        }
        int[] nums  = new int[len];
        for(int i = 0 ; i < len&&in.hasNext() ; i++){
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        long res = 0;
        for(int i = len-1, j = 0; i >= 0 ; i-- , j++){
            if(j < 2){
                res += nums[i];
            }else {
                j = 0;
            }
        }
        System.out.println(res);
    }

    public void hmn(){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt(), hm = in.nextInt();
        int[] nums  = new int[len];
        for(int i = 0 ; i < len&&in.hasNext() ; i++){
            nums[i] = in.nextInt();
        }
        int res = 0;
        for(int i = 0; i < len ; i++){
            int count = 0;
            for(int j = i ; j < len ; j++){
                count += nums[j];
                if(count % hm == 0){
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public void luck(){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt(), k = in.nextInt();
        String nums = in.nextLine();
        if(len == 0){
            System.out.println(0);
            System.out.println();
            return;
        }
        int[] arr = new int[len], map = new int[10];
        int res = 0;
        for(int i = 0 ; i < len ; i++){
            arr[i] = nums.charAt(i) - '0';
        }
        Arrays.fill(map,-1);

        for(int i = 0; i < len ; i++){
            if(map[arr[i]] != 0)continue;
            int temp = 0, count = 0;
            for(int j = 0 ; j < 10 ;j++){
                for(int m = 0 ; m < len ; m++){
                    if(arr[i] - arr[m] == j){
                        temp++;
                        count += arr[i] - arr[m];
                    }
                    if(temp == k)break;
                }
                if(temp == k)break;
            }
            map[arr[i]] = count;
        }
        int min = 0, index = 0;
        for(int n : map){
            if(n!=-1){
                min = Math.min(min, n);
            }
        }
        for(int i = 0 ; i < len ; i++){
            if(arr[i] == i){
                index = i;
                break;
            }
        }
        for(int j = 0 ; j < 10 ;j++){
            for(int m = 0 ; m < len ; m++){

            }
        }
        System.out.println();
    }

    public void cube(){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt(), k = in.nextInt();
        int[] nums  = new int[len];
        for(int i = 0 ; i < len&&in.hasNext() ; i++){
            nums[i] = in.nextInt();
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1, tmp = k; i < len ; i++){
            if(nums[i] == nums[i-1] && tmp > 0){
            }
        }
    }

    public void job(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] nums  = new int[m];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0 ; i < n ; i++){
            int key = in.nextInt();
            map.put(key, Math.max(map.getOrDefault(key, 0), in.nextInt()));
        }
        for(int i = 0 ; i < m&&in.hasNext() ; i++){
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        Map.Entry<Integer,Integer> tmp = null;
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            if(tmp != null){
                map.put(en.getKey(),Math.max(en.getValue(), tmp.getValue()));
            }else {
                tmp = en;
            }
        }
        for(int i = 0 ; i < m ; i++){
            Integer itg = map.floorKey(nums[i]);
            nums[i] = itg == null?0:map.get(itg);
            System.out.println(nums[i]);
        }
    }

    public void job_v1(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt();
        int[][] map = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            map[i][0] = in.nextInt();
            map[i][1] = in.nextInt();
        }
        Arrays.sort(map,((o1, o2) -> (o1[0] - o2[0])));
        for(int i = 1; i < N ; i++){
            map[i][1] = Math.max(map[i][1],map[i-1][1]);
        }
        //二分查找
        for(; M > 0; M--){
            int m = in.nextInt(), tmp = 0;
            for(int[] n : map){
                if(n[0] > m)break;
                tmp = n[1];
            }
            System.out.println(tmp);
        }
    }


    public void job_v2(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][2];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (e1, e2) -> (int)(e1[0] - e2[0]));
        for(int i = 1; i < arr.length; i++) {
            arr[i][1] = Math.max(arr[i-1][1], arr[i][1]);
        }
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i][0], arr[i][1]);
        }
        for(int i = 0; i < M; i++) {
            int ability = sc.nextInt();
            Integer index = map.floorKey(ability);
            if(index != null) {
                System.out.println(map.get(index));
            } else {
                System.out.println(0);
            }
        }

    }

    public void job_v3(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0 ; i < n ; i++){
            int key = in.nextInt();
            map.put(key, Math.max(map.getOrDefault(key, 0), in.nextInt()));
        }
        Map.Entry<Integer,Integer> tmp = null;
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            if(tmp != null){
                map.put(en.getKey(),Math.max(en.getValue(), tmp.getValue()));
            }
            tmp = en;
        }
        for(int i = 0 ; i < m ; i++){
            Integer itg = map.floorKey(in.nextInt());
            System.out.println(itg == null?0:map.get(itg));
        }
    }

    public void divideby3(){
        Scanner in = new Scanner(System.in);
        int L = in.nextInt(), R = in.nextInt(), res = 0;
        long num = 0;
        for(int i = 1 ; i <= R ; i++){
            num += i;
            if(i >= L && num % 3 == 0 ) res++;
        }
        System.out.println(res);
    }

    public void divideby3_v1(){
        Scanner in = new Scanner(System.in);
        int L = in.nextInt(), R = in.nextInt(), res = 0;
        long remainder = 0;
        for(int i = 1 ; i <= R ; i++){
            remainder = (remainder + i)%3;
            if(i >= L && remainder == 0 ) res++;
        }
        System.out.println(res);
    }

    public void light(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(; N > 0 ; N--){
            int len = in.nextInt(), res = 0;
            String arr = in.next();
            for(int i = 0 ; i < len ; i++){
                if(arr.charAt(i) == '.'){
                    res++;
                    i = i + 2;
                }
            }
            System.out.println(res);
        }

    }

    public void direction(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String arr = in.next();
        char[] direction = {'N','W','S','E'};
        int index = 0;
        for(int i = 0 ; i < N ; i++){
            if(arr.charAt(i) == 'R'){
                //index = index == 0 ? 3: index-1;
                index--;
            }else {
                //index = index == 3 ? 0 : index+1;
                index++;
            }
        }
        System.out.println(direction[(index%4+4)%4]);

    }

    public void numPair(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(),K = in.nextInt();
        int res = 0;
        for(int i = K+1 ; i <= N ; i++){
            //res += (i - K);
            for(int j = i ; j <= N ; j++){
                if(j % i >= K)res++;
            }
        }
        System.out.println(res);
    }

    public void numPair_v1(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(),K = in.nextInt();
        int res = 0;
        for(int i = K ; i <= N ; i++){
            for(int j = K+1 ; j <= i ; j++){
                if(i % j >= K)res++;
            }
            res += (N - i);
        }
        System.out.println(res);
    }

    public void numPair_v2(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(),K = in.nextInt();
        long res = 0;
        if(K == 0){
            res = N * N;
        }else {
            for(int i = K+1 ; i <= N ; i++){
                res += (N / i) * (i - K) + Math.max(0, N % i - K + 1);
            }
        }
        System.out.println(res);
    }

    public void sum(){
        Scanner in = new Scanner(System.in);
        long a = in.nextInt();
        long b = in.nextInt();
        long c = a + b;
        System.out.println(c);
    }

    public void distinct(){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Set<Character> set = new HashSet<>();
        StringBuilder  sb = new StringBuilder();
        for(int i = 0, len = str.length() ;i < len ; i++){
            char c = str.charAt(i);
            if(set.add(c)){
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

    public void Tetris(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] col = new int[n];
        for(int i = 0; i < m ; i++){
            col[in.nextInt()-1]++;
        }
        int res = 1001;
        for(int num : col){
            res = Math.min(num,res);
        }
        System.out.println(res);
    }

    public void correct(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(;n > 0 ; n--){
            String str = in.next();
            StringBuilder sb = new StringBuilder();
            for(int i = 0, len = str.length() ; i < len ; i++){
                char c = str.charAt(i);
                int size = sb.length();
                if(size > 0 && sb.charAt(size-1) == c){
                    if((size < 2|| sb.charAt(size-2) != c) && (size< 3 ||sb.charAt(size-3) != sb.charAt(size-2))){
                        sb.append(c);
                    }
                }else {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }


    public void correct_v1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();in.nextLine();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0, len = str[i].length() ; j < len ; j++){
                char c = str[i].charAt(j);
                int size = sb.length();
                if(size > 0 && sb.charAt(size-1) == c){
                    if((size < 2|| sb.charAt(size-2) != c) && (size< 3 ||sb.charAt(size-3) != sb.charAt(size-2))){
                        sb.append(c);
                    }
                }else {
                    sb.append(c);
                }
            }
            str[i] = sb.toString();
        }
        for (String s: str) {
            System.out.println(s);
        }

    }

    public void correct_2(){
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < line; i++) {
            System.out.println(scanner.nextLine()
                    .replaceAll("(.)\\1+","$1$1")
                    .replaceAll("(.)\\1(.)\\2","$1$1$2"));
        }
    }

    public void hw1(){
        Scanner in = new Scanner(System.in);
        String[] str = null;
        try{
            str = in.next().split(",");
        }catch (Exception e){
            System.out.println("error.0001");
            return;
        }
        if(str.length == 0){
            System.out.println("error.0001");
            return;
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : str){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        int max = 0;
        for(Map.Entry<String, Integer> en : map.entrySet()){
            max = Math.max(max, en.getValue());
        }
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> en : map.entrySet()){
            if(en.getValue() == max){
                list.add(en.getKey());
            }
        }
        if(list.size() == 1){
            System.out.println(list.get(0));
        } else {
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int i = 0, j = 0;
                    while(i< o1.length() && j < o2.length()){
                        if(o1.charAt(i) > o2.charAt(j)){
                            return 1;
                        }if(o1.charAt(i) < o2.charAt(j)){
                            return -1;
                        }
                        i++;
                        j++;
                    }
                    if(i == o1.length())return -1;
                    return 1;
                }
            });
            System.out.println(list.get(0));
        }
    }

    public void hw2(){
        Scanner in = new Scanner(System.in);
        String key = in.next();
        String[] str = in.next().split("],");
        for(String s : str){
            if(s.substring(0, s.indexOf("[")).matches(key)){
                int a = s.indexOf("addr=");
                String addr, mask, val;
                if(a == -1)continue;
                addr = s.substring(a+5, s.indexOf(","));
                a = s.indexOf("mask");
                if(a == -1)continue;
                mask = s.substring(a+5,s.indexOf(","));
                a = s.indexOf("val");
                if(a == -1)continue;
                val = s.substring(a+4);
                if(val.contains("]"))val = val.substring(0,val.indexOf("]"));
                System.out.println();
            }
        }

    }

    private static long res= 0;
    public void hw3(){
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        long[] arr = new long[sum];
        long[][] matrix = new long[sum][sum+1];
        for(int i = 0 ; i< sum ; i++){
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < sum; i++) {
            matrix[in.nextInt()-1][0] = in.nextInt();
            for (int j = 1; j <= arr[i]; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < sum; i++) {
            hw3_help(matrix,arr,0,new long[1]);
        }
        System.out.println(res);
    }

    private void hw3_help(long[][] matrix, long[] arr, long i,long[] count){
        count[0] += matrix[(int)i][0];
        if(matrix[(int)i][1] == 0){
            res = Math.max(res, count[0]);
        }
        for (int j = 1; j <= arr[(int)i]; j++) {
            hw3_help(matrix, arr , matrix[(int)i][j]-1, count);
            count[0] -= matrix[(int)matrix[(int)i][j]-1][0];
        }

    }

    public void maxval(){
        Scanner in = new Scanner(System.in);
        int len = 3;
        int[] nums = new int[len];
        for(int i = 0 ; i < len ; i++){
            nums[i] = in.nextInt();
        }
        int[][] dp = new int[len][len];
        for (int i = 0; i < dp[0].length; i++) {
            for (int j = i; j >= 0; j--) {
                if(i == j){
                    dp[j][i] = nums[i];
                }else {
                    for (int k = j; k < i; k++) {
                        dp[j][i] = Math.max(dp[j][k]*dp[k+1][i], dp[j][k] + dp[k+1][i]);
                    }
                }
            }
        }
        System.out.println(dp[0][len-1]);
    }

    public void sleep(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[][] list  = new int[n][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                list[j][i] = in.nextInt();
            }
        }
        int max = 0;
        for (int i = 0, count = 0; i < n; i++) {
            if(list[i][1] == 0) count += list[i][0];
            if(i-k >= 0 && list[i-k][1] == 0) count -= list[i-k][0];
            max = Math.max(max,count);
        }
        for (int i = 0; i < n; i++) {
            if(list[i][1] == 1) max += list[i][0];
        }
        System.out.println(max);
    }

    public void harvest(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list  = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt() + (i>0?list[i-1]:0);
        }
        for (int m = in.nextInt(); m > 0 ; m--) {
            int x = in.nextInt();
//            int left = 0, right = n-1;
//            while(left < right){
//                int tmp = (left + right)/2;
//                if(list[tmp] > x){
//                    right = tmp-1;
//                }else if(list[tmp] < x){
//                    left = tmp+1;
//                }else {
//                    left = tmp;
//                    break;
//                }
//            }
//            System.out.println(list[left] >= x?left+1 :left+1+1);
            int res = Arrays.binarySearch(list, x);
            System.out.println(res > 0 ? res +1 : -res);
        }
    }

    public void alarm(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][] clock = new int[num][2];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2; j++) {
                clock[i][j] = in.nextInt();
            }
        }
        int des = in.nextInt();
        int hours = in.nextInt();
        int minute = in.nextInt();
        minute -= des;
        while(minute < 0){
            minute += 60;
            hours -= 1;
        }
        Arrays.sort(clock, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])return o1[1]-o2[1];
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        for (int i = 0; i < num; i++) {
            if(hours > clock[i][0]){
                res = i;
            }else if(hours == clock[i][0] && minute >= clock[i][1]){
                 res = i;
            }else {
                break;
            }
        }
        System.out.println(clock[res][0] + " " + clock[res][1]);

    }

    /**
     * 21 1165911996
     * 842104736 130059605 359419358 682646280 378385685 622124412 740110626 814007758 557557315 40153082 542984016 274340808 991565332 765434204 225621097 350652062 714078666 381520025 613885618 64141537 783016950
     */
    public void bag(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), w = in.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }
        Arrays.sort(list);
        int[] res = new int[n];
        long count = 0; int index = 0;
        res[0] = list[0] > w?1:2;
        for (int i = 1; i < n; i++) {
            if(count + list[i] < w){
                count += list[i];
                res[i] = res[i-1]*2;
                index = i;
            }else {
                break;
            }
        }
        for (int i = index + 1; i < n; i++) {
            for (int j = index ; j >= 0; j--) {
                if(count - list[j] + list[i] < w){
                    res[i] = res[i-1] + (j >0 ?res[j-1]:0);
                    index = j;
                    break;
                }else {
                    count -= list[j];
                }
            }
            if(res[i] == 0)res[i] = res[i-1];
        }
        System.out.println(res[n-1]);
    }

    private static long result = 1;
    public void bag_v1(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long w = input.nextInt();
        long[] v = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            v[i] = input.nextInt();
            sum = sum + v[i];
        }
        if (sum <= w) {
            System.out.println((int) Math.pow(2, n));
        } else {
            state(v, 0, w, 0);
            System.out.println(result);
        }
        state(v, 0, w, 0);
        System.out.println(result);
    }
    private void state(long[] v,int index, long w, long current){
        if (index == v.length)
            return;
        if (current + v[index] <= w){
            result++;
            state(v, index+1,w,current+v[index]);
        }
        state(v,index+1,w,current);
    }

    public void time(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();in.nextLine();
        for (int i = 0; i < t; i++) {
            String[] str = in.nextLine().split(":");
            if(str[0].charAt(0) > '2' ||(str[0].charAt(0) == '2' && str[0].charAt(1)>'3')){
                str[0] = "0"+str[0].charAt(1);
            }
            if(str[1].charAt(0) > '5'){
                str[1] = "0" + str[1].charAt(1);
            }
            if(str[2].charAt(0) > '5'){
                str[2] = "0" + str[2].charAt(1);
            }
            System.out.println(str[0]+":"+str[1]+":"+str[2]);
        }
    }

    public void time_1(){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt(); sc.nextLine();
        for(int i = 0 ; i < T ; i++){
            System.out.println(sc.nextLine()
                            .replaceFirst("^[3-9]","0")
                            .replaceFirst("^2([4-9])","0$1")
                            .replaceAll("[6-9](\\d)","0$1"));
        }
    }

    public void agent(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), D = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        long res = 0;
        for (int i = 0; i < N; i++) {
            long index = Arrays.binarySearch(arr, arr[i] + D);
            index = index > 0? index : -index-2;
            index = index -i;
            res += (index-1)*index/2;
        }
        System.out.println(res%99997867);
    }

    public void agent_v1(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), D = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        long res = 0;
        for (int i = 0, j = 0; j < N; j++) {
            while(j >= 2 && arr[j] - arr[i] > D){
                i++;
            }
            long num = j-i;
            res += num * (num-1)/2;
        }
        res %= 99997867;
        System.out.println(res);
    }

    public void agent_v2(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), D = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        long res = 0;
        for (int i = 0, j = 0; i < N -1;) {
            if(j < N && (j - i < 2 || arr[j] - arr[i] <= D)){
                j++;
            }else {
                long num = j-i-1;
                res += num * (num-1)/2;
                i++;
            }
        }
        res %= 99997867;
        System.out.println(res);
    }


    public void change(){
        Scanner in = new Scanner(System.in);
        int N = 1024 - in.nextInt();
        int res = 0;
        for (int i = 64; i > 0;i /= 4) {
            res += N / i;
            N %= i;
            if(N == 0)break;
        }
        System.out.println(res);
    }

    public void change_dp(){
        Scanner in = new Scanner(System.in);
        int N = 1024 - in.nextInt();
        int[] dp = new int[N];
        Arrays.fill(dp,N);
        int[] money = {1,4,16,64};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < money.length; j++) {
                if (i - money[j] >= 0){
                    dp[i] = Math.min(dp[i - money[j]]+1, dp[i]);
                }
            }
        }
        System.out.println();
    }

    public void stringCount(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> en:
             map.entrySet()) {
            sb.append(en.getKey());
            sb.append(en.getValue());
        }
        System.out.println(sb.toString());
    }

    public void tower(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[][] res = new int[k+1][2];
        if (k == 0){
            int mini = 0, maxi = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[mini])mini = j;
                if (arr[j] > arr[maxi])maxi = j;
            }
            res[0][0] = arr[maxi] - arr[mini];
            res[0][1] = 0;
        }else {
            for (int i = 1; i <= k; i++) {
                int mini = 0, maxi = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[j] < arr[mini])mini = j;
                    if (arr[j] > arr[maxi])maxi = j;
                }
                if (maxi == mini){
                    res[0][0] = 0; res[0][1] = i;break;
                }
                arr[maxi]--;arr[mini]++;
                res[0][1] = i;
                res[i][0] = maxi+1;
                res[i][1] = mini+1;
                for (int j = 0; j < n; j++) {
                    if (arr[j] < arr[mini])mini = j;
                    if (arr[j] > arr[maxi])maxi = j;
                }
                res[0][0] = arr[maxi] - arr[mini];
            }
        }
        for (int i = 0; i <= res[0][1]; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }

    public void matirx(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[][] index = new long[N][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                index[j][i] = in.nextLong();
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int k = 0; k < N; k++) {
                    if (index[k][0] <= index[i][0] && index[k][2] > index[i][0]
                    && index[k][1] <= index[j][1] && index[k][3] > index[j][1]){
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        System.out.println(res);
    }

    public void session(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            LinkedHashSet<Integer> lset = new LinkedHashSet<>();
            for (int j = 0; j < N; j++) {
                int key = in.nextInt();
                lset.remove(key);
                lset.add(key);
            }
            StringBuilder sb = new StringBuilder();
            ListIterator<Integer> it = new ArrayList<>(lset).listIterator(lset.size());
            while(it.hasPrevious()){
                sb.append(it.previous());
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }


    public void url(){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        HashMap<String, HashSet<String>> map = new HashMap<>(k);
        for (int i = 0; i < k; i++) {
            String str = in.nextLine();
            int rindex = str.indexOf("//")+2;
            int index = str.indexOf('/' ,rindex);
            String root, path;
            if(index == -1){
                root = str;
                path = "";
            }else {
                root = str.substring(0, index);
                path = str.substring(index);
            }
            map.put(root,map.getOrDefault(root, new HashSet<>()));
            if(map.get(root) == null){
                HashSet<String> set = new HashSet<>();
                set.add(path);
                map.put(root,set);
            }else {
                HashSet<String> set = map.get(root);
                set.add(path);
                map.put(root, set);
            }
        }
        ArrayList<String> list = new ArrayList<>(k);
        Set<Map.Entry<String,HashSet<String>>> re = new HashSet<>();
        int index = 0;
        Iterator<Map.Entry<String,HashSet<String>>> it  = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,HashSet<String>> en = it.next();
            it.remove();
            if(re.contains(en))continue;
            String res = en.getKey();
            Iterator<Map.Entry<String,HashSet<String>>> ita  = map.entrySet().iterator();
            while(ita.hasNext()){
                Map.Entry<String,HashSet<String>> ne = ita.next();
                if(en.getValue().equals(ne.getValue())){
                    res = ne.getKey() + " " + res;
                    re.add(ne);
                }
            }
            if (!res.equals(en.getKey())){
                list.add(res);
                index++;
            }
        }
        System.out.println(list.size());
        for (String s: list) {
            System.out.println(s);
        }
    }

    public void matrix_01(){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt(), y = in.nextInt();
        int[][] matrix = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int res=0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 1 && matrix_01_helper(matrix,i,j,i,j)){
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private boolean matrix_01_helper(int[][] matrix, int i, int j, int prei, int prej){
        matrix[i][j] = -1;
        if(!(i-1 == prei || (i > 0 && matrix[i-1][j] == 0))){
            return false;
        }
        if(!(i < matrix.length-1 && (matrix[i+1][j] == 0 || matrix_01_helper(matrix,i+1,j, i, j)))){
            return false;
        }
        if(!(j-1 == prej ||j > 0 && (matrix[i][j-1] == 0))){
            return false;
        }
        if (!(j< matrix[0].length-1 && (matrix[i][j+1] == 0 || matrix_01_helper(matrix,i,j+1, i ,j)))){
            return false;
        }
        return true;
    }

    public void qu(){
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int i = 0; i < g; i++) {
            int n = in.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                String str = in.next();
                if(str.equals("PUSH")){
                    list.add(in.nextInt());
                }else if(str.equals("POP")){
                    if(list.size() > 0){
                        list.poll();
                    }else {
                        System.out.println(-1);
                    }
                }else if(str.equals("TOP")){
                    if(list.size() > 0){
                        System.out.println(list.peek());
                    }else {
                        System.out.println(-1);
                    }
                }else if(str.equals("SIZE")){
                    System.out.println(list.size());
                }else{
                    list.clear();
                }
            }
        }
    }

    public void distance(){
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int i = 0; i < g; i++) {
            int n = in.nextInt();
            long[][] A = new long[n][2];
            long[][] B = new long[n][2];
            for (int j = 0; j < n; j++) {
                A[j][0] = in.nextInt();
                A[j][1] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                B[j][0] = in.nextInt();
                B[j][1] = in.nextInt();
            }
            double min = Double.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    long x = (A[j][0] - B[k][0])*(A[j][0] - B[k][0]);
                    long y = (A[j][1] - B[k][1])*(A[j][1] - B[k][1]);
                    min = Math.min(min, Math.sqrt(x + y));
                }
            }
            System.out.println(String.format("%.3f",min));
        }
    }

    public void card(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] A = new int[n][2];
        for (int j = 0; j < n; j++) {
            A[j][0] = in.nextInt();
        }
        for (int j = 0; j < n; j++) {
            A[j][1] = in.nextInt();
        }
        int res= 0;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                if (A[i][0] < A[i-1][0]){
                    int tmp = A[i-1][0];
                    A[i-1][0] = A[i][1];
                    A[i][1] = tmp;
                    tmp = A[i-1][1];
                    A[i-1][1] = A[i][0];
                    A[i][0] = tmp;
                    res++;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (A[i][0] < A[i-1][0]){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(res);
    }

    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public void arr(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int j = 0; j < n; j++) {
            String str = in.next();
            if(str.equals("add")){
                int num = in.nextInt();
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
                st1.push(num);
                while(!st2.isEmpty()){
                    st1.push(st2.pop());
                }
            }else if(str.equals("poll")){
                st1.pop();
            }else {
                System.out.println(st1.peek());
            }
        }

    }

    public void arr1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            String str = in.next();
            if(str.equals("add")){
                list.add(in.nextInt());
            }else if(str.equals("poll")){
                list.poll();
            }else {
                System.out.println(list.peek());
            }
        }

    }

    public void tree(){
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            long x = in.nextInt(), k = in.nextInt();
            long kc = 1, count = 1;
            while(count < x){
                kc++;
                count *= 2;
            }
            if(kc < k ){
                System.out.println(-1);
                continue;
            }
            count /= 2;
            x = x - count;
            long k1 = (long)Math.pow(kc-k,2);
            System.out.println(x/k * (long)Math.pow(2,k));
        }

    }

    public void D2X(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.next();
            int res = 0;
            int resa = Integer.parseInt(s, 16);
            for (int len = s.length()-1, i = len; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == 'x'){
                    break;
                }
                switch (c){
                    case 'A':
                        res += 10 * Math.pow(16, len - i);
                        break;
                    case 'B':
                        res += 11 * Math.pow(16, len - i);
                        break;
                    case 'C':
                        res += 12 * Math.pow(16, len - i);
                        break;
                    case 'D':
                        res += 13 * Math.pow(16, len - i);
                        break;
                    case 'E':
                        res += 14 * Math.pow(16, len - i);
                        break;
                    case 'F':
                        res += 15 * Math.pow(16, len - i);
                        break;
                    default:
                        res += (c - '0') * Math.pow(16, len - i);

                }
            }
            System.out.println(res);
        }

    }

    public void primeNum(){
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        long prime = 2;
        while(num != 0){
            if (num % prime != 0){
                prime = nextPrime(prime);
            }else {
                num = num / prime;
                System.out.print(prime + " ");
            }
        }
    }

    private long nextPrime(long n){
        n++;
        for (int f = 0; ; n++) {
            f = 1;
            for (int i = 2; i < n/2; i++) {
                if ((n % i) == 0){
                    f = 0;
                    break;
                }
            }
            if (f == 1){
                break;
            }
        }
        return n;
    }

    public void lastWordLength(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(s.length() - s.lastIndexOf(" ")-1);
    }

    public void countNumber(){
        Scanner in = new Scanner(System.in);
        char[] arr = in.nextLine().toCharArray();
        char c = Character.toLowerCase(in.next().charAt(0));
        int res = 0;
        for (char value : arr) {
            if (Character.toLowerCase(value) == c) {
                res++;
            }
        }
        System.out.println(res);
    }


    public void RandomNumber(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = in.nextInt();
            int[] arr = new int[1000];
            for (int i = 0; i < len; i++) {
                arr[in.nextInt()-1]++;
            }
            for (int i = 0; i < 1000; i++) {
                if (arr[i] != 0){
                    System.out.println(i+1);
                }
            }
        }
    public void star(){
        Scanner sc = new Scanner(System.in);
        long h = sc.nextLong();
        long left = 0, right = h;
        while(left <= right){
            long mid = left + (right - left)/2;
            double tmp = mid + mid * mid;
            if(tmp > h){
                right = mid-1;
            }else if(tmp < h){
                left = mid+1;
            }else{
                System.out.println(mid);
                return;
            }
        }
        System.out.println(left-1);
    }

    public void star1(){
        Scanner sc = new Scanner(System.in);
        long h = sc.nextLong();
        long cur = 1;
        while(cur + cur * cur < h){
            cur = cur << 1;
        }
        long left = cur >> 1, right = cur;
        while(left <= right){
            long mid = left + ((right - left) >> 1);
            double tmp = mid + mid * mid;
            if(tmp > h){
                right = mid-1;
            }else if(tmp < h){
                left = mid+1;
            }else{
                System.out.println(mid);
                return;
            }
        }
        System.out.println(left-1);
    }

    public void sushu(){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        int res = 0;
        for (int i = 0; i < len; i++) {

        }
    }

    public void pailie(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        ArrayList<Integer> marr = new ArrayList<>(n);
        int[] nums = new int[n+1];
        for (int i = 0; i < m; i++) {
            int tmp = in.nextInt();
            marr.add(tmp);
            nums[tmp] = 1;
        }
        for (int i = 0, j = 1; j < nums.length; j++) {
            if (nums[j] == 1)continue;
            while(i < marr.size() && j > marr.get(i)){
                i++;
            }
            marr.add(i, j);
        }
        for (int i = 0, len = marr.size(); i < len; i++) {
            if (i != len - 1){
                System.out.print(marr.get(i) + " ");
            }else {
                System.out.print(marr.get(i));
            }
        }
    }

    public void pingfenwuping(){
        Scanner in = new Scanner(System.in);
        int group = in.nextInt();
        for (; group > 0; group--) {
            int len = in.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int max = 0;
            for (int n : arr) {
                max += n;
            }
            for (int i = 1; i <= len; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                pingfenwuping1(arr, new int[arr.length], i, list, 0);
            }
        }

    }
    private void pingfenwuping1(int[] arr, int[] used, int size, ArrayList<Integer> list, int num){
        if (size == 0){
            int left = 0;
            for (int i = 0; i < arr.length; i++) {
                if (used[i] != 1){
                    left += arr[i];
                }
            }
            list.add(num);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i] != 1){
                used[i] = 1;
                pingfenwuping1(arr, used, size-1, list, num + arr[i]);
                used[i] = 0;
            }
        }
    }

    public void minTree(){
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt(), lines = in.nextInt();
        int[][] matrix = new int[nodes][nodes];
        for (int i = 0; i < lines; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            int num = in.nextInt();
            matrix[s][e] = num;
        }

    }
    public void minTree1(){
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt(), lines = in.nextInt();
        int[][] list = new int[lines][3];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < 3; j++) {
                list[i][j] = in.nextInt();
            }
        }
        Arrays.sort(list, (o1, o2) -> o1[2] - o2[2]);
        int min = 0, max = 0;
        for (int i = 0, j = list.length-1, f = 0, l = 0; i < j;) {
            if (f == 0){
                int node1 = list[i][0], node2 = list[i][1];
                for (int k = i+1; k <= j; k++) {
                    if (list[k][0] == node1 || list[k][1] == node2){
                        node1 = -1;
                    }
                    if (list[k][0] == node2 || list[k][1] == node2){
                        node2 = -1;
                    }
                }
                if (node1 == -1 && node2 == -1){
                    min = list[i][2];
                    i++;
                }else {
                    if (l == 1)break;
                    l = 1;
                }
                if (l == 0)f = 1;
            }else {
                int node1 = list[j][0], node2 = list[j][1];
                for (int k = j-1; k >= i; k--) {
                    if (list[k][0] == node1 || list[k][1] == node2){
                        node1 = -1;
                    }
                    if (list[k][0] == node2 || list[k][1] == node2){
                        node2 = -1;
                    }
                }
                if (node1 == -1 && node2 == -1){
                    max = list[j][2];
                    j--;
                }else {
                    if (l == 1)break;
                    l = 1;
                }
                if (l == 0)f = 0;
            }

        }
        System.out.println(max - min);
    }

    public void noTwo(){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), col = sc.nextInt();
        int res = (row /4)  * (col /4) * 8;
        row = row % 4;
        col = col % 4;
        if (row == 3 && col == 3){
            res += 5;
        }else {
            res += (Math.min(row, 2)) * (Math.min(col, 2));
        }
        System.out.println(res);
    }

    public void noTwo_v1(){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), col = sc.nextInt();
        int colnum1 = (col / 4)*2 + Math.min(2, col%4);
        int colnum2 = (col / 4)*2 + Math.max(0, col%4-2);
        int res = (row / 4) * (colnum1 + colnum2) * 2;
        row = row % 4;
        if (row >= 1){
            res += colnum1;
        }
        if (row >= 2){
            res += colnum1;
        }
        if (row == 3){
            res += colnum2;
        }
        System.out.println(res);
    }

    public void saveEasy(){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] indexs = new int[len][2];
        for (int i = 0; i < len; i++) {
            indexs[i][0] = sc.nextInt();
        }
        for (int i = 0; i < len; i++) {
            indexs[i][1] = sc.nextInt();
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.min(res, indexs[i][0] + indexs[i][1]-2);
        }
        System.out.println(res);

    }

    public void huiwen(){
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String source = sc.nextLine();
        String[] arr = new String[10];
        int res = 0;
        for (int i = 0, len = target.length(); i <= len; i++) {
            String tmp = target.substring(0, i) + source + target.substring(i);
            int f = 0;
            for (int j = 0, k = tmp.length()-1; j < k; j++, k--) {
                if (tmp.charAt(j) != tmp.charAt(k)) {
                    f = 1;
                    break;
                }
            }
            if (f == 0)res++;
        }
        System.out.println(res);
    }


    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.next();
        }
        boolean lengths = true, lexicographically = true;
        for(int i = 1; i < len ; i++){
            if(arr[i-1].length() > arr[i].length()){
                lengths = false;
                break;
            }
        }
        for(int i = 1; i < len ;i++){
            if(!helper(arr[i-1], arr[i])){
                lexicographically = false;
                break;
            }
        }
        if(lengths && lexicographically){
            System.out.println("both");
        }else if(lengths){
            System.out.println("lengths");
        }else if(lexicographically){
            System.out.println("lexicographically");
        }else{
            System.out.println("none");
        }
    }
    private static boolean helper(String s1, String s2){
        for(int j = 0; j < s1.length() ;j++){
            if(j == s2.length())return false;
            if(s1.charAt(j) > s2.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public void structQeue(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int input = in.nextInt();
            int[] arr = new int[input];
            for (int j = 0, num = 1, tmp = 0, left = arr.length; left > 0; ) {
                if (arr[j] == 0 && (tmp == 1 || left == 1)){
                    arr[j] = num++;
                    tmp = 0; left--;
                }else if(arr[j] == 0){
                    tmp++;
                }
                if (j == arr.length -1)j = 0;
                else j++;
            }
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }


    public void upgrad(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt(), power = in.nextInt();
            for (int i = 0; i < N; i++) {
                int cur = in.nextInt();
                if (power < cur){
                    int tmp = 1;
                    for (int j = 1; j < power; j++) {
                        if (power % j == 0 && cur % j == 0){
                            tmp = j;
                        }
                    }
                    power += tmp;
                }else {
                    power += cur;
                }
            }
            System.out.println(power);
        }

    }

    public void attack(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long range = in.nextInt();
            long[][] index = new long[4][2];
            for (int i = 0; i < 4; i++) {
                index[i][0] = in.nextInt();
                index[i][1] = in.nextInt();
            }
            int demage = 0;
            for (int i = 0; i < 3; i++) {
                long len1 = (index[i][0] - index[3][0]);
                len1 *= len1;
                long len2 = (index[i][1] - index[3][1]);
                len2 *= len2;
                if ((len1 + len2) <= range*range){
                    demage++;
                }
            }
            System.out.println(demage+"x");
        }
        in.close();
    }


    public void shuffle(){
        Scanner in = new Scanner(System.in);
        int group = in.nextInt();
        for (; group > 0 ; group--) {
            int n = in.nextInt(), k = in.nextInt();
            int[] arr = new int[2*n];
            for (int i = 0, len = 2*n; i < len; i++) {
                arr[i] = in.nextInt();
            }
            for (; k > 0; k--) {
                int[] tmp = new int[arr.length];
                for (int i = n-1, j = arr.length-1, cur = 2*n-1; i >= 0 && j >= n;) {
                    tmp[cur--] = arr[j--];
                    tmp[cur--] = arr[i--];
                }
                arr = tmp;
            }
            for (int i = 0; i < arr.length-1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[arr.length-1]);
        }
    }

    public void splitGrid(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        if (n < 4 || m < 4){
            System.out.println(0);
            return;
        }

    }


    public void StringSplit(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            if (s == null || "".equals(s))continue;
            for (int i = 0, len = s.length(); i < len; i = i+8) {
                if (i + 8 > len){
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0, re = i + 8 - len; j < re; j++) {
                        sb.append('0');
                    }
                    System.out.println(String.format("%s", s.substring(i))+sb.toString());
                }else {
                    System.out.println(s.substring(i, i+8));
                }
            }
        }
    }

    public void reverseString(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder(s.length());
            for (int len = s.length(), i = len; i >= 0 ;) {
                int tmp = s.lastIndexOf(" ", i-1);
                sb.append(s.substring(tmp+1, i));
                if (tmp != -1) sb.append(" ");
                i = tmp;
            }
            System.out.println(sb.toString());
        }
    }

    public void round(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            double d = in.nextDouble();
            System.out.println(Math.round(d));
        }
    }

    public void movdIndex(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] arr = in.nextLine().split(";");
            int x = 0, y = 0;
            for (String s : arr) {
                if (s == null || "".equals(s)) continue;
                char letter = s.charAt(0);
                int number = 0;
                try {
                    number = Integer.parseInt(s.substring(1));
                } catch (Exception e) {
                    continue;
                }
                if (number < 0 || number > 99) continue;
                switch (letter) {
                    case 'A':
                        x -= number;
                        break;
                    case 'D':
                        x += number;
                        break;
                    case 'S':
                        y -= number;
                        break;
                    case 'W':
                        y += number;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(x+","+y);
        }
    }

    public void checkPassword(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String pw = in.nextLine();
            if (pw.length() <= 8 || !checkVarible(pw) || !checkDup(pw)){
                System.out.println("NG");
            }else {
                System.out.println("OK");
            }
        }
    }

    public static boolean checkVarible(String s){
        int variaty = 0;
        if (s.matches(".*[0-9]+.*"))variaty++;
        if (s.matches(".*[a-z]+.*"))variaty++;
        if (s.matches(".*[A-Z]+.*"))variaty++;
        if (s.matches(".*[^A-Za-z0-9]+.*"))variaty++;
        return variaty >= 3;
    }

    public static boolean checkDup(String s){
        for (int i = 0, len = s.length(); i < len-2; i++) {
            int tmp = s.lastIndexOf(s.substring(i, i+3));
            if (tmp >= i+1) return false;
        }
        return true;
    }

    public int floor(int num, int step){
        int[] dp = new int[num];
        if (num == 1)return 1;
        if (num == 2)return 2;
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < num; i++) {
            int tmp = 0;
            for (int j = i-1; j >= 0  && j >= i - step; j--) {
                tmp += dp[j];
            }
            dp[i] = tmp;
        }
        return dp[num-1];
    }

    public void deleteLetter(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            int[] map = new int[26];
            int min = s.length();
            for (int i = 0, len = s.length(); i < len; i++) {
                map[s.charAt(i) - 'a']++;
            }
            for (int node : map) {
                min = node > 0? Math.min(node, min) : min;
            }
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = 0, len = s.length(); i < len; i++) {
                char c = s.charAt(i);
                if (map[c - 'a'] > min){
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }


    public void circleTree(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            if (num == 0)return;
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = in.nextInt();
            }
            if (num == 1) {
                System.out.print(arr[0]);
                return;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0, step = 0; i < num;) {
                list.add(arr[i]);
                i += Math.pow(2, step++);
            }
            for (int i = 1, step = 1; i <= num;) {
                int tmp = i + (int)Math.pow(2, step++);
                if (tmp  >= num){
                    for (int j = i+2; j <= num; j++) {
                        list.add(arr[j-1]);
                    }
                }
                i = tmp;
            }
            for (int i = 2, step = 2, index = list.size(); i < num-1;) {
                list.add(index, arr[i]);
                i += Math.pow(2, step++);
            }
            for (int i = 0, len = list.size(); i < len; i++) {
                if (i != len - 1){
                    System.out.print(list.get(i) + " ");
                }else {
                    System.out.print(list.get(i));
                }
            }
        }
    }

    public void guessNum(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int k = in.nextInt();
            LinkedList<Integer> guss = new LinkedList<>();
            for (int left = 1, right = n ; left < right;){
                int tmp = (left + right)/2;
                left = tmp + 1;
                guss.add(tmp);
            }
            //guss.remove(guss.size()-1);
            for (int i = 0; i < k; i++) {
                if (!guss.isEmpty()){
                    guss.pollLast();
                }else {
                    break;
                }
            }
            int res = 0;
            for (int i : guss) {
                res += i;
            }
            System.out.println(res);
        }
    }

    public static void sumList(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            double res = n;
            double tmp = n;
            for (int i = 1; i < m; i++) {
                tmp = Math.sqrt(tmp);
                res += tmp;
            }
            System.out.println(String.format("%.2f", res));
        }
    }

    public void chorus(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            if (num <= 2){
                System.out.println(0);
                return;
            }
            int[] arr = new int[num];
            int[] inc_dp = new int[num];
            int[] desc_dp = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = in.nextInt();
                inc_dp[i] = 1;
                desc_dp[i] = 1;
            }
            inc_dp[0] = 1; desc_dp[num-1] = 1;
            for (int i = 1; i < num; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j] && inc_dp[j]+1 > inc_dp[i]){
                        inc_dp[i] = inc_dp[j]+1;
                    }
                }
            }
            for (int i = num-1; i >= 0; i--) {
                for (int j = num-1; j > i; j--) {
                    if (arr[i] > arr[j] && desc_dp[j]+1 > desc_dp[i]){
                        desc_dp[i] = desc_dp[j]+1;
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < num; i++) {
                max = Math.max(max, inc_dp[i] + desc_dp[i]);
            }
            System.out.println(num - max + 1);
        }
    }


    public int CountZero_1(int n){
        double res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        int count = 0;
        while (res != 0) {
            if (res % 10 == 0){
                res /= 10;
                count++;
            }else {
                break;
            }
        }
        return count;
    }

    public static int CountZero(int n){
        if(n == 0)return 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0){
                res++;
            }
        }
        if (n > 100)return res+2;
        if (n > 10)return res+1;
        return res;
    }

    public void xiangjiao(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] arr = in.next().toCharArray();
            Set<String> set = new HashSet<>();
            set.add("0,0");
            int x = 0, y = 0;
            for (char s : arr) {
                switch (s) {
                    case 'W':
                        x -= 1;
                        break;
                    case 'E':
                        x += 1;
                        break;
                    case 'S':
                        y -= 1;
                        break;
                    case 'N':
                        y += 1;
                        break;
                    default:
                        break;
                }
                String tmp = x+","+y;
                if (set.contains(tmp)){
                    System.out.println("True");
                    return;
                }else {
                    set.add(tmp);
                }
            }
            System.out.println("False");
        }
    }

    public void removeNode(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (i != k-1) {
                    if (i != n - 1){
                        System.out.print(arr[i] + " ");
                    }else {
                        System.out.println(arr[i]);
                    }
                }
            }
            System.out.println();
        }
    }
    public void removeNode1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            if (i == k-1){
                in.nextInt();
            }
            arr[i] = in.nextInt();
        }
        for (int node : arr) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    public void removeNode2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < n-1; i++) {
            if (i == k-1){
                in.nextInt();
            }
            cur.next = new ListNode(in.nextInt());
        }
        cur = dummy.next;
        for (;cur != null; cur = cur.next) {
            System.out.print(cur.val);
        }
        System.out.println();
    }

    public void kSubString(String str, int k){
        int count = 0;
        for (int i = 0, len = str.length(); i < len; i++) {
            
        }
    }
    public void numberSum(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long num = in.nextLong();
            long a = 1;
            for (;; a = a * 10) {
                if (num / a < 10){
                    a = (num / a) * a;
                    break;
                }
            }
            a = a - 1;
            long b = num - a;
            int res = 0;
            while(a != 0){
                res += a % 10;
                a /= 10;
            }
            while(b != 0){
                res += b % 10;
                b /= 10;
            }
            System.out.println(res);
        }
    }

    private static  int res_huiwen = 0;
    private static Map<String, Integer> map = new HashMap<>();
    public void huiwenzichuan(){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int group = in.nextInt();
        for (int i = 0; i < group; i++) {
            int left = in.nextInt(), right = in.nextInt();
            String sub = str.substring(left-1 ,right);
            Exam1.huiwenzichuan1(sub);
            System.out.println(res_huiwen);
            res_huiwen = 0;
        }
    }

    public static void huiwenzichuan1(String s){
        if (s == null || "".equals(s))return;
        int k = s.length()-1;
        for (int i = 0, j = k; i <= j; ) {
            if (s.charAt(i) == s.charAt(j)){
                i++; j--;
            }else {
                i = 0;
                j = --k;
            }
        }

        if (k+1 != s.length()){
            huiwenzichuan1(s.substring(k+1));
        }
        res_huiwen++;
    }

    public static void huiwenzichuan2(String s){
        if (s == null || "".equals(s))return;
        if (map.containsKey(s)){
            res++;return;
        }
        int k = s.length()-1;
        for (int i = 0, j = k; i <= j; ) {
            if (s.charAt(i) == s.charAt(j)){
                i++; j--;
            }else {
                i = 0;
                j = --k;
            }
        }
        map.put(s.substring(0, k+1) ,1);
        if (k+1 != s.length()){
            huiwenzichuan2(s.substring(k+1));
        }
        res_huiwen++;
    }

    public void kMinSub(){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int k = in.nextInt();
        if (k == 0 || "".equals(str)){
            return;
        }
        int min = 0;
        for (int i = 0, c = str.charAt(0), len = str.length()-1; i < len; i++) {
            if (c < str.charAt(i)){
                c = str.charAt(i);
                min = i;
            }
        }
        System.out.println(str.substring(min, k));
    }

    public void bush(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }
        int min = 0;
        for (int i = 0; i < num; i++) {
            min = Math.max(min, arr[i]);
        }
        int res = Math.min(min, num);
        System.out.println(res);
    }

    public void bush1(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }
        int flag = 0, res = 0;
        while(flag == 0){
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < num; k++) {
                if (arr[k] == 0)continue;
                min = Math.min(min, arr[k]);
            }
            flag = 1;
            for (int i = 0, tmp = 0; i < num; i++) {
                if (arr[i] == 0 || i == num - 1){
                    if (tmp == 1) {
                        res += min;tmp = 0;
                    }
                }else {
                    arr[i] -= min;
                    tmp = 1;flag = 0;
                }
            }
        }
        res = Math.min(res, num);
        System.out.println(res);
    }















}
