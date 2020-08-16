package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestTheadLocal {

    private static final ThreadLocal<String> localVar = new ThreadLocal<>();
    private static final ThreadLocal<String> localVar1 = new ThreadLocal<>();

    public static class TestTheadLocalExtend extends Thread{
        @Override
        public void run() {
            localVar.set("thead1 localVar variable1");
            localVar.set("thead1 localVar variable2");
            localVar1.set("thead1 localVar1 variable2");

            System.out.println(localVar1.get());
            System.out.println(localVar.get());
        }
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("thead1 localVar variable1");
                localVar.set("thead1 localVar variable2");
                localVar1.set("thead1 localVar1 variable2");

                System.out.println(localVar1.get());
                System.out.println(localVar.get());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("thead2 variable");
                System.out.println(localVar.get());
            }
        });

        Thread t3 = new TestTheadLocalExtend();

        t1.start();
        t2.start();
        //t3.start();

        Class clazz = t3.getClass();
        Field[] field;
        try{
            field = clazz.getDeclaredFields();
            for (Field f : field){
                System.out.println(f.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
