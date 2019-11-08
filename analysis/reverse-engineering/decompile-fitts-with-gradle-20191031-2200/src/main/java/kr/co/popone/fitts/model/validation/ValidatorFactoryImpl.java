package kr.co.popone.fitts.model.validation;

import com.uber.rave.BaseValidator;
import com.uber.rave.ValidatorFactory;
import org.jetbrains.annotations.NotNull;

public final class ValidatorFactoryImpl implements ValidatorFactory {
    @NotNull
    public BaseValidator generateValidator() {
        return new ValidatorFactoryImpl_Generated_Validator();
    }
}
