package test;

import java.lang.reflect.Method;

@TestAnnotation(testClassName = "TestProxy.Person", testMethodName = "eat")
public class TestAnnoUse {

    public static void main(String[] args) {
        TestAnnoUse ta = new TestAnnoUse();
        Class clazz = ta.getClass();

        Method[] methods = clazz.getMethods();

        for (Method method:methods) {
            if (method.isAnnotationPresent(TestAnnotation.class)){
                try {
                    method.invoke(ta);
                }catch (Exception e){

                }
            }
        }
    }

    public void testMethod(){
        System.out.println("test");
    }

}
