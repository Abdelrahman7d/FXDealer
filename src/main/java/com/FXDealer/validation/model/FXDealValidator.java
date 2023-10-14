package com.FXDealer.validation.model;

import com.FXDealer.model.FXDeal;
import com.FXDealer.validation.core.CurrencyValidator;
import com.FXDealer.validation.core.DateTimeValidator;
import com.FXDealer.validation.core.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("fXDealValidator")
public class FXDealValidator {


    private final FieldValidator fieldValidator;
    private final CurrencyValidator currencyValidator;
    private final DateTimeValidator dateTimeValidator;


    @Autowired
    FXDealValidator(
            @Qualifier("fieldValidator") FieldValidator fieldValidator,
            @Qualifier("currencyValidator") CurrencyValidator currencyValidator,
            @Qualifier("dateTimeValidator") DateTimeValidator dateTimeValidator

    ) {
        this.fieldValidator = fieldValidator;
        this.currencyValidator = currencyValidator;
        this.dateTimeValidator = dateTimeValidator;
    }

    public boolean isValidFXDeal(FXDeal fxDeal) {

        isValidFXDealFields(fxDeal);
        isValidFXDealCurrencies(fxDeal);
        isValidDateTimeFXDeal(fxDeal);

        return true;
    }

    private void isValidFXDealFields(FXDeal fxDeal) {

        fieldValidator.isValidField(fxDeal.getDealUniqueId());
        fieldValidator.isValidField(fxDeal.getFromCurrencyISOCode());
        fieldValidator.isValidField(fxDeal.getToCurrencyISOCode());
    }

    private void isValidFXDealCurrencies(FXDeal fxDeal) {

        //We add the currencies to an arraylist because we will need to modify it later and this is impossible with the list.
        ArrayList<String> codes = new ArrayList<String>();
        codes.add(fxDeal.getFromCurrencyISOCode());
        codes.add(fxDeal.getToCurrencyISOCode());
        currencyValidator.isValidCurrenciesISOCodes(codes);
        currencyValidator.isValidAmount(fxDeal.getDealAmount());
    }

    private void isValidDateTimeFXDeal(FXDeal fxDeal) {
        dateTimeValidator.isValidDateTimeStamp(fxDeal.getDealTimestamp());
    }

}
