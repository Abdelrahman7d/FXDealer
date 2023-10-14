package com.FXDealer.api;

import com.FXDealer.exception.ExceptionHandler;
import com.FXDealer.exception.ValidationException;
import com.FXDealer.model.FXDeal;
import com.FXDealer.service.FXDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/fxDeal")
@RestController
public class FXDealController {

    private final FXDealService fxDealService;

    @Autowired
    public FXDealController(FXDealService fxDealService){
        this.fxDealService = fxDealService;
    }

    @PostMapping
    public ResponseEntity<?> addFXDeal(@RequestBody FXDeal fxDeal){
        try {
            fxDealService.addFXDeal(fxDeal);
            return ResponseEntity.ok("Entity was inserted successfully!");
        } catch (ValidationException e){
            return ExceptionHandler.getResponseEntity(e);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
