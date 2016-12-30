package com.lixiaohao.test.annotation;

import java.lang.annotation.*;

/**
 * Created by lixiaohao
 * Date:${DATA}
 * Description:
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Compare {
    CompareTypeFactory value() default CompareTypeFactory.BASIC_TYPE;
    boolean loopDown() default false;
    enum CompareTypeFactory {REFERENCE_TYPE,BASIC_TYPE}
}
