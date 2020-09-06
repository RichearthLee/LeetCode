package test;

import java.io.UncheckedIOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class TestProxy {

    public static void main(String[] args) {
        DynamicProxy dp = new DynamicProxy(new Person());
        People people = (People) dp.getProxy();
        people.eat();
    }

    public interface People{
        public void eat();
    }

    public static class Person implements People{
        String id;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public void eat() {
            System.out.println("eat");
        }
    }


    public static class DynamicProxy{
        private Object obj;     //声明Object类型
        DynamicProxy(Object obj){
            this.obj = obj;     //构造函数传入需要代理的目标对象
        }
        @SuppressWarnings(value = "all")
        public Object getProxy(){
            ClassLoader classLoader = this.getClass().getClassLoader();     //获取本类的类加载器
            Class[] interfaces = obj.getClass().getInterfaces();        //通过反射获取接口信息
            return Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {    //动态创建实例
                @Override   //重写InvocationHandler中的invoke方法
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println(method.getName() + Arrays.toString(args));   //前置增强
                    Object object =  method.invoke(obj, args);      //执行目标方法
                    System.out.println(method.getName() + object);  //后置增强
                    return object;
                }
            });
        }
    }


    //代理
    class StaticProxy implements People
    {
        private Person person;

        public void eat()
        {
            if (person==null)
            {
                person=new Person();
            }
            preRequest();
            person.eat();
            postRequest();
        }
        public void preRequest()
        {
            System.out.println("访问真实主题之前的预处理。");
        }
        public void postRequest()
        {
            System.out.println("访问真实主题之后的后续处理。");
        }
    }



}
