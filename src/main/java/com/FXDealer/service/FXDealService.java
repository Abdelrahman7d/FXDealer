package com.FXDealer.service;

import com.FXDealer.dao.FXDealDao;
import com.FXDealer.model.FXDeal;
import com.FXDealer.validation.model.FXDealValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class FXDealService {
    private final FXDealDao fxDealDao;
    public final FXDealValidator fXDealValidator;

    public static final Logger logger = LoggerFactory.getLogger(FXDealService.class);


    @Autowired
    public FXDealService(@Qualifier("fxDealDao") FXDealDao fxDealDao,
                         @Qualifier("fXDealValidator") FXDealValidator fXDealValidator){

        this.fxDealDao = fxDealDao;
        this.fXDealValidator  = fXDealValidator;
    }

    public int addFXDeal(FXDeal fxDeal){

        logger.debug("Validating just started!");
        //Validate the deal before inserting it into the database.
        fXDealValidator.isValidFXDeal(fxDeal);
        logger.debug("Validating just ended successfully!");

        return fxDealDao.insertFXDeal(fxDeal);
    }
}
