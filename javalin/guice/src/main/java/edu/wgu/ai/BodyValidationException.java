package edu.wgu.ai;

import edu.wgu.ai.model.Job;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class BodyValidationException extends RuntimeException {
    private final Set<ConstraintViolation<Job>> validate;

    public BodyValidationException(Set<ConstraintViolation<Job>> validate) {
        this.validate = validate;
    }

    public Set<ConstraintViolation<Job>> getValidate() {
        return validate;
    }

}
