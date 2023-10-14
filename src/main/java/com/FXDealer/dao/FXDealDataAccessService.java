package com.FXDealer.dao;

import com.FXDealer.model.FXDeal;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("fxDealDao")
public class FXDealDataAccessService implements FXDealDao{

    final JdbcTemplate jdbcTemplate;

    public FXDealDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertFXDeal(FXDeal fxDeal) {
        String sql = """
                INSERT INTO fxdeal (
                deal_unique_id,
                 from_currency_iso_code,
                 to_currency_iso_code,
                 deal_timestamp,
                 deal_amount)
                 VALUES (?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql,
                fxDeal.getDealUniqueId(),
                fxDeal.getFromCurrencyISOCode(),
                fxDeal.getToCurrencyISOCode(),
                fxDeal.getDealTimestamp(),
                fxDeal.getDealAmount()
                );
    }
}
