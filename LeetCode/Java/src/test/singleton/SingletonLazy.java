package test.singleton;

public class SingletonLazy {
    private static SingletonLazy singletonLazy;
    private SingletonLazy(){

    }
    public static SingletonLazy getInstance(){
        if(singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
