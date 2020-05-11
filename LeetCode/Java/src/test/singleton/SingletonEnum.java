package test.singleton;

public enum SingletonEnum {
//    INSTANCE(new Integer(0));
    INSTANCE(0);

    private Integer integer;

    SingletonEnum(Integer i){
        this.integer = i;
    }

}
