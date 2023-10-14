package com.FXDealer.dao;

import com.FXDealer.model.FXDeal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("fxDealDao")
public class FXDealDataAccessService implements FXDealDao{

    ArrayList<FXDeal> DB = new ArrayList<>();
    @Override
    public int insertFXDeal(FXDeal fxDeal) {
        DB.add(fxDeal);
        return 1;
    }
}
