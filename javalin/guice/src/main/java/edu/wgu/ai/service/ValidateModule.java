package edu.wgu.ai.service;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

public class ValidateModule extends AbstractModule {
    @Provides
    @Singleton
    public Validator validator() {
//        return Validation.buildDefaultValidatorFactory().getValidator();
        return Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory()
                .getValidator();
    }

}
