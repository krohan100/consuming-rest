package com.example.consumingrest.validator;

import com.example.consumingrest.domain.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * This validator validates *just* Value instances
 */
public class ValueValidator implements Validator {

    public boolean supports(Class clazz) {
        new Value.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "id", "id.empty");
        ValidationUtils.rejectIfEmpty(errors, "quote", "quote.empty");

        Value v = (Value) target;

        if (v.getId() < 0) {
            errors.rejectValue("id", "negativevalue");
        } else if (v.getId() > 255) {
            errors.rejectValue("id", "greater.than.MAX");
        }

    }
}
