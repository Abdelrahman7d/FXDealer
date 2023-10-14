package com.FXDealer.validation.core;

import com.FXDealer.exception.ErrorCode;
import com.FXDealer.service.FXDealService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component("currencyValidator")
public class CurrencyValidator implements BaseValidator{

    public void isValidAmount(BigDecimal amount){
        if(amount == null || amount.doubleValue() < 0){
            throwInvalidOrMissingAmount();
        }
    }

    //This method is to check a group of currencies ISO codes if they are valid or not.
    public void isValidCurrenciesISOCodes(ArrayList<String> currenciesISOCodes){
        isCurrenciesISOCodesWithCorrectLength(currenciesISOCodes);
        isCurrenciesISOCodesExisted(currenciesISOCodes);
    }

    private void isCurrenciesISOCodesWithCorrectLength(ArrayList<String> currenciesISOCodes) {
        for (String cic: currenciesISOCodes){
            int l = cic.length();

            //(3, 7 and 8) are the possible lengths for the ISO code and any other lengths are invalid.
            if (l != 3 && l != 7 && l != 8){
                throwCurrencyValidationException();
            }
        }
    }

    private void isCurrenciesISOCodesExisted(ArrayList<String> currenciesISOCodes) {
                /*Use list of codes to decrease the number of iterations of the CIC loop
        and for more flexibility to add as many as codes you need.
         */
        for (String CIC : CURRENCIES_ISO_CODE) {

            short elementIndexToDelete = -1;
            for (short i = 0; i < currenciesISOCodes.size(); i++){

                //If it fined a match then it is a valid code, So it will not check it anymore.
                if(currenciesISOCodes.get(i).toLowerCase().matches(CIC.toLowerCase())){
                    elementIndexToDelete = i;
                    break;
                }
            }

            if(elementIndexToDelete > -1) {
                currenciesISOCodes.remove(elementIndexToDelete);

                //If there are no more codes to check then it will return because all codes are valid.
                if (currenciesISOCodes.isEmpty())
                    return;

                elementIndexToDelete = -1;
            }
        }

        // If the compiler arrives here, one or all of the codes will be wrong
        throwCurrencyValidationException();
    }

    private void throwCurrencyValidationException() {

        FXDealService.logger.error("There is an error because of invalid currency ISO code!");
        throwException(ErrorCode.INVALID_CURRENCY_ISO_CODE);
    }

    private void throwInvalidOrMissingAmount(){

        FXDealService.logger.error("There is an error because of invalid or missed amount!");
        throwException(ErrorCode.INVALID_OR_MISSING_AMOUNT);
    }

    // Hard coding these codes is not the best way to get them but to decrease any unnecessary complexity.
    private final List<String>CURRENCIES_ISO_CODE = List.of(
            "AED",
            "AFN",
            "ALL",
            "AMD",
            "ANG",
            "AOA",
            "ARS",
            "AUD",
            "AWG",
            "AZN",
            "BAM",
            "BBD",
            "BDT",
            "BGN",
            "BHD",
            "BIF",
            "BMD",
            "BND",
            "BOB",
            "BRL",
            "BSD",
            "BTN",
            "BWP",
            "BYN",
            "BZD",
            "CAD",
            "CDF",
            "CHF",
            "CKD",
            "CLP",
            "CNY",
            "COP",
            "CRC",
            "CUC",
            "CUP",
            "CVE",
            "CZK",
            "DJF",
            "DKK",
            "DOP",
            "DZD",
            "EGP",
            "EHP",
            "ERN",
            "ETB",
            "EUR",
            "FJD",
            "FKP",
            "FOK",
            "GBP",
            "GEL",
            "GGP",
            "GHS",
            "GIP",
            "GMD",
            "GNF",
            "GTQ",
            "GYD",
            "HKD",
            "HNL",
            "HRK",
            "HTG",
            "HUF",
            "IDR",
            "ILS",
            "IMP",
            "INR",
            "IQD",
            "IRR",
            "ISK",
            "JEP",
            "JMD",
            "JOD",
            "JPY",
            "KES",
            "KGS",
            "KHR",
            "KID",
            "KMF",
            "KPW",
            "KRW",
            "KWD",
            "KYD",
            "KZT",
            "LAK",
            "LBP",
            "LKR",
            "LRD",
            "LSL",
            "LYD",
            "MAD",
            "MDL",
            "MGA",
            "MKD",
            "MMK",
            "MNT",
            "MOP",
            "MRU",
            "MUR",
            "MVR",
            "MWK",
            "MXN",
            "MYR",
            "MZN",
            "NAD",
            "NGN",
            "NIO",
            "NOK",
            "NPR",
            "NZD",
            "OMR",
            "PAB",
            "PEN",
            "PGK",
            "PHP",
            "PKR",
            "PLN",
            "PND",
            "PRB",
            "PYG",
            "QAR",
            "RON",
            "RSD",
            "RUB",
            "RWF",
            "SAR",
            "SBD",
            "SCR",
            "SDG",
            "SEK",
            "SGD",
            "SHP",
            "SLL",
            "SLS",
            "SOS",
            "SRD",
            "SSP",
            "STN",
            "SVC",
            "SYP",
            "SZL",
            "THB",
            "TJS",
            "TMT",
            "TND",
            "TOP",
            "TRY",
            "TTD",
            "TVD",
            "TWD",
            "TZS",
            "UAH",
            "UGX",
            "USD",
            "UYU",
            "UZS",
            "VED",
            "VES",
            "VND",
            "VUV",
            "WST",
            "XAF",
            "XCD",
            "XOF",
            "XPF",
            "YER",
            "ZAR",
            "ZMW",
            "ZWB",
            "ZWL",
            "Abkhazia",
            "Artsakh");
}
