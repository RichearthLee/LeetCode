package test;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TestAnnotation {

    String testClassName();

    String testMethodName();


}
