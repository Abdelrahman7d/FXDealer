package com.FXDealer;

import com.FXDealer.model.FXDeal;
import com.FXDealer.service.FXDealService;
import com.FXDealer.validation.model.FXDealValidator;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class FxDealerApplicationTests {


	@Mock
	private FXDealValidator fXDealValidator;

	@Autowired
	private FXDealService fxDealService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testDealValidationMissingField() {

		FXDeal fxDeal = new FXDeal(
				1,
				"",
				"USD",
				"EUR",
				LocalDateTime.now(),
				new BigDecimal("1000.00")
		);

		boolean result = fxDealService.fXDealValidator.isValidFXDeal(fxDeal);

		assertFalse(!result);
	}

	@Test
	public void testDealValidationInvalidDealAmount() {

		FXDeal fxDeal = new FXDeal(
				1,
				"qwe",
				"USD",
				"EUR",
				LocalDateTime.now(),
				new BigDecimal("-1000.00")
		);

		boolean result = fxDealService.fXDealValidator.isValidFXDeal(fxDeal);

		assertFalse(!result);
	}

	@Test
	public void testDealValidationInvalidCurrencyISOCode() {

		FXDeal fxDeal = new FXDeal(
				1,
				"12345",
				"UD",
				"EUR",
				LocalDateTime.now(),
				new BigDecimal("1000.00")
		);

		boolean result = fxDealService.fXDealValidator.isValidFXDeal(fxDeal);

		assertFalse(!result);
	}

	@Test
	public void testDealValidationDealAfterCurrentMonet() {

		FXDeal fxDeal = new FXDeal(
				1,
				"12345",
				"USD",
				"EUR",
				LocalDateTime.parse("2024-10-13T14:37:27.270456100"),
				new BigDecimal("1000.00")
		);

		boolean result = fxDealService.fXDealValidator.isValidFXDeal(fxDeal);

		assertFalse(!result);
	}

	@Test
	public void testDealValidationCorrectDeal() {

		FXDeal fxDeal = new FXDeal(
				1,
				"12345",
				"USD",
				"EUR",
				LocalDateTime.now(),
				new BigDecimal("1000.00")
		);

		boolean result = fxDealService.fXDealValidator.isValidFXDeal(fxDeal);

		assertFalse(!result);
	}

}
