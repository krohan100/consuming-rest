package com.example.consumingrest.validator;

import com.example.consumingrest.domain.Quote;
import com.example.consumingrest.domain.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class QuoteValidator implements Validator {


    private final Validator valueValidator;

    public QuoteValidator(Validator addressValidator, Validator valueValidator) {
        if (valueValidator == null) {
            throw new IllegalArgumentException("The supplied [Validator] is required and must not be null.");
        }
        if(!valueValidator.supports(Value.class)) {
            throw new IllegalArgumentException("The supplied [Validator] must support the validation of [Value] instances.");
        }
        this.valueValidator = valueValidator;
    }

    /**
     * This validator validates Quote instances and any subclass of quote.
     * @param clazz
     * @return
     */
    public boolean supports(Class<?> clazz) {
        return Quote.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "field.required");
        Quote quote = (Quote) target;
        try {
            errors.pushNestedPath("value");
            ValidationUtils.invokeValidator(this.valueValidator, quote.getValue(), errors);
        } finally {
            errors.popNestedPath();
        }
    }

}
