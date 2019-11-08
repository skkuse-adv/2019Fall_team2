package org.simple.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscriber {
    ThreadMode mode() default ThreadMode.MAIN;

    String tag() default "default_tag";
}
