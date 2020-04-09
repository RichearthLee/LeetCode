package test;

public class TestReturnType {

    TestReturnType(){
        A a = testTypeA();
        B b = ((B) a);
        b.print();
    }



    public A testTypeA(){
        return new A();
    }

    public B testTypeB(){
        return new B();
    }


    public class A{
        private char a = 'a';
        public void print(){
            System.out.println(a);
        }

        public void other(){
            System.out.println(a);
        }

    }

    public class B extends A{
        @Override
        public void print(){
            System.out.println(super.a);
        }

    }
}


