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

        private Object obj;

        DynamicProxy(Object obj){
            this.obj = obj;
        }
        @SuppressWarnings(value = "all")
        public Object getProxy(){
            ClassLoader classLoader = this.getClass().getClassLoader();
            Class[] interfaces = obj.getClass().getInterfaces();
            return Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println(method.getName() + Arrays.toString(args));
                    Object object =  method.invoke(obj, args);
                    System.out.println(method.getName() + object);
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
