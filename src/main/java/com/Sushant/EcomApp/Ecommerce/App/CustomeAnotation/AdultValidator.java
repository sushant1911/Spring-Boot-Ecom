package com.Sushant.EcomApp.Ecommerce.App.CustomeAnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class AdultValidator implements ConstraintValidator<Adult, Date> {
    @Override
    public void initialize(Adult constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Date birthday, ConstraintValidatorContext constraintValidatorContext) {
        if (birthday == null) {
            return true;
        }

        LocalDate today = LocalDate.now();
        LocalDate birthdate = birthday.toInstant().atZone(Clock.systemDefaultZone().getZone()).toLocalDate();
        Period age = Period.between(birthdate, today);
        return age.getYears() >= 18&&age.getYears()<=90;
    }


}