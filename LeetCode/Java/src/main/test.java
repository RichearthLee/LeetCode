package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import solutions.Sol_1;
import t1.T1_Solution;

/**
 * @program: LeetCode
 * @description:
 * @author: Yukun Lee
 * @create: 2019-05-27 09:48
 */

public class test {
    public static void main(String[] args) {
        Sol_1 s = new Sol_1();
        System.out.println(s.isMatch("aaa",".*"));
        System.out.println(s.isMatch("aaa","ab*a"));
        System.out.println(s.isMatch("ab",".*"));

    }
}
