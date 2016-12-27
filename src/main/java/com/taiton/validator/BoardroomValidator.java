package com.taiton.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Taiton on 12/27/2016.
 */
@Component("boardroomValidator")
public class BoardroomValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return BoardroomValidator.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
