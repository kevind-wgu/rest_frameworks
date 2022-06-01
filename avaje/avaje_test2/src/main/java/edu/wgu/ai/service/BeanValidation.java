package edu.wgu.ai.service;

import io.avaje.http.hibernate.validator.BeanValidator;
import io.avaje.inject.Component;
import jakarta.inject.Inject;

// Not sure why I need this. Occationally avaje seems to wig out and act like BeanValidator is missing.
// Declaring it directly seems to fix that.
@Component
public class BeanValidation extends BeanValidator {
}
