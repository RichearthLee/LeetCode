package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> perClazz = Class.forName("TestReflect");

        Class<?> perClazz2 = TestReflect.class;

        TestReflect testReflect = new TestReflect();
        Class<?> perClazz3 = testReflect.getClass();

        Method[] methods = perClazz.getMethods();  //获取此类的所有public方法（父类的，实现接口的，自己的）
        Method[] methods1 = perClazz.getDeclaredMethods();//当前类所有方法

        Constructor<?>[] constructor = perClazz.getConstructors();//获取所有构造方法

        Class<?> clazz = perClazz.getSuperclass(); //获取父类

        Field[] fields = perClazz.getFields(); //所有属性
    }
}
