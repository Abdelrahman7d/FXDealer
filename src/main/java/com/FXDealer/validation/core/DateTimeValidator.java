package com.FXDealer.validation.core;

import com.FXDealer.exception.ErrorCode;
import com.FXDealer.service.FXDealService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("dateTimeValidator")
public class DateTimeValidator implements BaseValidator{

    public void isValidDateTimeStamp(LocalDateTime dateTimeStamp){
        isDateTimesStampAfterNow(dateTimeStamp);
    }

    private void isDateTimesStampAfterNow(LocalDateTime dateTimeStamp) {
        if(dateTimeStamp.isAfter(LocalDateTime.now())){
            throwDateTimeException(ErrorCode.INVALID_DATE_TIMESTAMP_AFTER_NOW);
        }
    }

    private void throwDateTimeException(ErrorCode e){

        FXDealService.logger.error("There is an error because of invalid date timestamp!");
        throwException(e);
    }
}
