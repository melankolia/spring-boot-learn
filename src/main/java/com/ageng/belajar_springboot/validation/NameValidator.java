package com.ageng.belajar_springboot.validation;

import com.ageng.belajar_springboot.validation.anotation.ValidName;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (name.equalsIgnoreCase("Ageng"))
            return false;
        return true;
    }
}
