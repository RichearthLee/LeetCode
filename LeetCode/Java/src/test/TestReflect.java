package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

    private int t = 1;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {

        //获取入口
        Class<?> perClazz = Class.forName("test.TestReflect");
        Class<?> perClazz2 = TestReflect.class;
        TestReflect testReflectInstance = new TestReflect();
        Class<?> perClazz3 = testReflectInstance.getClass();

        Method[] methods = perClazz.getMethods();  //获取此类的所有public方法（父类的，实现接口的，自己的）
        Method[] methods1 = perClazz.getDeclaredMethods();//当前类所有方法
        Constructor<?>[] constructor = perClazz.getConstructors();//获取所有构造方法
        Class<?> clazz = perClazz.getSuperclass(); //获取父类
        Field[] fields = perClazz.getFields(); //所有可以访问的属性

        Field[] testfields = perClazz3.getDeclaredFields();//获取所有的属性
        for (Field field: testfields) {
            field.setAccessible(true);
            Object f = field.get(testReflectInstance);
            int i = field.getInt(testReflectInstance);
            System.out.println(field.getName());
        }

    }
}
