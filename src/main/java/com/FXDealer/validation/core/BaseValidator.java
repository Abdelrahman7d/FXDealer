package com.FXDealer.validation.core;

import com.FXDealer.exception.ErrorCode;
import com.FXDealer.exception.ValidationException;

public interface BaseValidator {

    default void throwException(ErrorCode e){
        throw new ValidationException(e);
    }
}
