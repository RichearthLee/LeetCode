package test;

import utility.LRUCache;

public class TestString {

    public static void main(String[] args) {
        //三种构造方法
        String str1 = new String("abc");
        String str2 = new String(new char[]{'a','b','c'});
        String str3 = new String(new byte[]{});
        String str = "abc";
        String str4 = "abc";
        System.out.println(str.substring(2));
        String s = str.substring(3);

        String[] arr = "/a//b////c/d//././/.".split("/");
        System.out.println(s);

        System.out.println(str == str4);
        System.out.println(str == str2);
        System.out.println(str2 == str4);
        System.out.println(str2 == str1);
        "abc".equals(str);

        LRUCache.LRUCacheV1 lru = new LRUCache().new LRUCacheV1(2);
    }

}
