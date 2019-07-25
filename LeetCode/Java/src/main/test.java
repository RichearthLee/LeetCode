package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import solutions.Sol_1;

/**
 * @program: LeetCode
 * @description:
 * @author: Yukun Lee
 * @create: 2019-05-27 09:48
 */

public class test {
    public static void main(String[] args) {
        Sol_1 s = new Sol_1();
//        String[] str = {"flower","flow","flight"};
//        String[] str1 = {"dog","racecar","car"};
//        String[] str2 = {"a"};
//        String[] str3 = {"aa","aa"};
        //System.out.println(s.isValid("{[]}"));
        List<String> list = new ArrayList<>();
        list.add("init");
        int n = 0;
        String s1 = "init ";
        s.testParam(list, n, s1);
        for(String str: list){
            System.out.println(str);
        }
        System.out.println(n);
        System.out.println(s1);

    }
}
