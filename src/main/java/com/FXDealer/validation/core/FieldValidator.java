package com.FXDealer.validation.core;

import com.FXDealer.exception.ErrorCode;
import com.FXDealer.service.FXDealService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("fieldValidator")
public class FieldValidator implements BaseValidator{

    public void isValidField(String field){
        if(field == null || field.isEmpty()) {
            FXDealService.logger.error("There is an error because of empty or null field!");
            throwMissingFieldException();
        }
    }

    private void throwMissingFieldException() {
        throwException(ErrorCode.MISSING_FIELDS);
    }
}
