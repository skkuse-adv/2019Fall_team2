package com.uber.rave.annotation;

import com.uber.rave.ValidatorFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validated {
    Class<? extends ValidatorFactory> factory();
}
