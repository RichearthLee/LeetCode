package test.singleton;

public class SingletonHunger {
    private static final SingletonHunger singletonHunger = new SingletonHunger();

    private SingletonHunger(){
    }

    public static SingletonHunger getInstance(){
        return singletonHunger;
    }
}
