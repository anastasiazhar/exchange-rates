package com.example.bnp;

import com.example.bnp.service.ExchangeRateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
class BnpApplicationTests {

	@Autowired
	private ExchangeRateService exchangeRate;

	@Test
	void checkExchangeRate() {
		assertNotNull("...", exchangeRate.getResult("USD"));
	}
}
