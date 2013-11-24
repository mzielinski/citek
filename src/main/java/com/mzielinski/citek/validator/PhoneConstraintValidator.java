package com.mzielinski.citek.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author mzielinski, Rule Financial
 */
public class PhoneConstraintValidator  implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {}

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext context) {
        return phoneField != null && phoneField.matches("[0-9()-]*");
    }

}
