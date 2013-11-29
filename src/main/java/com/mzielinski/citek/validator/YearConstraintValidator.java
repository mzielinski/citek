package com.mzielinski.citek.validator;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author mzielinski, Rule Financial
 */
public class YearConstraintValidator implements ConstraintValidator<Year, Date> {

    private int annotationYear;

    @Override
    public void initialize(Year year) {
        this.annotationYear = year.value();
    }

    @Override
    public boolean isValid(Date target, ConstraintValidatorContext cxt) {
        if (target == null) {
            return true;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(target);
        return annotationYear == c.get(Calendar.YEAR);
    }

}